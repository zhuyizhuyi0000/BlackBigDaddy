# -*- coding: utf-8 -*-
from sikuli import *
import urllib
import simplejson as json
from array import array
import logging  
import logging.handlers  

import email  
import mimetypes  
from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText  
from email.MIMEImage import MIMEImage  
import smtplib 

#######  emai相关 开始 #########
def sendEmail(authInfo, fromAdd, toAdd, subject, plainText, htmlText):  
  
        strFrom = fromAdd  
        strTo = ', '.join(toAdd)  
  
        server = authInfo.get('server')  
        user = authInfo.get('user')  
        passwd = authInfo.get('password')  

# 由于user和passwd可以不写，此校验暂时注掉  
#        if not (server and user and passwd) :  
#                print 'incomplete login info, exit now'  
#                return  
  
        # 设定root信息  
        msgRoot = MIMEMultipart('related')  
        msgRoot['Subject'] = subject  
        msgRoot['From'] = strFrom  
        msgRoot['To'] = strTo  
        msgRoot.preamble = 'This is a multi-part message in MIME format.'  
  
        # Encapsulate the plain and HTML versions of the message body in an  
        # 'alternative' part, so message agents can decide which they want to display.  
        msgAlternative = MIMEMultipart('alternative')  
        msgRoot.attach(msgAlternative)  
  
        #设定纯文本信息  
        msgText = MIMEText(plainText, 'plain', 'utf-8')  
        msgAlternative.attach(msgText)  
  
        #设定HTML信息  
        #msgText = MIMEText(htmlText, 'html', 'utf-8')  
        #msgAlternative.attach(msgText)  
  
       #设定内置图片信息  
#        fp = open('test.jpg', 'rb')  
#        msgImage = MIMEImage(fp.read())  
#        fp.close()  
#        msgImage.add_header('Content-ID', '<image1>')  
#        msgRoot.attach(msgImage)  
  
       #发送邮件  
        smtp = smtplib.SMTP()  
       #设定调试级别，依情况而定  
        smtp.set_debuglevel(1)  
        smtp.connect(server)  
        #smtp.login(user, passwd)   #此步可以干掉
        #smtp.sendmail(strFrom, strTo, msgRoot.as_string())  #这句 貌似多收件人时 只有第一个收到--未确认
        smtp.sendmail(strFrom, toAdd, msgRoot.as_string())  #多收件人这个ok
 
        smtp.quit()  
        return

authInfo = {}  
authInfo['server'] = 'mail1-in.baidu.com'  
authInfo['user'] = ''  #此值可以不写
authInfo['password'] = ''  #此值可以不写
fromAdd = 'sikuli@baidu.com'   #发件人 随便写
toAdd = ['qixiuping@baidu.com','zhujinling@baidu.com','guolin02@baidu.com']  #收件人
subject = '进游戏监控--异常通知'  #邮件title
htmlText = ''    
#######  emai相关 结束 #########  


#######  log相关 开始 #########
LOG_FILE = 'tst.log'  
handler = logging.handlers.RotatingFileHandler(LOG_FILE, maxBytes = 1024*1024, backupCount = 5) # 实例化handler   
fmt = '%(asctime)s - %(filename)s:%(lineno)s - %(name)s - %(message)s'    
formatter = logging.Formatter(fmt)   # 实例化formatter  
handler.setFormatter(formatter)      # 为handler添加formatter    
logger = logging.getLogger('tst')    # 获取名为tst的logger  
logger.addHandler(handler)           # 为logger添加handler  
logger.setLevel(logging.DEBUG)
#######  log相关 结束 #########

#######  获取gameid+serverid 开始 #########
def getGameIdList():
    url_gameid = 'http://wanba.baidu.com/godoubi.xhtml?c=loadgame'
    page = urllib.urlopen(url_gameid)
    page_result_str = page.read()    
    page_result_json = json.loads(page_result_str)
    gameId_list = []
    gameList = page_result_json["gameList"]  #得到gameList

    letter_list = ["ABC","DEFG","HIJK","LMNO","TPQRS","UVWX","YZ"]
    for letter in letter_list:
       gameList_letter = gameList[letter]   
       for val in gameList_letter:   #得到gameid
           gameid = val["id"]
           gameId_list.append(gameid)
    return gameId_list

    
def getServerIdList(gameid):
    url = 'http://wanba.baidu.com/server_list_not_login.xhtml?c=gameList&gid='+gameid
    page = urllib.urlopen(url)
    page_result_str = page.read()
    page_result_json = json.loads(page_result_str)
    serverList =  page_result_json["serverList"]
    serverId_list = []
    for val in serverList:  #处理serverlist--只留serverid
        status = val["status"]        
        status_weihuzhong = "维护中".decode('utf-8')
        status_huobaokaiqi = "火爆开启".decode('utf-8')
        status_zhengchangkaiqi = "正常开启".decode('utf-8')
        
        if status == status_huobaokaiqi or status == status_zhengchangkaiqi:
            list = val["params"].split('=')
            server_no = len(list)
            serverid = list[server_no-1]
            e = serverid.encode('raw_unicode_escape')  #去掉u  
            serverId_list.append(e)
        if len(serverId_list) ==1:
            break
    return serverId_list
    
def getDataDict():
    data_list = []
    gameId_list = getGameIdList()
    for gameid in gameId_list:      
      serverId_list = getServerIdList(str(gameid))
      for serverid in serverId_list:
          data_dict = dict.fromkeys(['gameId','serverId'],0)
          data_dict['gameId'] = str(gameid)
          data_dict['serverId'] = serverid
          data_list.append(data_dict)
          del data_dict
    #print data_list
    return data_list
#######  获取gameid+serverid 结束 #########

global data_dict
data_dict = getDataDict()      #gameId和serverId List
print data_dict
time=len(data_dict)            #进游戏链接轮询次数

        
#################游戏加载情况判断###################        
def gameLoad(gameUrl,img_role):
    window=0
    result=1
    for i in range (0,2):      
        type("t",KEY_CTRL)
        window=window+1
        wait(1)
        paste(gameUrl)
        type(Key.ENTER)        
        if  exists(img_role,20):
            logger.info("OK------------gameId: "+gameId+"----serverId: "+serverId+"-----") 
            result=1
            break
        else:
            result=0        
    if result==0:
        logger.info("ERROR------------gameId: "+gameId+"----serverId: "+serverId+"-----")                       
        plainText = '进游戏异常链接:\n\n' + gameUrl  #邮件内容
        sendEmail(authInfo, fromAdd, toAdd, subject, plainText, htmlText) #发邮件
    for i in range(0,window):
        type("w",KEY_CTRL)
        while exists("1414581521671-2.png",2):
            click("1414581547450-2.png")
            wait(1)
        
###################主程序#####################################       
if __name__ == '__main__':
   for index in range (0,time):       
        gameId = data_dict[index]['gameId']
        serverId = data_dict [index]['serverId']
        gameUrl='http://wanba.baidu.com/login_game_for_general.xhtml?id='+gameId+ '&serverId='+serverId   # 游戏页地址
        img_role="..\img\\"+gameId+".png"        
        gameLoad(gameUrl,img_role)    
    #type("w",KEY_CTRL)
   
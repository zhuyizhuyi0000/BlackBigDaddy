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
toAdd = ['qixiuping@baidu.com']  #收件人
subject = '进游戏监控--异常通知'  #邮件title
htmlText = ''    
#######  emai相关 结束 #########
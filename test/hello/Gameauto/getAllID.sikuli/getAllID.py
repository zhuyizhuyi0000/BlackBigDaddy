from sikuli import *
import urllib
#print '\n'.join(sys.path)
import simplejson as json
from array import array

def getGameIdList():
    #url_gameid = 'http://youxi.baidu.com/godoubi.xhtml?c=loadgame'
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
    print  gameId_list
    return gameId_list
    
def getServerIdList(gameid):
    url = 'http://youxi.baidu.com/server_list_not_login.xhtml?c=gameList&gid='+gameid
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
    print(serverId_list)
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
    print data_list
    return data_list

    
if __name__ == '__main__':
    getGameIdList()
    #getServerIdList("776")
    #getDataDict()
    



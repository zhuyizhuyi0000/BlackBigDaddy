package com.baidu.gameqa.iat.steps.gift;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.AssertMultiResult;
import com.baidu.gameqa.iat.steps.common.ClientLoginRequest;
import com.baidu.gameqa.iat.steps.common.DBUtils;
import com.baidu.gameqa.iat.steps.common.GsonUtils;
import com.baidu.gameqa.iat.steps.common.SecurityUtils;
import com.baidu.gameqa.iat.steps.common.SetupSteps;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
//import com.baidu.wanba.common.tedis.repostory.TedisUtil;
//import com.baidu.wanba.common.tedis.util.GsonUtil;

/**
 * 礼包频道1.0 礼包领取  API: http://youxi.baidu.com/xxx/ajax_gift.xhtml
 * 
 * @author liumiao
 * @version V1.0  
 */
public class GiftCheck {

	static String actualResult = null;

	private static InterfaceStepParameter getParameters(String parameterID)
			throws Exception {
		@SuppressWarnings("deprecation")
		InterfaceStepParameter parameters = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		return parameters;
	}
	
	public List<List<String>> getDBData(String parameterID, String connectionString, 
			String user, String password, String commandText ) throws Exception{
		
		MysqlProxy proxy = new MysqlProxy(); 
		HashMap<String,String> requestParameter = new HashMap<String,String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		
		requestParameter.put("connectionString", parameter.getValue(connectionString));
		requestParameter.put("user", parameter.getValue(user));
		requestParameter.put("password", parameter.getValue(password));
		requestParameter.put("commandText", parameter.getValue(commandText));
		
		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		return sqlresult;
		
	}
	
	public String doDBQuery(String parameterID, String connectionString, 
			String user, String password, String commandText ) throws Exception{
		
		MysqlProxy proxy = new MysqlProxy(); 
		HashMap<String,String> requestParameter = new HashMap<String,String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		
		requestParameter.put("connectionString", parameter.getValue(connectionString));
		requestParameter.put("user", parameter.getValue(user));
		requestParameter.put("password", parameter.getValue(password));
		requestParameter.put("commandText", parameter.getValue(commandText));
		
		String sqlresult = proxy.executeNoneQuery(requestParameter);
		return sqlresult;
	}


	@StepMethodDesc(description = "initDBdata ", owner = "liumiao")
	public void initDBData(String parameterID) throws Exception {


	}

	@StepMethodDesc(description = "set user_got_gift_count ", owner = "liumiao")
	public void setUserGotGiftNum_personLimitNum(String parameterID) throws Exception {
		String  giftId=getParameters(parameterID).getValue("giftId");
		String userId=getParameters(parameterID).getValue("userId");
		String userName=getParameters(parameterID).getValue("userName");
		String  personLimitNum=getParameters(parameterID).getValue("personLimitNum");
		String count=getParameters(parameterID).getValue("userGotCount");
		String  connectionstring = getParameters(parameterID).ConnectiongString;
		String  user=getParameters(parameterID).getValue("user");
		String  password=getParameters(parameterID).getValue("password");
		String delCommandText= "delete from  youxi_gift_product_record"+Integer.parseInt(userId)%10+ "   where  userid = "+userId +" and giftid = "+giftId;
		doDBQuery(parameterID,connectionstring,user,password,delCommandText);       
	    
		String insertCommandText="insert into youxi_gift_product_record(username,userIp,remarks,status,giftType,plat,price,lastModifyAdminId,giftId,userId,createTime,lastUpdateTime) "
				+ " values('" +userName +"','172.22.234.167','{\"address\":\"\"}',1,1,1,10,0,"+giftId+userId+"1404230271828";
		for (int i=1;i<=Integer.parseInt(count);i++)
		{
			doDBQuery(parameterID,connectionstring,user,password,insertCommandText);       
		}
		String updateCommandText="update   youxi_gift_product  set  personLimitNum =  '"+personLimitNum+"' where id ="+giftId;
		doDBQuery(parameterID,connectionstring,user,password,updateCommandText);       

	}

@StepMethodDesc(description = "set user_totalnum_gotnum ", owner = "liumiao")
	public void  setGiftGotNum_totalNum(String parameterID) throws Exception{
		String  giftId=getParameters(parameterID).getValue("giftId");
		String gotNum =getParameters(parameterID).getValue("gotNum");
		String totalNum =getParameters(parameterID).getValue("totalNum");
		String  connectionstring = getParameters(parameterID).ConnectiongString;
		String  user=getParameters(parameterID).getValue("user");
		String  password=getParameters(parameterID).getValue("password");
		String updateCommandText= "update   youxi_gift_product  set totalNum =  "+Integer.parseInt(totalNum)+ ",gotNum = "+ Integer.parseInt(gotNum) +"   where  id = "+ giftId;
        doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
    } 

@StepMethodDesc(description = "set limit ", owner = "liumiao")
   public void setLimit(String parameterID) throws Exception{
        String giftId=getParameters(parameterID).getValue("giftId");
		String  connectionstring = getParameters(parameterID).ConnectiongString;
		String  user=getParameters(parameterID).getValue("user");
		String  userLimit=getParameters(parameterID).getValue("userLimit");
		String  password=getParameters(parameterID).getValue("password"); 
		String updateCommandText= "update   youxi_gift_product  set  userLimit =  '"+userLimit+"' where id ="+giftId;
        doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
    }

@StepMethodDesc(description = "set TimeRange ", owner = "liumiao")
public void setTimeRange(String parameterID) throws Exception{
     String giftId=getParameters(parameterID).getValue("giftId");
		String  connectionstring = getParameters(parameterID).ConnectiongString;
		String  user=getParameters(parameterID).getValue("user");
		String  password=getParameters(parameterID).getValue("password"); 
		String  startTime=getParameters(parameterID).getValue("startTime"); //差值
		String  endTime=getParameters(parameterID).getValue("endTime");//差值
		String updateCommandText= "UPDATE `youxi_gift_product` SET `endTime`= unix_timestamp(date_add( now( ),INTERVAL  "+endTime+"  DAY )), `startTime` = unix_timestamp(date_add( now( ),INTERVAL "+startTime+"  DAY )) WHERE id ="+giftId ;
     doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
 }

@StepMethodDesc(description = "setUserVipLevel ", owner = "liumiao") //vip等级是否需要考虑vip是否生效状态
public void setUserVipLevel(String parameterID) throws Exception{
		String  connectionstring = getParameters(parameterID).ConnectiongString;
		String  user=getParameters(parameterID).getValue("user");
		String  password=getParameters(parameterID).getValue("password"); 
		String  vipLevel=getParameters(parameterID).getValue("vipLevel"); 
		String  score=getParameters(parameterID).getValue("score"); 
    	String userId=getParameters(parameterID).getValue("userId");
    	String userName=getParameters(parameterID).getValue("userName");
		String delCommandText= " delete  from  `youxi_vip_user`   WHERE `userId` ="+userId ;
        doDBQuery(parameterID,connectionstring,user,password,delCommandText);
        if(Integer.parseInt(vipLevel)>0){
        	String  insertCommandText="insert into youxi_vip_user values('"+userId+"','"+userName+"','"+score+"','"+vipLevel+"',NULL,NULL,'2019-01-08','2013-07-08 01:19:37')";
            doDBQuery(parameterID,connectionstring,user,password,insertCommandText);
        
        }
 }

@StepMethodDesc(description = "setMemberLevel ", owner = "liumiao")
public void setMemberLevel(String parameterID) throws Exception{
	String  connectionstring = getParameters(parameterID).ConnectiongString;
	String  user=getParameters(parameterID).getValue("user");
	String  password=getParameters(parameterID).getValue("password"); 
	String  level=getParameters(parameterID).getValue("level"); 
	String userId=getParameters(parameterID).getValue("userId");
	String updateCommandText= "update `member_info` set `level`="+level+" where `userId` = "+userId ;
    doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
}

@StepMethodDesc(description = "setrPayByCoin ", owner = "liumiao")
public void setPayByCoin(String parameterID) throws Exception{
	String  connectionstring = getParameters(parameterID).ConnectiongString;
	String  user=getParameters(parameterID).getValue("user");
	String  password=getParameters(parameterID).getValue("password"); 
	String  score=getParameters(parameterID).getValue("score"); 
	String userId=getParameters(parameterID).getValue("userId");
	String updateCommandText= "UPDATE ` member_info ` SET score = "+score+" WHERE `userId` = "+userId ;
    doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
}

@StepMethodDesc(description = "setPayByGold ", owner = "liumiao")
public void setPayByGold(String parameterID) throws Exception{
	String  connectionstring = getParameters(parameterID).ConnectiongString;
	String  user=getParameters(parameterID).getValue("user");
	String  password=getParameters(parameterID).getValue("password"); 
	String  gold=getParameters(parameterID).getValue("gold"); 
	String userId=getParameters(parameterID).getValue("userId");
	String userName=getParameters(parameterID).getValue("userName");
	String endTime=getParameters(parameterID).getValue("endTime");
	String delCommandText="delete from   youxi_gold_coupon_"+Integer.parseInt(getParameters(parameterID).getValue("userId"))%10+"  WHERE userId =  "+userId ;
    doDBQuery(parameterID,connectionstring,user,password,delCommandText);
    if(Integer.parseInt(gold)>0){
    	String insertCommandText= "Insert  youxi_gold_coupon_"+Integer.parseInt(getParameters(parameterID).getValue("userId"))%10+"(id,userId,userName,amount,balance,startTime,endTime,startTime2,endTime2,gameId,activityId,couponType,createTime,updateTime,status)  "
    			+ "      values ('13745162dsd','"+userId+ "','"+userName+"',10000,"+gold+",'2013-02-25 14:38:20','"+endTime+"',Null,Null,0,0,1,'2013-02-25 14:38:20','2013-02-25 14:38:20',1";
        doDBQuery(parameterID,connectionstring,user,password,insertCommandText);
    }
			
}

@StepMethodDesc(description = "setUserAmount ", owner = "liumiao")
public void setUserAmount(String parameterID) throws Exception{
	String  connectionstring = getParameters(parameterID).ConnectiongString;
	String  user=getParameters(parameterID).getValue("user");
	String  password=getParameters(parameterID).getValue("password"); 
	String  score=getParameters(parameterID).getValue("amount"); //对应总充值金额
	String userId=getParameters(parameterID).getValue("userId");
	String userName=getParameters(parameterID).getValue("userName");
//	String updateCommandText= "Update  youxi_vip_user set score='"+score+"'  where  userId="+userId;
//    doDBQuery(parameterID,connectionstring,user,password,updateCommandText);

	String delCommandText= " delete  from  `youxi_vip_user`   WHERE `userId` ="+userId ;
    doDBQuery(parameterID,connectionstring,user,password,delCommandText);
	if(Integer.parseInt(score)>0){
    	String  insertCommandText="insert into youxi_vip_user values('"+userId+"','"+userName+"','"+score+"','3',NULL,NULL,'2019-01-08','2013-07-08 01:19:37')";
        doDBQuery(parameterID,connectionstring,user,password,insertCommandText);
    
    }

}

@StepMethodDesc(description = "setBindEmail ", owner = "liumiao")
public void setBindEmail(String parameterID) throws Exception{
	String  connectionstring = getParameters(parameterID).ConnectiongString;
	String  user=getParameters(parameterID).getValue("user");
	String  password=getParameters(parameterID).getValue("password"); 
	String userId=getParameters(parameterID).getValue("userId");
	String email=getParameters(parameterID).getValue("email");
	String updateCommandText= "UPDATE `user_binding_email` SET`email`='"+email+"' WHERE `userId`="+userId ;
    doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
}

@StepMethodDesc(description = "setBindPhone ", owner = "liumiao")
public void setBindPhone(String parameterID) throws Exception{
	String  connectionstring = getParameters(parameterID).ConnectiongString;
	String  user=getParameters(parameterID).getValue("user");
	String  password=getParameters(parameterID).getValue("password"); 
	String userId=getParameters(parameterID).getValue("userId");
	String phone=getParameters(parameterID).getValue("phone");

	String updateCommandText= "UPDATE `youxi_user_security_phone` SET phone ='"+phone+"' WHERE``userId` ="+userId ;
    doDBQuery(parameterID,connectionstring,user,password,updateCommandText);
}


// Step2 - userLogin
public void userLogin(String parameterID) throws Exception {
	SetupSteps setUpSteps = new SetupSteps();
	setUpSteps.login(parameterID);
}

// Step3 - giftPayCheck
public String giftPayCheck(String parameterID) throws Exception {
	WebConversation conversion = HttpUnitHelper.createConversation();
	WebRequest currentRequest = new PostMethodWebRequest(
			getParameters(parameterID).getValue("giftPayCheckUrl"));
	currentRequest.setParameter("c", getParameters(parameterID).getValue("c"));
	currentRequest.setParameter("id", getParameters(parameterID).getValue("id"));
	currentRequest.setParameter("count", getParameters(parameterID).getValue("count"));
	WebResponse response = conversion.getResponse(currentRequest);
	SimpleLogger.logInfo(GiftPayCheck.class, "gift check result:" + response.getText());
	actualResult = response.getText();
	return actualResult;
}

// Step4 - assertResult
public void assertResult(String parameterID) throws Exception {
	SimpleLogger.logInfo(this.getClass(), "actualResult : " + actualResult);
	AssertMultiResult.assertWithParameter(getParameters(parameterID), actualResult, getParameters(parameterID).getValue("expectedResult"));
}

}

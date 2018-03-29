package com.baidu.gameqa.iat.steps.member;



import java.util.Date;
import java.util.HashMap;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class RegisterwithInviteCode {

	@StepMethodDesc(description="Register a game user for A platform with an Invite Code successfully",owner="Lin Guo")
	public void RegisterGameUser_success(String parameterID) throws Exception{
		
		//TestCase 1: Register with Invite code - success
		Date ddDate = new Date();
		String usernameStr = String.valueOf(ddDate.getTime());
	    
	    //get parameters from xml files.
		System.out.println("Step1: get parameters from xml files");
		InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
	    WebRequest currentRequest=HttpUnitHelper.createWebRequest(parameter.getValue("url"),parameter.getValue("httpmethod"));
	    HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    //put username in url.
	    System.out.println("Step2: put username in url");
	    urlParameters.put("loginName",usernameStr); 
	    		
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	         
	    }	  
	    System.out.println("Step3: The requst url is:" + currentRequest.getURL());
	    WebResponse response=currentConversation.getResponse(currentRequest);
	    
	    System.out.println("Step4: " + response.getText());
	    int responsecode =response.getResponseCode();
    	JSONObject actualStep = JSONObject.fromObject(response.getText());
	    System.out.println("Step5: Assertion Start ...");
	    Assert.assertEquals(responsecode, 200);
		Assert.assertEquals(actualStep.getString("result"), "1");
		Assert.assertEquals(actualStep.getString("msg"), "http://youxi.baidu.com/index.html");
	    System.out.println("Step6: Assertion finished.");
		
	}
	
	@StepMethodDesc(description="Register failed with wrong invite code",owner="Lin Guo")
	public void RegisterGameUser_NoInviteCode(String parameterID) throws Exception{
		
		//TestCase 2: Register with Invite code - failed - there is not invite code parameter.
		Date ddDate = new Date();
		String usernameStr = String.valueOf(ddDate.getTime());
	    
	    //get parameters from xml files.
		System.out.println("Step1: get parameters from xml files");
		InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
	    WebRequest currentRequest=HttpUnitHelper.createWebRequest(parameter.getValue("url"),parameter.getValue("httpmethod"));
	    HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    //put username in url.
	    System.out.println("Step2: put username in url");
	    urlParameters.put("loginName",usernameStr); 
	    		
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	         
	    }	  
	    System.out.println("Step3: The requst url is:" + currentRequest.getURL());
	    System.out.println("Assert start...");
	    try {
	    	Assert.assertEquals(currentConversation.getExceptionsThrownOnErrorStatus(), true);
		} catch (Exception e) {
			// TODO: handle exception
			currentConversation.getResponse(currentRequest);
		}
	    
	    System.out.println("Assert finished.");
	
	}
	
	@StepMethodDesc(description="Register failed with an existed username",owner="Lin Guo")
	public void RegisterGameUser_existeduser(String parameterID) throws Exception{
		
		//TestCase 1: Register with Invite code - failed - the username have been used already.
		Date ddDate = new Date();
		String usernameStr = String.valueOf(ddDate.getTime());
	    
	    //get parameters from xml files.
		System.out.println("Step1: get parameters from xml files");
		InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
	    WebRequest currentRequest=HttpUnitHelper.createWebRequest(parameter.getValue("url"),parameter.getValue("httpmethod"));
	    HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    //put username in url.
	    System.out.println("Step2: put username in url");
	    urlParameters.put("loginName",usernameStr); 
	    		
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	         
	    }	  
	    System.out.println("Step3: The requst url is:" + currentRequest.getURL());
	    currentConversation.getResponse(currentRequest);
	    System.out.println("Try it again!");
	    WebResponse response2=currentConversation.getResponse(currentRequest);
	    System.out.println("Step4: " + response2.getText());
	    JSONObject actualStep = JSONObject.fromObject(response2.getText());
	    
	    System.out.println("Step5: Assertion Start ...");

		Assert.assertEquals(actualStep.getString("result"), "-1");
		//Assert.assertEquals(actualStep.getString("msg"), "此账号已被注册。");
	    System.out.println("Step6: Assertion finished.");
		
	}	
	
	@StepMethodDesc(description="Register for A platform with an Invite Code",owner="Lin Guo")
	public void RegisterGameUser_differentrepass(String parameterID) throws Exception{
		
		//TestCase 1: Register with Invite code - failed - repassword is different with password
		Date ddDate = new Date();
		String usernameStr = String.valueOf(ddDate.getTime());
	    
	    //get parameters from xml files.
		System.out.println("Step1: get parameters from xml files");
		InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
	    WebRequest currentRequest=HttpUnitHelper.createWebRequest(parameter.getValue("url"),parameter.getValue("httpmethod"));
	    HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    //put username in url.
	    System.out.println("Step2: put username in url");
	    urlParameters.put("loginName",usernameStr); 
	    		
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	         
	    }	  
	    System.out.println("Step3: The requst url is:" + currentRequest.getURL());
	    WebResponse response=currentConversation.getResponse(currentRequest);
	    
	    System.out.println("Step4: " + response.getText());
	    JSONObject actualStep = JSONObject.fromObject(response.getText());
	    
	    System.out.println("Step5: Assertion Start ...");

		Assert.assertEquals(actualStep.getString("result"), "-3");
		//Assert.assertEquals(actualStep.getString("msg"), "密码与确认密码不一致。");
	    System.out.println("Step6: Assertion finished.");
		
	}	
}
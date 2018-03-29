package com.baidu.gameqa.iat.steps.common;

import java.util.HashMap;
import java.util.List;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;

public  class  SqlResult {

	public SqlResult()
	{
		// TODO Auto-generated constructor stub
	}
	
	@StepMethodDesc(description = "get SqlResult Element with parameterID ,only for 1 line result", owner = "xiuping.qi")
	public String getSqlResultElement(String parameterID,String element) throws Exception{

		List<List<String>> sqlresult = this.getSqlResult(parameterID);		
		ResultCompare rc = new ResultCompare();
		String elementValue = rc.getListValue(1, sqlresult, element);
		return elementValue;
		
	}
	
	@StepMethodDesc(description = "get SqlResult Element with InterfaceStepParameter ,only for 1 line result", owner = "xiuping.qi")
	public String getSqlResultElement(InterfaceStepParameter parameter,String element) throws Exception{

		List<List<String>> sqlresult = this.getSqlResult(parameter);		
		ResultCompare rc = new ResultCompare();
		String elementValue = rc.getListValue(1, sqlresult, element);
		return elementValue;
		
	}
	
	@StepMethodDesc(description = "get SqlResult Element with requestParameter ,only for 1 line result", owner = "xiuping.qi")
	public String getSqlResultElement(HashMap<String, String> requestParameter,String element) throws Exception{

		List<List<String>> sqlresult = this.getSqlResult(requestParameter);		
		ResultCompare rc = new ResultCompare();
		String elementValue = rc.getListValue(1, sqlresult, element);
		return elementValue;
		
	}

	
	@StepMethodDesc(description = "get sql result with parameterID", owner = "xiuping.qi")
	public List<List<String>> getSqlResult(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);	

		List<List<String>> sqlresult = this.getSqlResult(parameter);
		return sqlresult;
	}
	
	
	@StepMethodDesc(description = "get sql result with InterfaceStepParameter ", owner = "xiuping.qi")
	public List<List<String>> getSqlResult(InterfaceStepParameter parameter) throws Exception {

		HashMap<String, String> requestParameter = new HashMap<String, String>();
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password")); 
		requestParameter.put("commandText", parameter.CommandText);
		
		List<List<String>> sqlresult = this.getSqlResult(requestParameter);
		return sqlresult;
	}
	
	@StepMethodDesc(description = "get sql result with requestParameter", owner = "xiuping.qi")
	public List<List<String>> getSqlResult(HashMap<String, String> requestParameter) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		return sqlresult;

	}
	
	@StepMethodDesc(description = "do sql with parameterID", owner = "xiuping.qi")
	public String doSql(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);	

		String str = this.doSql(parameter);
		return str;
	}
	
	@StepMethodDesc(description = "do sql with InterfaceStepParameter", owner = "xiuping.qi")
	public String doSql(InterfaceStepParameter parameter) throws Exception {

		HashMap<String, String> requestParameter = new HashMap<String, String>();
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password")); 
		requestParameter.put("commandText", parameter.CommandText);
		
		String str = this.doSql(requestParameter);
		return str;
	}
	
	@StepMethodDesc(description = "do sql with requestParameter", owner = "xiuping.qi")
	public String doSql(HashMap<String, String> requestParameter) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		String str = proxy.executeNoneQuery(requestParameter);
		return str;
	}
	
	@Deprecated
	@StepMethodDesc(description = "get sql result from modified CommandText ", owner = "xiuping.qi")
	public List<List<String>> getSqlResultFromModifiedCommandText(String parameterID, String commandText) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password")); 
		requestParameter.put("commandText", commandText);
		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		return sqlresult;

	}

}

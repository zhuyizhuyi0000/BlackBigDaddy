package com.baidu.gameqa.iat.steps.data;

import java.net.URLEncoder;
import java.util.HashMap;

import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.DBUtils;

/**
 * 封装通用数据构造方法
 * 通过制定的Parameters key&value构造对应的数据
 * @author yanglei12
 * @version V1.0 创建时间：2014年7月4日 下午8:24:15
 */
public class DataModule {

	static InterfaceStepParameter stepParameters = null;
	static String key;
	static String value;
	static String ConnectionString = "";
	static String CommandText = "";
	static String sql = "";
	static HashMap<String, String> para = new HashMap<String, String>();

	@SuppressWarnings("deprecation")
	public void getGiftData(String parameterID)
			throws Exception {
		stepParameters = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
	}
	
	public void setPair(String keyString, String valueString) {
		if(keyString.equals("ConnectionString")) {
			ConnectionString = valueString;
		} else if(keyString.equals("CommandText")) {
			CommandText = valueString;
		} else {
			key = keyString;
			value = valueString;
			System.out.println("setPair key : " + key);
			System.out.println("setPair value : " + value);
			para.put(key, value);
		}
	}
		
	public void setParaKeyValue(String parameterID) throws Exception{
		for (String eachKey : para.keySet()) {
			stepParameters.updateParameters(eachKey, para.get(eachKey));
		}
		for(int i=0; i<stepParameters.parameters.size(); i++){
			System.out.println(stepParameters.parameters.get(i).key + " : " + stepParameters.parameters.get(i).value);
		}
	}
	
	public String setSql(String parameterID) throws Exception {
		HashMap<String, String> pairMap = new HashMap<String, String>();
		String tableName = stepParameters.getValue("table");
		
		if (stepParameters.getValue("setKey").contains("#")
				&& stepParameters.getValue("setValue").contains("#")) {
			String[] keys = stepParameters.getValue("setKey").split("#");
			String[] values = stepParameters.getValue("setValue").split("#");

			for (int i = 0; i < keys.length; i++) {
				pairMap.put(keys[i], URLEncoder.encode(values[i], "UTF-8").replace("+", "%20"));
			}
		} else {
			//没办法URLEncoder处理空格就会有问题，只能转码完再replace下，，，
			pairMap.put(stepParameters.getValue("setKey"),
					URLEncoder.encode(stepParameters.getValue("setValue"), "UTF-8").replace("+", "%20"));
		}
		
		if (stepParameters.getValue("whereKey").contains("#") && stepParameters.getValue("whereValue").contains("#")) {
			String[] whereKeys = stepParameters.getValue("whereKey").split("#");
			String[] whereValues = stepParameters.getValue("whereValue").split("#");
			StringBuilder limit = new StringBuilder();
			
			limit.append(" WHERE ");
			for (int i = 0; i < whereKeys.length; i++) {
				limit.append("`" + whereKeys[i] + "` = " + whereValues[i]);
				if(i != whereKeys.length - 1){
					limit.append(" and ");
				} else {
					limit.append("");
				}
			}
			sql = DBUtils.togetherUpdateSql(pairMap, tableName) + limit.toString();
		} else {
			sql = DBUtils.togetherUpdateSql(pairMap, tableName) + " WHERE `"
					+ stepParameters.getValue("whereKey") + "` = "
					+ stepParameters.getValue("whereValue");
		}
		return sql;
	}

	public String executeSql(String parameterID) {
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		if(ConnectionString.equals("") || CommandText.equals("")){
			requestParameter.put("connectionString", stepParameters.ConnectiongString);
			requestParameter.put("commandText", sql);
		} else {
			requestParameter.put("connectionString", ConnectionString);
			requestParameter.put("commandText", stepParameters.CommandText);
		}
		requestParameter.put("user", stepParameters.getValue("dbUser"));
		requestParameter.put("password",
				stepParameters.getValue("dbPassword"));

		MysqlProxy sqlProxy = new MysqlProxy();
		SimpleLogger.logInfo(this.getClass(), "mysql parameters : " + requestParameter);
		SimpleLogger.logInfo(this.getClass(), "execute sql result : "
				+ sqlProxy.executeNoneQuery(requestParameter));
		return sqlProxy.executeNoneQuery(requestParameter);
	}
}

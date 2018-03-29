package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.Constant;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.common.MutilPlatUtil;
import com.baidu.gameqa.iat.steps.common.CacheFlush;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class GoDoubiValidateroleSteps {
	// modify by wangjing01,
	@AssertStepMethodDesc(description = "GoDoubi_queryUser", owner = "xiuping.qi")
	public void goDoubiValidaterole(String parameterID, String expectresult,
			String actualresult) throws Exception {
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		SimpleLogger.logInfo(this.getClass(), "=====usercooke:"
				+ currentConversation.getCookieValue("wanba_cookies"));
		SimpleLogger
				.logInfo(this.getClass(), "=====parameterID:" + parameterID);

		SimpleLogger.logInfo(this.getClass(), "=====actualresult:"
				+ actualresult);

	}
	
	@SetupStepMethodDesc(description = "loadServer_noLimit", owner = "wangjing01")
	public void loadServer_noLimit(String parameterID) throws Exception {
//		this.parameterID = parameterID;
//		this.platFlag = MutilPlatUtil.getPlatFlag();
//		if (platFlag == 4) {
//			this.updateYouxiInfonoLimit_newyouxi();
//			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);
//
//		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
//				|| platFlag == 1) {
//			this.updateYouxiInfonoLimit_newyouxi();
//			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
//		} else if (platFlag == 2) {
//			this.updateYouxiInfonoLimit_newyouxi();
//			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
//		}

	}

}

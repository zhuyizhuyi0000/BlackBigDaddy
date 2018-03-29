package demo.java.test;


public class Bsendback {
	public static void main(String args[])
	{
		String Bsendbacklog="bfb_order_rest/1?bank_no=&bfb_order_create_time=20120709150240&bfb_order_no=2012070933000000181110066647384&buyer_sp_username=zhuyi0001&currency=1&extra=&fee_amount=0&input_charset=1&order_no=345b3277bdf848710&pay_result=1&pay_time=20120709150240&pay_type=2&sign_method=1&sp_no=3300000018&total_amount=100&transport_amount=0&unit_amount=100&unit_count=1&version=2&sign=95d71d866e38469d6ff7e2059a569059";
		String Doid="345b3277bdf848710";
		String bank_no="201";
		String bfb_order_create_time="20120709150240";
		String bfb_order_no="2012070933000000181110066647384";
		String buyer_sp_username="zhuyi0001";
//		String currency=1&extra=&fee_amount=0&input_charset=1&order_no=345b3277bdf848710&pay_result=1&pay_time=20120709150240&pay_type=2&sign_method=1&sp_no=3300000018&total_amount=100&transport_amount=0&unit_amount=100&unit_count=1&version=2
		//DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	}
}
//
//public String createNoticeUrl() {
//	if (StringUtils.isBlank(oid)) {
//		return "showUrl";
//	}
//
//	String hql = "select new map(gameId as gameId,payName as pay_name,id.storeOid as store_oid,"
//			+ "coinOid as oid,amount*0.01 as amount,"
//			+ "currency as currency,orderStatus as orderStatus) "
//			+ "from OrderInfo where id.storeOid=?";
//	List list = orderInfoService.findOrderOnCommonNoCache(hql, oid);
//	if (list.size() == 0) {
//		msg = "订单号不存在";
//	} else if (list.size() >= 2) {
//		msg = "订单号重复";
//	} else {
//		Map dataMap = (Map) list.get(0);
//		if (!dataMap.get("orderStatus").toString().equals("30")) {
//			msg = "正在充值中...";
//			return "showUrl";
//		}
//
//		String baseUrl = "http://youxi.baidu.com/receive_order.xhtml?";
//		WanbaGame game = wanbaGameService.findById(Long.parseLong(dataMap
//				.get("gameId").toString()));
//		if (game.getActionTitle().startsWith("http://")) {
//			baseUrl = "http://youxi.baidu.com/receive_order_new.xhtml?";
//		}
//
//		String amount = dataMap.get("amount").toString();
//		if (StringUtils.contains(amount, ".")) {
//			String afterAmount = StringUtils.substringAfter(amount, ".");
//			if (Integer.parseInt(afterAmount) == 0) {
//				amount = StringUtils.substringBefore(amount, ".");
//			}
//		}
//
//		// 合并参数
//		StringBuffer sb = new StringBuffer();
//		sb.append("oid=").append(dataMap.get("oid"));
//		sb.append("&store_oid=").append(dataMap.get("store_oid"));
//		sb.append("&pay_oid=").append(dataMap.get("oid"));
//		sb.append("&amount=").append(amount);
//		sb.append("&currency=").append("CNY");
//		sb.append("&store_name=").append("baidu_wanba");
//		sb.append("&pay_name=").append(dataMap.get("pay_name"));
//		sb.append("&order_status=").append("30");
//		sb.append("&back_send=").append(back_send);
//		sb.append("&key=").append("41135Aa5d7Dbb2a2");
//
//		String sgStr = CoinMd5.getMD5ofStr(sb.toString());
//		String url = sb.toString();
//		url = baseUrl + url.substring(0, url.indexOf("key="))
//				+ "return_attach=hand&sig=" + sgStr;
//		msg = url;
//	}
//	return "showUrl";
//}
package task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityUrl {

	public static String commomStr = "http://map.baidu.com/?newmap=1&reqflag=pcmap&biz=1&from=webmap&da_par=direct"
			+ "&pcevaname=pc4.1&qt=con&from=webmap&wd=瑜伽馆&wd2=&"
			+ "db=0&sug=0&addr=0&pl_data_type=life&pl_sub_type=健身-瑜伽会所"
			+ "&pl_price_section=0%2C%2B&pl_sort_type=data_type&pl_sort_rule=0"
			+ "&pl_discount2_section=0%2C%2B&pl_groupon_section=0%2C%2B"
			+ "&pl_cater_book_pc_section=0%2C%2B&pl_hotel_book_pc_section=0%2C%2B"
			+ "&pl_ticket_book_flag_section=0%2C%2B&pl_movie_book_section=0%2C%2B"
			+ "&pl_business_type=life&pl_business_id=&da_src=pcmappg.poi.page&on_gel=1"
			+ "&src=7&gr=3&l=11&tn=B_NORMAL_MAP&u_loc=12733287,3546675" + "&ie=utf-8";

	public static Map<String, String> cityMap = new HashMap<String, String>();

	public CityUrl() {
		cityMap.put("北京市", "131");
		cityMap.put("上海", "289");
		cityMap.put("广东省",
				"257,340,119,138,301,140,259,140,187,303,139,302,197,200,258,198,137,201," + "199,338,141,339");
		cityMap.put("四川省", "73,74,75,76,77,78,79,80,81,185,186,239,240,241,242,248,291,329,330,331,369");
		cityMap.put("陕西省", "170,171,231,232,233,284,285,323,324,352");
		cityMap.put("山东省", "236,288,287,234,354,175,325,173,172,286,235,353,174,372,366,124");
		cityMap.put("江苏省", "224,315,317,316,348,161,277,223,347,160,346,276,162");
		cityMap.put("河南省", "268,153,309,152,267,308,210,154,213,269,211,155,214,344,212,209,215,1277");
		cityMap.put("浙江省", "179,333,180,178,334,244,293,294,292,243,245");
		cityMap.put("辽宁省", "58,167,320,152,267,308,210,154,213,269,211,155,214,344,212,209,215,1277");
		cityMap.put("湖北省", "218,156,270,216,271,310,311,217,157,373,362,122,371,1713,2654,1293");
		cityMap.put("河北省", "150,307,151,265,266,191,148,149,264,207,208");
		cityMap.put("福建省", "133,134,192,193,194,195,254,255,300");
		cityMap.put("湖南省", "158,159,219,220,221,222,272,273,274,275,312,313,314,363");
		cityMap.put("安徽省", "126,127,128,129,130,188,189,190,250,251,252,253,298,299,337,358,370");
		cityMap.put("江西省", "163,164,225,226,278,279,318,349,350,364,365");
		cityMap.put("广西壮族自治区", "142,143,144,145,202,203,204,260,261,295,304,305,341,361");
		cityMap.put("山西省", "176,237,238,290,327,328,355,356,357,367,368");
		cityMap.put("天津市", "332");
		cityMap.put("吉林省", "51,52,53,54,55,56,57,165,183");
		cityMap.put("重庆省", "132");
		cityMap.put("黑龙江省", "48,49,46,50,47");
		cityMap.put("内蒙古自治区", "61,62,63,64,123,168,169,229,230,283,297,321");
		cityMap.put("云南省", "104,105,106,107,108,109,110,111,112,114,116,177,249,336");
		cityMap.put("甘肃省", "33,34,35,36,37,117,118,135,136,196,256,359");
		cityMap.put("新疆维吾尔自治区", "92,93,95,86,91,770,94,789");
		cityMap.put("海南省", "125,121,1215,1641,2758");
		cityMap.put("贵州省", "146,147,205,206,262,263,306,342");
		cityMap.put("宁夏回族自治区", "181,246,322,335,360");
		cityMap.put("青海省", "66");
		cityMap.put("西藏自治区", "98,100");
	}

	// public CityUrl() {
	// cityMap.put("北京",commomStr+"&c=131");
	// cityMap.put("上海",commomStr+"&c=289");
	// cityMap.put("广州",commomStr+"&c=257");
	// cityMap.put("深圳",commomStr+"&c=340");
	// cityMap.put("成都",commomStr+"&c=75");
	// cityMap.put("天津",commomStr+"&c=332");
	// cityMap.put("南京",commomStr+"&c=315");
	// cityMap.put("武汉",commomStr+"&c=218");
	// cityMap.put("重庆",commomStr+"&c=132");
	// cityMap.put("西安", commomStr+"&c=233");
	// //山东省
	// cityMap.put("青岛", commomStr+"&c=236");
	// cityMap.put("济南", commomStr+"&c=288");
	// cityMap.put("潍坊", commomStr+"&c=287");
	// cityMap.put("临沂", commomStr+"&c=234");
	// cityMap.put("淄博", commomStr+"&c=354");
	// cityMap.put("威海", commomStr+"&c=175");
	// cityMap.put("泰安", commomStr+"&c=325");
	// cityMap.put("日照", commomStr+"&c=173");
	// cityMap.put("枣庄", commomStr+"&c=172");
	// cityMap.put("济宁", commomStr+"&c=286");
	// cityMap.put("滨州", commomStr+"&c=235");
	// cityMap.put("菏泽", commomStr+"&c=353");
	// cityMap.put("东营", commomStr+"&c=174");
	// cityMap.put("德州", commomStr+"&c=372");
	// cityMap.put("聊城", commomStr+"&c=366");
	// cityMap.put("莱芜", commomStr+"&c=124");
	//
	// //江苏省
	// cityMap.put("苏州", commomStr+"&c=224");
	// cityMap.put("南京", commomStr+"&c=315");
	// cityMap.put("无锡", commomStr+"&c=317");
	// cityMap.put("徐州", commomStr+"&c=316");
	// cityMap.put("常州", commomStr+"&c=348");
	// cityMap.put("南通", commomStr+"&c=161");
	// cityMap.put("宿迁", commomStr+"&c=277");
	// cityMap.put("盐城", commomStr+"&c=223");
	// cityMap.put("连云港", commomStr+"&c=347");
	// cityMap.put("镇江", commomStr+"&c=160");
	// cityMap.put("扬州", commomStr+"&c=346");
	// cityMap.put("泰州", commomStr+"&c=276");
	// cityMap.put("淮安", commomStr+"&c=162");
	//
	// //浙江省
	// cityMap.put("杭州", commomStr+"&c=179");
	// cityMap.put("金华", commomStr+"&c=333");
	// cityMap.put("宁波", commomStr+"&c=180");
	// cityMap.put("温州", commomStr+"&c=178");
	// cityMap.put("嘉兴", commomStr+"&c=334");
	// cityMap.put("台州", commomStr+"&c=244");
	// cityMap.put("绍兴", commomStr+"&c=293");
	// cityMap.put("湖州", commomStr+"&c=294");
	// cityMap.put("丽水", commomStr+"&c=292");
	// cityMap.put("衢州", commomStr+"&c=243");
	// cityMap.put("舟山", commomStr+"&c=245");
	//
	// //河南省
	// cityMap.put("郑州", commomStr+"&c=268");
	// cityMap.put("洛阳", commomStr+"&c=153");
	// cityMap.put("南阳", commomStr+"&c=309");
	// cityMap.put("新乡", commomStr+"&c=152");
	// cityMap.put("安阳", commomStr+"&c=267");
	// cityMap.put("周口", commomStr+"&c=308");
	// cityMap.put("开封", commomStr+"&c=210");
	// cityMap.put("商丘", commomStr+"&c=154");
	// cityMap.put("平顶山", commomStr+"&c=213");
	// cityMap.put("驻马店", commomStr+"&c=269");
	// cityMap.put("焦作", commomStr+"&c=211");
	// cityMap.put("许昌", commomStr+"&c=155");
	// cityMap.put("信阳", commomStr+"&c=214");
	// cityMap.put("漯河", commomStr+"&c=344");
	// cityMap.put("三门峡", commomStr+"&c=212");
	// cityMap.put("濮阳", commomStr+"&c=209");
	// cityMap.put("鹤壁", commomStr+"&c=215");
	// cityMap.put("济源", commomStr+"&c=1277");
	//
	// //辽宁省
	// cityMap.put("沈阳", commomStr+"&c=58");
	// cityMap.put("大连", commomStr+"&c=167");
	// cityMap.put("鞍山", commomStr+"&c=320");
	// cityMap.put("新乡", commomStr+"&c=152");
	// cityMap.put("安阳", commomStr+"&c=267");
	// cityMap.put("周口", commomStr+"&c=308");
	// cityMap.put("开封", commomStr+"&c=210");
	// cityMap.put("商丘", commomStr+"&c=154");
	// cityMap.put("平顶山", commomStr+"&c=213");
	// cityMap.put("驻马店", commomStr+"&c=269");
	// cityMap.put("焦作", commomStr+"&c=211");
	// cityMap.put("许昌", commomStr+"&c=155");
	// cityMap.put("信阳", commomStr+"&c=214");
	// cityMap.put("漯河", commomStr+"&c=344");
	// cityMap.put("三门峡", commomStr+"&c=212");
	// cityMap.put("濮阳", commomStr+"&c=209");
	// cityMap.put("鹤壁", commomStr+"&c=215");
	// cityMap.put("济源", commomStr+"&c=1277");
	// }

	public static String[] keys = new String[] { 
			"北京市", "上海", "广东省", "四川省", "陕西省", 
			"山东省", "江苏省", "河南省", "浙江省", "辽宁省",
			"湖北省", "河北省", "福建省", "湖南省", "安徽省", 
			"江西省", "广西壮族自治区", "山西省", "天津市", 
			"吉林省", "重庆省", "黑龙江省", "内蒙古自治区", "云南省",
			"甘肃省", "新疆维吾尔自治区", "海南省", "贵州省",
			"宁夏回族自治区", "青海省", "西藏自治区" };
}

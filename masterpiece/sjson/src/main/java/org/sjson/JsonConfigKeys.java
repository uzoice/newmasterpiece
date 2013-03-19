package org.sjson;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class JsonConfigKeys {
	public static final int UTIL_DATE_FORMAT = 1;// yyyy-MM-dd hh:mm:ss
	public static final int TIME_FORMAT = 2; // hh:mm:ss
	public static final int DATE_FORMAT = 3; // yyyy-MM-dd
	public static final int DATETIME_FORMAT = 4;// yyyy-MM-dd hh:mm:ss
	public static final int WRITE_NULL_STRING = 5;// true
	public static final int WRITE_NULL_STRING_AS = 6;// ""
	public static final int WRITE_NULL_LIST = 7;// true

	public static final Map<Integer, Object> DEFAULT_CONFIGS = new HashMap<>(10);
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT =new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat DEFAULT_TIME_FORMAT =new SimpleDateFormat("hh:mm:ss");
	public static final SimpleDateFormat DEFAULT_DATETIME_FORMAT =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	static {
//		DEFAULT_CONFIGS.put(TIME_FORMAT, "hh:mm:ss");
//		DEFAULT_CONFIGS.put(DATE_FORMAT, "yyyy-MM-dd");
//		DEFAULT_CONFIGS.put(DATETIME_FORMAT, "yyyy-MM-dd hh:mm:ss");
		DEFAULT_CONFIGS.put(WRITE_NULL_STRING, true);
		DEFAULT_CONFIGS.put(WRITE_NULL_STRING_AS, "");
		DEFAULT_CONFIGS.put(WRITE_NULL_LIST, true);
	}
}

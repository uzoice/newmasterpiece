package org.sjson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonCodecTrunk implements JsonCodec {

	private Charset charset = Charset.forName("utf-8");
	private Map<Integer, Object> config = new HashMap<>();

	Map<Type, TypeCodec> codecs = new HashMap<>();
	public static Map<Integer, Object> DEFAULT_CONFIGS = new HashMap<>(10);
	public static SimpleDateFormat DEFAULT_DATE_FORMAT = JsonConfigKeys.DEFAULT_DATE_FORMAT;
	public static SimpleDateFormat DEFAULT_TIME_FORMAT = JsonConfigKeys.DEFAULT_TIME_FORMAT;
	public static SimpleDateFormat DEFAULT_DATETIME_FORMAT = JsonConfigKeys.DEFAULT_DATETIME_FORMAT;

	public JsonCodecTrunk() {
		config.putAll(JsonConfigKeys.DEFAULT_CONFIGS);
	}

	public JsonCodecTrunk(Map<String, Object> config) {
		this();
		config.putAll(config);
	}

	public static void main(String[] args) {
		String a = "'a";
		String ab = "\'a";
		for (byte b : a.getBytes()) {
			System.out.print(b);
		}
		System.out.println();
		for (byte b : ab.getBytes()) {
			System.out.print(b);
		}
	}

	private static final Set<Class<?>> NUMERIC_TYPE = new HashSet<>();
	static {
		NUMERIC_TYPE.add(Character.class);
		NUMERIC_TYPE.add(Short.class);
		NUMERIC_TYPE.add(Integer.class);
		NUMERIC_TYPE.add(Long.class);
		NUMERIC_TYPE.add(Double.class);
		NUMERIC_TYPE.add(Float.class);
		NUMERIC_TYPE.add(BigInteger.class);
		NUMERIC_TYPE.add(BigDecimal.class);
	}

	public void encodeBasicType(Class<?> type, Object value, StringBuilder builder) {
		if (value instanceof Double) {

		}
	}

	/**
	 * 只支持三种类型： Map , Iterable , Basic
	 */
	@Override
	public String encode(Object object) {
		// int size = 1024;
		// ByteArrayOutputStream outputStream = new ByteArrayOutputStream(size);
		// StringBuilder builder = new StringBuilder(size);
		if (null == object) {
			return null;
		}
		Class<?> type = object.getClass();
		TypeCodec codec = codecs.get(type);
		boolean isEmpty = true;
		if (object instanceof Map) {
			StringBuilder builder = new StringBuilder(1024);
			Map map = (Map) object;
			builder.append('{');
			for (Object e : map.entrySet()) {
				isEmpty = false;
				Entry entry = (Entry) e;
				builder.append("\"");
				builder.append(entry.getKey());
				builder.append("\"");
				builder.append(':');
				builder.append(encode(entry.getValue()));
				builder.append(',');
			}
			if (!isEmpty) {
				builder.deleteCharAt(builder.length() - 1);
			}
			builder.append('}');
			return builder.toString();
		}
		if (object instanceof Iterable) {
			StringBuilder builder = new StringBuilder(1024);
			Iterable list = (Iterable) object;
			builder.append('[');
			Class itemType = null;
			for (Object item : list) {
				isEmpty = false;
				builder.append(encode(item));
				builder.append(',');
			}
			if (!isEmpty) {
				builder.deleteCharAt(builder.length() - 1);
			}
			builder.append(']');
			return builder.toString();
		}
		if (type.isArray()) {
			StringBuilder builder = new StringBuilder(1024);
			builder.append('[');
			String arrayString = object.toString();
			builder.append(']');
			return builder.toString();
		}
		if (String.class.equals(type)) {
			String value = (String) object;
			StringBuilder builder = new StringBuilder(value.length() + 2);
			builder.append("\"");
			builder.append(value);
			builder.append("\"");
			return builder.toString();
		}
		if (NUMERIC_TYPE.contains(type)) {
			StringBuilder builder = new StringBuilder(10);
			builder.append(object);
			return builder.toString();
		}

		if (object instanceof Date) {
			StringBuilder builder = new StringBuilder(10);
			builder.append("\"");
			builder.append(DEFAULT_DATE_FORMAT.format((Date) object));
			builder.append("\"");
			return builder.toString();
		}
		if (object instanceof Time) {
			StringBuilder builder = new StringBuilder(8);
			builder.append("\"");
			builder.append(DEFAULT_TIME_FORMAT.format((Time) object));
			builder.append("\"");
			return builder.toString();
		}
		if (object instanceof Timestamp) {
			StringBuilder builder = new StringBuilder(19);
			builder.append("\"");
			builder.append(DEFAULT_DATETIME_FORMAT.format((Timestamp) object));
			builder.append("\"");
			return builder.toString();
		}
		if (object instanceof java.util.Date) {
			StringBuilder builder = new StringBuilder(19);
			builder.append("\"");
			builder.append(DEFAULT_DATETIME_FORMAT.format((java.util.Date) object));
			builder.append("\"");
			return builder.toString();
		}
		return codecs.get(type).encode(object);

	}

	@Override
	public Object decode(String string) {
		Object result = null;
		String json = string.trim();
		if(json.startsWith("{")){
			
		}
		
		return result;
	}

	@Override
	public void registerTypeCodec(Type type, TypeCodec typeCodec) {
		codecs.put(type, typeCodec);
	}

}

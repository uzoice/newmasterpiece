package org.sjson;

import java.lang.reflect.Type;

public interface JsonCodec {
	String encode(Object object);
	Object decode(String object);
	void registerTypeCodec(Type type , TypeCodec typeCodec);
}

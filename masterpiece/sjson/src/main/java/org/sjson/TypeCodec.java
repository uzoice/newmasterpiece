package org.sjson;

import java.lang.reflect.Type;

public interface TypeCodec {
	String encode(Object object);
	String decode(Type type  , Object object);
}

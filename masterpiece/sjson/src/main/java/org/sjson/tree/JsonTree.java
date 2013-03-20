package org.sjson.tree;

import java.io.IOException;
import java.io.StringReader;

import javax.management.RuntimeErrorException;

import org.sjson.JsonStatus;

public class JsonTree {
	
	public static void main(String[] args) throws IOException {
		JsonTree jsonTree = new JsonTree();
		String s = "{\"name\":\"jim\" , \"age\":10,\"emails\":[\"1@163.com\",1] ,\"1\":\"jinm\"}";
		StringReader reader = new StringReader(s );
//		System.out.println(jsonTree.parse(reader ));
	}

	public Node parse(StringReader reader , JsonStatus jsonStatus) throws IOException {

		
		return null;
	}
	
	boolean containChar(char c , char... anchor){
		for (char d : anchor) {
			if(c == d){
				return true;
			}
		}
		return false;
	}

	String readTo(StringReader reader, char... anchor) {
		StringBuilder builder = new StringBuilder();
		int c = -1;
		boolean escaped = false;
		try {
			while (-1 != (c = reader.read())) {
				if (containChar((char)c, anchor) && !escaped) {
					break;
				}
				if ('\\' == c) {
					escaped = true;
				} else {
					escaped = false;
				}
				builder.append((char)c);
			}
			return builder.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

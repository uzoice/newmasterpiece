package org.sjson;

public class JsonValue {
	private String value;
	public JsonValue(String value){
		this.value = value;
	}
	
	public String get(){
		return value;
	}
	
	
	public int getInt(){
		return Integer.valueOf(value);
	}
	
	
}

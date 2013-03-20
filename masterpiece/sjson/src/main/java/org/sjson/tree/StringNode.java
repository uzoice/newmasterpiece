package org.sjson.tree;

public class StringNode extends Node{
	public String value;

	public StringNode(String value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "\""+value+"\"";
	}
}

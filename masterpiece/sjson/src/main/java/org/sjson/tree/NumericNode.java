package org.sjson.tree;

public class NumericNode extends Node {
	public String value;

	public NumericNode(String value) {
		super();
		this.value = value;
	}
	@Override
	public String toString() {
		return value;
	}

}

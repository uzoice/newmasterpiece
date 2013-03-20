package org.sjson.tree;

public class KeyValueNode extends Node {
	public String key;
	public Node node;

	public KeyValueNode(String key, Node node) {
		super();
		this.key = key;
		this.node = node;
	}
	
	@Override
	public String toString() {
		if(null==node){
			return "null";
		}
		return "\""+key+"\":"+node.toString();
	}

}

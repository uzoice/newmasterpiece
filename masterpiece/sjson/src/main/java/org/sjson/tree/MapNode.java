package org.sjson.tree;

import java.util.LinkedList;
import java.util.List;

public class MapNode extends Node{
	public List<KeyValueNode> nodes = new LinkedList<>();
	
	@Override
	public String toString() {
		String s = "{";
		for (KeyValueNode node : nodes) {
			s+=node.toString()+",";
		}
		s+="}";
		return s;
	}

}

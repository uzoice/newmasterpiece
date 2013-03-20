package org.sjson.tree;

import java.util.LinkedList;
import java.util.List;

public class ListNode extends Node {
	public List<Node> nodes = new LinkedList<>();
	
	@Override
	public String toString() {
		String s = "[";
		for (Node node : nodes) {
			s+=(null==node?null:node.toString())+",";
		}
		s+="]";
		return s;
	}
}

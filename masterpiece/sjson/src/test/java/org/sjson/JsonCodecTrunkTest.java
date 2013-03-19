package org.sjson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JsonCodecTrunkTest {
	JsonCodecTrunk jsonCodecTrunk = new JsonCodecTrunk();

	@Test
	public void testEncodeList() {
		Map<Object, Object> map = new HashMap<>();
		map.put("hello", 1);
		map.put("fdfd", new Date());
		map.put("as", new int[] { 1, 2, 3, 4 });
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add("fdf");
			list.add(1);
			list.add(map);
		}
		// map.put("hello", list);
		System.out.println(jsonCodecTrunk.encode(list));
	}
	@Test
	public void testEncodeMap() {
		Map<Object, Object> map = new HashMap<>();
		map.put("age", 10);
		map.put("name", "jim");
//		map.put("fdfd", new Date());
//		map.put("as", new int[] { 1, 2, 3, 4 });
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("fdf");
			list.add(1);
//			list.add(map);
		}
		map.put("list", list);
		String r =jsonCodecTrunk.encode(list);
		// map.put("hello", list);
		System.out.println(r);
	}
	
	@Test
	public void testArray(){
		int[] ia = {1};
		char[] ca = {123};
		float[] fa = {1};
		double[] da = {1};
		Integer[] Ia = {1};
		String[] sa = {"z"};
		System.out.println(ia);
		Object oca = ca;
		System.out.println(oca.toString());
		System.out.println(fa);
		System.out.println(da);
		System.out.println(Ia);
		System.out.println(sa);
	}

}

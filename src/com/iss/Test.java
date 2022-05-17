package com.iss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface AttributeTypeI {
}

enum AttributeType implements AttributeTypeI {
	A, B, C, D;

	enum US implements AttributeTypeI {
		AA, AB, AC, AD, AE
	}

	enum NZ implements AttributeTypeI {
		BA, BB, BC, BD
	}
}

public class Test {
	public static void main1(String[] args) {
		StringBuffer sb = new StringBuffer("abcdef");
		sb.setLength(2);
		System.out.println(sb);
	}

	public static void main(String[] args) {
		Map<AttributeTypeI, String> map = new HashMap<AttributeTypeI, String>();
		map.put(AttributeType.US.AA, "g");
		map.put(AttributeType.NZ.BA, "h");
		System.out.println(map);
		map.entrySet().stream().forEach(k -> {
			AttributeTypeI l=AttributeType.valueOf(k.getKey().toString());
			System.out.println(l);
		});
	}

}

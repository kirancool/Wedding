package com.wedding.meta;

public class Helper {
	public static String generateTableName(String filePath) {
		if (filePath ==  null) {
		
			return "Path was null";
		}
		
		String[] list = filePath.split("/");
		
		return String.format("%s_%s_%s", list[list.length-3].replaceAll("-", "_"), list[list.length-2], list[list.length-1]);
	}

}

package com.learning.vault.util;

public class StringUtils {

	public static boolean isNullOrEmpty(String str) {
		if(str!=null && !str.trim().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public static String removeSlash(String str) {
		if(!isNullOrEmpty(str)) {
			if(str.contains("/")) {
				str = str.replace("/", "");
				System.out.println("After removing slash str:"+str);
			}
		}
		
		return str;
	}

}

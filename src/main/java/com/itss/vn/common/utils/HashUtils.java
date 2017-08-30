package com.itss.vn.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashUtils {
	
	public static boolean compareToHash(String str, String hashedStr) {
//		BCryptPasswordEncoder b = new BCryptPasswordEncoder(12);
//		return b.matches(str, hashedStr);
		return str.equals(hashedStr);
	}

}

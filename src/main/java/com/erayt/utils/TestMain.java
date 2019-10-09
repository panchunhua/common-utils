package com.erayt.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author panch
 *
 */
public class TestMain {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "测试展会同步                                                                                  201801";
		System.out.println(str.length());
		byte[] buff = str.getBytes("gbk");
		System.out.println(buff.length);
		String str1 = "测试展会同步                                                                                  ";
		System.out.println(str1.length());
		byte[] buff1 = str1.getBytes("gbk");
		System.out.println(buff1.length);
		

	}

}

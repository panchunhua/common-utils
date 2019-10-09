/**
 * 
 * @author panch
 * @date 2019年5月15日
 */
package com.erayt.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 * @author panch
 *
 */
public class ExtractMessage {

	/**
	 * 递归遍历目录下面所有的.java文件，根据正则表达式匹配出所有的符合正则表达式字符串
	 * @param read
	 * @param write
	 * @param reg
	 * @throws IOException
	 */
	public static void readFileContent(File read, File write, String reg) throws IOException {
		if (!read.exists()) {
			return;
		}
		if (read.isFile() && read.getName().endsWith(".java")) {
			System.out.println("开始解析文件：" + read.getAbsolutePath());
			List<String> list = FileUtils.readLines(read, "utf-8");
			for (String str : list) {
				Pattern p = Pattern.compile(reg);
				Matcher m = p.matcher(str);
				List<String> subList = new ArrayList<String>();
				while (m.find()) {
					subList.add(m.group());
				}
				FileUtils.writeLines(write, "utf-8", subList, true);
			}
		} else if (read.isDirectory()) {
			File[] files = read.listFiles();
			for (File fi : files) {
				readFileContent(fi, write, reg);
			}
		}
	}

}

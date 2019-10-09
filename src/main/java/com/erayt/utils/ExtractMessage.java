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

	public static void main(String[] args) {
		// File read = new File(
		// "D:\\workspaces\\eclipse-workspace\\workspace_goldfair_903\\goldfair\\src\\com\\erayt\\goldfair");
		// File write = new File("./write.txt");
		// String reg = "error[.]{1}([a-zA-Z]+[.]{1})+[a-zA-Z]+";
		// try {
		// ExtractMessage.readFileContent(read, write, reg);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// File write2 = new File("./write2.txt");
		// File write3 = new File("./write3.txt");
		// List<String> list = new ArrayList<String>();
		// try {
		// List<String> listwrite2 = FileUtils.readLines(write2, "utf-8");
		// for (String str : listwrite2) {
		// String s = StringUtils.trim(StringUtils.substring(str, 0,
		// str.indexOf(":")));
		// list.add(s);
		// }
		// FileUtils.writeLines(write3, "utf-8", list, true);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

//		File write = new File("./write.txt");
//		File write3 = new File("./write3.txt");
//		File write4 = new File("./write4.txt");
//		try {
//			List<String> listwrite = FileUtils.readLines(write, "utf-8");
//			List<String> listwrite3 = FileUtils.readLines(write3, "utf-8");
//			List<String> list = new ArrayList<String>();
//			for (String str : listwrite) {
//				if (!listwrite3.contains(str)) {
//					list.add("\"" + str + "\"" + ":\"\",");
//					System.out.println(str);
//				}
//			}
//			
//			FileUtils.writeLines(write4, "utf-8", list, true);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		File write4 = new File("./write4.txt");
		File write5 = new File("./write5.txt");
		try {
			List<String> listwrite4 = FileUtils.readLines(write4, "utf-8");
			List<String> list = new ArrayList<String>();
			for(String str : listwrite4)
			{
				if(!list.contains(str))
				{
					list.add(str);
				}
			}
			FileUtils.writeLines(write5, "utf-8", list, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

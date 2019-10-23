package com.itheima.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class DownLoadUtils {
	/**
	 * 处理下载文件名称为中文
	 * @param agent 浏览器内核
	 * @param filename 原来文件的名称
	 * @return 处理后的文件名称
	 * @throws 
	 */
	public static String getName(String agent, String filename) throws UnsupportedEncodingException {
		if (agent.contains("Firefox")) {
			// 火狐浏览器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// 其它浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}
}

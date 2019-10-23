package com.itheima.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.DownLoadUtils;

public class GifServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String filename = "裸眼3D.gif";
		String agent = request.getHeader("User-Agent");
		String name = DownLoadUtils.getName(agent, filename);
		response.setHeader("Content-Disposition", "attachment;filename="+name);
		String path = getServletContext().getRealPath("/download/裸眼3D.gif");
		InputStream in = new FileInputStream(path);
		ServletOutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
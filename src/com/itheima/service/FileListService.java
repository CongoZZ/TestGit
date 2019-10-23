package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.FileListDao;
import com.itheima.domain.DownloadFile;

public class FileListService {

	public List<DownloadFile> findAll() {
		FileListDao fld=new FileListDao(); 
		List<DownloadFile> list=null;
		try {
			list = fld.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}

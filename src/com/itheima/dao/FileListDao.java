package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.DownloadFile;
import com.itheima.utils.DataSourceUtils;

public class FileListDao {

	public List<DownloadFile> findAll() throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from filelist";
		List<DownloadFile> list = qr.query(sql, new BeanListHandler<DownloadFile>(DownloadFile.class));
		return list;
	}

}

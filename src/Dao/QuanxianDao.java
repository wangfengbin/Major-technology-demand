package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.QuanxianBean;
import util.jdbcUtil;

public class QuanxianDao {
	
	/**
	 * ����Ȩ��id����Ȩ�޵�
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public QuanxianBean selectQuanxian(int id) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from ";
		QuanxianBean quanxianbean = new QuanxianBean();
		return quanxianbean;
	}

}

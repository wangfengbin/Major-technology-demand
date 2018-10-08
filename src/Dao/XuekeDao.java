package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.FirstXuekeBean;
import Bean.HangyeBean;
import Bean.TwoHangyeBean;
import Bean.TwoxuekeBean;

public class XuekeDao {
	
	public List<FirstXuekeBean> getXueke() throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select * from firstxueke";
		List<FirstXuekeBean> firstBeans = new ArrayList<FirstXuekeBean>();
		FirstXuekeBean firstbean = null;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			firstbean = new FirstXuekeBean();
			firstbean.setId(rs.getInt("id"));
			firstbean.setName(rs.getString("xueke"));
			firstbean.setCode(rs.getString("code"));
			firstBeans.add(firstbean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return firstBeans;
	}
	
	
	public List<TwoxuekeBean> getTwoxueke(int fuid) throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select * from twoxueke where fuid="+fuid;
		List<TwoxuekeBean> twoBeans = new ArrayList<TwoxuekeBean>();
		TwoxuekeBean twobean = null;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			twobean = new TwoxuekeBean();
			twobean.setId(rs.getInt("id"));
			twobean.setName(rs.getString("xueke"));
			twobean.setCode(rs.getString("code"));
			twoBeans.add(twobean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return twoBeans;
	}
	
	public List<HangyeBean> getHangye() throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select * from firsthangye";
		List<HangyeBean> hangyeBeans = new ArrayList<HangyeBean>();
		HangyeBean hangyebean = null;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			hangyebean = new HangyeBean();
			hangyebean.setId(rs.getInt("id"));
			hangyebean.setHangye(rs.getString("hangye"));
			hangyebean.setCode(rs.getInt("code"));
			hangyeBeans.add(hangyebean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return hangyeBeans;
	}
	
	
	public List<TwoHangyeBean> getTwohangye(int fuid) throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select * from twohangye where fuid="+fuid;
		List<TwoHangyeBean> twoBeans = new ArrayList<TwoHangyeBean>();
		TwoHangyeBean twobean = null;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			twobean = new TwoHangyeBean();
			twobean.setId(rs.getInt("id"));
			twobean.setTwohangye(rs.getString("hangye"));
			twobean.setCode(rs.getInt("code"));
			twobean.setFuid(rs.getInt("fuid"));
			twoBeans.add(twobean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return twoBeans;
	}
	/**
	 * 根据第一行业的id,找到该行业的名字
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public String getHangye(int id) throws SQLException, ClassNotFoundException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select * from firsthangye where id="+id;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String hangye = "";
		if(rs.next())
		{
			hangye = rs.getString("hangye");
		}
		return hangye;
	}
	
	/**
	 * 根据学科的id,找到该学科的名字
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String getXueke(int id) throws SQLException, ClassNotFoundException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select * from firstxueke where id="+id;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String xueke = "";
		if(rs.next())
		{
			xueke = rs.getString("xueke");
		}
		return xueke;
	}
}

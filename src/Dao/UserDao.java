package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.JueseBean;
import Bean.PageBean;
import Bean.UserBean;
import util.jdbcUtil;


public class UserDao {
	
	/**
	 * 根据用户名返回用户对象
	 * @param username
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserBean searchuser(String username) throws ClassNotFoundException, SQLException
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
		String sql = "select * from user where username='"+username+"'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		UserBean userbean = null;
		if(rs.next())
		{
			int id = rs.getInt("id");
			String password = rs.getString("password");
			String phnumber = rs.getString("phnumber");
			String depart = rs.getString("depart");
			String truename = rs.getString("truename");
			String city = rs.getString("city");
			String director = rs.getString("director");
			String hangye = rs.getString("hangye");
			String education = rs.getString("education");
			String zhicheng = rs.getString("zhicheng");
			String address = rs.getString("address");
			String e_code = rs.getString("e_code");
			String dianhua = rs.getString("dianhua");
			String email = rs.getString("email");
			String cardid = rs.getString("cardid");
			String jigoushuxing = rs.getString("jigoushuxing");
			String jigoujianjie = rs.getString("jigoujianjie");
			String departname = rs.getString("departname");
			String wangzhi = rs.getString("wangzhi");
			String faren = rs.getString("faren");
			String chuanzhen = rs.getString("chuanzhen");
			userbean = new UserBean( id,  username,  password,  phnumber,  depart,  truename,
					 city,  director,  hangye,  education,  zhicheng,  address,
					 e_code,  dianhua,  email,  cardid,  jigoushuxing,  jigoujianjie,
					 departname,  wangzhi,  faren,  chuanzhen);
			userbean.setJuese(rs.getString("juese"));
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return userbean;
		
	}
	
	/**
	 * 获得用户的集合
	 * @return
	 * @throws Exception
	 */
	public List<UserBean> getUserBeans() throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from user";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<UserBean> userbeans = new ArrayList<UserBean>();
		while(rs.next())
		{
			UserBean userbean = new UserBean();
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String phnumber = rs.getString("phnumber");
			String depart = rs.getString("depart");
			String truename = rs.getString("truename");
			String city = rs.getString("city");
			String director = rs.getString("director");
			String hangye = rs.getString("hangye");
			String education = rs.getString("education");
			String zhicheng = rs.getString("zhicheng");
			String address = rs.getString("address");
			String e_code = rs.getString("e_code");
			String dianhua = rs.getString("dianhua");
			String email = rs.getString("email");
			String cardid = rs.getString("cardid");
			String jigoushuxing = rs.getString("jigoushuxing");
			String jigoujianjie = rs.getString("jigoujianjie");
			String departname = rs.getString("departname");
			String wangzhi = rs.getString("wangzhi");
			String faren = rs.getString("faren");
			String chuanzhen = rs.getString("chuanzhen");
			userbean = new UserBean( id,  username,  password,  phnumber,  depart,  truename,
					 city,  director,  hangye,  education,  zhicheng,  address,
					 e_code,  dianhua,  email,  cardid,  jigoushuxing,  jigoujianjie,
					 departname,  wangzhi,  faren,  chuanzhen);
			userbean.setJuese(rs.getString("juese"));
			userbeans.add(userbean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return userbeans;
	}
	
	/**
	 * 修改用户的juese
	 * @param username
	 * @param juese
	 * @return
	 * @throws Exception
	 */
	public boolean upjuese(String username,String juese) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "update user set juese=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, juese);
		int a = 0;
		boolean f = false;
		a = pstmt.executeUpdate();
		if(a > 0)
			f =true;
		jdbcUtil.closeResource(conn, pstmt, rs);
		return f;
	}
	
	/**
	 * 修改密码
	 * @param username
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean updateMima(String password,String username) throws ClassNotFoundException, SQLException
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
		String sql = "update user set password="+password+" where username="+username;
		pstmt = conn.prepareStatement(sql);
		boolean f = false;
		int a = 0;
		a = pstmt.executeUpdate();
		if(a > 0)
			f =true;
		return f;
	}
	/**
	 * 修改用户信息
	 * @param userbean
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean update(UserBean userbean) throws SQLException, ClassNotFoundException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn=DriverManager.getConnection(dbURL,userName,userPwd);
		String sql = "update user set username='"+userbean.getUsername()+"',password='"+
				userbean.getPassword()+"',phnumber='"+userbean.getPhnumber()+"',depart='"+userbean.getDepart()+"'";
		pstmt = conn.prepareStatement(sql);
		boolean f = false;
		int a = 0;
		a = pstmt.executeUpdate();
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		if(a > 0)
			f = true;
		return f ;
	}
	/**
	 * 添加用户
	 * @param userbean
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean adduser(UserBean userbean) throws ClassNotFoundException, SQLException
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
		String sql = "insert into user(username,password,phnumber,depart,truename,city,director,"
				+ "hangye,education,zhicheng,address,e_code,dianhua,email,cardid,juese) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userbean.getUsername());
		pstmt.setString(2, userbean.getPassword());
		pstmt.setString(3, userbean.getPhnumber());
		pstmt.setString(4, userbean.getDepart());
		pstmt.setString(5, userbean.getTruename());
		pstmt.setString(6, userbean.getCity());
		pstmt.setString(7, userbean.getDirector());
		pstmt.setString(8, userbean.getHangye());
		pstmt.setString(9, userbean.getEducation());
		pstmt.setString(10, userbean.getZhicheng());
		pstmt.setString(11, userbean.getAddress());
		pstmt.setString(12, userbean.getE_code());
		pstmt.setString(13, userbean.getDianhua());
		pstmt.setString(14, userbean.getEmail());
		pstmt.setString(15, userbean.getCardid());
		pstmt.setString(16, "普通用户");
		int a = 0;
		boolean f = false;
		a = pstmt.executeUpdate();
		if(a > 0)
			f= true;
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return f;
	}
	
	/**
	 * 将需求征集的用户信息修改
	 * @param userbean
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean updateInsert(UserBean userbean ,int id) throws ClassNotFoundException, SQLException
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
		String sql = "update user set depart='"+userbean.getDepart()+
				"',departname='"+userbean.getDepartname()+"',truename='"+userbean.getTruename()+
				"',dianhua='"+userbean.getDianhua()+"',phnumber='"+userbean.getPhnumber()+
				"',chuanzhen='"+userbean.getChuanzhen()+"',jigoushuxing='"+userbean.getJigoushuxing()
				+"' where id="+id;
		
		pstmt = conn.prepareStatement(sql);
		boolean f = false;
		int a = 0;
		a = pstmt.executeUpdate();
		if(a > 0) f = true;
		return f;
	}
	
	/**
	 * mysql数据库分页查询
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<UserBean> findPage(int currPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String userName = "root";
		String userPwd = "123123";
		String ur11 = "jdbc:mysql://localhost:3306/need";
		String ur12 = "?user=" + userName + "&password=" + userPwd;
		String ur13 = "&useUnicode=true&characterEncoding=UTF-8";
		String ur1 = ur11 + ur12 + ur13;
		Class.forName(driverName);
		conn = DriverManager.getConnection(ur1);
		String sql = "select * from user limit ?,?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,(currPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();  //查询
		//PageBean<UserBean> bean = new PageBean<UserBean>();
		List<UserBean> userlist = new ArrayList<UserBean>();
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("username");
			String password = rs.getString("password");
			UserBean userbean = new UserBean(id,name,password);
			userlist.add(userbean);
		}
		
		if(pstmt != null)
			pstmt.close();
		if(conn != null)
			conn.close();
		System.out.println("每页内容"+userlist);
		return userlist;
	}
//	public static void main(String[] args) throws Exception
//	{
//		int a = getCount();
//		System.out.println("数量");
//	}
	public int getCount() throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String userName = "root";
		String userPwd = "123123";
		String ur11 = "jdbc:mysql://localhost:3306/need";
		String ur12 = "?user=" + userName + "&password=" + userPwd;
		String ur13 = "&useUnicode=true&characterEncoding=UTF-8";
		String ur1 = ur11 + ur12 + ur13;
		Class.forName(driverName);
		conn = DriverManager.getConnection(ur1);
		String sql = "select count(*) as num from user";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int a = 0;
		if(rs.next())
		{
			a = rs.getInt(1);
		}
		System.out.println("数量条数"+a);
		return a; 
	}
}

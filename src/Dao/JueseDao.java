package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.JueseBean;
import util.jdbcUtil;

public class JueseDao {
	
	/**
	 * 添加角色
	 * @param juesebean
	 * @return
	 * @throws Exception
	 */
	public boolean addJuese(JueseBean juesebean) throws Exception
	{
		System.out.println("添加角色");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "insert into juese(juese,wangluo,xuqiu,upmima,userinfo,dealneed,"
				+ "addneed,weishenhe,tongguo,tuihui) values(?,?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, juesebean.getJuese());
		pstmt.setString(2, juesebean.getWangluo());
		pstmt.setString(3, juesebean.getXuqiu());
		pstmt.setString(4, juesebean.getUpmima());
		pstmt.setString(5, juesebean.getUserinfo());
		pstmt.setString(6, juesebean.getDealneed());
		pstmt.setString(7, juesebean.getAddneed());
		pstmt.setString(8, juesebean.getWeishenhe());
		pstmt.setString(9, juesebean.getTongguo());
		pstmt.setString(10, juesebean.getTuihui());
		int a = 0;
		boolean f = false;
		a = pstmt.executeUpdate();
		if(a > 0)
			f = true;
		jdbcUtil.closeResource(conn, pstmt, rs);
		return f;
	}
	
	/**
	 * 获得所有的角色集合
	 * @param 
	 * @return
	 * @throws Exception 
	 */
	public List<JueseBean> getJueseBeans() throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from juese";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<JueseBean> juesebeans = new ArrayList<JueseBean>();
		while(rs.next())
		{
			
			String id = rs.getString("id");
			String juese = rs.getString("juese");
			String wangluo = rs.getString("wangluo");
			String xuqiu = rs.getString("xuqiu");
			String upmima = rs.getString("upmima");
			String weishenhe = rs.getString("weishenhe");
			String addneed = rs.getString("addneed");
			String dealneed = rs.getString("dealneed");
			String userinfo = rs.getString("userinfo");
			String tongguo = rs.getString("tongguo");
			String tuihui = rs.getString("tuihui");
			JueseBean juesebean = new JueseBean(id,juese,wangluo,xuqiu,upmima,addneed,dealneed,userinfo,weishenhe,tongguo,tuihui);
			juesebeans.add(juesebean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return juesebeans;
	}
	
	/**
	 * 根据角色name获得角色对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JueseBean getJuse(String name) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from juese where juese='"+name+"'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		JueseBean juesebean = null;
		if(rs.next())
		{
			String id = rs.getString("id");
			System.out.println("根据角色名称获得角色对象  "+id);
			String wangluo = rs.getString("wangluo");
			String xuqiu = rs.getString("xuqiu");
			String upmima = rs.getString("upmima");
			String weishenhe = rs.getString("weishenhe");
			String addneed = rs.getString("addneed");
			String dealneed = rs.getString("dealneed");
			String userinfo = rs.getString("userinfo");
			String tongguo = rs.getString("tongguo");
			String tuihui = rs.getString("tuihui");
		    juesebean = new JueseBean(id,name,wangluo,xuqiu,upmima,addneed,dealneed,userinfo,weishenhe,tongguo,tuihui);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return juesebean;
	}
	/**
	 * 根据角色id，修改角色的权限
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public boolean upjuese(JueseBean juesebean) throws Exception
	{
		System.out.println("修改权限");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "update juese set wangluo=?,xuqiu=?,upmima=?,addneed=?,dealneed=?,"
				+ "userinfo=?,weishenhe=?,tongguo=?,tuihui=? where juese='"+juesebean.getJuese()+"'";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, juesebean.getWangluo());
		System.out.println(juesebean.getWangluo());
		pstmt.setString(2, juesebean.getXuqiu());
		pstmt.setString(3, juesebean.getUpmima());
		pstmt.setString(4, juesebean.getAddneed());
		pstmt.setString(5, juesebean.getDealneed());
		pstmt.setString(6, juesebean.getUserinfo());
		pstmt.setString(7, juesebean.getWeishenhe());
		pstmt.setString(8, juesebean.getTongguo());
		pstmt.setString(9, juesebean.getTuihui());
		int a = 0;
		boolean f = false;
		a = pstmt.executeUpdate();
		if(a > 0)
			f = true;
		jdbcUtil.closeResource(conn, pstmt, rs);
		return f;
	}
	
}

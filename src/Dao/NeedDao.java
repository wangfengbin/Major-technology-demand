package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Bean.NeedBean;
import util.jdbcUtil;

public class NeedDao {
	
	public List<NeedBean> fenye(int currPage) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select top 3 * from need where id not in (select top "+((currPage-1)*3)+ " id from need)";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		
		while(rs.next())
		{
			//needbean = new NeedBean();
			String id = rs.getString("id");
			String name1 = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid1 = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke+"   "+name1);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			NeedBean needbean = new NeedBean(id,userid1,name1,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return needbeans;
	}
//	public static void main(String[] args) throws Exception
//	{
//		int a = getCount();
//		System.out.println("数量");
//	}
	public static int getCount() throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select count(*) from need";
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
	
	
	/**
	 * 添加需求 返回true，false
	 * @param needbean
	 * @return
	 * @throws Exception 
	 */
	public boolean addneed(NeedBean needbean) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "insert into need(id,name,descrpt,type,moshi,money,date,userid,qiannian,hounian,guanjian1,guanjian2,guanjian3,"
				+ "guanjian4,guanjian5,hezuo,xueke,lingyu,yingyong,twoxueke,twohangye) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, needbean.getId());
		pstmt.setString(2, needbean.getName());
		pstmt.setString(3, needbean.getDescrpt());
		pstmt.setString(4, needbean.getType());
		pstmt.setString(5, needbean.getMoshi());
		pstmt.setDouble(6, needbean.getMoney());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		pstmt.setString(7, sdf.format(date));
		pstmt.setInt(8, needbean.getUserid());
		pstmt.setString(9, needbean.getQiannian());
		pstmt.setString(10, needbean.getHounian());
		pstmt.setString(11, needbean.getGuanjian1());
		pstmt.setString(12, needbean.getGuanjian2());
		pstmt.setString(13, needbean.getGuanjian3());
		pstmt.setString(14, needbean.getGuanjian4());
		pstmt.setString(15, needbean.getGuanjian5());
		pstmt.setString(16, needbean.getHezuo());
		pstmt.setString(17, needbean.getXueke());
		pstmt.setString(18, needbean.getLingyu());
		pstmt.setString(19, needbean.getYingyong());
		pstmt.setString(20, needbean.getTwoxueke());
		pstmt.setString(21, needbean.getTwohangye());
		int a = 0;
		boolean f = false;
		a = pstmt.executeUpdate();
		if(a > 0)
			f = true;
		jdbcUtil.closeResource(conn, pstmt, rs);
		return f;
	}
	
	public int typenum(String moshi) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql ="select * from need where moshi='"+moshi+"'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int a = 0;
		while(rs.next())
		{
			a++;
		}
		System.out.println("数量 "+a);
		jdbcUtil.closeResource(conn, pstmt, rs);
		return a;
	}
	/**
	 * 获得该种类对应的needbeans
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	public List<NeedBean> getTypeNeeds(String type) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from need where type=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, type);
		System.out.println(sql);
		rs = pstmt.executeQuery();
		NeedBean needbean = null;
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			needbean = new NeedBean();
			String id = rs.getString("id");
			String name1 = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			//String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid1 = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke+"   "+name1);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			needbean = new NeedBean(id,userid1,name1,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return needbeans;
	}
	
	/**
	 * 获得行业对应的needbeans
	 * @param hangye
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	public List<NeedBean> getHangyeNeeds(String yingyong, String type) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from need where type=? and yingyong=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, type);
		pstmt.setString(2, yingyong);
		System.out.println(sql);
		rs = pstmt.executeQuery();
		NeedBean needbean = null;
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			needbean = new NeedBean();
			String id = rs.getString("id");
			String name1 = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			//String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid1 = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke+"   "+name1);
			String lingyu = rs.getString("lingyu");
			//String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			needbean = new NeedBean(id,userid1,name1,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return needbeans;
	}
	
	/**
	 * 根据第一学科，找到对应的needbeans集合
	 * @return
	 * @throws Exception
	 */
	public List<NeedBean> getXuekeNeeds(String xueke) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "select * from need where type='基础研究' and xueke="+xueke;
		System.out.println(sql);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		NeedBean needbean = null;
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			needbean = new NeedBean();
			String id = rs.getString("id");
			String name1 = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid1 = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			//String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke+"   "+name1);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			needbean = new NeedBean(id,userid1,name1,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return needbeans;
	}
	
	
	/**
	 * 多条件查询
	 * @param search1
	 * @param find1
	 * @param beforeFind1
	 * @param afterFind1
	 * @param search2
	 * @param find2
	 * @param beforeFind2
	 * @param afterFind2
	 * @param logical1
	 * @param search3
	 * @param find3
	 * @param beforeFind3
	 * @param afterFind3
	 * @param logical2
	 * @return
	 * @throws Exception
	 */
	public List<NeedBean> chaxunlist(String search1,String find1,String beforeFind1,String afterFind1,
			String search2,String find2,String beforeFind2,String afterFind2,String logical1,
			String search3,String find3,String beforeFind3,String afterFind3,String logical2) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		String sql = "";
		
		
		if(find1.equals("") && find2 ==null && find3 == null && beforeFind1== null && beforeFind2 == null && beforeFind3 == null)
		{
			System.out.println("查询所有");
			sql = "select * from need";		
		}
		else{
			System.out.println("find1  "+find1+"  find2   "+find2+"  find3  "+find3);
			if(find1!= null && find1.length()>0)
				System.out.println("find1的长度");
			sql = "select * from [need] where";
			
			if((find1 != null && find1.length()>0) || (beforeFind1 != null && beforeFind1.length() > 0))
			{
				System.out.println("search1 "+search1);
				if(search1.equals("title"))
					sql += " name like '%"+find1+"%'" ;
				else if(search1.equals("creatorId"))
					sql += " userid="+find1;
				else if(search1.equals("addDate"))
					sql += " date between '"+beforeFind1+"' and '"+afterFind1+"'";
			}
			
			
			if((find2 !=null && find1.length()>0) || (beforeFind2 != null && beforeFind2.length() > 0))
			{
				
				if(logical1.equals("and")|| logical1.equals("or") )
				{	
					sql += " "+logical1 ;
					if(search2.equals("title"))
						sql += " name like '%"+find2+"%'";
					else if(search2.equals("creatorId"))
						sql += " userid="+find2;
					else if(search2.equals("addDate"))
						sql += " date between '"+beforeFind2+"' and '"+afterFind2+"'";
				}
				else if(logical1.equals("not"))
				{
					if(search2.equals("title"))
						sql += " and name not like '%"+find2+"%'";
					else if(search2.equals("creatorId"))
						sql += " and userid !="+find2;
					else if(search2.equals("addDate"))
						sql += " and date not between '"+beforeFind2+"' and '"+afterFind2+"'";
					
				}
			}
			
			if((find3 != null && find3.length() >0) || (beforeFind3 != null && beforeFind3.length() > 0))
			{
				
				if(logical2.equals("and")|| logical2.equals("or") )
				{	
					sql += " "+logical2 ;
					if(search3.equals("title"))
						sql += " name like '%"+find3+"%'";
					else if(search3.equals("creatorId"))
						sql += " userid="+find3;
					else if(search3.equals("addDate"))
						sql += " date between '"+beforeFind3+"' and '"+afterFind3+"'";
				}
				else if(logical2.equals("not"))
				{
					if(search3.equals("title"))
						sql += " and name not like '%"+find3+"%'";
					else if(search3.equals("creatorId"))
						sql += " and userid !="+find3;
					else if(search3.equals("addDate"))
						sql += " and date not between '"+beforeFind3+"' and '"+afterFind3+"'";
					
				}
			}
		
		}
		
		System.out.println("sql语句  "+sql);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		NeedBean needbean = null;
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			needbean = new NeedBean();
			String id = rs.getString("id");
			String name1 = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid1 = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke+"   "+name1);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			needbean = new NeedBean(id,userid1,name1,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		jdbcUtil.closeResource(conn, pstmt, rs);
		return needbeans;
	}
	
	
	
	/**
	 * 获得数据库中最大的need ID,如果没有，就设置新的
	 * @return
	 * @throws Exception
	 */
	public String getBigidneed() throws Exception
	{
		String needid = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = jdbcUtil.getConnection();
		//获得当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String y = sdf.format(date);
		int m = date.getMonth()+1;
		String me="";
		String de = "";
		if(m<10)
			me = "0"+m;
		else me = m +"";
		int d = date.getDate();
		if(d<10)
			de = "0"+d;
		else de = d +"";
		String num = y+me+de;
		//
		String sql = "select top 1 id from need where id like '"+num+"%' order by id desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			long needid1 = Long.parseLong(rs.getString("id"));
			long needid2 = needid1+1;
			needid = needid2+"";
		}
		else
			needid = num+"001";
		System.out.println("获得最大的需求id   "+needid);
		return needid;
	}
	
	
	/**
	 * 修改需求信息，如果需求已被审核，则不能被修改
	 * @param needbean
	 * @param needid
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean updateneed(NeedBean needbean, String needid ) throws ClassNotFoundException, SQLException
	{
		System.out.println("修改需求");
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/need?uerUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String userPwd = "123123";
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		String sql = "select status,status1 from need where id="+needid;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int status = 0;
		int status1 = 0; 
		boolean f = false;
		if(rs.next())
		{
			status = Integer.parseInt(rs.getString("status"));
			status1 = Integer.parseInt(rs.getString("status1"));
		}
		if(status==0&&status==0)
		{
			String sql1 = "update [need] set name='"+needbean.getName()+"',qiannian='"+needbean.getQiannian()+"',hounian='"+needbean.getHounian()+"',descrpt='"+needbean.getDescrpt()+"',guanjian1='"+needbean.getGuanjian1()+"',guanjian2='"+needbean.getGuanjian2()+
					"',guanjian3='"+needbean.getGuanjian3()+"',guanjian4='"+needbean.getGuanjian4()+"',guanjian5='"+needbean.getGuanjian5()+"',type='"+needbean.getType()+"',moshi='"+needbean.getMoshi()+"',hezuo='"+needbean.getHezuo()+"',money='"+needbean.getMoney()+
					"',xueke='"+needbean.getXueke()+"',twoxueke='"+needbean.getTwoxueke()+"',yingyong='"+needbean.getYingyong()+"',twohangye='"+needbean.getTwohangye()+"',lingyu='"+needbean.getLingyu()+"' where id="+needid;
			pstmt1 = conn.prepareStatement(sql1);
			System.out.println(sql1);
			int a = 0;
			a = pstmt1.executeUpdate();
			if(a > 0)
				f = true;				
		}
		
		if(conn!=null)
			conn.close();
		if(pstmt!=null)
			pstmt.close();
		if(pstmt1!=null)
			pstmt1.close();
		return f;
	}
	
	
	public List<NeedBean> getnameneed(String name,int status,int userid) throws SQLException, ClassNotFoundException
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
		//String sql = "select top 1 id from [need] where id like '"+num+"%' order by id desc";
		//String sql = "select * from [need] where name= '"+name+"'and status="+status;
		String sql = "";
		if(userid == 0)
		{
			sql = "select * from need where name like '%"+name+"%'and status="+status;
		}else
		{
			sql = "select * from need where userid='"+userid+"' and name like '%"+name+"%'and status="+status;
		}
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		NeedBean needbean = null;
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			needbean = new NeedBean();
			String id = rs.getString("id");
			String name1 = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid1 = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke+"   "+name1);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			needbean = new NeedBean(id,userid1,name1,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		if(pstmt != null)
			pstmt.close();
		if(conn !=null)
			conn.close();
		return needbeans;
	}
	
	/**
	 * 获取当前用户的需求
	 * 
	 */
	public List<NeedBean> listneedmy(int status,int userid) throws ClassNotFoundException, SQLException
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
		String sql = "";
		if(status == 4)
		{
			sql = "select * from need where userid="+userid;	
		}
		else
			sql = "select * from need where status='"+status+"' and userid="+userid;		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			String id = rs.getString("id");
			String name = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			//int userid = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			NeedBean needbean = new NeedBean(id,userid,name,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return needbeans;
	}
	/**需求审核
	 * 根据审核的状态，返回未审核的所有集合
	 * status=0，未审核；1，已审核；2，已退回；3，所有的审核
	 * @param name
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<NeedBean> listneed(int status) throws ClassNotFoundException, SQLException
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
		String sql = "";
		
		if(status==3)
			sql = "select * from need";
		else{
			System.out.println("Dao  listneed  status="+status);
			sql = "select * from need where status="+status;
		}
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			String id = rs.getString("id");
			String name = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			System.out.println("NeedDao/listneed  第二学科"+twoxueke);
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			NeedBean needbean = new NeedBean(id,userid,name,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return needbeans;
	}
	/**
	 * 找出所有网络审核未0的需求 
	 * @param status
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public List<NeedBean> listwangneed(int status) throws ClassNotFoundException, SQLException
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
		String sql = "";
		sql = "select * from need where status1="+status;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		while(rs.next())
		{
			String id = rs.getString("id");
			String name = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status1 = rs.getInt("status");
			int status2 = rs.getInt("status1");
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			int userid = rs.getInt("userid");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			NeedBean needbean = new NeedBean(id,userid,name,descrpt,type,moshi,money,status1,status2,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,
					hezuo,xueke,twoxueke,lingyu,yingyong,twohangye);
			needbeans.add(needbean);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return needbeans;
	}
	
	
	
	/**
	 * 根据id值返回该需求对象
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public NeedBean search(String id) throws SQLException, ClassNotFoundException 
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
		String sql = "select * from need where id="+id;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		NeedBean needbean = null;
		if(rs.next())
		{
			int userid = rs.getInt("userid");
			String name = rs.getString("name");
			String descrpt = rs.getString("descrpt");
			String type = rs.getString("type");
			String moshi = rs.getString("moshi");
			double money = rs.getDouble("money");
			int status = rs.getInt("status");//审核1
			int status1 = rs.getInt("status1");//审核2
			String date = rs.getString("date");
			String ping = rs.getString("ping");
			String qiannian = rs.getString("qiannian");
			String hounian = rs.getString("hounian");
			String guanjian1 = rs.getString("guanjian1");
			String guanjian2 = rs.getString("guanjian2");
			String guanjian3 = rs.getString("guanjian3");
			String guanjian4 = rs.getString("guanjian4");
			String guanjian5 = rs.getString("guanjian5");
			String hezuo = rs.getString("hezuo");
			String xueke = rs.getString("xueke");
			String twoxueke = rs.getString("twoxueke");
			String lingyu = rs.getString("lingyu");
			String yingyong = rs.getString("yingyong");
			String twohangye = rs.getString("twohangye");
			needbean = new NeedBean(id,userid,name,descrpt,type,moshi,money,status,status1,date,ping,
					qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,hezuo,
					xueke,twoxueke,lingyu,yingyong,twohangye);
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
		return needbean;
	}
	
	/**
	 * 添加评论
	 * @param id
	 * @param ping
	 * @param status
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean addping(String id,String ping,int status,String pass) throws SQLException, ClassNotFoundException
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
		String sql = "";
		if(pass.equals("xu"))//如果是需求审核
		{
			sql = "update need set ping='"+ping+"',status='"+status+"' where id="+id;
		}
		else if(pass.equals("wang"))
		{
			sql = "update need set ping='"+ping+"',status1='"+status+"' where id="+id;
		}
		pstmt = conn.prepareStatement(sql);
		boolean f = false;
		int a = 0;
		a = pstmt.executeUpdate();
		if(a > 0)
		{
			f = true;
		}
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
	
	
}

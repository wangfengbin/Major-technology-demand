package util;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Bean.UserBean;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*int resp = JOptionPane.showConfirmDialog(null, "是否继续", "系统提示", JOptionPane.YES_NO_OPTION);
		if(resp == 0)
		{
			System.out.println("点击了0");
		}
		else if(resp ==1)
		{
			System.out.println("点击了1");
		}
		else if(resp ==2)
		{
			System.out.println("点击了2");
		}*/
		
	///////////////////////////////////
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
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
		System.out.println("日期 "+num);*/
	///////////////////////////////////
		/*int a = 29;
		int b = 10;
		System.out.println(a/b);*/
	////////////////////////////////////
	/*	
		int a = 0;
		a = getUserBeans();
		System.out.println(a);
	}
	public static int getUserBeans() throws Exception
	{
		int rowCount;
		int pageCount;
		int pageSize = 10;
		Connection conn = null;
		conn = jdbcUtil.getConnection();
		String sql = "select top 10 * from [twohangye] where id not in (select top 11 id from [twohangye])";
		Statement pstmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = pstmt.executeQuery(sql); 
        rs.last(); 
        rowCount = rs.getRow(); //获得数据集合的行数
        pageCount = (rowCount +pageSize-1)/pageSize; //求出该集合在分页中的页数
        
        System.out.println("rowCount "+rowCount);
		//rs = pstmt.executeQuery();
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
		return pageCount;
	}*/
	String a1 = "   ";
	System.out.println(a1.length());
 }
}
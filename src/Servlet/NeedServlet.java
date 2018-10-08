package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.alibaba.fastjson.JSON;

import Bean.FirstXuekeBean;
import Bean.HangyeBean;
import Bean.NeedBean;
import Bean.PageBean;
import Bean.TwoHangyeBean;
import Bean.TwoxuekeBean;
import Bean.UserBean;
import Bean.page;
import Dao.NeedDao;
import Dao.UserDao;
import Dao.XuekeDao;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
//addneed1.jsp表单验证
//详情页面表格
//审核页面   注册web.xml Qualified  name  Servlet.NeedServlet
/**
 * Servlet implementation class NeedServlet
 */
@WebServlet("/NeedServlet")
public class NeedServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
		System.out.println("这是原版的需求征集");
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
		if("add".equals(method))
		{
			try {
				add(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("namelist".equals(method))
		{
			try {
				namelist(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("addneed".equals(method))
		{
			try {
				addneed(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("updateneed".equals(method)){
			try {
				updateneed(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("listneed".equals(method))
		{
			try {
				//System.out.println("显示所有需求");
				listneed(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("search".equals(method))
		{
			try {
				search(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("update".equals(method))
		{
			try {
				update(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("getTwoxueke".equals(method))
		{
			try {
				getTwoxueke(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("getTwohangye".equals(method))
		{
			try {
				getTwohangye(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("getneedid".equals(method))
		{
			try {
				getneedid(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("chaxunlist".equals(method))
		{
			try {
				chaxunlist(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("getxuekeNeed".equals(method))
		{
			try {
				System.out.println("获得该学科对应的need集合");
				getxuekeNeed(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("gethangyeNeed".equals(method))
		{
			try {
				System.out.println("获得该行业对应的need集合");
				gethangyeNeed(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("getTypeNeed".equals(method))
		{
			try {
				getTypeNeed(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("display".equals(method))
		{
			try {
				display(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("fenye".equals(method))
		{
			try {
				fenye(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	//将所有的需求进行分页显示
	private void fenye(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int currPage = Integer.parseInt(req.getParameter("currPage"));
		System.out.println("第几页"+currPage);
		int pageSize=3;
		
		NeedDao needdao = new NeedDao();
		List<NeedBean> needlist = needdao.fenye(currPage);
		int num = needdao.getCount();
		
		
		//System.out.println("数量"+needdao.getCount());
		PageBean<NeedBean> bean = new PageBean<>(needlist,currPage,pageSize,num);
		System.out.println("分页对象"+bean);
		req.setAttribute("page", bean);
		req.getRequestDispatcher("/listneedfen.jsp").forward(req, resp);
		
	}

	//获得每种类型的需求的数量
	private void display(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("查询类型数量");
		
		NeedDao needdao = new NeedDao();
		int duli = needdao.typenum("独立开发");
		int weituo = needdao.typenum("委托研发");
		int hezuo = needdao.typenum("合作研发");
		int qita = needdao.typenum("其他");
		String num = "";
		num += ""+duli+","+weituo+","+hezuo+","+qita;
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(num));
		out.flush();
		out.close();
	}

	//获得该种类的所有
	private void getTypeNeed(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String type = req.getParameter("type");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.getTypeNeeds(type);
		System.out.println("获得的对应的学科的needbeans  "+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
	}

	/**
	 * 获得该行业对应的集合needbeans
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void gethangyeNeed(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String hangye = req.getParameter("hangye");
		String type = req.getParameter("type");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.getHangyeNeeds(hangye,type);
		System.out.println("获得的对应的学科的needbeans  "+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
	}

	/**
	 * 获得基础研究中的对应学科的needbeans
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void getxuekeNeed(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("获得该学科对应的need集合");
		String xueke = req.getParameter("xueke");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.getXuekeNeeds(xueke);
		System.out.println("获得的对应的学科的needbeans  "+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
		
	}

	/**
	 * 多条件查询
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void chaxunlist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("多条件查询");
		
		String search1 = req.getParameter("search1"); //第一个条件
		String find1 = req.getParameter("find1");		//第一个输入框(需求名称或发布人)
			
		
		System.out.println("find1 servlet "+find1);
		String beforeFind1 = req.getParameter("beforeFind1");//前时间
		String afterFind1 = req.getParameter("afterFind1");  //后时间

		
		String search2 = req.getParameter("search2");
		String find2 = req.getParameter("find2");
		String beforeFind2 = req.getParameter("beforeFind2");
		String afterFind2 = req.getParameter("afterFind2");
		String logical1 = req.getParameter("logical1");

		
		String search3 = req.getParameter("search3");
		String find3 = req.getParameter("find3");
		String beforeFind3 = req.getParameter("beforeFind3");
		String afterFind3 = req.getParameter("afterFind3");
		String logical2 = req.getParameter("logical2");
		
		
		System.out.println("时间格式  "+beforeFind1);
		//System.out.println("发布人  ");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.chaxunlist(search1, find1, beforeFind1, afterFind1,
				 search2, find2, beforeFind2, afterFind2, logical1,
				 search3, find3, beforeFind3, afterFind3, logical2);
		System.out.println("多条件查询  "+needbeans);
		
		//req.setAttribute("needbeans", needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();	
	}

	/**
	 * 获得新的needid
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void getneedid(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		NeedDao needdao = new NeedDao();
		String needid = needdao.getBigidneed();
		System.out.println("NeedServlet   needid  "+needid);
		req.setAttribute("needid", needid);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needid));
		out.flush();
		out.close();
	}

	/**
	 * 获取第二行业
	 * @param req
	 * @param resp
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void getTwohangye(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		int parentId = Integer.parseInt(req.getParameter("id"));
		XuekeDao xuekedao = new XuekeDao();
		System.out.println("转到getCity");
		List<TwoHangyeBean> twobeans = new ArrayList<TwoHangyeBean>();
		twobeans = xuekedao.getTwohangye(parentId);
		//System.out.println(cityList.get(0).getName());
		System.out.println("二级行业"+twobeans);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(twobeans));
		out.flush();
		out.close();
	}
	
	/**
	 * 获取第二学科
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void getTwoxueke(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int parentId = Integer.parseInt(req.getParameter("id"));
		XuekeDao xuekedao = new XuekeDao();
		System.out.println("转到getCity");
		List<TwoxuekeBean> twobeans = new ArrayList<TwoxuekeBean>();
		twobeans = xuekedao.getTwoxueke(parentId);
		//System.out.println(cityList.get(0).getName());
		System.out.println("二级学科"+twobeans);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(twobeans));
		out.flush();
		out.close();
	}
	
	/**
	 * 打开征集信息页面之前先将数据库中的下拉列报数据取出
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//先将数据库中的一级学科取出
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");	
		
		//HashMap h = new HashMap<>();
		String sta2 = req.getParameter("sta");	
		System.out.println("状态sta2");
		List<FirstXuekeBean> firstBeans = new ArrayList<FirstXuekeBean>();
		XuekeDao xuekedao = new XuekeDao();
		firstBeans = xuekedao.getXueke();
		req.setAttribute("xuekeBeans", firstBeans);
		System.out.println("一级学科"+firstBeans);
		
		List<HangyeBean> hangyeBeans = new ArrayList<HangyeBean>();
		hangyeBeans = xuekedao.getHangye();
		req.setAttribute("hangyeBeans", hangyeBeans);
		System.out.println("一级行业"+hangyeBeans);
		
		NeedDao needdao = new NeedDao();
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		needBeans = needdao.listneed(3);
		req.setAttribute("needbeans", needBeans);
		
		if(sta2!=null&&sta2.equals("1"))
		{
			search(req,resp);
		}
		else if(sta2!=null&&sta2.equals("5"))
		{
			req.getRequestDispatcher("chaxun.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("addneed1.jsp").forward(req, resp);
		}
		
	}
	
	/**
	 * 修改，相当于审核
	 * @param req
	 * @param resp
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");	
		String id = req.getParameter("id");
		String ping = req.getParameter("ping");
		int type = Integer.parseInt(req.getParameter("shenhe"));		
		String pass = req.getParameter("pass");
		NeedDao needdao = new NeedDao();
		boolean f = false;
		System.out.println("网络审核pass  type  "+pass+"   "+type+"    "+ping);
		f = needdao.addping(id, ping, type,pass);
		if(f)
		{
			System.out.println("从update跳到listneed");
			resp.sendRedirect("NeedServlet?method=listneed");
			//listneed(req,resp);
		}
			//req.getRequestDispatcher("NeedServlet?method=listneed&status=3").forward(req, resp);
		else{
			System.out.println("审核修改失败");
		}
	}
	/**
	 * 根据id获得需求的对象
	 * @param req
	 * @param resp
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void search(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String sta = req.getParameter("sta10");
		String shenhe = req.getParameter("shenhe");
		System.out.println("获取审核类型  "+shenhe);
		
		String id = req.getParameter("id");//需求的need_id
		System.out.println("获取id值  "+id);
		NeedDao needdao = new NeedDao();
		XuekeDao xuekedao = new XuekeDao(); 
		NeedBean needbean = new NeedBean();
		needbean = needdao.search(id);
		String xueke = xuekedao.getXueke(Integer.parseInt(needbean.getXueke()));
		String hangye = xuekedao.getHangye(Integer.parseInt(needbean.getYingyong()));
		req.getSession().setAttribute("needbean", needbean);
		if(sta.equals("0")&&shenhe.equals("0"))
			req.getRequestDispatcher("check.jsp?xueke="+xueke+"&hangye="+hangye).forward(req, resp);
		else if(sta.equals("0")&&shenhe.equals("1"))
			req.getRequestDispatcher("check2.jsp?xueke="+xueke+"&hangye="+hangye).forward(req, resp);
		else
			req.getRequestDispatcher("needdetail.jsp").forward(req, resp);
	}

	/**
	 * 添加需求
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void addneed(HttpServletRequest req, HttpServletResponse resp) throws Exception 
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("用户的id   "+id);
		NeedDao needdao = new NeedDao();
		String needid = req.getParameter("numInput");
		String name =req.getParameter("name");
		String qiannian = req.getParameter("qiannian");
		String hounian = req.getParameter("hounian");
		String descrpt = req.getParameter("descrpt");
		String guanjian1 = req.getParameter("guanjian1");
		String guanjian2 = req.getParameter("guanjian2");
		String guanjian3 = req.getParameter("guanjian3");
		String guanjian4 = req.getParameter("guanjian4");
		String guanjian5 = req.getParameter("guanjian5");
		String type = req.getParameter("type");   //科技活动类型
		String moshi = req.getParameter("moshi");	//解决方式
		String hezuo = req.getParameter("hezuo");	//合作单位
		String money1 = req.getParameter("money");
		System.out.println("投资金额  "+money1);
		double money = 0;
		if(!money1.equals(""))
			money = Double.parseDouble(money1);
		String xueke = req.getParameter("firstxueke");
		String twoxueke = req.getParameter("twxueke");
		System.out.println("第二学科  "+twoxueke);
		String lingyu1[] = req.getParameterValues("lingyu");
		String lingyu = "";
		if(lingyu1 != null)
		{
		for(int i=0;i<lingyu1.length;i++)
			lingyu += lingyu1[i]+",";
		}
		String hangye = req.getParameter("twhangye");
		String yingyong = req.getParameter("firsthangye");
		String ping = req.getParameter("ping");
		NeedBean needbean = new NeedBean(needid,id,name,descrpt,type,moshi,money,ping,qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,hezuo,xueke,twoxueke,lingyu,yingyong,hangye);
		boolean flag = false;
		flag = needdao.addneed(needbean);
		PrintWriter out=resp.getWriter();
		if(flag)//添加成功
		{	
			System.out.println("添加成功");
			resp.sendRedirect("NeedServlet?method=listneed&info=1");
		}
	}
	
	/**
	 * 修改需求信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void updateneed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException
	{
		System.out.println("修改需求信息");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int userid = Integer.parseInt(req.getParameter("userid"));//用户id
		String needid = req.getParameter("needid");//需求id
		System.out.println("用户的userid,需求的needid   "+userid+"  "+needid);
		
		String depart = req.getParameter("depart");
		String departname = req.getParameter("departname");
		
		String truename = req.getParameter("truename");
		String dianhua = req.getParameter("dianhua");
		String phnumber = req.getParameter("phnumber");
		String chuanzhen = req.getParameter("chuanzhen");
		String jigoushuxing = req.getParameter("jigoushuxing");
		//String jigoujianjie = req.getParameter("jigoujianjie");
		UserBean userbean = new UserBean( phnumber, depart, truename, dianhua,jigoushuxing, departname,  chuanzhen );
		UserDao userdao = new UserDao();
		boolean f = false;
		f = userdao.updateInsert(userbean,userid);// 将添加信息页面的用户信息修改
		
		String name =req.getParameter("name");
		String qiannian = req.getParameter("qiannian");
		String hounian = req.getParameter("hounian");
		String descrpt = req.getParameter("descrpt");
		String guanjian1 = req.getParameter("guanjian1");
		String guanjian2 = req.getParameter("guanjian2");
		String guanjian3 = req.getParameter("guanjian3");
		String guanjian4 = req.getParameter("guanjian4");
		String guanjian5 = req.getParameter("guanjian5");
		String type = req.getParameter("type");   //科技活动类型
		String moshi = req.getParameter("moshi");	//解决方式
		String hezuo = req.getParameter("hezuo");	//合作单位
		String money1 = req.getParameter("money");
		double money = 0;
		if(!money1.equals(""))
			money = Double.parseDouble(money1);
		String xueke = req.getParameter("firstxueke");
		String twoxueke = req.getParameter("twxueke");
		System.out.println("第二学科  "+twoxueke);
		String lingyu1[] = req.getParameterValues("lingyu");
		String lingyu = "";
		if(lingyu1 != null)
		{
			for(int i=0;i<lingyu1.length;i++)
				lingyu += lingyu1[i]+",";
		}
		String hangye = req.getParameter("twhangye");
		System.out.println("第二行业  "+hangye);
		String yingyong = req.getParameter("firsthangye");
		String ping = req.getParameter("ping");
		NeedBean needbean = new NeedBean(userid,name,descrpt,type,moshi,money,ping,qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,hezuo,xueke,twoxueke,lingyu,yingyong,hangye);
		NeedDao needdao = new NeedDao();
		boolean flag = false;
		flag = needdao.updateneed(needbean,needid);
		if(flag)//修改成功
		{	System.out.println("修改成功");
			resp.sendRedirect("NeedServlet?method=add&sta=1&sta10=1&msg=1&id="+needid);
			//req.getRequestDispatcher("/NeedServlet?method=listneed&status=3").forward(req, resp);
		}
		else//添加失败
		{	System.out.println("修改失败");
		
			System.out.println("该需求已被审核，不能修改信息");
			resp.sendRedirect("NeedServlet?method=add&sta=1&sta10=1&msg=0&id="+needid);
		}
	}
	
	private void namelist(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, IOException 
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = "";
		name = req.getParameter("name");
		System.out.println("name   "+name);
		String status1 = "";
		status1 = req.getParameter("status");
		int status = 3;
		if(status1!=null&&!status1.equals(""))
			status = Integer.parseInt(status1);
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		NeedDao needdao = new NeedDao();
		
		if(name == null || name.equals("")){
			System.out.println("名字为空");
			needbeans = needdao.listneed(status);//status=3全部的需求，status=0，需求审核为0的需求，status=2，需求审核为2的需求
		}
		else if(name != null&& (!name.equals("")))
		{
			System.out.println("名字不为空");
			needbeans = needdao.getnameneed(name, status,0);
		}
		req.setAttribute("needbeans", needbeans);
		System.out.println("需求"+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
	}
	
	/**
	 * 显示所有的需求信息
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void listneed(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		
		System.out.println("显示信息");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//status=0,未审核；statsu=1已审核；2 已退回 3.全部 4.该用户的填写过的需求
		String name = "";
		name = req.getParameter("name");
		System.out.println("name   "+name);
		String sta1 = "";
		sta1 = req.getParameter("shenhe");//需求审核sta1=0；网络审核sta1=1
		String suoshu = "";
		suoshu = req.getParameter("suoshu");//suoshu = me,我的需求 =all 所有的
		
		String status1 = "";
		status1 = req.getParameter("status"); //综合查询，status=5
		System.out.println("status1  "+status1);
		int status = 3;    //确定是显示全部还是显示需求、网络审核未审核的需求
		if(status1!=null&&!status1.equals(""))
			status = Integer.parseInt(status1);
		System.out.println("status  "+status);
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		NeedDao needdao = new NeedDao();
		page pa = new page();
		
		if(sta1 !=null&&(!sta1.equals(""))&&sta1.equals("0"))//需求审核未审核
		{
			System.out.println("sta1   "+sta1);
			System.out.println("获得需求未审核");
			needbeans = needdao.listneed(status);//获得需求审核未审核的需求
			
		}
		else if(sta1 !=null&&(!sta1.equals(""))&&sta1.equals("1"))
		{
			System.out.println("sta1   "+sta1);
			System.out.println("获得网络未审核");
			needbeans = needdao.listwangneed(status);//获得网络审核未审核的需求
		}
		else if(status == 5)
		{
			needbeans = needdao.listneed(status);//查询所有
			req.setAttribute("needbeans", needbeans);
			req.getRequestDispatcher("chaxun.jsp").forward(req, resp);
		}
		else if(name == null || name.equals(""))
		{
			System.out.println("名字为空");
			if(status == 4)//status=4,该用户的需求；
			{
				UserBean userbean = (UserBean) req.getSession().getAttribute("userbean");
				int userid = userbean.getId();
				needbeans = needdao.listneedmy(status,userid);
				req.setAttribute("needbeans", needbeans);
				req.getRequestDispatcher("listmyneed.jsp").forward(req, resp);
			}
			else if(suoshu!=null&&suoshu.equals("me"))//该用户的
			{
				UserBean userbean = (UserBean) req.getSession().getAttribute("userbean");
				int userid = userbean.getId();
				needbeans = needdao.listneedmy(status,userid);
				req.setAttribute("needbeans", needbeans);
				
				req.getRequestDispatcher("listmyneed.jsp?status2="+status).forward(req, resp);
			}
			else if((suoshu!=null&&suoshu.equals("all")) || (status==3))	//所有的
				needbeans = needdao.listneed(status);//status=3全部的需求，status=0，需求审核为0的需求，status=2，需求审核为2的需求
		}
		else if(name != null&& (!name.equals("")))
		{
			System.out.println("名字不为空");
			if(suoshu.equals("me"))//该用户的
			{
				UserBean userbean = (UserBean) req.getSession().getAttribute("userbean");
				int userid = userbean.getId();
				needbeans = needdao.getnameneed(name, status,userid);
				req.setAttribute("needbeans", needbeans);
				pa.setSum(needbeans.size());
				pa.initpage();
				req.setAttribute("page", pa);
				req.getRequestDispatcher("listmyneed.jsp?status2="+status).forward(req, resp);
			}
			else	//所有的
				needbeans = needdao.getnameneed(name, status,0);
		}
		
		req.setAttribute("needbeans", needbeans);
		System.out.println("需求"+needbeans);
		
		if(name ==null&&status == 0) //需求、网络审核中未审核的
		{
			System.out.println("需求、网络审核中未审核的");
			req.getRequestDispatcher("listshen.jsp?shenhe="+sta1).forward(req, resp);
		}		
		else if(name == null)
		{
			System.out.println("名字为空");
			req.getRequestDispatcher("listneed.jsp?status2="+status).forward(req, resp);
			
		}		
		else if(name != null){
			System.out.println("名字不为空   "+status);
			req.getRequestDispatcher("listneed.jsp?name='"+name+"'&status2="+status).forward(req, resp);
		}
	}
	
}

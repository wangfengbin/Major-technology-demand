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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
//addneed1.jsp����֤
//����ҳ����
//���ҳ��   ע��web.xml Qualified  name  Servlet.NeedServlet
/**
 * Servlet implementation class NeedServlet
 */
@WebServlet("/NeedServlet")
public class NeedServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
		System.out.println("����ԭ�����������");
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
				//System.out.println("��ʾ��������");
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
				System.out.println("��ø�ѧ�ƶ�Ӧ��need����");
				getxuekeNeed(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("gethangyeNeed".equals(method))
		{
			try {
				System.out.println("��ø���ҵ��Ӧ��need����");
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
	//�����е�������з�ҳ��ʾ
	private void fenye(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int currPage = Integer.parseInt(req.getParameter("currPage"));
		System.out.println("�ڼ�ҳ"+currPage);
		int pageSize=3;
		
		NeedDao needdao = new NeedDao();
		List<NeedBean> needlist = needdao.fenye(currPage);
		int num = needdao.getCount();
		
		
		//System.out.println("����"+needdao.getCount());
		PageBean<NeedBean> bean = new PageBean<>(needlist,currPage,pageSize,num);
		System.out.println("��ҳ����"+bean);
		req.setAttribute("page", bean);
		req.getRequestDispatcher("/listneedfen.jsp").forward(req, resp);
		
	}

	//���ÿ�����͵����������
	private void display(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("��ѯ��������");
		
		NeedDao needdao = new NeedDao();
		int duli = needdao.typenum("��������");
		int weituo = needdao.typenum("ί���з�");
		int hezuo = needdao.typenum("�����з�");
		int qita = needdao.typenum("����");
		String num = "";
		num += ""+duli+","+weituo+","+hezuo+","+qita;
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(num));
		out.flush();
		out.close();
	}

	//��ø����������
	private void getTypeNeed(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String type = req.getParameter("type");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.getTypeNeeds(type);
		System.out.println("��õĶ�Ӧ��ѧ�Ƶ�needbeans  "+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
	}

	/**
	 * ��ø���ҵ��Ӧ�ļ���needbeans
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
		System.out.println("��õĶ�Ӧ��ѧ�Ƶ�needbeans  "+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
	}

	/**
	 * ��û����о��еĶ�Ӧѧ�Ƶ�needbeans
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void getxuekeNeed(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("��ø�ѧ�ƶ�Ӧ��need����");
		String xueke = req.getParameter("xueke");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.getXuekeNeeds(xueke);
		System.out.println("��õĶ�Ӧ��ѧ�Ƶ�needbeans  "+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
		
	}

	/**
	 * ��������ѯ
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void chaxunlist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("��������ѯ");
		
		String search1 = req.getParameter("search1"); //��һ������
		String find1 = req.getParameter("find1");		//��һ�������(�������ƻ򷢲���)
			
		
		System.out.println("find1 servlet "+find1);
		String beforeFind1 = req.getParameter("beforeFind1");//ǰʱ��
		String afterFind1 = req.getParameter("afterFind1");  //��ʱ��

		
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
		
		
		System.out.println("ʱ���ʽ  "+beforeFind1);
		//System.out.println("������  ");
		NeedDao needdao = new NeedDao();
		List<NeedBean> needbeans = new ArrayList();
		needbeans = needdao.chaxunlist(search1, find1, beforeFind1, afterFind1,
				 search2, find2, beforeFind2, afterFind2, logical1,
				 search3, find3, beforeFind3, afterFind3, logical2);
		System.out.println("��������ѯ  "+needbeans);
		
		//req.setAttribute("needbeans", needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();	
	}

	/**
	 * ����µ�needid
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
	 * ��ȡ�ڶ���ҵ
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
		System.out.println("ת��getCity");
		List<TwoHangyeBean> twobeans = new ArrayList<TwoHangyeBean>();
		twobeans = xuekedao.getTwohangye(parentId);
		//System.out.println(cityList.get(0).getName());
		System.out.println("������ҵ"+twobeans);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(twobeans));
		out.flush();
		out.close();
	}
	
	/**
	 * ��ȡ�ڶ�ѧ��
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
		System.out.println("ת��getCity");
		List<TwoxuekeBean> twobeans = new ArrayList<TwoxuekeBean>();
		twobeans = xuekedao.getTwoxueke(parentId);
		//System.out.println(cityList.get(0).getName());
		System.out.println("����ѧ��"+twobeans);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(twobeans));
		out.flush();
		out.close();
	}
	
	/**
	 * ��������Ϣҳ��֮ǰ�Ƚ����ݿ��е������б�����ȡ��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//�Ƚ����ݿ��е�һ��ѧ��ȡ��
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");	
		
		//HashMap h = new HashMap<>();
		String sta2 = req.getParameter("sta");	
		System.out.println("״̬sta2");
		List<FirstXuekeBean> firstBeans = new ArrayList<FirstXuekeBean>();
		XuekeDao xuekedao = new XuekeDao();
		firstBeans = xuekedao.getXueke();
		req.setAttribute("xuekeBeans", firstBeans);
		System.out.println("һ��ѧ��"+firstBeans);
		
		List<HangyeBean> hangyeBeans = new ArrayList<HangyeBean>();
		hangyeBeans = xuekedao.getHangye();
		req.setAttribute("hangyeBeans", hangyeBeans);
		System.out.println("һ����ҵ"+hangyeBeans);
		
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
	 * �޸ģ��൱�����
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
		System.out.println("�������pass  type  "+pass+"   "+type+"    "+ping);
		f = needdao.addping(id, ping, type,pass);
		if(f)
		{
			System.out.println("��update����listneed");
			resp.sendRedirect("NeedServlet?method=listneed");
			//listneed(req,resp);
		}
			//req.getRequestDispatcher("NeedServlet?method=listneed&status=3").forward(req, resp);
		else{
			System.out.println("����޸�ʧ��");
		}
	}
	/**
	 * ����id�������Ķ���
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
		System.out.println("��ȡ�������  "+shenhe);
		
		String id = req.getParameter("id");//�����need_id
		System.out.println("��ȡidֵ  "+id);
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
	 * �������
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
		System.out.println("�û���id   "+id);
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
		String type = req.getParameter("type");   //�Ƽ������
		String moshi = req.getParameter("moshi");	//�����ʽ
		String hezuo = req.getParameter("hezuo");	//������λ
		String money1 = req.getParameter("money");
		System.out.println("Ͷ�ʽ��  "+money1);
		double money = 0;
		if(!money1.equals(""))
			money = Double.parseDouble(money1);
		String xueke = req.getParameter("firstxueke");
		String twoxueke = req.getParameter("twxueke");
		System.out.println("�ڶ�ѧ��  "+twoxueke);
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
		if(flag)//��ӳɹ�
		{	
			System.out.println("��ӳɹ�");
			resp.sendRedirect("NeedServlet?method=listneed&info=1");
		}
	}
	
	/**
	 * �޸�������Ϣ
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void updateneed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException
	{
		System.out.println("�޸�������Ϣ");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int userid = Integer.parseInt(req.getParameter("userid"));//�û�id
		String needid = req.getParameter("needid");//����id
		System.out.println("�û���userid,�����needid   "+userid+"  "+needid);
		
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
		f = userdao.updateInsert(userbean,userid);// �������Ϣҳ����û���Ϣ�޸�
		
		String name =req.getParameter("name");
		String qiannian = req.getParameter("qiannian");
		String hounian = req.getParameter("hounian");
		String descrpt = req.getParameter("descrpt");
		String guanjian1 = req.getParameter("guanjian1");
		String guanjian2 = req.getParameter("guanjian2");
		String guanjian3 = req.getParameter("guanjian3");
		String guanjian4 = req.getParameter("guanjian4");
		String guanjian5 = req.getParameter("guanjian5");
		String type = req.getParameter("type");   //�Ƽ������
		String moshi = req.getParameter("moshi");	//�����ʽ
		String hezuo = req.getParameter("hezuo");	//������λ
		String money1 = req.getParameter("money");
		double money = 0;
		if(!money1.equals(""))
			money = Double.parseDouble(money1);
		String xueke = req.getParameter("firstxueke");
		String twoxueke = req.getParameter("twxueke");
		System.out.println("�ڶ�ѧ��  "+twoxueke);
		String lingyu1[] = req.getParameterValues("lingyu");
		String lingyu = "";
		if(lingyu1 != null)
		{
			for(int i=0;i<lingyu1.length;i++)
				lingyu += lingyu1[i]+",";
		}
		String hangye = req.getParameter("twhangye");
		System.out.println("�ڶ���ҵ  "+hangye);
		String yingyong = req.getParameter("firsthangye");
		String ping = req.getParameter("ping");
		NeedBean needbean = new NeedBean(userid,name,descrpt,type,moshi,money,ping,qiannian,hounian,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,hezuo,xueke,twoxueke,lingyu,yingyong,hangye);
		NeedDao needdao = new NeedDao();
		boolean flag = false;
		flag = needdao.updateneed(needbean,needid);
		if(flag)//�޸ĳɹ�
		{	System.out.println("�޸ĳɹ�");
			resp.sendRedirect("NeedServlet?method=add&sta=1&sta10=1&msg=1&id="+needid);
			//req.getRequestDispatcher("/NeedServlet?method=listneed&status=3").forward(req, resp);
		}
		else//���ʧ��
		{	System.out.println("�޸�ʧ��");
		
			System.out.println("�������ѱ���ˣ������޸���Ϣ");
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
			System.out.println("����Ϊ��");
			needbeans = needdao.listneed(status);//status=3ȫ��������status=0���������Ϊ0������status=2���������Ϊ2������
		}
		else if(name != null&& (!name.equals("")))
		{
			System.out.println("���ֲ�Ϊ��");
			needbeans = needdao.getnameneed(name, status,0);
		}
		req.setAttribute("needbeans", needbeans);
		System.out.println("����"+needbeans);
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(needbeans));
		out.flush();
		out.close();
	}
	
	/**
	 * ��ʾ���е�������Ϣ
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void listneed(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		
		System.out.println("��ʾ��Ϣ");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//status=0,δ��ˣ�statsu=1����ˣ�2 ���˻� 3.ȫ�� 4.���û�����д��������
		String name = "";
		name = req.getParameter("name");
		System.out.println("name   "+name);
		String sta1 = "";
		sta1 = req.getParameter("shenhe");//�������sta1=0���������sta1=1
		String suoshu = "";
		suoshu = req.getParameter("suoshu");//suoshu = me,�ҵ����� =all ���е�
		
		String status1 = "";
		status1 = req.getParameter("status"); //�ۺϲ�ѯ��status=5
		System.out.println("status1  "+status1);
		int status = 3;    //ȷ������ʾȫ��������ʾ�����������δ��˵�����
		if(status1!=null&&!status1.equals(""))
			status = Integer.parseInt(status1);
		System.out.println("status  "+status);
		List<NeedBean> needbeans = new ArrayList<NeedBean>();
		NeedDao needdao = new NeedDao();
		page pa = new page();
		
		if(sta1 !=null&&(!sta1.equals(""))&&sta1.equals("0"))//�������δ���
		{
			System.out.println("sta1   "+sta1);
			System.out.println("�������δ���");
			needbeans = needdao.listneed(status);//����������δ��˵�����
			
		}
		else if(sta1 !=null&&(!sta1.equals(""))&&sta1.equals("1"))
		{
			System.out.println("sta1   "+sta1);
			System.out.println("�������δ���");
			needbeans = needdao.listwangneed(status);//����������δ��˵�����
		}
		else if(status == 5)
		{
			needbeans = needdao.listneed(status);//��ѯ����
			req.setAttribute("needbeans", needbeans);
			req.getRequestDispatcher("chaxun.jsp").forward(req, resp);
		}
		else if(name == null || name.equals(""))
		{
			System.out.println("����Ϊ��");
			if(status == 4)//status=4,���û�������
			{
				UserBean userbean = (UserBean) req.getSession().getAttribute("userbean");
				int userid = userbean.getId();
				needbeans = needdao.listneedmy(status,userid);
				req.setAttribute("needbeans", needbeans);
				req.getRequestDispatcher("listmyneed.jsp").forward(req, resp);
			}
			else if(suoshu!=null&&suoshu.equals("me"))//���û���
			{
				UserBean userbean = (UserBean) req.getSession().getAttribute("userbean");
				int userid = userbean.getId();
				needbeans = needdao.listneedmy(status,userid);
				req.setAttribute("needbeans", needbeans);
				
				req.getRequestDispatcher("listmyneed.jsp?status2="+status).forward(req, resp);
			}
			else if((suoshu!=null&&suoshu.equals("all")) || (status==3))	//���е�
				needbeans = needdao.listneed(status);//status=3ȫ��������status=0���������Ϊ0������status=2���������Ϊ2������
		}
		else if(name != null&& (!name.equals("")))
		{
			System.out.println("���ֲ�Ϊ��");
			if(suoshu.equals("me"))//���û���
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
			else	//���е�
				needbeans = needdao.getnameneed(name, status,0);
		}
		
		req.setAttribute("needbeans", needbeans);
		System.out.println("����"+needbeans);
		
		if(name ==null&&status == 0) //�������������δ��˵�
		{
			System.out.println("�������������δ��˵�");
			req.getRequestDispatcher("listshen.jsp?shenhe="+sta1).forward(req, resp);
		}		
		else if(name == null)
		{
			System.out.println("����Ϊ��");
			req.getRequestDispatcher("listneed.jsp?status2="+status).forward(req, resp);
			
		}		
		else if(name != null){
			System.out.println("���ֲ�Ϊ��   "+status);
			req.getRequestDispatcher("listneed.jsp?name='"+name+"'&status2="+status).forward(req, resp);
		}
	}
	
}

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.alibaba.fastjson.JSON;

import Bean.JueseBean;
import Bean.PageBean;
import Bean.UserBean;
import Dao.JueseDao;
import Dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
		System.out.println("����ԭ�����������");
    	req.setCharacterEncoding("utf-8");
    	String method = req.getParameter("method");
    	System.out.println("new project"+method);
    	if("login".equals(method))
    	{
			try {
				System.out.println("��¼");
				login(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if("register".equals(method))
    	{
			try {
				System.out.println("ע���û�");
				register(req,resp);
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
    	else if("updateuser".equals(method))
    	{
    		try {
				updateuser(req,resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if("getUserBean".equals(method))
    	{
    		try {
				getUserBeans(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if("upjuese".equals(method))
		{
			try {
				upjuese(req,resp);
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
	/**
	 * ��ҳ
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void fenye(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int currPage = Integer.parseInt(req.getParameter("currPage"));
		int pageSize=3;
		
		UserDao userdao = new UserDao();
		List<UserBean> userlist = userdao.findPage(currPage, pageSize);
		int num = userdao.getCount();
		
		
		System.out.println("����"+userdao.getCount());
		PageBean<UserBean> bean = new PageBean<>(userlist,currPage,pageSize,num);
		System.out.println("��ҳ����"+bean);
		req.setAttribute("page", bean);
		req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
		//req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
		
	}

	private void upjuese(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String username = req.getParameter("username");
		String juese = req.getParameter("juese1");
		UserDao userdao = new UserDao();
		boolean f = userdao.upjuese(username, juese);
		if(f)
		{
			req.getRequestDispatcher("addjuese.jsp").forward(req, resp);
		}
		else
			System.out.println("�޸�ʧ��");
	}
	
	//����û��ļ���
	private void getUserBeans(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDao();
		List<UserBean> userbeans = new ArrayList<UserBean>();
		userbeans = userdao.getUserBeans(); 
		req.setAttribute("userbeans", userbeans);
		System.out.println("�û�����userbeans  "+userbeans);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		out = resp.getWriter();
		out.print(JSON.toJSONString(userbeans));
		out.flush();
		out.close();
	}

	/**
	 * �޸��û���Ϣ
	 * @param req
	 * @param resp
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updateuser(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("�û���id   "+id);
		String depart = req.getParameter("depart");
		String departname = req.getParameter("departname");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String wangzhi = req.getParameter("wangzhi");
		String email = req.getParameter("email");
		String faren = req.getParameter("faren");
		String e_code = req.getParameter("e_code");
		String truename = req.getParameter("truename");
		String dianhua = req.getParameter("dianhua");
		String phnumber = req.getParameter("phnumber");
		String chuanzhen = req.getParameter("chuanzhen");
		String jigoushuxing = req.getParameter("jigoushuxing");
		String jigoujianjie = req.getParameter("jigoujianjie");
		UserBean userbean = new UserBean( depart, departname, address, city, wangzhi, email, faren, e_code,
				 truename, dianhua, phnumber, chuanzhen, jigoushuxing, jigoujianjie);
		UserDao userdao = new UserDao();
		boolean f = false;
		f = userdao.updateInsert(userbean,id);// �������Ϣҳ����û���Ϣ�޸�
		PrintWriter out=resp.getWriter();
		if(f)
		{//�޸ĳɹ�
			//out.print("<script language='javascript'>alert('�޸ĳɹ�');</script>"); 
			//out.print("<script type='text/javascript'>");
			//out.print("alter('ϵͳ��ʾ','�޸ĳɹ�')");
			//out.print("</script>");
			System.out.println("�޸ĳɹ�");
			req.getSession().setAttribute("userbean", userbean);
			//req.setAttribute("msg", "�޸ĳɹ�");
			req.getRequestDispatcher("userinfo.jsp?msg=1").forward(req, resp);
		}
		
	}

	/**
	 * �޸�����
	 * @param req
	 * @param resp
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String old = req.getParameter("old");
		String new1 = req.getParameter("new1");
		String new2 = req.getParameter("new2");
		String username = req.getParameter("username");
		System.out.println("username  "+username);
		UserBean userbean = new UserBean();
		UserDao userdao = new UserDao();
		userbean = userdao.searchuser(username);
		System.out.println("userbean   "+userbean);
		if(old.equals(userbean.getPassword()))
		{//��������ȷ
			boolean f = false;
			f = userdao.updateMima(new1, username);
			if(f)
			{//�޸ĳɹ�
				req.getRequestDispatcher("updateMima.jsp?status=1").forward(req, resp);
			}
			else{
				req.getRequestDispatcher("updateMima.jsp?status=2").forward(req, resp);
			}
		}
		else{
			System.out.println("���������");
			req.getRequestDispatcher("updateMima.jsp?status=0").forward(req, resp);
		}
		
	}


	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String updateid = req.getParameter("updateid");
		System.out.println("updateid  "+updateid);
		
		UserDao userdao = new UserDao();
		String username = (String)req.getParameter("username");
		String phnumber = (String)req.getParameter("Pnumber");
		String password = (String)req.getParameter("password");
		String depart = (String)req.getParameter("depart");
		String truename = req.getParameter("truename");
		String city = req.getParameter("city");
		String director = req.getParameter("director");
		String hangye = req.getParameter("hangye");
		String education = req.getParameter("education");
		String zhicheng = req.getParameter("zhicheng");
		String address = req.getParameter("address");
		String e_code = req.getParameter("e_code");
		String dianhua = req.getParameter("dianhua");
		String email = req.getParameter("email");
		String cardid = req.getParameter("cardid");
		UserBean userbean = new UserBean(username,password,phnumber,depart,truename,city,director,hangye,education,zhicheng,address,e_code,dianhua,email,cardid);
		 //ע��
		boolean f = false;
		System.out.println("ע�� "+userbean);
		f = userdao.adduser(userbean);
		if(f){//ע��ɹ�
			System.out.println("ע��ɹ� "+userbean);
			req.setAttribute("userbean", userbean);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			System.out.println("ע��ʧ�� "+userbean);
			resp.sendRedirect("register.jsp?status=2");
		} 
		
		
	}
	
	


	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = (String)req.getParameter("username");
		String password = (String)req.getParameter("password");
		UserBean userbean = new UserBean();
		System.out.println("�û���" + username +"  ���� " + password);
		UserDao userdao = new UserDao();
		userbean = userdao.searchuser(username);
		if(userbean != null)
		{//���û�����
			if(username.equals(userbean.getUsername())&&password.equals(userbean.getPassword()))
			{//��¼�ɹ�
				req.getSession().setAttribute("userbean", userbean);
				System.out.println("��½�ɹ�,��תҳ��"+userbean);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else{
				//��¼ʧ��
				System.out.println("�������");
				req.getRequestDispatcher("login.jsp?status=2").forward(req, resp);
			}
		}
		else{//�û�������
			System.out.println("�û�������");
			req.getRequestDispatcher("login.jsp?status=1").forward(req, resp);
		}
		
	}
}

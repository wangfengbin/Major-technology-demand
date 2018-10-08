package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import Bean.JueseBean;
import Bean.TwoHangyeBean;
import Dao.JueseDao;

/**
 * Servlet implementation class JueseServlet
 */
@WebServlet("/JueseServlet")
public class JueseServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if("getJueseBeans".equals(method))
		{
			try {
				getJueseBeans(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("addjuese".equals(method))
		{
			try {
				addjuese(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("getJuese".equals(method))
		{
			
			try {
				getJuese(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	
	private void getJuese(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		JueseDao juesedao = new JueseDao();
		String juesename = req.getParameter("juesena");
		JueseBean juesebean = new JueseBean();
		juesebean = juesedao.getJuse(juesename); 
		req.setAttribute("juesebean", juesebean);
		System.out.println("juesebean  "+juesebean);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		out = resp.getWriter();
		out.print(JSON.toJSONString(juesebean));
		out.flush();
		out.close();
	}

	/**
	 * 添加角色
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void addjuese(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");	
		
		String juesename = req.getParameter("juesename");//新建角色
		String selectjuese = req.getParameter("juese");//修改角色
		System.out.println("修改用户的角色名");
		String upmima = req.getParameter("upmima");
		System.out.println("复选 "+upmima);
		String userinfo = req.getParameter("userinfo");
		String dealneed = req.getParameter("dealneed");
		String addneed = req.getParameter("addneed");
		String wangluo = req.getParameter("wangluo");
		String xuqiu = req.getParameter("xuqiu");
		String weishenhe = req.getParameter("weishenhe");
		String tongguo = req.getParameter("tongguo");
		String tuihui = req.getParameter("tuihui");
		if(upmima ==null)
			upmima = "0";
		if(userinfo == null)
			userinfo = "0";
		if(dealneed == null)
			dealneed = "0";
		if(addneed == null)
			addneed = "0";
		if(wangluo == null)
			wangluo = "0";
		if(xuqiu == null)
			xuqiu = "0";
		if(weishenhe == null)
			weishenhe = "0";
		if(tongguo == null)
			tongguo = "0";
		if(tuihui == null)
			tuihui = "0";
		JueseDao juesedao = new JueseDao();
		//如果角色名为空，则是修改，不为空，则为添加新角色
		if(juesename == null || juesename.equals(""))
		{//修改权限
			System.out.println("JueseServlet 修改角色权限  "+selectjuese+" "+wangluo+" "+xuqiu+" "+upmima+" "+addneed+" "+dealneed+" "+userinfo+" "+weishenhe);
			JueseBean juesebean = new JueseBean(selectjuese,wangluo,xuqiu,upmima,addneed,dealneed,userinfo,weishenhe,tongguo,tuihui);
			juesedao.upjuese(juesebean);
		}
		else{
			JueseBean juesebean = new JueseBean(juesename,wangluo,xuqiu,upmima,addneed,dealneed,userinfo,weishenhe,tongguo,tuihui);
			juesedao.addJuese(juesebean);
		}
		
		req.getRequestDispatcher("addjuese.jsp").forward(req, resp);
			
	}

	/**
	 * 获得角色的集合
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void getJueseBeans(HttpServletRequest req, HttpServletResponse resp) throws Exception 
	{
		// TODO Auto-generated method stub
		JueseDao juesedao = new JueseDao();
		List<JueseBean> juesebeans = new ArrayList<JueseBean>();
		juesebeans = juesedao.getJueseBeans(); 
		req.setAttribute("juesebeans", juesebeans);
		System.out.println("juesebeans  "+juesebeans);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(juesebeans));
		out.flush();
		out.close();
	}
}

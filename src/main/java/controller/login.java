package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_client;
import model.client;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		String loginUserName = request.getParameter("loginUserName");
		String loginPassword = request.getParameter("loginPassword");
		
		request.setAttribute("loginUserName",loginUserName);
		request.setAttribute("loginPassword",loginPassword);
		
		String err_Login = "";
		String url = "";
		
		if( DAO_client.getInstance().checkLoginUserExist(loginUserName, loginPassword) != null ) {
			client loginClient = DAO_client.getInstance().checkLoginUserExist(loginUserName, loginPassword);
			HttpSession session = request.getSession();
			session.setAttribute("client",loginClient );
			request.setAttribute("user_Welcome", loginClient.getClient_FullName());
			String block = "block";
            request.setAttribute("welcome_Notification",block);

			url = "/index.jsp";
			
		}else {
			err_Login = "Account or password is wrong";
			url = "/Login.jsp";
			request.setAttribute("err_Login",err_Login);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}

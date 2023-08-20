package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_client;
import model.client;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		response.setContentType("text/html");
		
		//get value in register_form:
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String numberPhone = request.getParameter("numberPhone");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean receiveEmail = (request.getParameter("receiveEmail")!=null);
		request.setAttribute("fullName",fullName);
		request.setAttribute("gender",gender);
		request.setAttribute("address",address);
		request.setAttribute("numberPhone",numberPhone);
		request.setAttribute("userName",userName);
		request.setAttribute("email",email);
		request.setAttribute("password",password);
		request.setAttribute("confirmPassword",confirmPassword);
//		request.setAttribute("receiveEmail",receiveEmail);
		
		
		int err_message = 0;
		
		//Exception fullName:
		String err_FullName = "";
		boolean ex_FullName = Pattern.matches("^[a-zA-Z ]{8,16}$",fullName);
		if(!(ex_FullName)) {
			err_FullName += "Must not contain number and special character";
			request.setAttribute("err_FullName", err_FullName);
			err_message +=1;
		}
		
		//Exception Password:
		String err_Password ="";
		if(!password.equals(confirmPassword)) {
			err_Password += "Password is not match !";
			request.setAttribute("err_password", err_Password);
			err_message +=1;
		}
		
		//Exception Email and UserName:
		String err_MatchUser="";
		if(!DAO_client.getInstance().checkUserExist(userName,email)) {
			err_MatchUser = "UserName or Email is Exist";
			request.setAttribute("err_Email", err_MatchUser);
			request.setAttribute("err_userName", err_MatchUser);
			err_message +=1;
		}
		
		String url = "/Login.jsp";
		if(!(err_message > 0)) {
			String clientId = "CI_" + System.currentTimeMillis();
			client newClient = new client(clientId, userName, password, fullName, gender, address,numberPhone, email,receiveEmail);
			DAO_client.getInstance().addItem(newClient);
			// Đăng ký thành công
			// Lưu thông tin đăng ký thành công vào request attribute
			request.setAttribute("registrationSuccess", "true");
			// Tiếp tục chuyển hướng đến trang login/register.jsp
			
			request.setAttribute("fullName",null);
			request.setAttribute("gender",null);
			request.setAttribute("address",null);
			request.setAttribute("numberPhone",null);
			request.setAttribute("userName",null);
			request.setAttribute("email",null);
			request.setAttribute("password",null);
			request.setAttribute("confirmPassword",null);
			url = "/Login.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}

package com.password;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FIrst
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out= response.getWriter();
	String username= request.getParameter("username");
	String password= request.getParameter("password");
	
	
	if(username.isEmpty()||password.isEmpty())
	{
		RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
	out.print("<font color=#ff0000><center>You cannot leave the fields empty!</center></font>");
		rd.include(request, response);
	}
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","0707");
			PreparedStatement ps=con.prepareStatement("select * from info where password=? AND username=?");  
			ps.setString(1,password);
			ps.setString(2,username);
			
			
			      
			ResultSet rs=ps.executeQuery();  
			
			if(rs.absolute(1)) {
				String user=rs.getString(1);
				HttpSession session=request.getSession();
				session.setAttribute("name",user);
		
				out.println("<font color=#ff0000><center>Hello " + user+"!</center></font>");
				RequestDispatcher rd = request.getRequestDispatcher("postsignin.jsp");
				rd.include(request, response);
				
			}
			else
			{
			out.print("<font color=#ff0000><center>You have entered a wrong password!</center></font><br>");
			
			RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
			rd.include(request, response);
			}
			
			
			
				
			}catch (Exception e2) {System.out.println(e2);}
			
			out.close();
	

		
		
	
	}
		
	}
	
	
	
	
	
	
	
	



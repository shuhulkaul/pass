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

/**
 * Servlet implementation class FIrst
 */
@WebServlet("/first")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
	String password2= request.getParameter("password2");
	
	if(username.isEmpty()||password.isEmpty())
	{
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	out.print("<font color=#ff0000 ><center>You cannot leave the fields empty!</center></font>");
		rd.include(request, response);
	}
	else if(password.equals(password2) )
	{ if(password.length()>=8){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","0707");
			PreparedStatement ps=con.prepareStatement("select * from info where username=?");  
			ps.setString(1,username);  
			      

			ResultSet rs=ps.executeQuery();  
			if(rs.absolute(1)) {
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				out.print("<font color=#ff0000><center>The user already exists!</center></font>");
				rd.include(request, response);
			}
			else{
			
			
			PreparedStatement ps1=con.prepareStatement("insert into info values(?,?)");
			ps1.setString(1,username);
			ps1.setString(2,password);
		
			
			int i=ps1.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				out.println("<font color=#00ff00><center>"+"Account has been created successfully!"+"</center></font><br><br>");
				rd.include(request, response);
			}
			}
			
				
			}catch (Exception e2) {System.out.println(e2);}
	}
	else
	{RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		out.print("<font color=#ff0000><center>Password must have 8 or more characters.</center></font>");
		rd.include(request, response);

	}
			out.close();
	}
	else
	{ RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	out.print("<font color=#ff0000><center>The passwords doesnot match!</center></font>");
	rd.include(request, response);
		
		
	
	}
		
	}
	
	
	
	
	
	
	
	}



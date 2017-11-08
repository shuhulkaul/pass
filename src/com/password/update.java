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
@WebServlet("/second")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
	String password3= request.getParameter("password3");
	
	
	if(username.isEmpty()||password.isEmpty())
	{
		RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
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

				if(password2.isEmpty()||password3.isEmpty())
				{
					RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
				out.print("<font color=#ff0000><center>You cannot leave the fields empty!</center></font>");
					rd.include(request, response);
				}
				else if(password3.equals(password2))
				{ if(password.length()>=8)
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","0707");
						PreparedStatement psk=conn.prepareStatement("update info set password=? where username=?");  
						psk.setString(1,password2);
						psk.setString(2,user);  
						psk.executeUpdate(); 
			            
			con.close();
			           
			out.print("<center>Password was changed successfully!</center><br>");
			    			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			    				
			    				rd.include(request, response);

			        
					
							
						}catch (Exception e2) {System.out.println(e2);}
				}
				else{
					
					out.print("<script>alert("+"Hi"+");</script>");
					out.print("<font color=#ff0000><center>The password must have 8 or more characters.</center></font>");
					RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
					
					rd.include(request, response);
				}
						out.close();
				}
				else
				{ RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
				out.print("<font color=#ff0000><center>The passwords doesnot match!</center></font>");
				rd.include(request, response);
					
					
				
				}
				
				
				RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
			
				rd.include(request, response);
			}
			else
			{
			out.print("<font color=#ff0000><center>You have entered a wrong password!</center></font><br>");
			
			RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
			rd.include(request, response);
			}
			
			
			
				
			}catch (Exception e2) {System.out.println(e2);}
			
			out.close();
	

		
		
	
	}
		
	}
	
	
	
	
	
	
	
	



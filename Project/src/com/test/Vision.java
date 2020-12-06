package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vision
 */
@WebServlet("/Vision")
public class Vision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();    
						
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","root","root"); 
			
			int a=Integer.parseInt(request.getParameter("ssn"));     
			
			PreparedStatement ps=con.prepareStatement("select * from soldier where ssn=?");
			ps.setInt(1,a);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				out.println("<html>"
						+"<img src='images/details2.jpg' style='z-index:-1;position:fixed;width:100%;height:100%'/>"
						+" <h1><b><center><font size=7 color=white>SOLDIER DETAILS</font></center></h1><br><br><font size=6 color=white>SOLDIER SSN= ");
				out.println(rs.getInt(1)+"<br>SOLDIER NAME= "+rs.getString(2)+"<br> HEIGHT=  "+rs.getInt(3)+"<br>WEIGHT= "+rs.getInt(4)+"<br>DIVISION NUMBER=  "+rs.getInt(5)+"<br>DIVISION NAME= "+rs.getString(6)+"<br>BARRACK NAME= "+rs.getString(7)+"<br>BARRACK CAPACITY= "+rs.getInt(8)+"<br>BARRACK SIZE= "+rs.getInt(9)+" <br>EOUIPMENT NUMBER= "+rs.getInt(10)+" <br>TYPE OF EQUIPMENT= "+rs.getString(11));
				out.println("<br><form method=post action=Home.html></font>"
						+ "<input type=submit name=submit value=Back></form>"
						+"<br><br><blockquote><footer><i><center><font size=7 color=white>\"A man's feet should be planted in his country, but his eyes should survey the world.\r\n" + 
						"\"\r\n" + 
						"</font></center></i></footer></blockquote>"
						+ "</html>");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}

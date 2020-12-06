package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class storeData
 */
@WebServlet("/storeData")
public class storeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeData() {
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
		try {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int m=Integer.parseInt(request.getParameter("ssn"));
		String n=request.getParameter("s_name");
		int o=Integer.parseInt(request.getParameter("height"));
		int p=Integer.parseInt(request.getParameter("weight"));
		int q=Integer.parseInt(request.getParameter("choice0"));
		String r=request.getParameter("choice1");
		String s=request.getParameter("choice2");
		int t=Integer.parseInt(request.getParameter("choice3"));
		int u=Integer.parseInt(request.getParameter("choice4"));
		int v=Integer.parseInt(request.getParameter("choice5"));
		String w=request.getParameter("choice6");
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/project","root","root");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into soldier values(?,?,?,?,?,?,?,?,?,?,?)");  
		  
		     ps.setInt(1,m); 
			 ps.setString(2,n);
			 ps.setInt(3,o); 
			 ps.setInt(4,p); 
			 ps.setInt(5,q);
			 ps.setString(6,r);
			 ps.setString(7,s);
			 ps.setInt(8,t); 
			 ps.setInt(9,u);
			 ps.setInt(10,v);
			 ps.setString(11,w);
			
			int i=ps.executeUpdate();  
			if(i>0)
			{
				out.println("<html>"
						+ "<img src=\"images/success.jpg\" style=\"z-index:-1;position:fixed;width:100%;height:100%\"/>"
						+" <h1><b><center><font size=7 color=black>SUCCESS PAGE</font></center></h1><br><br>");
				out.println("<font size=6 color=white>Successfully Registered</font><br><br><br><br>");
				out.println("<html><form method=post action=Home.html>"
						+ "<input type=submit name=submit value=Back></form>"
						+"<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"
						+"<blockquote><footer><i><center><font size=7 color=white>'Patriotism is religion and religion is love for India.'\r\n</font></center></i></footer></blockquote>"
						+ "</html>");
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
	}
}

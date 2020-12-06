package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Soldier
 */
@WebServlet("/Soldier")
public class Soldier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Soldier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter ps = response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			String sql ="select * from division";
			Statement st = con.createStatement();
			ps.println("<html>"
					+ "<img src=\"images/selectssn4.jpg\" style=\"z-index:-1;position:fixed;width:100%;height:100%\"/>"
					+" <h1><b><center><font size=7 color=white>SOLDIER REGISTRATION</font></center></b><br></h1>");
			ps.println("<form method=post action=storeData>"
					+
					"<font size=6 color=white>SSN:<input type='text' name='ssn'/>\r\n" + 
					"<font size=6 color=white>SOLDIER NAME:<input type='text' name='s_name'/>\r\n" + 
					"<font size=6 color=white>HEIGHT:<input type='text' name='height'/>\r\n" + 
					"<font size=6 color=white>WEIGHT:<input type='text' name='weight'/></font><br>"
					+ ""
					+ "<h1><font size=6 color=white>Division Number</h1><select name=choice0></font>");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				
				ps.print("<option>"+rs.getInt(1)+"</option>");
			}
			ps.println("</select>");
			
			String sql1 ="select * from division";
			Statement st1 = con.createStatement();
			ps.println("<h1><font size=6 color=white>Division Name</h1><select name=choice1></font>");
			ResultSet rs1 = st1.executeQuery(sql1);
			while(rs1.next())
			{
				
				ps.print("<option>"+rs1.getString(2)+"</option>");
			}
			ps.println("</select>");
			
			String sql2 ="select * from barracks";
			Statement st2 = con.createStatement();
			ps.println("<h1><font size=6 color=white>Barrack Name</h1><select name=choice2></font>");
			ResultSet rs2 = st2.executeQuery(sql2);
			while(rs2.next())
			{
				
				ps.print("<option>"+rs2.getString(1)+"</option>");
			}
			ps.println("</select>");
			
			String sql3 ="select * from barracks";
			Statement st3 = con.createStatement();
			ps.println("<h1><font size=6 color=white>Barrack Capacity</h1><select name=choice3></font>");
			ResultSet rs3 = st3.executeQuery(sql3);
			while(rs3.next())
			{
				
				ps.print("<option>"+rs3.getInt(2)+"</option>");
			}
			ps.println("</select>");
			
			String sql4 ="select * from barracks";
			Statement st4 = con.createStatement();
			ps.println("<h1><font size=6 color=white>Barrack Size</h1><select name=choice4></font>");
			ResultSet rs4 = st4.executeQuery(sql4);
			while(rs4.next())
			{
				
				ps.print("<option>"+rs4.getString(3)+"</option>");
			}
			ps.println("</select>");
			
			String sql5 ="select * from equipments";
			Statement st5 = con.createStatement();
			ps.println("<h1><font size=6 color=white>Equipment Number </h1><select name=choice5></font>");
			ResultSet rs5 = st5.executeQuery(sql5);
			while(rs5.next())
			{
				
				ps.print("<option>"+rs5.getInt(1)+"</option>");
			}
			ps.println("</select>");
			
			String sql6 ="select * from equipments";
			Statement st6 = con.createStatement();
			ps.println("<h1><font size=6 color=white>Type Of Arm</h1><select name=choice6></font>");
			ResultSet rs6 = st6.executeQuery(sql6);
			while(rs6.next())
			{
				
				ps.print("<option>"+rs6.getString(2)+"</option>");
			}
			
			
			ps.println("</select><br><br><input type=submit name=submit value=Register></form></html>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

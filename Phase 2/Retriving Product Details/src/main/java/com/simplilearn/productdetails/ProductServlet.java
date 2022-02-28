package com.simplilearn.productdetails;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Properties props = new Properties();
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		int prodID =  Integer.parseInt(request.getParameter("id"));
		try {
			DatabaseConfig config = new DatabaseConfig(props.getProperty("driver"), props.getProperty("url"), 
					props.getProperty("username"), props.getProperty("password"));
			Connection con=config.getConnection();
			if(con!=null)
			{
					String query = "select * from mobile where id=?";
					PreparedStatement stat = con.prepareStatement(query);
					stat.setInt(1, prodID);
					ResultSet rs = stat.executeQuery();
					if(rs!=null)
					{
						while(rs.next())
						{
							out.print("Product id = "+rs.getInt(1)+"<br>"+"Brand = "+rs.getString(2)+"<br>"+"Processor = "+
						rs.getString(3)+"<br>"+"Ram = "+rs.getString(4)+"<br>"+"Storage = "+rs.getString(5)+"<br><br>");
						}
					}
					else
					{
						out.print("Failed to fetch data : No such ProductID exists ");
					}
			}
			else
			{
				out.print("Failed to Fetch Data");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

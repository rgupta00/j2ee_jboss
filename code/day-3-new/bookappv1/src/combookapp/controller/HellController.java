package combookapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/HellController")
public class HellController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    
//	@Resource(lookup="java:/MySqlDS")
//	private DataSource dataSource;
	
	private DataSource dataSource;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			InitialContext ctx=new InitialContext();
			dataSource=(DataSource)ctx.lookup("java:/MySqlDS");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(dataSource!=null) {
			try {
				Connection connection=dataSource.getConnection();
				System.out.println("conn is done");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	

}

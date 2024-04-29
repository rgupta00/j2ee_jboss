package com.shoppingcart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.logic.CartRemote;

@WebServlet("/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// java:module/Cart!com.shoppingcart.logic.CartRemote

	private CartRemote cartRemote;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cartRemote = (CartRemote) request.getSession().getAttribute("cart");

		if (cartRemote == null) {
			// EJB is not present in the HTTP session so let's fetch a new one from the
			// container

			try {
				InitialContext ic = new InitialContext();
				cartRemote = (CartRemote) ic.lookup("java:module/Cart!com.shoppingcart.logic.CartRemote");

				// put EJB in HTTP session for future servlet calls

				request.getSession().setAttribute("cart", cartRemote);

			} catch (NamingException e) {
				throw new ServletException(e);
			}
		}
		
			PrintWriter out = response.getWriter();
			
			String action = request.getParameter("action");
			String item = request.getParameter("item");
			String quantity = request.getParameter("quantity");

			out.println("<html><body><h1>Cart Manager</h1>");
		
			if (action.equals("add"))
			{
				cartRemote.putItem(item, Integer.parseInt(quantity));
			}
			else if (action.equals("remove")) 
			{
				cartRemote.removeItem(item);
			} 
			else if (action.equals("list")) 
			{
			Hashtable<String, Integer> items = cartRemote.getItem();
			Enumeration<String> itemNames = items.keys();
			while (itemNames.hasMoreElements()) 
			{
				String itemId = (String) itemNames.nextElement();
				out.println("Item id: " + itemId + " Quantity : "+ items.get(itemId));
				out.println("<BR>");
			}
			
			}
			out.println("</body></html>");
			
		
	}

}

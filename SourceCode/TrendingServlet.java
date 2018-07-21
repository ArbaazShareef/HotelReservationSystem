import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class TrendingServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		String fName = null;
		
		if(session != null)
		{
			fName=(String)session.getAttribute("firstName");
		}

		int C=0;
        Cart cart=null;
        if(session != null)
		{
        	cart = (Cart) session.getAttribute("cart");
        }
		if(session!=null){
        if(cart == null ){
          cart = new Cart();
          session.setAttribute("cart", cart);
          C=0;
          session.setAttribute("C",C);

        }else{C = (int)session.getAttribute("C");}}
		
		out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		out.println("<title>Al Hamdan</title><link rel=\"stylesheet\" href=\"styles1.css\" type=\"text/css\" />");
		out.println("<script type=\"text/javascript\" src=\"JS/javascript.js\"></script></head>");
		if(fName != null && !fName.isEmpty())
		{
			out.println("<body onload='init()'><div id=\"container\"><header><div align=\"right\" ><a href=\"logoutservlet\">Logout</a><br></div><img src=\"images/AlHamdan.jpg\" alt=\"\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4>");
		
		}else{
			out.println("<body onload='init()'><div id=\"container\"><header><div align=\"right\" ><a href=\"Login.html\" >Login</a><a href=\"SignUP.html\">Signup</a><br></div><img src=\"images/AlHamdan.jpg\" alt=\"\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4>");
		
		}
		//out.println("<body onload='init()'><div id=\"container\"><header><div align=\"right\" ><a href=\"Login.html\" >Login</a><a href=\"SignUP.html\">Signup</a><br></div><img src=\"images/AlHamdan.jpg\" alt=\"\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4>");
		out.println("<form  name='autofillform1' action='autocomplete'>");
		out.println("<div name='autofillform'>");
		out.println("<strong>Search Products: </strong>");
		out.println("<input type='text' name='searchId' size='40' id='searchId' onkeyup='doCompletion()' placeholder='Search Here...'>");
		out.println("<div id='auto-row'>");
		out.println("<table border='0' id='complete-table' class='popupBox'></table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		out.println("</header>");
		
		if(fName != null && !fName.isEmpty())
		{
			out.println("<h5>Welcome ");
			out.println(fName);
			out.println("</h5>");
			out.println("<nav><ul><li class=\"start selected\"><a href=\"loginedhomeservlet\">Home</a></li>");
		}else{
			out.println("<nav><ul><li class=\"start selected\"><a href=\"homeservlet\">Home</a></li>");
		}
		out.println("<li class=\"\"><a href=\"contentservlet?productType=Rooms\">Rooms</a></li>");
		out.println("<li><a href=\"contentservlet?productType=Suites\">Suites</a></li>");
		out.println("<li><a href=\"contentservlet?productType=LR\">Leisure Facilities</a></li>");
		out.println("<li><a href=\"contentservlet?productType=Dinning\">Dinning</a></li>");
		
		if(fName != null && !fName.isEmpty())
		{
			out.println("<li><a href=\"cartservlet\">Cart("+C+")</a></li>");
			out.println("<li><a href=\"vieworderservlet\">Your Orders</a></li></ul></nav>");
		}else{
			out.println("</ul></nav>");
		}
		out.println("<div id=\"body\">");
		out.println("<section id=\"content\">");
		
		String trendType = request.getParameter("trendType");
		
		if(trendType.equals("MR"))
		{
			
			LinkedHashMap<String, Integer> top5SoldProducts;
			top5SoldProducts = MongoDBDataStoreUtilities.getTop5SoldProducts();
			
			out.println("<h3 align='center'>Top 5 Most Reviewed Products</h3>");
			out.println("<table>");
			out.println("<tr><td><b>Product Name</b></td><td><b>Product Sold</b></td></tr>");
			
			for(Map.Entry<String, Integer> m :top5SoldProducts.entrySet())
			{
				String key = m.getKey();
				int value = m.getValue();
				
				out.println("<tr><td>"+key+"</td>");
				out.println("<td>"+value+"</td></tr>");
			}
			
			out.println("</table>");

			
		}
		
		if(trendType.equals("ML"))
		{
			LinkedHashMap<String, Double> top5LikedProducts;
			top5LikedProducts = MongoDBDataStoreUtilities.getTop5LikedProducts();
			
			out.println("<h3 align='center'>Top 5 Most Liked Products</h3>");
			out.println("<table>");
			out.println("<tr><td><b>Product Name</b></td><td><b>Average Rating</b></td></tr>");
			
			for(Map.Entry<String, Double> m :top5LikedProducts.entrySet())
			{
				String key = m.getKey();
				Double value = m.getValue();
				
				out.println("<tr><td>"+key+"</td>");
				out.println("<td>"+value+"</td></tr>");
			}
			
			out.println("</table>");
		}
		
		
			out.println("</section>");
		out.println("<aside class=\"sidebar\">");
                              
            out.println("<ul><li><h4>Gallery</h4>");
            out.println("<ul><li><form>");
            out.println("<div class=\"block form-group\">");
            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX1\">");
                            
            out.println("<label for=\"CHECKBOX1\"><b>Trump Hotel<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX2\">");
                            
                            out.println("<label for=\"CHECKBOX2\"><b>Washington Jefferson Hotel<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX3\">");
                            
                            out.println("<label for=\"CHECKBOX3\"><b>Park Lane New York<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div class=\"block\">");
                            out.println("<button align='center' class = 'formbutton' id=\"useGsFunctions\">GO</button>");
                            out.println("</div>");
         out.println("</form></li>");
                        
            out.println("</ul></ul>");
             
            
            out.println("<ul><li><h4>Hotel Information</h4>");
            out.println("<ul>");
                        out.println("<li><a href=\"contentservlet?productType=H1\">Trump Hotel</a><br></li>");
                        out.println("<li><a href=\"contentservlet?productType=H2\">Washington Jefferson Hotel</a><br></li>");
                        out.println("<li><a href=\"contentservlet?productType=H3\">Park Lane New York</a><br></li>");
            out.println("</ul>");
              
            out.println("</ul>");
            
            out.println("<ul><li><h4>Trending</h4>");
            out.println("<ul>");
            out.println("<li><a href=\"TrendingServlet?trendType=MR\">Most Reviewed</a><br></li>");
                        out.println("<li><a href=\"TrendingServlet?trendType=ML\">Most Liked</a><br></li>");
            out.println("</ul>");
            out.println("</ul></ul></aside>");
		
		out.println("<div class=\"clear\"></div>");


		out.println("<footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
		out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
		out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
		out.println("<p>&copy; AlHamdanHotels 2017. by AlHamdan</p></div></footer></div>");
		out.println("</div></body></html>");
		
		out.close();
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
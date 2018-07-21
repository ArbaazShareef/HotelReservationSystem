import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class loginedhomeservlet extends HttpServlet
{
	Customer customer;
	HashMap<String,Customer> customers;
    String emailId;
	String password;
	
	fillHashmap fH;
	
	public void init()
	{
		fH = new fillHashmap();
		customers = new HashMap<String, Customer>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	HttpSession session = request.getSession();
	String fName = (String)session.getAttribute("firstName");
	int C;
       Cart cart;
        cart = (Cart) session.getAttribute("cart");
		
        if(cart == null){
          cart = new Cart();
          session.setAttribute("cart", cart);
          C=0;
          session.setAttribute("C",C);

        }else{C = (int)session.getAttribute("C");}

    out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
	out.println("<title>Smart Portables</title><link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" /><script type=\"text/javascript\" src=\"javascript.js\"></script></head>");
	out.println("<body onload=\"init()\"><div id=\"container\"><header><h1><a href=\"/\">Smart<span>Portables</span></a></h1><h2>Buy best for the best</h2>");
	out.println("<form  name='autofillform1' action=''>");
		out.println("<div name='autofillform'>");
		out.println("<strong>Search Products: </strong>");
		out.println("<input type='text' name='searchId' size='40' id='searchId' onkeyup='doCompletion()' placeholder='Search Here...'><div id='auto-row'>");
		out.println("<table border='0' id='complete-table' class='popupBox'></table>");
		out.println("</div></div></form></header>");
	out.println("<h5>Welcome ");
	out.println(fName);
	out.println("!</h5>");
	
	out.println("<nav><ul><li class=\"start selected\"><a href=\"loginedhomeservlet\">Home</a></li>");
	out.println("<li class=\"\"><a href=\"contentservlet?productType=All\">Products</a></li>");
	out.println("<li><a href=\"contentservlet?productType=Accessories\">Accessories</a></li>");
	out.println("<li><a href=\"cartservlet\">Cart("+C+")</a></li>");
	out.println("<li><a href=\"vieworderservlet\">Your Orders</a></li>");
	out.println("<li><a href=\"logoutservlet\">Logout</a></li>");
	
	out.println("</ul></nav><img class=\"header-image\" src=\"images/homepage.jpg\" alt=\"Advertisment Image Here\" />");
	
	out.println("<div id=\"body\">");
	out.println("<section id=\"content\">");
	out.println("<article><h2>Welcome to Smart Portables, Best Price Guaranteed !</h2>");
	out.println("<p>Smart Portables brings to you the best products from the best retailers in America. We provide our customers excellent customer service. Lowest price guaranteed across all the major retailers in America.</p>");
	out.println("<p>We specialize in providing high quality products to our customers. Making our customers happy is our prime goal.</p>");
	out.println("<p>Currently we sell the following products online as well as in store.</p>");
	out.println("<ul class=\"styledlist\"><li>Smart Watches</li><li>Speakers</li><li>Headphones</li><li>Phones</li><li>Laptops</li><li>External Storage</li></ul>");
	out.println("</article>");
	out.println("</section>");
	
	out.println("<aside class=\"sidebar\">");

	out.println("<ul><li><h4>Trending</h4><ul>");
	out.println("<li><a href=\"TrendingServlet?trendType=topFiveLiked\">Top 5 Liked Products</a></li>");
	out.println("<li><a href=\"TrendingServlet?trendType=topFiveZipCodes\">Top 5 Zip Codes</a></li>");
	out.println("<li><a href=\"TrendingServlet?trendType=topFiveSold\">Top 5 Sold Product</a></li></ul></li>");

	out.println("<ul><li><h4><a href=\"contentservlet?productType=Smart Watches\">Smart Watches</a></h4></li>");
	out.println("<li><h4><a href=\"contentservlet?productType=Speakers\">Speakers</a></h4></li>");
	out.println("<li><h4><a href=\"contentservlet?productType=Headphones\">Headphones</a></h4></li>");
	out.println("<li><h4><a href=\"contentservlet?productType=Phones\">Phones</a></h4></li>");
	out.println("<li><h4><a href=\"contentservlet?productType=Laptops\">Laptops</a></h4></li>");
	out.println("<li><h4><a href=\"contentservlet?productType=External Storages\">External Storage</a></h4></li>");
	out.println("</ul></aside><div class=\"clear\"></div></div>");

	
	out.println("<footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
	out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
	out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
	out.println("<p>&copy; Smart Portables 2017. by Syed Hamdan Sher</p></div></footer></div>");
	out.println("</body></html>");
	
	
	out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}
	
	
}
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.*;
import java.util.Set;
import java.util.Date;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ViewReviews extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		String fName = null;
		if (session!=null){
		fName=(String)session.getAttribute("firstName");}

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
		
		
		String userid=(String)session.getAttribute("userid");
		
		String productName = request.getParameter("productName");
		
		HashMap<String,Review> reviews;
		reviews = MongoDBDataStoreUtilities.getReviews();
		
		HashMap<String,Review> thisProductReviews;
		thisProductReviews = new HashMap<String, Review>();
		
		for(Map.Entry<String,Review> m :reviews.entrySet())
		{
			String key = m.getKey();
			Review c = m.getValue();
			
			if(c.getProductName().equals(productName))
			{
				thisProductReviews.put(key, c);
			}
		}
		
		
		if(thisProductReviews.isEmpty()){
			out.println("<section id=\"content\">");
			out.println("<article>");
			out.println("<h3>There are no Reviews for this product<h3>");
			out.println("</article>");
			out.println("</section>");

			/*out.println("<aside class=\"sidebar\">");

			out.println("<ul><li><h4><a href=\"contentservlet?productType=Smart Watches\">Smart Watches</a></h4></li>");
			out.println("<li><h4><a href=\"contentservlet?productType=Speakers\">Speakers</a></h4></li>");
			out.println("<li><h4><a href=\"contentservlet?productType=Headphones\">Headphones</a></h4></li>");
			out.println("<li><h4><a href=\"contentservlet?productType=Phones\">Phones</a></h4></li>");
			out.println("<li><h4><a href=\"contentservlet?productType=Laptops\">Laptops</a></h4></li>");
			out.println("<li><h4><a href=\"contentservlet?productType=External Storages\">External Storage</a></h4></li>");
			out.println("</ul></aside><div class=\"clear\"></div></div>");*/
	
			out.println("<footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
			out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
			out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
			out.println("<p>&copy; Smart Portables 2017. by Syed Hamdan Sher</p></div></footer></div>");
			out.println("</body></html>");
		}
		else	
		{
			String name;
			String emailId;
			int reviewRating;
			Date date;
			String reviewText;
			
			String retailer;
			String retailerZip;
			String retailerCity;

			out.println("<section id=\"content\">");
			
			out.println("<h3 align='center'>Product Reviews</h3>");
			out.println("<table>");
			out.println("<tr><td>No.</td><td>Product Name</td><td>Email Id</td><td>Review Rating</td><td>Review Date</td><td>Hotel</td><td>Retailer Zip</td><td>Retailer City</td><td>Review text</td></tr>");
				
			int no=1;
			
				for(Map.Entry<String,Review> m :thisProductReviews.entrySet()){
					
					Review c = m.getValue();
					
					name = c.getProductName();
					emailId = c.getEmailId();
					reviewRating = c.getReviewRating();
					
					retailer = c.getRetailer();
					retailerZip = c.getRetailerZip();
					retailerCity = c.getRetailerCity();
					
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					date = c.getReviewDate();
					String reviewDate = dateFormat.format(date);
					
					reviewText = c.getReviewText();
					
					out.println("<tr><td>"+no+"</td>");
					out.println("<td>"+name+"</td>");
					out.println("<td>"+emailId+"</td>");
					out.println("<td>"+reviewRating+"</td>");
					out.println("<td>"+reviewDate+"</td>");
					out.println("<td>"+retailer+"</td>");
					out.println("<td>"+retailerZip+"</td>");
					out.println("<td>"+retailerCity+"</td>");
					out.println("<td>"+reviewText+"</td></tr>");
					
					no++;
					
				}
			
			out.println("</table>");
			out.println("</section>");

			out.println("<aside class=\"sidebar\">");
                              
            out.println("<ul><li><h4>Gallery</h4>");
            out.println("<ul><li><form>");
            out.println("<div class=\"block form-group\">");
            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX1\">");
                            
            out.println("<label for=\"CHECKBOX1\"><b>HOTEL 1<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX2\">");
                            
                            out.println("<label for=\"CHECKBOX2\"><b>HOTEL 2<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX3\">");
                            
                            out.println("<label for=\"CHECKBOX3\"><b>HOTEL 3<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div class=\"block\">");
                            out.println("<button align='center' class = 'formbutton' id=\"useGsFunctions\">GO</button>");
                            out.println("</div>");
         out.println("</form></li>");
                        
            out.println("</ul></ul>");
             
            
            out.println("<ul><li><h4>Hotel Information</h4>");
            out.println("<ul>");
                        out.println("<li><a href=\"contentservlet?productType=H1\">Hotel 1</a><br></li>");
                        out.println("<li><a href=\"contentservlet?productType=H2\">Hotel 2</a><br></li>");
                        out.println("<li><a href=\"contentservlet?productType=H3\">Hotel 3</a><br></li>");
            out.println("</ul>");
              
            out.println("</ul>");
            
            out.println("<ul><li><h4>Trending</h4>");
            out.println("<ul>");
            out.println("<li><a href=\"TrendingServlet?trendType=MR\">Most Reviewed</a><br></li>");
                        out.println("<li><a href=\"TrendingServlet?trendType=ML\">Most Liked</a><br></li>");
            out.println("</ul>");
            out.println("</ul></ul></aside>");out.println("<div class=\"clear\"></div></div>");

	
	out.println("<footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
	out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
	out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
	out.println("<p>AlHamdanHotels 2017. by AlHamdan</p></div></footer></div>");
	out.println("</body></html>");	
		}
	}
}
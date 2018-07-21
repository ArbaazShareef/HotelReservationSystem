import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class WriteReview extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        HttpSession session = request.getSession();
		String fName = (String)session.getAttribute("firstName");
		String userId = (String)session.getAttribute("userid");

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

		/*out.println("<tr><td><form method = 'get' action = 'WriteReview'>");
                out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getProductName() +"' value = 'Write Review'>");
                out.println("<input type='hidden' name='productType' value='"+productType+"'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='color' value='"+s.getLocation()+"'>");
            	out.println("<input type='hidden' name='productID' value='"+s.getProductId()+"'>");
                out.println("<input type='hidden' name='company' value='"+s.getHotelName()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                out.println("</form></td></tr>");*/

		String productType = request.getParameter("productType");
		String productName = request.getParameter("productName");
		String image = request.getParameter("image");
		double price = Double.parseDouble(request.getParameter("price"));
		String location = request.getParameter("color");
		String productID = request.getParameter("productID");
		String hotelName = request.getParameter("company");
		String quantity = request.getParameter("quantity");
		
		String productOnSale = "Yes";
		
		String manufacturerRebate = "No";
		String emailId = userId;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date today = new Date();
		String reviewDate = dateFormat.format(today);
		
			
				
			out.println("<div id=\"body\"><article class=\"expanded\"><h3 align=\"center\">Write a Review</h3>");
			out.println("<fieldset><div style=\"width:400px; margin-right:auto; margin-left:auto;\">");
			out.println("<form action=\"WriteReview\" method=\"POST\">");
			
			out.println("<input type='hidden' name='productType' value='"+productType+"'>");
			out.println("<input type='hidden' name='productName' value='"+productName+"'>");
			out.println("<input type='hidden' name='price' value='"+price+"'>");
			out.println("<input type='hidden' name='hotelName' value='"+hotelName+"'>");
			out.println("<input type='hidden' name='quantity' value='"+quantity+"'>");

			out.println("<input type='hidden' name='productOnSale' value='"+productOnSale+"'>");
			
			out.println("<input type='hidden' name='emailId' value='"+emailId+"'>");
			out.println("<input type='hidden' name='reviewDate' value='"+reviewDate+"'>");
			
			
			out.println("<p><label><b>Product Category: </b></label>"+productType+"</p>");
			out.println("<p><label><b>Product Name: </b></label>"+productName+"</p>");
			out.println("<p><label><b>Product Price: </b></label>"+price+"</p>");
			out.println("<p><label><b>Hotel Name: </b></label>"+hotelName+"</p>");
			out.println("<p><label><b>Product Name: </b></label>"+productName+"</p>");
			
			//out.println("<p><label><b>Retailer Name: </b></label><input name=\"retailer\" type=\"text\"></p>");
			out.println("<p><label><b>Hotel Zip: </b></label><input name=\"hotelZip\" type=\"text\"></p>");
			out.println("<p><label><b>Hotel City: </b></label><input name=\"hotelCity\"type=\"text\" /></p>");
			out.println("<p><label><b>Hotel State: </b></label><input name=\"hotelState\"type=\"text\" /></p>");
			
			out.println("<p><label><b>Product On Sale: </b></label>"+productOnSale+"</p>");
			
			out.println("<p><label><b>User Id: </b></label>"+emailId+"</p>");
			
			out.println("<p><label><b>User Age: </b></label><input name=\"userAge\" type=\"text\"></p>");
			out.println("<p><label><b>User Gender: </b></label><input name=\"userGender\"type=\"text\" /></p>");
			out.println("<p><label><b>User Occupation: </b></label><input name=\"userOccupation\"type=\"text\" /></p>");
			
			out.println("<p><label><b>Review Rating: </b></label><select name='reviewRating'><option name='reviewRating' value='1' selected>1</option><option name='reviewRating' value='2'>2</option>");
			out.println("<option name='reviewRating' value='3'>3</option><option name='reviewRating' value='4'>4 </option><option name='reviewRating' value='5'>5</option></select></p>");
			
			out.println("<p><label><b>Review Date: </b></label>"+reviewDate+"</p>");
			out.println("<p><label><b>Review Text: </b></label><textarea rows=\"4\" cols=\"50\" name=\"reviewText\"></textarea>");
			out.println("<p><input name=\"send\" style=\"margin-left: 150px;\"  class=\"formbutton\" value=\"Submit Review\" type=\"submit\" /></p>");
			
			out.println("</form></div></fieldset></article><div class=\"clear\"></div></div>");
		
		//printSideBar(out);
		
		out.close();
	
}

public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        HttpSession session = request.getSession();
		String fName = (String)session.getAttribute("firstName");
		String userId = (String)session.getAttribute("userid");

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

		
		String productID = request.getParameter("productID");
		String quantity = request.getParameter("quantity");
		
		String productType = request.getParameter("productType");
		String productName = request.getParameter("productName");
		double price = Double.parseDouble(request.getParameter("price"));
		String hotelName = request.getParameter("hotelName");
		String retailerZip = request.getParameter("hotelZip");
		String retailerCity = request.getParameter("hotelCity");
		String retailerState = request.getParameter("hotelState");
		String productOnSale = request.getParameter("productOnSale");
		
		String emailId = request.getParameter("emailId");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userGender = request.getParameter("userGender");
		String userOccupation = request.getParameter("userOccupation");
		int reviewRating = Integer.parseInt(request.getParameter("reviewRating"));
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date reviewDate = null;
		try{
			reviewDate = dateFormat.parse(request.getParameter("reviewDate"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		String reviewText = request.getParameter("reviewText");
		
		if(userAge != 0 && userGender != null && userGender.length() != 0 && userOccupation != null && userOccupation.length() != 0
			&& reviewText != null && reviewText.length() != 0
			&& retailerZip != null && retailerZip.length() != 0 && retailerCity != null && retailerCity.length() != 0
			&& retailerState != null && retailerState.length() != 0)
		{
				
			MongoDBDataStoreUtilities.insertReview(productName, productType, price, hotelName, retailerZip, retailerCity, retailerState,
													productOnSale, emailId, userAge, userGender,
													userOccupation, reviewRating, reviewDate, reviewText);
            out.println("<div id=\"body\">");
            out.println("<section id=\"content\">");
			out.println("<h3>Review has been submitted ! View your review in the products review section</h3>");
            out.println("</section></div>");
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
            out.println("</ul></ul></aside>");
			out.println("<div class=\"clear\"></div></div>");
	
	out.println("</div><footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
	out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
	out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
	out.println("<p>&copy; AlHamdanHotels 2017. by AlHamda</p></div></footer></div>");
	out.println("</body></html>");
	out.println("</body>");
		out.println("</html>");
												
		}
		else
		{
            out.println("<div id=\"body\">");
            out.println("<section id=\"content\">");
			out.println("<h3>Fields may be empty. Please go back and fill all the fields of the review form</h3>");
            out.println("</section></div>");
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
            out.println("</ul></ul></aside>");
            out.println("<div class=\"clear\"></div></div>");
	
	out.println("</div><footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
	out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
	out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
	out.println("<p>&copy; AlHamdanHotels 2017. by AlHamdan</p></div></footer></div>");
	out.println("</body></html>");
	out.println("</body>");
		out.println("</html>");
		}			
		
	
	
}

}

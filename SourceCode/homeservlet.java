import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class homeservlet extends HttpServlet
{
	public HashMap<String, Products> selectedProducts;
	public ArrayList<String> tweets;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		String fName = null;
		String productType = null;
		selectedProducts = DealMatches.getSelectedProductsFromTweets();	
		tweets = DealMatches.getTweets();
		
		if(session != null)
		{
			productType = request.getParameter("productType");
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
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
out.println("<title>Al Hamdan</title>");
out.println("<link rel=\"stylesheet\" href=\"styles1.css\" type=\"text/css\" />");
out.println("<script type=\"text/javascript\" src=\"JS/javascript.js\"></script>");
out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
out.println("</head>");

out.println("<body onload=\"init()\">");
out.println("<div id=\"container\">");
    out.println("<header>");
    out.println("<div align=\"right\" >");
    out.println("<a href=\"Login.html\">Login</a>");
    
    out.println("<a href=\"SignUP.html\">Signup</a><br>");
    out.println("</div>");
    	out.println("<img src=\"images/AlHamdan.jpg\" alt=\"\" style=\"width:70px;height:70px;\">");
        out.println("<h4>AL-HAMDAN</h4>");
        out.println("<form  name='autofillform1' action=''>");
            out.println("<div name='autofillform'>");
                out.println("<strong>Search Products: </strong>");
        
                out.println("<input type='text' name='searchId' size='40' id='searchId' onkeyup='doCompletion()' placeholder='Search Here...'>");
                out.println("<div id='auto-row'>");
                    out.println("<table border='0' id='complete-table' class='popupBox'></table>");
                out.println("</div>");
            out.println("</div>");
        out.println("</form>");

    out.println("</header>");
    out.println("<nav>");
    	out.println("<ul>");
            out.println("<li class=\"start selected\"><a href=\"homeservlet\">Home</a></li>");
            out.println("<li class=\"\"><a href=\"contentservlet?productType=Rooms\">Rooms</a></li>");
            out.println("<li><a href=\"contentservlet?productType=Suites\">Suites</a></li>");
            out.println("<li><a href=\"contentservlet?productType=LR\">Leisure Facilities</a></li>");
            out.println("<li><a href=\"contentservlet?productType=Dinning\">Dinning</a></li>");
        out.println("</ul>");
    out.println("</nav>");
	
    out.println("<div id=\"body\">");
	 out.println("<section id=\"content\">");
	    out.println("<article >");
        
        out.println("<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">");
            out.println("<ol class=\"carousel-indicators\">");
                out.println("<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>");
                out.println("<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>");
                out.println("<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li></ol>");
            out.println("<div class=\"carousel-inner\">");
            out.println("<div class=\"item active\">");
                out.println("<img src=\"coimage/AlHamdan1.jpg\" alt=\"Image not found AlHamdan1\" class = \"img-responsive\">");
            out.println("</div>");
            out.println("<div class=\"item\">");
            out.println("<img src=\"coimage/AlHamdan2.jpg\" alt=\"Image not found AlHamdan2.jpg\" class = \"img-responsive\">");
            out.println("</div>");
            out.println("<div class=\"item\">");
            out.println("<img src=\"coimage/AlHamdan3.jpg\" alt=\"Image not found AlHamdan3.jpg\" class = \"img-responsive\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">");
            out.println("<span class=\"glyphicon glyphicon-chevron-left\"></span>");
            out.println("<span class=\"sr-only\">Previous</span>");
            out.println("</a>");
            out.println("<a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\">");
            out.println("<span class=\"glyphicon glyphicon-chevron-right\"></span>");
            out.println("<span class=\"sr-only\">Next</span>");
            out.println("</a>");
        out.println("</div>");
                                        
        out.println("<h3>Overview</h3>");
          out.println("<p>At the Al Hamdan hotel, we bring you an experience of your life time! We have luxury the rooms, fancy dip in our pools, pampering in our Spa. We give you the break you deserve! We are devoted to make everyone feel like a cherished guest</p>"); 
           out.println("<p> Our warm inviting decor and thoughtful staff will soon have you calling this hotel your \"home\" away from home! Our hotel offers unparalleled service and easy access to everything the city has to offer. Other amenities including free wireless Internet access! </p>");
            out.println("<p>You are welcome to view our image gallery and hotel services pages. We welcome you with open hearts.</p>");
            out.println("<h2>Trending in Twitter !</h2>");
		out.println("<h2>Amazing Hotel !</h2>");
		
		if(tweets.isEmpty())
		{
			out.println("<p style='color:#325b9e'>"+"No Offers Found !"+"</p>");
		}
		else
		{
			for(String tweet: tweets)
			{
				out.println("<p style='color:#325b9e'>"+tweet+"</p>");
			}
		}
		
		out.println("<article><h2>Hotel Matches</h2></article>");
		
		String fname = null;
		
		if(selectedProducts.isEmpty())
		{
			out.println("<article>");
			out.println("<p style='color:#325b9e'>"+"No Deals Found !"+"</p>");
			out.println("</article>");
		}
		else
		{
			for(Map.Entry<String,Products> m :selectedProducts.entrySet()){
			Products s = m.getValue();
			
			out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
            out.println("<tr><td width=\"30%\">");
            out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"roomimages/");
            out.println(s.getImage());
            out.println("\" /></a>");
            out.println("</td>");
            out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
            out.println(s.getProductName());
            out.println("</b></td></tr><tr><td width=\"40\"><b>Name:</b>");
            out.println(s.getHotelName());
            out.println("</td></tr><tr><td><b>Location:</b>");
            out.println(s.getLocation());
            out.println("</td></tr></table></td>");
            out.println("<td width=\"30%\"><table><tr><td><b>Price:");
            out.println(s.getPrice());
			

            if(fName != null && !fName.isEmpty())
            {
                out.println("<tr><td><form method = 'get' action = 'WriteReview'>");
                out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getProductName() +"' value = 'Write Review'>");
                out.println("<input type='hidden' name='productType' value='"+productType+"'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='color' value='"+s.getLocation()+"'>");
            	out.println("<input type='hidden' name='productID' value='"+s.getProductId()+"'>");
                out.println("<input type='hidden' name='company' value='"+s.getHotelName()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                out.println("</form></td></tr>");
                
                out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
                out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getProductName() +"' value = 'View Review'>");
                out.println("<input type='hidden' name='productType' value='"+productType+"'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='color' value='"+s.getLocation()+"'>");
            	out.println("<input type='hidden' name='productID' value='"+s.getProductId()+"'>");
                out.println("<input type='hidden' name='company' value='"+s.getHotelName()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                out.println("</form></td></tr>");

                out.println("<tr><td><form method = 'get' action = 'CheckAvailability'>");
                out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getProductName() +"' value = 'Check Availability'>");
                out.println("<input type='hidden' name='productType' value='"+productType+"'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='location' value='"+s.getLocation()+"'>");
            
                out.println("<input type='hidden' name='hotelname' value='"+s.getHotelName()+"'>");
                out.println("<input type='hidden' name='productID' value='"+s.getProductId()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                out.println("<tr><td><label for=\"from\">From</label><input type=\"text\" id=\"from\" placeholder=\"MM/dd/yyyy\" name=\"from\"><label for=\"to\">to</label><input type=\"text\" id=\"to\" placeholder=\"MM/dd/yyyy\" name=\"to\"></td></tr>");
                out.println("</form></td></tr>");



                out.println("<tr><td><form method = 'get' action = 'addtocartservlet'>");
                out.println("<input class = 'button' type = 'submit' name = '"+ s.getProductName() +"' value = 'Add to Cart'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                session.setAttribute("pro",s.getAIDs());//session.setAttribute(s.getId(),s.getAIDs());
                out.println("<input type='hidden' name='id' value='"+s.getProductId()+"'>");
                out.println("</form></td></tr>");
                out.println("</table></td></tr></table>");
            }
            else{
                out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
                out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getProductName() +"' value = 'View Review'>");
                out.println("<input type='hidden' name='productType' value='"+productType+"'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='color' value='"+s.getLocation()+"'>");
            	out.println("<input type='hidden' name='productID' value='"+s.getProductId()+"'>");
                out.println("<input type='hidden' name='company' value='"+s.getHotelName()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                out.println("</form></td></tr>");

                out.println("<tr><td><form method = 'get' action = 'CheckAvailability'>");
                out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getProductName() +"' value = 'Check Availability'>");
                out.println("<input type='hidden' name='productType' value='"+productType+"'>");
                out.println("<input type='hidden' name='productName' value='"+s.getProductName()+"'>");
                out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
                out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
                out.println("<input type='hidden' name='location' value='"+s.getLocation()+"'>");
            
                out.println("<input type='hidden' name='hotelname' value='"+s.getHotelName()+"'>");
                out.println("<input type='hidden' name='productID' value='"+s.getProductId()+"'>");
                out.println("<input type='hidden' name='quantity' value='"+1+"'>");
                out.println("<tr><td><label for=\"from\">From</label><input type=\"text\" id=\"from\" placeholder=\"MM/dd/yyyy\" name=\"from\"><label for=\"to\">to</label><input type=\"text\" id=\"to\" placeholder=\"MM/dd/yyyy\" name=\"to\"></td></tr>");
                out.println("</form></td></tr>");

                out.println("</table></td></tr></table>");
			}
		}
	}
        out.println("</article>");

        out.println("</section>");
     

	out.println("<aside class=\"sidebar\">");
                              
            out.println("<ul><li><h4>Gallery</h4>");
            out.println("<ul><li><form method = 'get' action = 'filterservlet'>");
            out.println("<div class=\"block form-group\">");
            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX1\" name=\"HotelName\" value =\"HotelOne\">");
                            
            out.println("<label for=\"CHECKBOX1\"><b>Trump Hotel<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX1\" name=\"HotelName\" value =\"HotelTwo\">");
                            
                            out.println("<label for=\"CHECKBOX2\"><b>Washington Jefferson Hotel<b></label>");
                            out.println("</div>");
                            
                            out.println("</br>");
                            
                            out.println("<div><input type=\"checkbox\" id=\"CHECKBOX3\" name=\"HotelName\" value =\"HotelThree\">");
                            
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
              
            out.println("</ul>");
            out.println("</ul>");
        
    out.println("</aside>");
	
	out.println("<div class=\"clear\"></div>");
	out.println("</div>");

	out.println("<footer>");
        out.println("<div class=\"footer-content\">");
            out.println("<ul>");
            	out.println("<li><h4>About Us</h4></li>");
            out.println("</ul>");
            
            out.println("<ul>");
            	out.println("<li><h4>Contact Us</h4></li>");
            out.println("</ul>");
            
            out.println("<ul class=\"endfooter\">");
            	out.println("<li><h4>Customer Service</h4></li>");
            out.println("</ul>");
            
            out.println("<div class=\"clear\"></div>");
        out.println("</div>");
        out.println("<div class=\"footer-bottom\">");
            out.println("<p>AlHamdanHotels , by AlHamdan</p>");
         out.println("</div>");
    out.println("</footer>");
	
out.println("</div>");
	
out.println("</body>");
out.println("</html>");
	

	}
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class contentservlet extends HttpServlet
{
	/*ArrayList<Object> products;
	HashMap<String, Products> smartwatches;
	HashMap<String, Products> speakers;
	HashMap<String, Products> headphones;
	HashMap<String, Products> phones;
	HashMap<String, Products> laptops;
	HashMap<String, Products> externalstorages;
	HashMap<String, Accessories> accessories;
	
	MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();*/
	
	/*void loadXML()
	{
		try{
		products = mysql.getProducts();
		
		smartwatches = (HashMap<String,Products>)products.get(0);
		speakers = (HashMap<String, Products>)products.get(1);
		headphones = (HashMap<String, Products>)products.get(2);
		phones = (HashMap<String, Products>)products.get(3);
		laptops = (HashMap<String, Products>)products.get(4);
		externalstorages = (HashMap<String, Products>)products.get(5);
		accessories = (HashMap<String, Accessories>)products.get(6);
		
		}catch(Exception E){
		System.out.println("Exception");
		}
	}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//loadXML();
		
		HttpSession session = request.getSession();
		String fName = null;
		if(session!=null)
			fName=(String)session.getAttribute("firstName");
		
		String productType = request.getParameter("productType");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//session.setAttribute("Accessories", accessories);
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
		
		//out.println("</ul></nav><img class=\"header-image\" src=\"images/homepage.jpg\" alt=\"Advertisment Image Here\" />");
		
		out.println("<div id=\"body\">");
		
		
		if(productType.equals("Rooms"))
		{
			out.println("<section id=\"content\">");
			/*out.println("<article><h3>Rooms</h3></article>");
			out.println("<article class=\"expanded\">");*/
			
			/*for(Map.Entry<String,Products> m :smartwatches.entrySet()){
			Products s = m.getValue();//21-9 ,21-15.
			
			out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr><td width=\"30%\">");
			out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
			out.println(s.getImage());
			out.println("\" /></a>");
			out.println("</td>");
			out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
			out.println(s.getName());
			out.println("</b></td></tr><tr><td width=\"40\"><b>Color:</b>");
			out.println(s.getColor());
			out.println("</td></tr><tr><td><b>Condition:</b>");
			out.println(s.getCondition());
			out.println("</td></tr></table></td>");
			out.println("<td width=\"30%\"><table><tr><td><b>Price:");
			out.println(s.getPrice());
			////
			
			
			if(fName != null && !fName.isEmpty())
			{
				out.println("<tr><td><form method = 'get' action = 'WriteReview'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'Write Review'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");

				out.println("<tr><td><form method = 'get' action = 'addtocartservlet'>");
				out.println("<input class = 'button' type = 'submit' name = '"+ s.getName() +"' value = 'Add to Cart'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				session.setAttribute("pro",s.getAIDs());//session.setAttribute(s.getId(),s.getAIDs());
				out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			else{
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			
			}*/

			out.println("</section>");
		//out.println("<div class=\"clear\"></div></div></div>");
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
                        out.println("<li><a href=\"Facilities.jsp\">Hotel 1</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Hotel 2</a><br></li>");
                        out.println("<li><a href=\"Local.jsp\">Hotel 3</a><br></li>");
            out.println("</ul>");
              
            out.println("</ul>");
            
            out.println("<ul><li><h4>Trending</h4>");
            out.println("<ul>");
            out.println("<li><a href=\"Facilities.jsp\">Most Reviewed</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Most Liked</a><br></li>");
            out.println("</ul>");
            out.println("</ul></ul></aside>");
		}
		
		if(productType.equals("Suites"))
		{
			out.println("<section id=\"content\">");
			/*for(Map.Entry<String,Products> m :speakers.entrySet()){
			Products s = m.getValue();
			
			out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr><td width=\"30%\">");
			out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
			out.println(s.getImage());
			out.println("\" /></a>");
			out.println("</td>");
			out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
			out.println(s.getName());
			out.println("</b></td></tr><tr><td width=\"40\"><b>Color:</b>");
			out.println(s.getColor());
			out.println("</td></tr><tr><td><b>Condition:</b>");
			out.println(s.getCondition());
			out.println("</td></tr></table></td>");
			out.println("<td width=\"30%\"><table><tr><td><b>Price:");
			out.println(s.getPrice());
			//
			
			
			
			if(fName != null && !fName.isEmpty())
			{

				out.println("<tr><td><form method = 'get' action = 'WriteReview'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'Write Review'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");

				out.println("<tr><td><form method = 'get' action = 'addtocartservlet'>");
				out.println("<input class = 'button' type = 'submit' name = '"+ s.getName() +"' value = 'Add to Cart'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				session.setAttribute("pro",s.getAIDs());//session.setAttribute(s.getId(),s.getAIDs());
				out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			else{
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			
			}*/

			out.println("</article></section>");
		//out.println("<div class=\"clear\"></div></div></div>");
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
                        out.println("<li><a href=\"Facilities.jsp\">Hotel 1</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Hotel 2</a><br></li>");
                        out.println("<li><a href=\"Local.jsp\">Hotel 3</a><br></li>");
            out.println("</ul>");
              
            out.println("</ul>");
            
            out.println("<ul><li><h4>Trending</h4>");
            out.println("<ul>");
            out.println("<li><a href=\"Facilities.jsp\">Most Reviewed</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Most Liked</a><br></li>");
            out.println("</ul>");
            out.println("</ul></ul></aside>");
		}
		
		if(productType.equals("Dinning"))
		{
			out.println("<section id=\"content\">");
			
			/*for(Map.Entry<String,Products> m :headphones.entrySet()){
			Products s = m.getValue();
			
			out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr><td width=\"30%\">");
			out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
			out.println(s.getImage());
			out.println("\" /></a>");
			out.println("</td>");
			out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
			out.println(s.getName());
			out.println("</b></td></tr><tr><td width=\"40\"><b>Color:</b>");
			out.println(s.getColor());
			out.println("</td></tr><tr><td><b>Condition:</b>");
			out.println(s.getCondition());
			out.println("</td></tr></table></td>");
			out.println("<td width=\"30%\"><table><tr><td><b>Price:");
			out.println(s.getPrice());
			//
			
			
			
			if(fName != null && !fName.isEmpty())
			{

				out.println("<tr><td><form method = 'get' action = 'WriteReview'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'Write Review'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");

				out.println("<tr><td><form method = 'get' action = 'addtocartservlet'>");
				out.println("<input class = 'button' type = 'submit' name = '"+ s.getName() +"' value = 'Add to Cart'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				session.setAttribute("pro",s.getAIDs());//session.setAttribute(s.getId(),s.getAIDs());
				out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			else{
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			
			}*/

			out.println("</article></section>");
		//out.println("<div class=\"clear\"></div></div></div>");
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
                        out.println("<li><a href=\"Facilities.jsp\">Hotel 1</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Hotel 2</a><br></li>");
                        out.println("<li><a href=\"Local.jsp\">Hotel 3</a><br></li>");
            out.println("</ul>");
              
            out.println("</ul>");
            
            out.println("<ul><li><h4>Trending</h4>");
            out.println("<ul>");
            out.println("<li><a href=\"Facilities.jsp\">Most Reviewed</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Most Liked</a><br></li>");
            out.println("</ul>");
            out.println("</ul></ul></aside>");
		}
		
		if(productType.equals("LR"))
		{
			out.println("<section id=\"content\">");
			
			/*for(Map.Entry<String,Products> m :phones.entrySet()){
			Products s = m.getValue();
			
			out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr><td width=\"30%\">");
			out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
			out.println(s.getImage());
			out.println("\" /></a>");
			out.println("</td>");
			out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
			out.println(s.getName());
			out.println("</b></td></tr><tr><td width=\"40\"><b>Color:</b>");
			out.println(s.getColor());
			out.println("</td></tr><tr><td><b>Condition:</b>");
			out.println(s.getCondition());
			out.println("</td></tr></table></td>");
			out.println("<td width=\"30%\"><table><tr><td><b>Price:");
			out.println(s.getPrice());
			//
			
			
			
			if(fName != null && !fName.isEmpty())
			{

				out.println("<tr><td><form method = 'get' action = 'WriteReview'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'Write Review'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");

				out.println("<tr><td><form method = 'get' action = 'addtocartservlet'>");
				out.println("<input class = 'button' type = 'submit' name = '"+ s.getName() +"' value = 'Add to Cart'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				session.setAttribute("pro",s.getAIDs());//session.setAttribute(s.getId(),s.getAIDs());
				out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			else{
				out.println("<tr><td><form method = 'get' action = 'ViewReviews'>");
				out.println("<input class = 'formbutton' type = 'submit' name = '"+ s.getName() +"' value = 'View Reviews'>");
				out.println("<input type='hidden' name='productType' value='"+productType+"'>");
				out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
				out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
				out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
				out.println("<input type='hidden' name='color' value='"+s.getColor()+"'>");
				out.println("<input type='hidden' name='condition' value='"+s.getCondition()+"'>");
				out.println("<input type='hidden' name='company' value='"+s.getCompany()+"'>");
				out.println("<input type='hidden' name='retailer' value='"+s.getRetailer()+"'>");
				out.println("<input type='hidden' name='quantity' value='"+1+"'>");
				out.println("</form></td></tr>");
				out.println("</table></td></tr></table>");
			}
			
			}*/
			out.println("</article></section>");
		//out.println("<div class=\"clear\"></div></div></div>");
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
                        out.println("<li><a href=\"Facilities.jsp\">Hotel 1</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Hotel 2</a><br></li>");
                        out.println("<li><a href=\"Local.jsp\">Hotel 3</a><br></li>");
            out.println("</ul>");
              
            out.println("</ul>");
            
            out.println("<ul><li><h4>Trending</h4>");
            out.println("<ul>");
            out.println("<li><a href=\"Facilities.jsp\">Most Reviewed</a><br></li>");
                        out.println("<li><a href=\"Services.jsp\">Most Liked</a><br></li>");
            out.println("</ul>");
            out.println("</ul></ul></aside>");
		}

		
		
            out.println("<div class=\"clear\"></div></div>");
	
	out.println("</div><footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
	out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
	out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
	out.println("<p>&copy; Smart Portables 2017. by Syed Hamdan Sher</p></div></footer></div>");
	out.println("</body></html>");

		out.close();
	}
	
}
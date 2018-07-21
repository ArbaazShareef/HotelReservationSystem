import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class cartservlet extends HttpServlet {
	ArrayList<Object> products;
    HashMap<String, Products> rooms;
    HashMap<String, Products> lr;
    HashMap<String, Products> su;
    HashMap<String, Products> di;
    MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
	

	
	void loadXML()
	{
		try{
		products = mysql.getProducts();
		
		rooms = (HashMap<String,Products>)products.get(0);
        lr = (HashMap<String,Products>)products.get(1);
        su = (HashMap<String,Products>)products.get(2);
        di = (HashMap<String,Products>)products.get(3);
		
		}catch(Exception E){
		System.out.println("Exception");
		}
	}
	
	
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
  		loadXML();
      	
      	int C;
        Cart cart;

        
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
        String productType = request.getParameter("productType");
        
		String firstName = (String)session.getAttribute("firstName");
		if(cart == null){
          cart = new Cart();
          session.setAttribute("cart", cart);
          C=0;
          session.setAttribute("C",C);

        }else{C = (int)session.getAttribute("C");
    	cart = (Cart) session.getAttribute("cart");}
        
		out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		out.println("<title>Al Hamdan</title><link rel=\"stylesheet\" href=\"styles1.css\" type=\"text/css\" />");
		out.println("<script type=\"text/javascript\" src=\"JS/javascript.js\"></script><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script><script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script></head>");
		
		if(firstName != null && !firstName.isEmpty())
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
		
		if(firstName != null && !firstName.isEmpty())
		{
			out.println("<h5>Welcome ");
			out.println(firstName);
			out.println("</h5>");
			out.println("<nav><ul><li class=\"\"><a href=\"loginedhomeservlet\">Home</a></li>");
		}else{
			out.println("<nav><ul><li class=\"start selected\"><a href=\"homeservlet\">Home</a></li>");
		}
		out.println("<li class=\"\"><a href=\"contentservlet?productType=Rooms\">Rooms</a></li>");
		out.println("<li><a href=\"contentservlet?productType=Suites\">Suites</a></li>");
		out.println("<li><a href=\"contentservlet?productType=LR\">Leisure Facilities</a></li>");
		out.println("<li><a href=\"contentservlet?productType=Dinning\">Dinning</a></li>");
		
		if(firstName != null && !firstName.isEmpty())
		{
			out.println("<li class=\"start selected\"><a href=\"cartservlet\">Cart("+C+")</a></li>");
			out.println("<li><a href=\"vieworderservlet\">Your Orders</a></li></ul></nav>");
		}else{
			out.println("</ul></nav>");
		}

		out.println("<div id=\"body\">");
		out.println("<section id=\"content\">");
		out.println("<article class=\"expanded\">");
		
		String typeOfProduct = request.getParameter("productType");
		String productCompany = request.getParameter("company");
		String AIDs=(String)request.getParameter("id");
        List AIDL=(List)session.getAttribute("pro");
		
		if(firstName != null && !firstName.isEmpty())
		{
			if(cart==null)
			{
				out.println("<h2>Cart is Empty</h2>");
			}
			else
			{
				 HashMap<String, List<Object>> items = cart.getCartItems();
			
					if(items.isEmpty())
					{
					out.println("<h1>Cart is Empty </h1>");
					out.println("<tr>");
					out.println("<td>");
					out.println("</td>");
					out.println("</tr>");
						
					}
					else
					{
						out.println("<h1>List of current items in Cart</h1>");
					out.println("<hr>");
					if (AIDL != null){
					//C---------------------------------------------------------------
						out.println("<article><h3>Leisure Facilities</h3></article>");
						out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
						
						out.println("<div id=\"myCarousel\" class=\"carousel slide\">");
  						out.println("<ol class=\"carousel-indicators\">");
						int count=0;
						for(Map.Entry<String,Products> m :lr.entrySet()){
						Products s = m.getValue();

						for(int i=0;i<AIDL.size();i++){
							if(s.getProductId().equals(AIDL.get(i))){
								count=count+1;
								if(count==1){
    							out.println("<li data-target=\"#myCarousel\" data-slide-to="+count+" class=\"active\"></li>");}
								else{
    							out.println("<li data-target=\"#myCarousel\" data-slide-to="+count+"></li>");}}}}
  						out.println("</ol>");

  						
  						out.println("<div class=\"carousel-inner\">");
  						count=0;
  						for(Map.Entry<String,Products> m :lr.entrySet()){
						Products s = m.getValue();
						for(int i=0;i<AIDL.size();i++){
							if(s.getProductId().equals(AIDL.get(i))){
								count=count+1;
									if(count==1){
    									out.println("<div class=\"item active\">");
    									out.println("<article class=\"expanded\">");
										out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
										out.println("<tr><td width=\"30%\">");
										out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
										out.println(s.getImage());
										out.println("\" /></a>");
										out.println("</td>");
										out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
										out.println(s.getProductName());
										out.println("</b></td></tr><tr><td width=\"40\"><b>Hotel:</b>");
										out.println(s.getHotelName());
										out.println("</td></tr><tr><td><b>Location:</b>");
										out.println(s.getLocation());
										out.println("</td></tr></table></td>");
										out.println("<td width=\"30%\"><table><tr><td><b>Price:");
										out.println(s.getPrice());
										//
			
										if(firstName != null && !firstName.isEmpty())
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
											out.println("</article>");
										}
										else{
										out.println("<tr><td><a href=\"cartservlet\" class=\"button\">Add to Cart</a></td></tr></table></td></tr></table>");
										}
      									//out.println("<img src=\"images/"+s.getImage()+"\" alt=\"Image not found\" class = \"img-responsive\">");
      									/*out.println("<div class=\"carousel-caption\">");
      									//out.println();
      									out.println("<article class=\"expanded\">");
										out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
										out.println("<tr><td width=\"30%\">");
										out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
										out.println(s.getImage());
										out.println("\" /></a>");
										out.println("</td>");
										out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
										out.println(s.getProductName());
										out.println("</b></td></tr><tr><td width=\"40\"><b>Hotel:</b>");
										out.println(s.getHotelName());
										out.println("</td></tr><tr><td><b>Location:</b>");
										out.println(s.getLocation());
										out.println("</td></tr></table></td>");
										out.println("<td width=\"30%\"><table><tr><td><b>Price:");
										out.println(s.getPrice());
										//
			
										if(firstName != null && !firstName.isEmpty())
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
											out.println("</article>");
										}
										else{
										out.println("<tr><td><a href=\"cartservlet\" class=\"button\">Add to Cart</a></td></tr></table></td></tr></table>");
										}
    									out.println("</div>");*/
    									out.println("</div>");}
    								else{
    									out.println("<div class=\"item\">");
    									out.println("<article class=\"expanded\">");
										out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
										out.println("<tr><td width=\"30%\">");
										out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
										out.println(s.getImage());
										out.println("\" /></a>");
										out.println("</td>");
										out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
										out.println(s.getProductName());
										out.println("</b></td></tr><tr><td width=\"40\"><b>Hotel:</b>");
										out.println(s.getHotelName());
										out.println("</td></tr><tr><td><b>Location:</b>");
										out.println(s.getLocation());
										out.println("</td></tr></table></td>");
										out.println("<td width=\"30%\"><table><tr><td><b>Price:");
										out.println(s.getPrice());
										//
			
										if(firstName != null && !firstName.isEmpty())
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
											out.println("</article>");
										}
										else{
										out.println("<tr><td><a href=\"cartservlet\" class=\"button\">Add to Cart</a></td></tr></table></td></tr></table>");
										}
      									//out.println("<img src=\"images/"+s.getImage()+"\" alt=\"Image not found\" class = \"img-responsive\">");
      									/*out.println("<div class=\"carousel-caption\">");
      									out.println("<article class=\"expanded\">");
										out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
										out.println("<tr><td width=\"30%\">");
										out.println("<a href=#><img style=\"width:200px;height:200px;\" style=\"display:block;\"  src=\"images/");
										out.println(s.getImage());
										out.println("\" /></a>");
										out.println("</td>");
										out.println("<td width=\"40%\"><table><tr><td width=\"40\"><b>");
										out.println(s.getProductName());
										out.println("</b></td></tr><tr><td width=\"40\"><b>Hotel:</b>");
										out.println(s.getHotelName());
										out.println("</td></tr><tr><td><b>Location:</b>");
										out.println(s.getLocation());
										out.println("</td></tr></table></td>");
										out.println("<td width=\"30%\"><table><tr><td><b>Price:");
										out.println(s.getPrice());
										//
			
										if(firstName != null && !firstName.isEmpty())
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
											out.println("</article>");
										}
										else{
										out.println("<tr><td><a href=\"cartservlet\" class=\"button\">Add to Cart</a></td></tr></table></td></tr></table>");
										}
    									out.println("</div>");*/
    									out.println("</div>");
    								}}}}

    					out.println("</div>");
    					out.println("<a class=\"carousel-control left\" href=\"#myCarousel\" data-slide=\"prev\">");
    					out.println("<span class=\"icon-prev\"></span></a>");
    					out.println("<a class=\"carousel-control right\" href=\"#myCarousel\" data-slide=\"next\">");
    					out.println("<span class=\"icon-next\"></span></a>");
    					out.println("</div>");



								/*out.println("<article class=\"expanded\">");
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
									out.println("<tr><td><form method = 'get' action = 'addtocartservlet'>");
									out.println("<input class = 'button' type = 'submit' name = '"+ s.getName() +"' value = 'Add to Cart'>");
									out.println("<input type='hidden' name='productName' value='"+s.getName()+"'>");
									out.println("<input type='hidden' name='image' value='"+s.getImage()+"'>");
									out.println("<input type='hidden' name='price' value='"+s.getPrice()+"'>");
									out.println("<input type='hidden' name='quantity' value='"+1+"'>");
									out.println("</form></td></tr>");
									out.println("</table></td></tr></table>");
								}
								else{
										out.println("<tr><td><a href=\"cartservlet\" class=\"button\">Add to Cart</a></td></tr></table></td></tr></table>");
								}*/
						out.println("</article>");
					//C-------------------------------------------------------------
					}

					out.println("<table border='2' bordercolor=\"#ff0000\">");
					out.println("<tr><th>Product image</th><th>Product Detail</th><th>Cost&nbsp&nbsp&nbsp&nbsp</th><th>Quantity</th><th>Remove</th>");
					
					String key = "";
					for (Map.Entry<String, List<Object>> entry : items.entrySet()) {
						key = entry.getKey();
						List<Object> values = entry.getValue();
						out.println("<form action='RemoveProductServlet'><input type='hidden' name='name' value='" + key + "'>");

						out.println("<tr><th><img src ='images/" + values.get(4) + "' width = '100' height = '100'></th><th>" + values.get(1) + "  </th><th>" + "$" + values.get(2) + "</th>");
						out.println("<td><select name='" + key + "'><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
						out.println("<td><input  class = 'formbutton' type='submit' name='value' value='Remove'></td></tr></form>");

					}
					out.println("<form action='checkoutservlet'>");
					out.println("<tr><td align='center' colspan='5'><input class = 'formbutton' type='submit' name='value' value='Checkout'></td></form>");
					out.println("</tr></table>");
				}
			}
		} else {
			out.println("<p>Please login to add items in your cart !");
		}

		out.println("<br><br><br><br><br><br>");
		
		out.println("</article>");

			out.println("</section>");
		
		
		out.println("<aside class=\"sidebar\">");
                              
            
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
		
		out.println("</section>");
		
		out.println("<div class=\"clear\"></div></div>");
	
	out.println("</div><footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
	out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
	out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
	out.println("<p>&copy; AlHamdanHotels 2017. by AlHamdan</p></div></footer></div>");
	out.println("</body></html>");

		out.close();
		
	}

}

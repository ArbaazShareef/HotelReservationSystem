import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class adminContentItemRemoved extends HttpServlet{
    ArrayList<String> myHotels;
    ArrayList<String> myCustomers;
    ArrayList<String> myOrders;
    adminMySql mysql = new adminMySql();

// loadXMl()
    void loadXML(){
        try{
            myHotels = mysql.getHotels();
            myCustomers = mysql.getCustomers();
            myOrders = mysql.getOrders();
        }catch(Exception E){
            System.out.println("Exception");
        }
    }

// doGet()
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
// Session
        HttpSession session = request.getSession();
        String fName = null;
        if(session!=null){
            fName=(String)session.getAttribute("firstName");
        }
        String productType = request.getParameter("productType");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int C;
        Cart cart;
        cart = (Cart) session.getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart", cart);
            C=0;
            session.setAttribute("C",C);
        }else{
            C = (int)session.getAttribute("C");
        }

// Updating values
        String myAction = request.getParameter("action");
        String myItem = request.getParameter("Item");
        if(myItem.equals("Hotel")){
            if(myAction.equals("Delete")){
                String myHotel = request.getParameter("HotelName");
                mysql.deleteHotel(myHotel);
            }
            if(myAction.equals("Add")){
                String hotelName = request.getParameter("HotelName");
                String location = request.getParameter("Location");
                String productId = request.getParameter("ProductId");
                String productName = request.getParameter("ProductName");
                String category = request.getParameter("Category");
                String type = request.getParameter("Type");
                String price = request.getParameter("Price");
                String image = request.getParameter("Image");
                String sQuantity = request.getParameter("SQuantity");
                String rQuantity = request.getParameter("RQuantity");
                String sales = request.getParameter("Sales");
                String description = request.getParameter("Description");
                String accessories = request.getParameter("Accessories");
                mysql.addHotel(productId, productName, category, type, hotelName, price, location, image, sQuantity, rQuantity, sales, description, accessories);
            }
        }
        if(myItem.equals("Customer")){
            if(myAction.equals("Delete")){
                String myCustomerFirst = request.getParameter("CustomerFirstName");
                mysql.deleteCustomer(myCustomerFirst);
            }
            if(myAction.equals("Add")){
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailId = request.getParameter("emailId");
                String phoneNumber = request.getParameter("phoneNumber");
                String password = request.getParameter("password");
                mysql.addCustomer(firstName, lastName, emailId, phoneNumber, password);
            }
        }
        if(myItem.equals("Order")){
            if(myAction.equals("Delete")){
                String myOrder = request.getParameter("OrderId");
                mysql.deleteOrder(myOrder);
            }
            if(myAction.equals("Add")){
                String orderId = request.getParameter("OrderId");
                String checkInDate = request.getParameter("CheckInDate");
                String checkOutDate = request.getParameter("CheckOutDate");
                String productName = request.getParameter("ProductName");
                String price = request.getParameter("Price");
                String quantity = request.getParameter("quantity");
                String dateofOrder = request.getParameter("dateofOrder");
                String UserId = request.getParameter("ProductName");
                String address = request.getParameter("Address");
                mysql.addOrder(orderId, checkInDate, checkOutDate, productName, price, UserId);
            }
        }

// loadXML()
        loadXML();

// HTML
        out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        out.println("<title>Al Hamdan</title><link rel=\"stylesheet\" href=\"styles1.css\" type=\"text/css\" />");
        out.println("<script type=\"text/javascript\" src=\"JS/javascript.js\"></script></head>");
        if(fName != null && !fName.isEmpty()){
            out.println("<body onload='init()'><div id=\"container\"><header><div align=\"right\" ><a href=\"logoutservlet\">Logout</a><br></div><img src=\"images/AlHamdan.jpg\" alt=\"\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4>");

        }else{
            out.println("<body onload='init()'><div id=\"container\"><header><div align=\"right\" ><a href=\"logoutservlet\" >Logout</a><br></div><img src=\"images/AlHamdan.jpg\" alt=\"\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4>");
        }
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
        if(fName != null && !fName.isEmpty()){
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

// Content table Hotels
        if(productType.equals("Hotels")){
            out.println("<section id=\"content\">");
            out.println("<article>");
            out.println("<table style='width:100%'>");
            out.println("<tr>");
            out.println("<td><h3><a href=\"adminContent?productType=Hotels\">Hotels</a></h3></td>");
            out.println("<td><h3><a href=\"adminContent?productType=Customers\">Customers</a></h3></td>");
            out.println("<td><h3><a href=\"adminContent?productType=Orders\">Orders</a></h3></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</article>");
            out.println("<article><h3>Hotels</h3></article>");
            out.println("<article class=\"expanded\">");
            for(int x=0; x<myHotels.size(); x++){
                out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
                out.println("<tr><td width=\"40\"><b>Name: </b>"+myHotels.get(x)+"</td></tr>");
                out.println("</table>");
                out.println("<td width=\"30%\"><table>");
                out.println("<tr><td><form action='adminContentItemRemoved'>");
                out.println("<input class='formbutton' type='submit' name='' value='Delete Hotel'>");
                out.println("<input type='hidden' name='productType' value='Hotels'>");
                out.println("<input type='hidden' name='action' value='Delete'>");
                out.println("<input type='hidden' name='Item' value='Hotel'>");
                out.println("<input type='hidden' name='HotelName' value='"+myHotels.get(x)+"'>");
                out.println("</form></td></tr>");
                out.println("</table>");
            }
            out.println("<table>");
            out.println("<tr><td><form method = 'get' action = 'AddHotel.html'>");
            out.println("<input class = 'formbutton' style=float:right type = 'submit' value = 'Add Hotel'>");
            out.println("</form></td></tr>");
            out.println("</table>");
            out.println("</article>");
        }

// Content table Customers
        else if(productType.equals("Customers")){
            out.println("<section id=\"content\">");
            out.println("<article>");
            out.println("<table style='width:100%'>");
            out.println("<tr>");
            out.println("<td><h3><a href=\"adminContent?productType=Hotels\">Hotels</a></h3></td>");
            out.println("<td><h3><a href=\"adminContent?productType=Customers\">Customers</a></h3></td>");
            out.println("<td><h3><a href=\"adminContent?productType=Orders\">Orders</a></h3></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</article>");
            out.println("<article><h3>Customers</h3></article>");
            out.println("<article class=\"expanded\">");
            for(int y=0; y<myCustomers.size(); y++){
                out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
                out.println("<tr><td width=\"40\"><b>Name: </b>"+myCustomers.get(y)+"</td></tr>");
                out.println("</table>");
                out.println("<td width=\"30%\"><table>");
                out.println("<tr><td><form action='adminContentItemRemoved'>");
                out.println("<input class='formbutton' type='submit' name='' value='Delete Customer'>");
                out.println("<input type='hidden' name='productType' value='Customers'>");
                out.println("<input type='hidden' name='action' value='Delete'>");
                out.println("<input type='hidden' name='Item' value='Customer'>");
                out.println("<input type='hidden' name='CustomerFirstName' value='"+myCustomers.get(y)+"'>");
                out.println("</form></td></tr>");
                out.println("</table>");
            }
            out.println("<table>");
            out.println("<tr><td><form method = 'get' action = 'AddCustomer.html'>");
            out.println("<input class = 'formbutton' style=float:right type = 'submit' value = 'Add Customer'>");
            out.println("</form></td></tr>");
            out.println("</table>");
            out.println("</article>");        
        }

// Content table Orders
        else if(productType.equals("Orders")){
            out.println("<section id=\"content\">");
            out.println("<article>");
            out.println("<table style='width:100%'>");
            out.println("<tr>");
            out.println("<td><h3><a href=\"adminContent?productType=Hotels\">Hotels</a></h3></td>");
            out.println("<td><h3><a href=\"adminContent?productType=Customers\">Customers</a></h3></td>");
            out.println("<td><h3><a href=\"adminContent?productType=Orders\">Orders</a></h3></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</article>");
            out.println("<article><h3>Orders</h3></article>");
            out.println("<article class=\"expanded\">");
            for(int z=0; z<myOrders.size(); z++){
                out.println("<table style=\"width:100%\" style=\"height:100%\" border=\"1\" bordercolor=\"#aaa\" cellspacing=\"0\" cellpadding=\"0\">");
                out.println("<tr><td width=\"40\"><b>Order Id: </b>"+myOrders.get(z)+"</td></tr>");
                out.println("</table>");
                out.println("<td width=\"30%\"><table>");
                out.println("<tr><td><form action='adminContentItemRemoved'>");
                out.println("<input class='formbutton' type='submit' name='' value='Delete Order'>");
                out.println("<input type='hidden' name='productType' value='Orders'>");
                out.println("<input type='hidden' name='action' value='Delete'>");
                out.println("<input type='hidden' name='Item' value='Order'>");
                out.println("<input type='hidden' name='OrderId' value='"+myOrders.get(z)+"'>");
                out.println("</form></td></tr>");
                out.println("</table>");
            }
            out.println("<table>");
            out.println("<tr><td><form method = 'get' action = 'AddOrder.html'>");
            out.println("<input class = 'formbutton' style=float:right type = 'submit' value = 'Add Order'>");
            out.println("</form></td></tr>");
            out.println("</table>");
            out.println("</article>");        
        }


        out.println("</section>");
        out.println("<div class=\"clear\"></div></div>");

// Footer
        out.println("</div><footer><div class=\"footer-content\"><ul><li><h4>About Us</h4></li></ul><ul>");
        out.println("<li><h4>Contact Us</h4></li></ul><ul class=\"endfooter\"><li><h4>Customer Service</h4></li>");
        out.println("</ul><div class=\"clear\"></div></div><div class=\"footer-bottom\">");
        out.println("<p>&copy; AlHamdanHotels 2017. by AlHamdan</p></div></footer></div>");
        out.println("</body></html>");
        out.close();
    }
}

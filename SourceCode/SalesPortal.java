import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Set;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class SalesPortal extends HttpServlet {
	HashMap<String, Products> productsMap = MySqlDataStoreUtilities.getProductsforsales();
	HashMap<Date, Integer> dailyTransactions = MySqlDataStoreUtilities.getDailyTransactionsFromMySQL();
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
     
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		//MySqlDataStoreUtilities.insertAllProductsToMySQLFromXML();
		

		//productType = request.getParameter("productType");
        out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        out.println("<title>Al Hamdan</title><link rel=\"stylesheet\" href=\"styles1.css\" type=\"text/css\" />");
        out.println("</head><body onload=\"init()\"><div id=\"container\">");
        out.println("<header><img src=\"images/AlHamdan.jpg\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4></header>");
		out.println("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">");
		out.println("google.charts.load('current', {'packages':['corechart']});");
		out.println(" google.charts.setOnLoadCallback(drawChart);");
		out.println("function drawChart() {");
		out.println("var data = new google.visualization.DataTable();");
		out.println("data.addColumn('string', 'Products');");
		out.println("data.addColumn('number', 'Count');");
		out.println(" data.addRows([");
		out.println("['Mushrooms', 3],");
		out.println(" ['Pepperoni', 2]");
		out.println("]);");
		out.println("var options = {'title':'No of Products available ',");
		out.println("'width':400,");
		out.println("'height':300};");
		out.println("var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
		out.println("chart.draw(data, options);");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body><div id=\"container\">");
		out.println("<header><h3>Data Analytics Portal</h3></header>");
		out.println("<nav><ul>");
		
        out.println("<div align='left'><li><a href=\"adminPanel\"><--Admin Panel</a></li></ul></nav></div>");

		
		out.println("<div align='center' id=\"body\"><article><h3 align=\"center\">Select from the dropdown the queries you require</h3>");
		out.println("<fieldset>");

		out.println("<form action='SalesPortal' method='post'>");
		out.println("<p><select name='queryType'>");
		out.println("<option name='queryType' value='1' selected> Generate a table of all Rooms Rented </option>");
		out.println("<option name='queryType' value='2'>Generate a Bar Chart that shows the Rooms names and the total number of Rooms sold</option>");
		//out.println("<option name='queryType' value='3'>Generate a table of daliy sales transactions </option>");
		out.println("</select></p>");
		out.println("<p><input name=\"send\"   class=\"formbutton\" value=\"Execute Query\" type=\"submit\" /></p>");
		out.println("</form>");
		out.println("</fieldset></article</div></div></body></html>");
		out.close();
		out.println("</fieldset></article</div></div></body></html>");
		
		
	}
		public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
				
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
		
				String queryType = "";
				queryType = request.getParameter("queryType");
            out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<title>Al Hamdan</title><link rel=\"stylesheet\" href=\"styles1.css\" type=\"text/css\" />");
            out.println("</head><body onload=\"init()\"><div id=\"container\">");
            out.println("<header><img src=\"images/AlHamdan.jpg\" style=\"width:70px;height:70px;\"><h4>AL-HAMDAN</h4></header>");
			out.println("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">");
			out.println("google.charts.load('current', {'packages':['corechart']});");
			out.println(" google.charts.setOnLoadCallback(drawChart);");
			out.println("function drawChart() {");
			out.println("var data = new google.visualization.DataTable();");
			out.println("data.addColumn('string', 'Products');");
			out.println("data.addColumn('number', 'Total Sales');");
			out.println(" data.addRows([");
			for(Map.Entry<String, Products> m :productsMap.entrySet())
			{
				
				Products p = m.getValue();
				String pname = p.getProductName();
				String totalSold = p.getSales();
				out.println("['"+pname+"', "+totalSold+ "],");
			
			}
			out.println("]);");
			out.println("var options = {'title':'Total Sales of the Products ($) ',");
			out.println("'width':800,");
			out.println("'height':1000};");
			out.println("var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
			out.println("chart.draw(data, options);");
			out.println("}");
			out.println("</script>");
			out.println("</head>");
			out.println("<body><div id=\"container\">");
			out.println("<header><h3>Sales Portal</h3></header>");
			out.println("<nav><ul>");
            out.println("<div align='left'><li><a href=\"adminPanel\"><--Admin Panel</a></li></ul></nav></div>");

		

			out.println("<div align='center' id=\"body\"><article><h3 align=\"center\">Select any one query from the folowing and click Execute Query</h3>");
			out.println("<fieldset>");

		if(queryType.equals("1"))
		{
		out.println("<fieldset>");
		out.println("<form action='SalesPortal' method='post'>");
		out.println("<p><select name='queryType'>");
		out.println("<option name='queryType' value='1' selected> Generate a table of all Products Rented </option>");
		out.println("<option name='queryType' value='2'>Generate a Bar Chart that shows the Product names and the total number of Product sold</option>");
		//out.println("<option name='queryType' value='3'>Generate a table of daliy sales transactions </option>");
		out.println("</select></p>");
		out.println("<p><input name=\"send\"   class=\"formbutton\" value=\"Execute Query\" type=\"submit\" /></p>");
		out.println("</form>");
		out.println("<table>");
		out.println("<tr><th>Product Name</th><th>Price</th><th>No. of times Rented</th><th>Total Sales $</th></tr>");
		
		for(Map.Entry<String, Products> m :productsMap.entrySet())
			{
				
				Products p = m.getValue();
				String pname = p.getProductName();
				String pprice = p.getPrice();
				String sold = p.getSQuantity();
				String totalSold = p.getSales();
				out.println("<tr>");
				out.println("<td>"+pname+"</td>");
				out.println("<td>"+pprice+"</td>");
				out.println("<td>"+sold+"</td>");
				out.println("<td>"+totalSold+"</td>");
				out.println("</tr>");
				
			}
		
		out.println("</table>");
		out.println("</fieldset></article</div></div></body></html>");
		out.close();
		out.println("</fieldset></article</div></div></body></html>");
		
		}
		if(queryType.equals("2"))
		{
		out.println("<fieldset>");
		out.println("<form action='SalesPortal' method='post'>");
		out.println("<p><select name='queryType'>");
		out.println("<option name='queryType' value='1' selected> Generate a table of all Products Rented </option>");
		out.println("<option name='queryType' value='2'>Generate a Bar Chart that shows the product names and the total number of product rented</option>");
		//out.println("<option name='queryType' value='3'>Generate a table of daliy sales transactions </option>");
		out.println("</select></p>");
		out.println("<p><input name=\"send\"   class=\"formbutton\" value=\"Execute Query\" type=\"submit\" /></p>");
		out.println("</form>");
		out.println("<div id=\"chart_div\"></div>");
		out.println("</fieldset></article</div></div></body></html>");
		out.close();
		out.println("</fieldset></article</div></div></body></html>");
		}
		/*if(queryType.equals("3"))
		{
		out.println("<fieldset>");
		out.println("<form action='SalesPortal' method='post'>");
		out.println("<p><select name='queryType'>");
		out.println("<option name='queryType' value='1' selected> Generate a table of all Products Rented </option>");
		out.println("<option name='queryType' value='2'>Generate a Bar Chart that shows the Products names and the total number of Products sold</option>");
		out.println("<option name='queryType' value='3'>Generate a table of daliy sales transactions </option>");
		out.println("</select></p>");
		out.println("<p><input name=\"send\"   class=\"formbutton\" value=\"Execute Query\" type=\"submit\" /></p>");
		out.println("</form>");
		out.println("<h2>Daily Transaction</h2>");
		out.println("<table>");
		out.println("<tr><th>Date of Sale</th><th>Transaction Total in $</th></tr>");
				
					for(Map.Entry<Date,Integer> m :dailyTransactions.entrySet()){
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
							String date = sdf.format(m.getKey());
							int Total = m.getValue();
							//out.println("<tr><td>"+date+"</td><td>"+Total+"$</td></tr>");
							out.println("<tr><td>"+"11/17/17"+"</td><td>"+"350$"+"</td></tr>");
							out.println("<tr><td>"+"11/19/17"+"</td><td>"+"350$"+"</td></tr>");
							out.println("<tr><td>"+"11/21/17"+"</td><td>"+"450$"+"</td></tr>");
							out.println("<tr><td>"+"11/24/17"+"</td><td>"+"750$"+"</td></tr>");
							

					}*/
			
		
		
		//out.println("</table>");
		out.println("</fieldset></article</div></div></body></html>");
		//out.close();
		//out.println("</fieldset></article</div></div></body></html>");
		//}
		
		}
			
}



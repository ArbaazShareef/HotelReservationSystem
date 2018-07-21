import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.*;
import java.util.*;

public class DealMatches {

	static ArrayList<Object> products;
    static HashMap<String, Products> rooms;
    static HashMap<String, Products> lr;
    static HashMap<String, Products> su;
    static HashMap<String, Products> di;
    static MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
    
    static void loadXML()
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
	
	static HashMap<String, Products> selectedProducts;
	
	public static ArrayList<String> tweets = new ArrayList<String>();
	
	public static ArrayList<String> getTweets()
	{
		return tweets;
	}
	
	public static HashMap<String, Products> getSelectedProductsFromTweets()
	{
		loadXML();
		selectedProducts = new HashMap<String, Products>();
		
		tweets = new ArrayList<String>();
		
		String line=null;
		
		try
		{
			for(Map.Entry<String, Products> entry: rooms.entrySet())
			{
				
				Products s = entry.getValue();
				if(selectedProducts.size()<2 && !selectedProducts.containsKey(entry.getKey()))
				{
					BufferedReader reader = new BufferedReader(new FileReader(new File("/Library/tomcat/webapps/AlHamdanHotels/DealMatches.txt")));
					
					line = reader.readLine();
					
					if(line==null)
					{
						
					}
					
					else
					{
						do{
							if(line.contains(s.getHotelName()))
							{
								tweets.add(line);
								selectedProducts.put(entry.getKey(), s);
								break;
							}
							
						}while ((line=reader.readLine()) != null);
					}
				
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return selectedProducts;
		
	}
	
	public static void main(String args[]){
		
		DealMatches dm = new DealMatches();
		
		HashMap<String, Products> s1=dm.getSelectedProductsFromTweets();
		ArrayList<String> tweets=dm.getTweets();
		for(int i=0;i<tweets.size();i++)
			System.out.println(tweets);
		for(Map.Entry<String,Products> m :s1.entrySet()){
			Products s = m.getValue();
			System.out.println(s.getHotelName());
		}

	}

}

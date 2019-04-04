package apireqres;

import java.net.*;
import java.util.Base64;
import java.io.*;

public class GETrequestAPI {

	public static void main(String[] args) throws IOException {
		
        
        String usernameColonPassword = "ToolsQA:TestPassword";
        String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes()); 
        
        URL details = new URL("http://restapi.demoqa.com/utilities/weather/city/hyderabad");
        HttpURLConnection conn = (HttpURLConnection) details.openConnection();
        
        conn.addRequestProperty("Authorization", basicAuthPayload);        
        
        System.out.println("Response code is :"+conn.getResponseCode());
        System.out.println("Response message is :"+conn.getResponseMessage());     
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));      
        String inputLine;
        FileWriter jsonwrite = new FileWriter("Output.json");
        BufferedWriter bwrite = new BufferedWriter(jsonwrite);
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
            bwrite.write(inputLine); 	
        }  
        in.close();
        bwrite.close();

	}

}

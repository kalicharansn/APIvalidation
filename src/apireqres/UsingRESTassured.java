package apireqres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsingRESTassured {

	@Test
	public void getResponse() throws IOException {
				
	
		Response response = RestAssured.get("http://restcountries.eu/rest/v1/name/norway");	
        //Response response = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/hyderabad");
		int statcode = response.getStatusCode();
		System.out.println("Status code: "+statcode);
		
        BufferedReader in = new BufferedReader(new InputStreamReader(response.asInputStream()));      
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
	
	@Test(enabled=false)
	public void getData() {

		Response response = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/hyderabad");
		String value = response.asString();
		System.out.println("Data present: "+value);

	}
}

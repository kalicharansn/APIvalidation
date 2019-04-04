package apireqres;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReadAPI {

	ExtentReports extentreport;
	ExtentHtmlReporter htmlreporter;
	ExtentTest extenttest;

	@BeforeTest
	public void report() {
		extentreport = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter("Testreport.html");
		extentreport.attachReporter(htmlreporter);
	}

	@Test(enabled = false)
	public void validateAPIdetailsway1() throws IOException, ParseException {

		extenttest = extentreport.createTest("API Validation");

		JSONParser jpar = new JSONParser();
		FileReader read = new FileReader("Output.json");
		Object jobj = jpar.parse(read);
		JSONObject jsonobj = (JSONObject) jobj;

		LinkedHashMap<String, String> tempdetails = new LinkedHashMap<String, String>();

		tempdetails.put("City", (String) jsonobj.get("City"));
		tempdetails.put("Temperature", (String) jsonobj.get("Temperature"));
		tempdetails.put("Humidity", (String) jsonobj.get("Humidity"));
		tempdetails.put("WeatherDescription", (String) jsonobj.get("WeatherDescription"));
		tempdetails.put("WindSpeed", (String) jsonobj.get("WindSpeed"));
		tempdetails.put("WindDirectionDegree", (String) jsonobj.get("WindDirectionDegree"));

		System.out.println(tempdetails);
		Assert.assertEquals(tempdetails.get("City"), "Hyderabad");
		Assert.assertEquals(tempdetails.get("Temperature"), "37.66 Degree celsius");
		Assert.assertEquals(tempdetails.get("Humidity"), "39 Percent");

		extentreport.flush();

	}

	@Test
	public void validateAPIdetailsway2() throws IOException, ParseException {

		JSONParser jpar = new JSONParser();
		FileReader read = new FileReader("Output3.json");
		Object jobj = jpar.parse(read);

		JSONArray jsonarray = (JSONArray) jobj;
		for (Object object : jsonarray) {

			JSONObject jsonobj = (JSONObject) object;

			String first_name = (String) jsonobj.get("first_name");
			String last_name = (String) jsonobj.get("last_name");
			String avatar = (String) jsonobj.get("avatar");
			System.out.println(first_name + "," + last_name + "," + avatar);
		}
	}

	@Test(enabled = false)
	public void validateAPIdetailsway3() throws IOException, ParseException {

		JSONParser jpar = new JSONParser();
		FileReader read = new FileReader("Output3.json");
		Object jobj = jpar.parse(read);

		JSONArray jsonarray = (JSONArray) jobj;
		for (Object object : jsonarray) {

			JSONObject jsonobj = (JSONObject) object;

			JSONArray first_name = (JSONArray) jsonobj.get("first_name");

			Iterator iterate = first_name.iterator();
			while (iterate.hasNext()) {
				System.out.println(iterate.next());
			}
		}
	}
	
	@Test(enabled = false)
	public void validateAPIdetailsway4() throws IOException, ParseException {

		JSONParser jpar = new JSONParser();
		FileReader read = new FileReader("Output3.json");
		Object jobj = jpar.parse(read);

		JSONArray jsonarray = (JSONArray) jobj;
		for (Object object : jsonarray) {

			JSONObject jsonobj = (JSONObject) object;

			JSONArray first_name = (JSONArray) jsonobj.get("first_name");

			Iterator iterate = first_name.iterator();
			while (iterate.hasNext()) {
				System.out.println(iterate.next());
			}
		}
	}
}

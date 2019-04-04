package apireqres;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class POSTrequestAPI {

	private static final String POST_PARAMS = "{\"name\":\"Bumrah123\",\"salary\":\"98877\",\"age\":\"22\"}";
	
	public static void main(String[] args) throws IOException {

		sendPOST();
		System.out.println("POST DONE");
	}

	private static void sendPOST() throws IOException {

		URL url = new URL("http://dummy.restapiexample.com/api/v1/create");
		String json = new String(POST_PARAMS);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("POST");
		
		OutputStream os = (OutputStream) con.getOutputStream();
		os.write(POST_PARAMS.getBytes());		os.close();
		System.out.println(con.getResponseCode());
		int responseCode = con.getResponseCode();
		
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
		con.disconnect();
		}

}
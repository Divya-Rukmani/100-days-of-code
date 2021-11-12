
import java.io.*;
import java.net.*;

public class HttpDemo {
	public static void main(String[] args){

	 HttpURLConnection urlConnection = null;

	            // URL TO FETCH DATA
	            try {
	                URL url = new URL("https://reqres.in/api/users?page=2");
	                urlConnection = (HttpURLConnection) url.openConnection();

	                int code = urlConnection.getResponseCode();
	                if (code != 200) {
	                    throw new IOException("Invalid response from server: " + code);
	                }

	                BufferedReader rd = new BufferedReader(new InputStreamReader(
	                        urlConnection.getInputStream()));
	                String line;
	                while ((line = rd.readLine()) != null) {
	                    System.out.println("data"+line);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                if (urlConnection != null) {
	                    urlConnection.disconnect();
	                }
	            }

	}
	}


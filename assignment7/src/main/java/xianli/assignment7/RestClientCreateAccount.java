package xianli.assignment7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class RestClientCreateAccount {
	public static void main(String[] args) {

		  try {
			URL url = new URL("http://localhost:8080/src/main/java/assignment7/createAccount");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"username\":\"username\",\"password\":\"test123\",\"email\":\"xianli@gmail.com\" }";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (Exception e) {
			  System.out.println(e);
		  }

		}
}

package empresa1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

//import javax.net.ssl.HttpsURLConnection;
import sun.net.www.protocol.http.HttpURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProxyServlet
 */
public class ProxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProxyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Map<String, String[]> parameters = request.getParameterMap();
		//String[] dataArray = parameters.get("param1");
		//String data = dataArray[0];
		
		String url = request.getParameter("url");
		String data = request.getParameter("data");
		String contentType = request.getParameter("contentType");
		String responseString = "Error";
		
		System.out.println("ProxyServlet.doPost() -> url= " + url);
		System.out.println("ProxyServlet.doPost() -> data= " + data);
		
		response.setStatus(HttpServletResponse.SC_OK);
		/*
		for(int i = 0; i < param1.length; i++) {
			response.getWriter().write(param1[i]);
		}
		*/
		
		
		try {
			responseString = sendPost(url,data, contentType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().write(responseString);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	//Extraido de: http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
	private String sendPost(String url, String urlParameters, String contentType) throws Exception {
		
		String USER_AGENT = "ProxyServlet";
		
		//String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		//HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", contentType);
 
		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		String responseString = response.toString();
		
		//print result
		System.out.println("ProxyServlet.sendPost() -> responseString= " + response.toString());
		
		return responseString;
 
	}


}

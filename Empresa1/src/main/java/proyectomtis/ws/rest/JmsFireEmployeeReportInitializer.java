package proyectomtis.ws.rest;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

import javax.servlet.*;
import javax.jms.*;
import javax.servlet.http.HttpServlet;






import org.apache.activemq.ActiveMQConnectionFactory;

import sun.net.www.protocol.http.HttpURLConnection;



public class JmsFireEmployeeReportInitializer extends HttpServlet  implements MessageListener,Runnable {


    public void init() throws ServletException
    {
    	System.out.println("JMS Subscriber launching thread");
    	//Creating an object of the first thread 
        JmsFireEmployeeReportInitializer  Thread1 = new JmsFireEmployeeReportInitializer();
        Thread thread1 = new Thread(Thread1); 
        thread1.start();
    	System.out.println("JMS Subscriber thread launched");
        
    }


      @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            System.out.println("Received message '"
	                + textMessage.getText() + "'");
	            
	            String msg = textMessage.getText();
	            sendPost("api/isOkAndFireEmployeeReports/",msg);
            }
        } catch (JMSException e) {
            System.out.println("Got a JMS Exception!");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	@Override
	public void run() {
		// URL of the JMS server.
				String url = "tcp://localhost:61616";
				// Name of the topic we will receive messages from
			    String subject = "fireEmployeeReport";
			    CountDownLatch latch = new CountDownLatch(1);
			    try{
					// Getting JMS connection from the server
			        ConnectionFactory connectionFactory
			            = new ActiveMQConnectionFactory(url);
			        Connection connection = connectionFactory.createConnection();
			        connection.start();
			
			        // Creating session for seding messages
			        Session session = connection.createSession(false,
			            Session.AUTO_ACKNOWLEDGE);
			
			        // Getting the topic
			        Destination destination = session.createTopic(subject);
			
			        // MessageConsumer is used for receiving (consuming) messages
			        MessageConsumer consumer = session.createConsumer(destination);
			
			        // Here we receive the message.
			        // By default this call is blocking, which means it will wait
			        // for a message to arrive on the topic.
			        consumer.setMessageListener(new JmsFireEmployeeReportInitializer());
			        latch.await();
			        consumer.close();
			        connection.close();
			    }catch (Exception e)
			    {
			    	System.out.println("Error: "+e);
			    }

		
	}
	
private String sendPost(String url, String urlParameters) throws Exception {
		
		String USER_AGENT = "ProxyServlet";
		
		//String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		//HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
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
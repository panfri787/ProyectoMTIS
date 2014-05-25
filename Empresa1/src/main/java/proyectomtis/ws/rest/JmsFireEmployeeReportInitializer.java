package proyectomtis.ws.rest;


import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.jms.*;
import javax.naming.InitialContext;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsFireEmployeeReportInitializer extends HttpServlet  implements MessageListener {


    public void init() throws ServletException
    {
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
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            System.out.println("Received message '"
	                + textMessage.getText() + "'");
            }
        } catch (JMSException e) {
            System.out.println("Got a JMS Exception!");
        }
    }
}
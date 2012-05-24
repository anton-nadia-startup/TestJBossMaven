package com.github.anton_nadia_startup.jms.hornetq.embedded;

import junit.framework.TestCase;

import javax.jms.*;
import java.util.Date;

/**
 * User: Anton Krupnov
 * Date: 18.04.12
 * Time: 9:52
 */
public class Test extends TestCase {

    public void test() throws Exception {

        ServerUtils.start();

        Connection connection = null;
        try {
            connection = ServerUtils.getConnection().createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(ServerUtils.getQueue());
            TextMessage message = session.createTextMessage("Hello sent at " + new Date());
            System.out.println("Sending message: " + message.getText());
            producer.send(message);
            MessageConsumer messageConsumer = session.createConsumer(ServerUtils.getQueue());
            connection.start();
            TextMessage messageReceived = (TextMessage) messageConsumer.receive(1000);
            System.out.println("Received message:" + messageReceived.getText());
        } finally {
            if (connection != null) {
                connection.close();
            }
            ServerUtils.stop();
        }
    }

}

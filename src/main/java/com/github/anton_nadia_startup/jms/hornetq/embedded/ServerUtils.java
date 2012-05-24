package com.github.anton_nadia_startup.jms.hornetq.embedded;

import org.hornetq.jms.server.embedded.EmbeddedJMS;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 * User: Anton Krupnov
 * Date: 18.04.12
 * Time: 9:27
 */
public class ServerUtils {

    private static final EmbeddedJMS jmsServer = new EmbeddedJMS();

    public static void start() throws Exception {
        jmsServer.start();
        System.out.println("Started Embedded JMS Server");
    }

    public static ConnectionFactory getConnection() {
        return (ConnectionFactory)jmsServer.lookup("/ConnectionFactory");
    }

    public static Queue getQueue() {
        return (Queue)jmsServer.lookup("/queue/exampleQueue");
    }

    public static void stop() throws Exception {
        jmsServer.stop();
        System.out.println("Stopped the JMS Server");
    }
}

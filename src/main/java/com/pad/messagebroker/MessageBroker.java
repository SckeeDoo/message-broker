package com.pad.messagebroker;

import com.pad.transport.TransportServer;
import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class MessageBroker {

    private static TransportServer transportServer;
    private final static Logger LOGGER = Logger.getLogger(MessageBroker.class.getName());


    public static void main(String[] args) {

        new Thread(() -> transportServer = new TransportServer(8878)).start();

        LOGGER.info("Message Broker is running.");
        LOGGER.info("Type STOP to kill the broker.");
        boolean isStopped = false;

        while (!isStopped) {
            String userInput = new Scanner(System.in).nextLine();

            switch (userInput.toUpperCase()) {

                case "STOP":
                    transportServer.stop();
                    transportServer = null;
                    isStopped = true;
                    break;
                default:
                    break;
            }
        }

        LOGGER.info("Close MessageBroker");
    }

}

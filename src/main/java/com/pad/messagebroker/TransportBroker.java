package com.pad.messagebroker;

public interface TransportBroker {
    void sendMessageToAllReceivers();
    String readMessageFromSender();
    void sendMessage(int id);
    String readMessage(int id);
}

package com.pad.sender;

public interface TransportSender {

    void sendToBroker(String message);
    void close();

}

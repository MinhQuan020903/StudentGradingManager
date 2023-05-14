/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferData;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quocd
 */
public class MessageBroker {
    private static MessageBroker instance;
    private List<MessageListener> listeners;

    private MessageBroker() {
        listeners = new ArrayList<>();
    }

    public static MessageBroker getInstance() {
        if (instance == null) {
            instance = new MessageBroker();
        }
        return instance;
    }

    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MessageListener listener) {
        listeners.remove(listener);
    }

    public void sendMessage(String message) {
        for (MessageListener listener : listeners) {
            listener.onMessageReceived(message);
        }
    }
}


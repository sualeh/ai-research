package com.example;

import java.util.LinkedList;

public class ChatHistory {
    private final int maxMessages;
    private final LinkedList<String> messages;

    public ChatHistory(int maxMessages) {
        this.maxMessages = maxMessages;
        this.messages = new LinkedList<>();
    }

    public void addMessage(String message) {
        if (messages.size() >= maxMessages) {
            messages.removeFirst();
        }
        messages.addLast(message);
    }

    public LinkedList<String> getMessages() {
        return new LinkedList<>(messages);
    }
}

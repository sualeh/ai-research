package com.example;

import java.util.Scanner;

public class LLMServer {

    private final AddTool addTool;
    private final SubtractTool subtractTool;
    private final ChatHistory chatHistory;

    public LLMServer() {
        this.addTool = new AddTool();
        this.subtractTool = new SubtractTool();
        this.chatHistory = new ChatHistory(10);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the LLM Server. Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            chatHistory.addMessage("You: " + userInput);
            String response = processInput(userInput);
            chatHistory.addMessage("LLM: " + response);

            System.out.println("LLM: " + response);
        }

        scanner.close();
    }

    private String processInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            return "Invalid input. Please use the format: [add/subtract] [num1] [num2]";
        }

        String command = parts[0];
        int num1;
        int num2;

        try {
            num1 = Integer.parseInt(parts[1]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return "Invalid numbers. Please enter valid integers.";
        }

        switch (command.toLowerCase()) {
            case "add":
                return String.valueOf(addTool.execute(num1, num2));
            case "subtract":
                return String.valueOf(subtractTool.execute(num1, num2));
            default:
                return "Unknown command. Please use 'add' or 'subtract'.";
        }
    }

    public static void main(String[] args) {
        LLMServer server = new LLMServer();
        server.start();
    }
}

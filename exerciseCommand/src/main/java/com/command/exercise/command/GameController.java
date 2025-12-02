package com.command.exercise.command;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    public enum Button { CROSS, TRIANGLE, SQUARE, CIRCLE }

    private final Map<Button, Command> buttonMappings = new HashMap<>();

    public void setCommand(Button button, Command command) {
        buttonMappings.put(button, command);
    }

    public void press(Button button) {
        Command command = buttonMappings.get(button);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command mapped for " + button);
        }
    }
}

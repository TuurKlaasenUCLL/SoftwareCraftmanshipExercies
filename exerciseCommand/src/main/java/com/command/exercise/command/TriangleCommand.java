package com.command.exercise.command;

import com.command.exercise.domain.Receiver;

public class TriangleCommand implements Command {
    private final Receiver receiver;

    public TriangleCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionTriangle();
    }
}

package com.command.exercise.command;

import com.command.exercise.domain.Receiver;

public class SquareCommand implements Command {
    private final Receiver receiver;

    public SquareCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionSquare();
    }
}


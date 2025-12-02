package com.command.exercise.command;

import com.command.exercise.domain.Receiver;

public class CircleCommand implements Command {
    private final Receiver receiver;

    public CircleCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionCircle();
    }
}

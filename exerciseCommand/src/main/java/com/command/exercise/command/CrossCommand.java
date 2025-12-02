package com.command.exercise.command;

import com.command.exercise.domain.Receiver;

public class CrossCommand implements Command {
    private final Receiver receiver;

    public CrossCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionCross();
    }
}

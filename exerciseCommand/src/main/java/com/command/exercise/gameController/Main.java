package com.command.exercise.gameController;

import com.command.exercise.command.CircleCommand;
import com.command.exercise.command.Command;
import com.command.exercise.command.CrossCommand;
import com.command.exercise.command.GameController;
import com.command.exercise.command.SquareCommand;
import com.command.exercise.command.TriangleCommand;
import com.command.exercise.domain.Receiver;

public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command jump = new CrossCommand(receiver);
        Command switchWeapon = new TriangleCommand(receiver);
        Command useWeapon = new SquareCommand(receiver);
        Command crouch = new CircleCommand(receiver);

        GameController controller = new GameController();

        controller.setCommand(GameController.Button.CROSS, jump);
        controller.setCommand(GameController.Button.TRIANGLE, switchWeapon);
        controller.setCommand(GameController.Button.SQUARE, useWeapon);
        controller.setCommand(GameController.Button.CIRCLE, crouch);

        controller.press(GameController.Button.CROSS);
        controller.press(GameController.Button.CIRCLE);


        controller.setCommand(GameController.Button.CROSS, crouch);

        controller.press(GameController.Button.CROSS);
    }
}


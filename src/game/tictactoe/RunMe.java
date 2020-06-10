package game.tictactoe;

import game.tictactoe.consoleui.ConsolePrinter;
import game.tictactoe.consoleui.ConsoleReader;
import game.tictactoe.consoleui.ConsoleUi;
import game.tictactoe.controller.MockGameController;

public class RunMe {

    public static void main(String[] args) {

        ConsoleUi consoleUi = new ConsoleUi(new MockGameController(), new ConsolePrinter(), new ConsoleReader());
        consoleUi.Start();

    }
}

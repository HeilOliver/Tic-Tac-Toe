package game.tictactoe.consoleui;

public class ConsolePrinter implements IConsolePrinter {

    @Override
    public void print(String para) {
        System.out.print(para);
    }
}

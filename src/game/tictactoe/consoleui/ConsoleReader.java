package game.tictactoe.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements IConsoleReader {
    private final BufferedReader bufferedReader;

    public ConsoleReader() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

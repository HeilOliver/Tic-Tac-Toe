package game.tictactoe.consoleui;

import game.tictactoe.controller.GameMove;
import game.tictactoe.controller.GameResult;
import game.tictactoe.controller.GameState;
import game.tictactoe.controller.PlayerIcon;

final class ConsoleController {
    private final IConsolePrinter consolePrinter;
    private final IConsoleReader consoleReader;

    public ConsoleController(IConsolePrinter consolePrinter, IConsoleReader consoleReader) {
        this.consolePrinter = consolePrinter;
        this.consoleReader = consoleReader;
    }

    void showHeader() {
        consolePrinter.print("___________.__         ___________               ___________            \n");
        consolePrinter.print("\\__    ___/|__| ____   \\__    ___/____    ____   \\__    ___/___   ____  \n");
        consolePrinter.print("  |    |   |  |/ ___\\    |    |  \\__  \\ _/ ___\\    |    | /  _ \\_/ __ \\ \n");
        consolePrinter.print("  |    |   |  \\  \\___    |    |   / __ \\\\  \\___    |    |(  <_> )  ___/ \n");
        consolePrinter.print("  |____|   |__|\\___  >   |____|  (____  /\\___  >   |____| \\____/ \\___  >\n");
        consolePrinter.print("                   \\/                 \\/     \\/                      \\/ \n");
    }

    public String getPlayerName(PlayerIcon playerIcon) {
        consolePrinter.print("Enter Player name for " + playerIcon + "\n");
        String read = null;
        do {
            read = consoleReader.read();
            if (read == null || read.isEmpty()) {
                consolePrinter.print("The entered Player name is not Valid \n");
            }
        } while (read == null || read.isEmpty());
        return read;
    }

    public void printResult(GameResult result) {
        if (result.IsDraw()) {
            consolePrinter.print("DDDDD                             \n");
            consolePrinter.print("DD  DD  rr rr    aa aa ww      ww \n");
            consolePrinter.print("DD   DD rrr  r  aa aaa ww      ww \n");
            consolePrinter.print("DD   DD rr     aa  aaa  ww ww ww  \n");
            consolePrinter.print("DDDDDD  rr      aaa aa   ww  ww   \n");
            return;
        }
        PlayerIcon playerIcon = result.getPlayerWon().getPlayerIcon();
        if (playerIcon == PlayerIcon.Cross) {
            consolePrinter.print("ooooooo  ooooo      oooooo   oooooo     oooo                       \n");
            consolePrinter.print(" `8888    d8'        `888.    `888.     .8'                        \n");
            consolePrinter.print("   Y888..8P           `888.   .8888.   .8'    .ooooo.  ooo. .oo.   \n");
            consolePrinter.print("    `8888'             `888  .8'`888. .8'    d88' `88b `888P\"Y88b  \n");
            consolePrinter.print("   .8PY888.             `888.8'  `888.8'     888   888  888   888  \n");
            consolePrinter.print("  d8'  `888b             `888'    `888'      888   888  888   888  \n");
            consolePrinter.print("o888o  o88888o            `8'      `8'       `Y8bod8P' o888o o888o \n");
        } else {
            consolePrinter.print("  .oooooo.        oooooo   oooooo     oooo                       \n");
            consolePrinter.print(" d8P'  `Y8b        `888.    `888.     .8'                        \n");
            consolePrinter.print("888      888        `888.   .8888.   .8'    .ooooo.  ooo. .oo.  \n");
            consolePrinter.print("888      888         `888  .8'`888. .8'    d88' `88b `888P\"Y88b  \n");
            consolePrinter.print("888      888          `888.8'  `888.8'     888   888  888   888  \n");
            consolePrinter.print("`88b    d88'           `888'    `888'      888   888  888   888  \n");
            consolePrinter.print(" `Y8bood8P'             `8'      `8'       `Y8bod8P' o888o o888o\n");
        }
    }

    public void showGameState(GameState state) {
        PlayerIcon[][] gameField = state.getGameField();

        consolePrinter.print("-------------\n");
        for (int i = 0; i < 3; i++) {
            consolePrinter.print("| ");
            for (int j = 0; j < 3; j++) {
                char toPrint = ' ';
                if (gameField[i][j] == PlayerIcon.Circle)
                    toPrint = 'O';
                if (gameField[i][j] == PlayerIcon.Cross)
                    toPrint = 'X';

                consolePrinter.print(toPrint + " | ");
            }
            consolePrinter.print("\n");
            consolePrinter.print("-------------\n");
        }
    }

    public GameMove getNextMove(PlayerIcon nextTurn) {
        consolePrinter.print("Enter next move for " + nextTurn + "(Column Row):\n");
        GameMove gameMove = null;

        do {
            String read = consoleReader.read();
            String[] values = read.split(" ");

            if (values.length != 2) {
                consolePrinter.print("Invalid input!\n");
                continue;
            }

            try {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                gameMove = new GameMove(x, y, nextTurn);
            } catch (NumberFormatException e) {
                consolePrinter.print("Input is not a number!\n");
            }
        } while (gameMove == null);
        return gameMove;
    }

    public boolean allowRestart() {
        consolePrinter.print("New round? (yes)");
        String read = consoleReader.read();

        return read != null && read.equals("yes");
    }
}

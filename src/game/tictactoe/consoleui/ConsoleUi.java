package game.tictactoe.consoleui;

import game.tictactoe.controller.*;

public class ConsoleUi {
    private final IGameController gameController;
    private final ConsoleController consoleHeadings;
    private ConsoleUiState state;

    public ConsoleUi(IGameController gameController, IConsolePrinter consolePrinter, IConsoleReader consoleReader) {
        if (gameController == null)
            throw new IllegalArgumentException("Argument gameController is not allowed to be null");
        if (consolePrinter == null)
            throw new IllegalArgumentException("Argument consolePrinter is not allowed to be null");

        this.gameController = gameController;
        state = ConsoleUiState.Init;
        consoleHeadings = new ConsoleController(consolePrinter, consoleReader);
    }

    public void Start() {
        boolean inRun = true;
        PlayerIcon nextTurn = PlayerIcon.Circle;

        while (inRun) {
            switch (state) {
                case Init:
                    consoleHeadings.showHeader();
                    state = ConsoleUiState.CreatePlayer0;
                    break;
                case CreatePlayer0:
                    Player player0 = createPlayer(PlayerIcon.Circle);
                    gameController.setPlayer(PlayerIcon.Circle, player0);
                    state = ConsoleUiState.CreatePlayer1;
                    break;
                case CreatePlayer1:
                    Player player1 = createPlayer(PlayerIcon.Cross);
                    gameController.setPlayer(PlayerIcon.Cross, player1);
                    state = ConsoleUiState.Play;
                    break;
                case Play:
                    if (nextTurn == PlayerIcon.Circle)
                        nextTurn = PlayerIcon.Cross;
                    else
                        nextTurn = PlayerIcon.Circle;

                    GameState gameState = gameController.getState();
                    consoleHeadings.showGameState(gameState);
                    GameMove nextMove = consoleHeadings.getNextMove(nextTurn);
                    gameController.doMove(nextMove);

                    if (gameController.isFinish())
                        state = ConsoleUiState.Finish;
                    break;
                case Finish:
                    showGameResult();
                    if (playerWontRestart())
                        resetGame();
                    else
                        inRun = false;
                    break;
            }
        }
    }

    private void resetGame() {
        gameController.resetGameField();
        state = ConsoleUiState.Play;
    }

    private void showGameResult() {
        GameResult result = gameController.getResult();
        consoleHeadings.printResult(result);
    }

    private Player createPlayer(PlayerIcon playerIcon) {
        String playerName = consoleHeadings.getPlayerName(playerIcon);
        return new Player(playerIcon, playerName);
    }

    private boolean playerWontRestart() {
        return consoleHeadings.allowRestart();
    }
}

package game.tictactoe.controller;

public class GameResult {
    private final boolean isDraw;
    private final Player playerWon;
    private final Player playerLose;

    public GameResult(boolean isDraw, Player playerWon, Player playerLose) {
        this.isDraw = isDraw;
        this.playerWon = playerWon;
        this.playerLose = playerLose;
    }

    public Player getPlayerWon() {
        return playerWon;
    }

    public Player getPlayerLose() {
        return playerLose;
    }

    public boolean IsDraw() {
        return isDraw;
    }
}

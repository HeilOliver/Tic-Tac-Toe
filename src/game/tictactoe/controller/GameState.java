package game.tictactoe.controller;

public class GameState {
    private final PlayerIcon[][] gameField;

    public GameState(PlayerIcon[][] gameField) {
        this.gameField = gameField;
    }

    public PlayerIcon[][] getGameField() {
        return gameField;
    }
}

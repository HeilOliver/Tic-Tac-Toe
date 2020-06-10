package game.tictactoe.controller;

public class GameMove {
    private final int column;
    private final int row;
    private final PlayerIcon playerIcon;

    public GameMove(int column, int row, PlayerIcon playerIcon) {
        this.column = column;
        this.row = row;
        this.playerIcon = playerIcon;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public PlayerIcon getPlayerIcon() {
        return playerIcon;
    }
}

package game.tictactoe.controller;

public class Player {

    private final PlayerIcon playerIcon;
    private final String playerName;

    public Player(PlayerIcon playerIcon, String playerName) {

        if (playerName == null || playerName.isEmpty())
            throw new IllegalArgumentException("player name is not allowed to null or empty");

        this.playerIcon = playerIcon;
        this.playerName = playerName;
    }

    public PlayerIcon getPlayerIcon() {
        return playerIcon;
    }

    public String getPlayerName() {
        return playerName;
    }
}

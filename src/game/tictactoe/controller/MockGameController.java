package game.tictactoe.controller;

import java.util.Arrays;

public class MockGameController implements IGameController {
    @Override
    public void setPlayer(PlayerIcon icon, Player player) {

    }

    @Override
    public GameResult getResult() {
        return new GameResult(true, null, null);
    }

    @Override
    public void resetGameField() {

    }

    @Override
    public GameState getState() {
        PlayerIcon[][] playerIcons = new PlayerIcon[3][3];
        for (PlayerIcon[] playerIcon : playerIcons) {
            Arrays.fill(playerIcon, PlayerIcon.None);
        }

        return new GameState(playerIcons);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public void doMove(GameMove nextMove) {

    }
}

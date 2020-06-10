package game.tictactoe.controller;

public interface IGameController {

    void setPlayer(PlayerIcon icon, Player player);

    GameResult getResult();

    void resetGameField();

    GameState getState();

    boolean isFinish();

    void doMove(GameMove nextMove);
}

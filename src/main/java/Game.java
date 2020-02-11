import java.util.function.DoubleToIntFunction;

public class Game {
    public static void main(String[] args){
        Board board = new Board();
        board.fillBoardZero();
        for(int i = 0; i < 8; i++){
            board.createRandTail();
            Output.Print(board);
            board.doMove(Direction.Down);
            Output.Print(board);
        }
    }
}

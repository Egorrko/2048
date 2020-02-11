import java.util.ArrayList;

public class Output {
    public static void Print(Board board){
        for (int i = 0 ; i < board.board.length; i++
             ) {
            for (int k = 0; k < board.board.length; k++
                 ) {
                if(board.board[i][k].num == 0)
                    System.out.print("_ ");
                else
                    System.out.printf("%s ",board.board[i][k].num);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}

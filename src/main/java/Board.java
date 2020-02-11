import java.util.*;

public class Board {
    public int size= 4;
    public int probOf4 = 10;
    public Tail[][] board = new Tail[size][size];
    public void fillBoardZero(){
        for (int i = 0 ; i < size; i++
        ) {
            for (int k = 0; k < size; k++
            ) {
                board[i][k] = new Tail(0);
            }
        }
    }
    public void createRandTail(){
        ArrayList<IntPair> nulls = new ArrayList<>();
        for (int i = 0 ; i < size; i++
        ) {
            for (int k = 0; k < size; k++
            ) {
                if(board[i][k].num == 0)
                    nulls.add(new IntPair(i,k));
            }
        }
        Random r = new Random();
        IntPair selected = nulls.get(r.nextInt(nulls.size()));
        board[selected.x][selected.y] = r.nextInt(probOf4) == 0 ? new Tail(4) : new Tail(2);
    }
    static class IntPair {
        // Ideally, name the class after whatever you're actually using
        // the int pairs *for.*
        final int x;
        final int y;
        IntPair(int x, int y) {this.x=x;this.y=y;}
        // depending on your use case, equals? hashCode?  More methods?
    }
    public void doMove(Direction dir){
        int[][] temp = new int[size][size];
        if(dir == Direction.Left){
            for (int i = 0 ; i < size; i++
            ) {
                for (int k = 0; k < size; k++
                ) {
                    temp[i][k] = board[i][k].num;
                }
            }
            for (int i = 0; i < size; i++) {
                temp[i] = Do(temp[i]);
            }
            for (int i = 0 ; i < size; i++
            ) {
                for (int k = 0; k < size; k++
                ) {
                    board[i][k].num = temp[i][k];
                }
            }
        }
        if(dir == Direction.Right){
            for (int i = 0 ; i < size; i++
            ) {
                for(int k = size - 1; k >= 0; k--
                ) {
                    temp[i][size - k - 1] = board[i][k].num;
                }
            }
            for (int i = 0; i < size; i++) {
                temp[i] = Do(temp[i]);
            }
            for (int i = 0 ; i < size; i++
            ) {
                for (int k = 0; k < size; k++
                ) {
                    board[i][k].num = temp[i][size - k - 1];
                }
            }
        }
        if(dir == Direction.Up){
            for (int i = 0 ; i < size; i++
            ) {
                for (int k = 0; k < size; k++
                ) {
                    temp[i][k] = board[k][i].num;
                }
            }
            for (int i = 0; i < size; i++) {
                temp[i] = Do(temp[i]);
            }
            for (int i = 0 ; i < size; i++
            ) {
                for (int k = 0; k < size; k++
                ) {
                    board[i][k].num = temp[k][i];
                }
            }
        }
        if(dir == Direction.Down){
            for (int i = size - 1; i >= 0; i--
            ) {
                for(int k = 0; k < size; k++
                ) {
                    temp[i][k] = board[k][i].num;
                }
            }
            for (int i = 0; i < size; i++) {
                temp[i] = Do(temp[i]);
            }
            for (int i = size - 1; i >= 0; i--
            ) {
                for (int k = 0; k < size; k++
                ) {
                    board[i][k].num = temp[k][i];
                }
            }
        }
    }
    public int[] Do(int[] arr){
        //переводим в аррейЛист и удаляем нули
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int value : arr) {
            if (value != 0)
                tempList.add(value);
        }
        //бежим по нему и соединяем
        int i = 0;
        while(i < tempList.size() - 1){
            if(tempList.get(i).equals(tempList.get(i + 1))){
                tempList.set(i,tempList.get(i)*2);
                tempList.remove(i+1);
            }
            i++;
        }
        // обнуляем массив
        for(i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
        //заполняем новыми значениями
        for(i = 0; i < tempList.size(); i++){
            arr[i] = tempList.get(i);
        }
        return arr;
    }
    public static void main(String[] args){
        xVxTest();
    }
    public static void Test(String input) {
        String[] integerStrings = input.split(" ");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(integerStrings[i]);
        }
        Board board = new Board();
        int[] w = board.Do(integers);
        System.out.print("input :  " + input + "  result:  ");
        for (int e :w
        ) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    public static void xVxTest(){
        int size = 4;
        int[][] temp = new int[size][size];
        int q = 0;
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++){
                q++;
                temp[i][k] = q;
            }
        }
        for(int i = size - 1; i >= 0; i--){
            for(int k = 0; k < size; k++)
                arr[k] = temp[k][i];
            print(arr);
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++)
                arr[k] = temp[k][i];
            print(arr);
            System.out.println();
        }
    }
    public static void print(int[] arr){
        for(int i = 0; i < 4; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

# import java.util.Scanner;

public class Main {

    static void matrixBoardPrint(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static char win(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != '_') {

                return matrix[i][0];
            }

        }
        for (int j = 0; j < 3; j++) {
            if (matrix[0][j] == matrix[1][j] && matrix[1][j] == matrix[2][j] && matrix[0][j] != '_') {
                return matrix[0][j];
            }
        }
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != '_') {
            return matrix[0][0];
        }
        if (matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2] && matrix[2][0] != '_') {
            return matrix[2][0];

        }
        return '_';

    }

    static boolean tie(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == '_') {
                    return false;
                }
            }

        }
        return true;
    }

    public void game(){

        Scanner scanner = new Scanner(System.in);


        char[][] matrix = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
            }
        }

        boolean player = true;
        boolean End = false;
        matrixBoardPrint(matrix);
        char playAgain;
        while (!End) {


            char symbol = ' ';
            if (player) {
                symbol = 'x';


            } else {
                symbol = 'o';
            }
            if (player) {
                System.out.println("x turn");
            } else {
                System.out.println("o turn");
            }

            int row = 0;
            int column = 0;

            while (true) {
                System.out.println("enter a row ");
                row = scanner.nextInt();
                System.out.println("enter a column");
                column = scanner.nextInt();

                if (row < 0 || column < 0 || row > 2 || column > 2) {
                    System.out.println("out of bounds, please enter a value between 0-2");
                } else if (matrix[row][column] != '_') {
                    System.out.println("position taken, please mark different position");
                } else {
                    break;
                }
            }

            matrix[row][column] = symbol;
            matrixBoardPrint(matrix);

            if (win(matrix) == 'x') {

                System.out.println("player x  won");
                End = true;
            } else if (win(matrix) == 'o') {
                System.out.println("player o won");
                End = true;
            } else {
                if (tie(matrix)) {

                    System.out.println("Tie");
                    End = true;
                } else {
                    player = !player;
                }

            }

        }
        System.out.println("would you like to play again? y-yes, n-no");
       playAgain = scanner.next().charAt(0);
        if (playAgain=='Y'|| playAgain=='y'){
            this.game();
        }else {
            System.out.println("Goodbye");
        }
    }

    public static void main(String[] args) {

        new Main().game();

    }

}



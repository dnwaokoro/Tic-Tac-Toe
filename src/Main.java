import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    static int turns;
    public static void main(String[] args) {
        int oneWins = 0;
        int twoWins = 0;
        int Draws = 0;
        System.out.println("Hi, today we play tic tac toe");
        System.out.println("player one enter your name!");
        Scanner Newp = new Scanner(System.in);
        String Pone = Newp.nextLine();
        System.out.println(Pone);
        System.out.println("player two enter your name!");
        Scanner Newptwo = new Scanner(System.in);
        String Ptwo = Newptwo.nextLine();
        System.out.println(Ptwo);
        System.out.println(Pone + "(player one) " + " is 'X' " + Ptwo + "(player two) " + " is 'O'");

        boolean gameTime = true;
        while( gameTime = true){
            char[][] dataGrid;
            dataGrid = new char[3][3];
            //clear the game board
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++) {
                    dataGrid[i][j] = '*';
                }
            }
            // scan for input -> int var
            // selection -> x,y
            // gamedata[x][y] = 'X' or 'O' or mark
            // print data
            System.out.println("X goes first");
            printGame(dataGrid);

            boolean xTurn = true;
            System.out.println("use numPad for placement");
            while(true) {
                Scanner move = new Scanner(System.in);
                ///////////////////////
                try {
                    if (xTurn) {
                        int Pmoveone = move.nextInt();
                        int moveCol = numpadToCol(Pmoveone);
                        int moveRow = numpadToRow(Pmoveone);


                        if (dataGrid[moveCol][moveRow] == '*') {//valid selection
                            dataGrid[moveCol][moveRow] = 'X'; // mark the space
                            turns++;
                            System.out.println("O moves next");
                            xTurn = false;
                        } else { //invalid seleciton
                            System.out.println("play on an empty spot marked '*'");
                        }
                        printGame(dataGrid);
                        char wincheck = checkWin(dataGrid);
                        if(turns == 9) {
                            System.out.println("game ended in a draw");
                            Draws++;
                            break;
                        } else if (wincheck == 'X') {
                            System.out.println(Pone + "(X)" + " wins, game over");
                            oneWins ++;
                            break;
                        }




                    } else {

                        int Pmovetwo = move.nextInt();
                        int moveCol = numpadToCol(Pmovetwo);
                        int moveRow = numpadToRow(Pmovetwo);

                        if (dataGrid[moveCol][moveRow] == '*') {
                            dataGrid[moveCol][moveRow] = 'O';
                            turns++;
                            System.out.println("X moves next");
                            xTurn = true;
                        } else {
                            System.out.println("play on an empty spot marked '*' ");
                        }
                        printGame(dataGrid);
                        char wincheck = checkWin(dataGrid);
                        if(turns == 9) {
                            System.out.println("game ended in a draw");
                            Draws++;
                            break;
                        }else if (wincheck == 'O') {
                            System.out.println(Ptwo + "(O)" + " wins, game over");
                            twoWins ++;
                            break;
                        }



                    }
                } catch (Exception ex) {
                    System.out.println("that's not a number...");
                }


            }
            System.out.println(Pone + "'s wins = " + oneWins  + "   " +Ptwo + "'s wins = " + twoWins + "   Draws = " + Draws);


            System.out.println( "would you like to go again? [1]Yes [2]quit");
            Scanner Uin = new Scanner(System.in);
            int Ui = Uin.nextInt();
            if(Ui == 1){
                gameTime = true;
                turns = 0;
                if(oneWins > twoWins){
                    System.out.println(Pone + " plays as x");
                }else if(twoWins > oneWins){
                    System.out.println(Ptwo + " plays as x");
                }else {
                    System.out.println(Pone + " plays as x");
                }
            }else if (Ui == 2){
                break;
            }


        }


    }
    static char checkWin (char[][] dataGrid ){
        char Win = 'N';
        //horizontal win check
        for (int i = 0; i < 3; i++) {
            if( dataGrid[0][i] == dataGrid[1][i] && dataGrid[0][i] == dataGrid[2][i]  && dataGrid[0][i] != '*') {
                Win = dataGrid[0][i];
            }
        }

        //vertical win check
        for (int i = 0; i < 3; i++) {
            if( dataGrid[i][0] == dataGrid[i][1] && dataGrid[i][0] == dataGrid[i][2]  & dataGrid[i][0] != '*') {
                Win = dataGrid[i][0];
            }
        }

        //diagonal up win
        if( dataGrid[1][1] == dataGrid[0][2] && dataGrid[1][1] == dataGrid[2][0] && dataGrid[1][1] != '*'){
            Win = dataGrid[1][1];
        }

        //diagonal down win
        if( dataGrid[1][1] == dataGrid[0][0] && dataGrid[1][1] == dataGrid[2][2] && dataGrid[1][1] != '*'){
            Win = dataGrid[1][1];
        }


        //draw game check



        return Win;
    }

    static int numpadToCol(int np){
        int moveCol = 0;
        if (np == 7) {
            moveCol = 0;
        } else if (np == 8) {
            moveCol = 0;
        } else if (np == 9) {
            moveCol = 0;
        } else if (np == 4) {
            moveCol = 1;
        } else if (np == 5) {
            moveCol = 1;
        } else if (np == 6) {
            moveCol = 1;
        } else if (np == 1) {
            moveCol = 2;
        } else if (np == 2) {
            moveCol = 2;
        } else if (np == 3) {
            moveCol = 2;
        }
        return moveCol;
    }
    static int numpadToRow(int np){
        int moveRow = 0;
        if (np == 7) {
            moveRow = 0;
        } else if (np == 8) {
            moveRow = 1;
        } else if (np == 9) {
            moveRow = 2;
        } else if (np == 4) {
            moveRow = 0;
        } else if (np == 5) {
            moveRow = 1;
        } else if (np == 6) {
            moveRow = 2;
        } else if (np == 1) {
            moveRow = 0;
        } else if (np == 2) {
            moveRow = 1;
        } else if (np == 3) {
            moveRow = 2;
        }
        return moveRow;
    }
    static void printGame(char[][] gameData){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                System.out.print(gameData[i][j]);
                System.out.print("  ");
            }
            System.out.print('\n');
        }
    }

}

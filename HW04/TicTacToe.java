//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

public class TicTacToe {


    // Place your methods here
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int player = TicTacToe.getNumberPlayers(scan);
        if (player == 1) {
            TicTacToe.onePlayerGame(scan);
        } else if (player == 2) {
            TicTacToe.twoPlayersGame(scan);
        }

        //Continue the game?

    }

    public static void onePlayerGame(Scanner sc) {
        Board newBoard = new Board();
        while (newBoard.getGameState() == (GameState.ONGOING)) {

            Location loc;
            loc = TicTacToe.getInput("1", sc);
            if (newBoard.checkLocation(loc)) {
                if (newBoard.placeSign(loc, 'X')) {
                    System.out.println(newBoard);
                }
            } else {
                continue;
            }

            if (newBoard.getGameState() == GameState.ONGOING) {
                System.out.println("The Computer is making a move...");
                boolean log = false;
                while (!log) {
                    Location compLocation = new Location((int) (Math.random() * 3), (int) (Math.random() * 3));
                    if (newBoard.checkLocation(compLocation)) {
                        log = newBoard.placeSign(compLocation, 'O');
                    }
                }
                System.out.println(newBoard);
            }
        }
        switch (newBoard.getGameState()) {
        case PLAYER1_WIN:
            System.out.println("Player 1 wins! ");
            break;
        case PLAYER2_WIN:
            System.out.println("Player 2 wins! ");
            break;
        default:
            System.out.println("It's a tie! ");
            break;
        }
    }


    public static void twoPlayersGame(Scanner sc) {
        Board newBoard = new Board();
        Location loc1;
        Location loc2;
        boolean player1 = true;
        while (newBoard.getGameState() == GameState.ONGOING) {
            if (player1) {
                loc1 = TicTacToe.getInput("1", sc);
                if (newBoard.checkLocation(loc1)) {
                    if (newBoard.placeSign(loc1, 'X')) {
                        System.out.println(newBoard);
                        player1 = !player1;
                    }
                } else {
                    continue;
                }
            } else {
                if (newBoard.getGameState() == (GameState.ONGOING)) {
                    loc2 = TicTacToe.getInput("2", sc);
                    if (newBoard.checkLocation(loc2)) {
                        if (newBoard.placeSign(loc2, 'O')) {
                            System.out.println(newBoard);
                            player1 = !player1;
                        }
                    } else {
                        continue;
                    }
                }
            }

        }
        switch (newBoard.getGameState()) {
        case PLAYER1_WIN:
            System.out.println("Player 1 wins! ");
            break;
        case PLAYER2_WIN:
            System.out.println("Player 2 wins! ");
            break;
        default:
            System.out.println("It's a tie! ");
            break;
        }
    }

    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/

   /**
     * Gets number of players from command line
     * @param sc        for reading from command-line
     * @return number of players (always 1 or 2)
     */
    private static int getNumberPlayers(Scanner sc) {
        boolean repeatPrompt = true;
        int numPlayers = 0;
        while (repeatPrompt) {
            System.out.print("How many players (1 or 2)? ");
            String input = sc.next();
            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    repeatPrompt = false;
                } else {
                    System.out.println("Enter 1 or 2 players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please only enter a number.");
            }
        }
        return numPlayers;
    }

   /**
     * Handles scanner calls and user input
     * @param player    whose turn it is
     * @param sc        for reading from command-line
     * @return int[] holding row, column in that order
     */
    private static Location getInput(String player, Scanner sc) {
        boolean repeatPrompt = true;
        int row = -1;
        int col = -1;
        while (repeatPrompt) {
            System.out.print("Enter desired square for " + player + ": ");
            String input = sc.next();
            input = input.trim();
            String[] splitInput = input.split(",");
            try {
                row = Integer.parseInt(splitInput[0]);
                col = Integer.parseInt(splitInput[1]);
                repeatPrompt = false;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please follow the format 'row,col'; for ex '1,2'");
            }
        }
        Location loc = new Location(row, col);
        return loc;
    }

}



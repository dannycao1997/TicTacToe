package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private final Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        return isPlayerWinning('X');
    }

    public Boolean isInFavorOfO() {
        return isPlayerWinning('O');
    }

    public Boolean isTie() {
        return !isInFavorOfX() && !isInFavorOfO();
    }

    public String getWinner() {
        if (isInFavorOfX()) {
            return "X";
        } else if (isInFavorOfO()) {
            return "O";
        } else {
            return null;
        }
    }


    private boolean isPlayerWinning(char player) {
        return checkRows(player) || checkColumns(player) || checkDiagonals(player);
    }

    private boolean checkRows(char player) {
        for (int row = 0; row < 3; row++) {
            if (matrix[row][0] == player && matrix[row][1] == player && matrix[row][2] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char player) {
        for (int col = 0; col < 3; col++) {
            if (matrix[0][col] == player && matrix[1][col] == player && matrix[2][col] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char player) {
        return (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player) ||
                (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player);
    }
}

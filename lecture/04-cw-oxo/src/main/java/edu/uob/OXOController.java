// NOTE: manage rules / change rules
package edu.uob;

import java.io.Serial;
import java.io.Serializable;

public class OXOController implements Serializable {
    @Serial private static final long serialVersionUID = 1;
    OXOModel gameModel;

    public OXOController(OXOModel model) {
        gameModel = model;
    }

    public void handleIncomingCommand(String command) throws OXOMoveException {
        String formatCommand = command.toLowerCase();
        // separate a&1
        int rowNum = formatCommand.charAt(0) - 97;
        int colNum = formatCommand.charAt(1) - '0' - 1; // -1 to index

        // render what player input on the right position
        int currentPlayerNumber = gameModel.getCurrentPlayerNumber();
        OXOPlayer currentPlayer = gameModel.getPlayerByNumber(currentPlayerNumber);
        System.out.println("Current player : " + currentPlayer.getPlayingLetter());

        // if condition to decide where to draw in the 2D array list -> set cell owner
        // draw? -> after setting cellOwner, it will draw automatically!!
        gameModel.setCellOwner(rowNum, colNum, currentPlayer);

        // change player
        if(currentPlayerNumber == 0) gameModel.setCurrentPlayerNumber(1);
        else gameModel.setCurrentPlayerNumber(0);
        checkForWinOrDraw();
    }

    public void addRow() {
        gameModel.addRow();
        this.increaseWinThreshold();
    }

    public void removeRow() {
        gameModel.removeRow();
        this.decreaseWinThreshold();
    }

    public void addColumn() {
        gameModel.addColumn();
        this.increaseWinThreshold();
    }

    public void removeColumn() {
        gameModel.removeColumn();
        this.decreaseWinThreshold();
    }

    public void increaseWinThreshold() {
        gameModel.setWinThreshold(gameModel.getWinThreshold() + 1);
    }
    public void decreaseWinThreshold() {
        gameModel.setWinThreshold(gameModel.getWinThreshold() - 1);
    }

    public void reset() {
        // detect `Esc` key -> already defined in keyReleased method
        // set CellOwner to 0
        int rows = gameModel.getNumberOfRows();
        int cols = gameModel.getNumberOfColumns();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                gameModel.setCellOwner(i, j, null);
            }
        }
    }



    public void checkForWinOrDraw(){
        int rows = gameModel.getNumberOfRows();
        System.out.println("Number of rows : " + rows);
        int cols = gameModel.getNumberOfColumns();
        System.out.println("Number of columns : " + cols);
        int threshold = gameModel.getWinThreshold();

        OXOPlayer winner = null;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                OXOPlayer current = gameModel.getCellOwner(i, j);
                if(current != null){
                    if (checkDirection(i, j, 0, 1, threshold, current) ||
                        checkDirection(i, j, 1, 0, threshold, current) ||
                        checkDirection(i, j, 1, 1, threshold, current) ||
                        checkDirection(i, j, -1, 1, threshold, current)
                    ) {
                        winner = current;
                        break;
                    }
                }
            }
            if(winner != null){
                break;
            }
        }
        if(winner != null){
            gameModel.setWinner(winner);
            System.out.println("We have a winner: " + winner);
        } else if(isBoardFull()){
            gameModel.setGameDrawn(true);
            System.out.println("The game is a draw");
        }



    }


    /**
     * Checks from a starting cell (row, col) in the direction specified by (rowInc, colInc)
     * for a consecutive sequence of cells owned by the same player.
     *
     * @param row       The starting row index.
     * @param col       The starting column index.
     * @param rowInc    The row increment (e.g., 0 for horizontal, 1 for vertical).
     * @param colInc    The column increment.
     * @param threshold The number of consecutive marks required to win.
     * @param player    The player to check for.
     * @return true if a winning sequence is found, false otherwise.
     */
    public boolean checkDirection(int row, int col, int rowInc, int colInc, int threshold, OXOPlayer player){
        int count = 0;
        int rows = gameModel.getNumberOfRows();
        int cols = gameModel.getNumberOfColumns();
        int r = row;
        int c = col;
        while(r >= 0 && r < rows &&  c>= 0 && c < cols && gameModel.getCellOwner(r, c) == player){
            count++;
            r += rowInc;
            c += colInc;
        }
        return count >= threshold;
    }

    private boolean isBoardFull(){
        int rows = gameModel.getNumberOfRows();
        int cols = gameModel.getNumberOfColumns();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(gameModel.getCellOwner(i,j) == null){
                    return false;
                }
            }
        }
        return true;
    }
}

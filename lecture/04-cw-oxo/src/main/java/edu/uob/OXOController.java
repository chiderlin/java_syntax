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

    }
    public void addRow() {
        gameModel.addRow();
    }
    public void removeRow() {
        gameModel.removeRow();
    }
    public void addColumn() {
        gameModel.addColumn();
    }
    public void removeColumn() {
        gameModel.removeColumn();
    }
    public void increaseWinThreshold() {}
    public void decreaseWinThreshold() {}
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
}

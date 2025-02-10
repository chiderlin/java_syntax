// NOTE: Basic Game setting  (core data structures)
package edu.uob;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;


public class OXOModel implements Serializable {
    @Serial private static final long serialVersionUID = 1;
//    private OXOPlayer[][] cells;
    private List<List<OXOPlayer>> cells = new ArrayList<>();
    private OXOPlayer[] players;
    private int currentPlayerNumber;
    private OXOPlayer winner;
    private boolean gameDrawn;
    private int winThreshold;

    public OXOModel(int numberOfRows, int numberOfColumns, int winThresh) {
        winThreshold = winThresh;
//        cells = new OXOPlayer[numberOfRows][numberOfColumns];
        for(int i=0; i< numberOfRows; i++){
            ArrayList<OXOPlayer> row = new ArrayList<>();
            for(int j=0; j< numberOfColumns; j++){
              row.add(null);
            }
            cells.add(row);
        }
        // System.out.println(cells.size()); // row size
        // System.out.println(cells.get(0).size()); // col size
        players = new OXOPlayer[2];
    }

    public int getNumberOfPlayers() {
        return players.length;
    }

    public void addPlayer(OXOPlayer player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

    public OXOPlayer getPlayerByNumber(int number) {
        return players[number];
    }

    public OXOPlayer getWinner() {
        return winner;
    }

    public void setWinner(OXOPlayer player) {
        winner = player;
    }

    public int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

    public void setCurrentPlayerNumber(int playerNumber) {
        currentPlayerNumber = playerNumber;
    }

    public int getNumberOfRows() {

//        return cells.length;
        return cells.size();
    }

    public int getNumberOfColumns() {
//        return cells[0].length;
        return cells.isEmpty() ? 0 : cells.get(0).size();
    }

    public OXOPlayer getCellOwner(int rowNumber, int colNumber) {
//        return cells[rowNumber][colNumber];
        return cells.get(rowNumber).get(colNumber);
    }


    public void setCellOwner(int rowNumber, int colNumber, OXOPlayer player) {
//        cells[rowNumber][colNumber] = player;
        cells.get(rowNumber).set(colNumber, player);
    }


    public void addColumn(){
        for(List<OXOPlayer> row: cells){
            row.add(null);
        }
    }

    public void addRow(){
        int currentColumns = getNumberOfColumns();
        List<OXOPlayer> newRow = new ArrayList<>();

        // Initialize the new row with null values for each column.
        for(int j=0; j<currentColumns; j++){
            newRow.add(null);
        }
        cells.add(newRow);
    }

    public void removeColumn(){
        if(getNumberOfColumns() > 0) {
            for(List<OXOPlayer> row: cells){
                row.remove(row.size()-1);
            }
        }
    }

    public void removeRow(){
        if(getNumberOfRows()>0){
            cells.remove(cells.size()-1);
        }
    }


    public void setWinThreshold(int winThresh) {
        winThreshold = winThresh;
    }

    public int getWinThreshold() {
        return winThreshold;
    }

    public void setGameDrawn(boolean isDrawn) {
        gameDrawn = isDrawn;
    }

    public boolean isGameDrawn() {
        return gameDrawn;
    }

}

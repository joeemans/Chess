/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

public class Queen extends Piece {

    public Queen(String type, ChessAlphabet position, String color) {
        super(type, position, color);

    }

    @Override
    boolean isValidMove(Board board, ChessAlphabet start, ChessAlphabet end) {
        int row = start.getRank();
        int column = start.getFile();
        int Drow = end.getRank();
        int Dcolumn = end.getFile();
        //checking that queen movement is valid and that we have a piece at starting square
        if ((row == Drow || column == Dcolumn || Math.abs(row - Drow) == Math.abs(column - Dcolumn)) && board.positions[row][column].isOccupied) {
            int rowDirection = Drow > row ? 1 : (Drow < row ? -1 : 0);
            int columnDirection = Dcolumn > column ? 1 : (Dcolumn < column ? -1 : 0);
            int Crow = row + rowDirection;
            int Ccolumn = column + columnDirection;
            //we need to check first if path is clear
            while (Crow != Drow || Ccolumn != Dcolumn) {
                if (board.positions[Crow][Ccolumn].isOccupied) {
                    return false;
                }
                Crow += rowDirection;
                Ccolumn += columnDirection;
            }
            //now we have finished checking the path, time to check if target square is empty
            if (!board.positions[Drow][Dcolumn].isOccupied) {
                return true;
            } //queen takes
            if ((board.positions[row][column].piece.isWhite && !board.positions[Drow][Dcolumn].piece.isWhite) ||
                (!board.positions[row][column].piece.isWhite && board.positions[Drow][Dcolumn].piece.isWhite)) {
                return true;
            }

        }
        return false;
    }

}

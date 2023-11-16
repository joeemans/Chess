/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author LEGION
 */
public class Bishop extends Piece{
    public Bishop(String type, ChessAlphabet position, String color)
    {
        super(type,position,color);
        
    }

    @Override
    boolean isValidMove(Board board, ChessAlphabet start, ChessAlphabet end) {
    int row = start.getRank();
    int column = start.getFile();
    int Drow = end.getRank();
    int Dcolumn = end.getFile();
    //checking for diagonal movement and if starting block is occupied so that we have a piece to move
    if(Math.abs(Drow-row) == Math.abs(Dcolumn-column) && board.positions[row][column].isOccupied)
    {
        int rowDirection = Drow > row ? 1 : -1 ;
        int columnDirection =  Dcolumn > row ? 1 : -1;
        int Crow = row + rowDirection;
        int Ccolumn = column + columnDirection;
        //iterating over the pieces till the location to check if any of squares in the path are occupied
        while(Crow != Drow)//we can add the column too but we already checked that they are equal in difference so no need
        {
            if (board.positions[Crow][Ccolumn].isOccupied)
                return false;
            Crow += rowDirection;
            Ccolumn += columnDirection;
        }
        //now the path is clear, we need to check if destination square is occupied
        if(!board.positions[Drow][Dcolumn].isOccupied)
            return true;
        //bishop takes//board.positions[row][column].piece.isWhite
        if((board.positions[row][column].piece.isWhite && !board.positions[Drow][Dcolumn].piece.isWhite) ||
                (!board.positions[row][column].piece.isWhite && board.positions[Drow][Dcolumn].piece.isWhite))
                return true;
    }
    return false;
    }
    
}

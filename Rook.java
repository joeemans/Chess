package chess;


public class Rook extends Piece {
    private boolean hasMoved;//this is needed for the castle move

    /**
     *
     * @param type
     * @param position
     * @param color
     */
    public Rook(String type, ChessAlphabet position, String color)
    {
        super(type,position,color);
        
    }
    
    public void setHasMoved() {
        hasMoved = true;
    }

    @Override
    boolean isValidMove(Board board, ChessAlphabet start, ChessAlphabet end) {
    int row = start.getRank();
    int column = start.getFile();
    int Drow = end.getRank();
    int Dcolumn = end.getFile();
    //checking for valid rook movement, and that we have a piece at starting square
    if ((row == Drow || column == Dcolumn) && board.positions[row][column].isOccupied)
    {
        int rowDirection = Drow > row ? 1 : (Drow < row ? -1 : 0);
        int columnDirection = Dcolumn > column ? 1 : (Dcolumn < column ? -1 : 0);
        int Crow = row + rowDirection;
        int Ccolumn = column + columnDirection;
        //iterating over the squares in the path to check if they are occupied
        while (Crow != Drow || Ccolumn != Dcolumn) {
                if (board.positions[Crow][Ccolumn].isOccupied) {
                    return false;
                }
                Crow += rowDirection;
                Ccolumn += columnDirection;
            }
        //now we have checked that path is clear, time to check if destination is occupied
        if (!board.positions[Drow][Dcolumn].isOccupied) {
                return true;
        }
        //rook takes
        if ((board.positions[row][column].piece.isWhite && !board.positions[Drow][Dcolumn].piece.isWhite) ||
                (!board.positions[row][column].piece.isWhite && board.positions[Drow][Dcolumn].piece.isWhite)) {
                return true;
            }
    }
    return false;
    }
    
    
}

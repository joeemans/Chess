package chess;

public class Pawn extends Piece {

    private boolean hasMoved;//needed for en passant

    public Pawn(String type, ChessAlphabet position, String color) {
        super(type, position, color);

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
        int direction = isWhite ? 1 : -1;
        //checking first starting block is occupied so that we have a piece to move
        if (board.positions[row][column].isOccupied) {
            //pawn moving upwards
            if (column == Dcolumn && Drow == row + direction && !board.positions[Drow][Dcolumn].isOccupied) {
                return true;
            }
            //pawn moving upwards by 2 as first move
            if (column == Dcolumn && Drow == row + 2 * direction && !board.positions[Drow][Dcolumn].isOccupied && !board.positions[row + direction][column + direction].isOccupied & !hasMoved) {
                return true;
            }
            //pawn captures
            if (Math.abs(column - Dcolumn) == 1 && row + direction == Drow && board.positions[Drow][Dcolumn].isOccupied) {
                if (board.positions[Drow][Dcolumn].piece.isWhite && !board.positions[row][column].piece.isWhite) {
                    return true;
                }
                if (!board.positions[Drow][Dcolumn].piece.isWhite && board.positions[row][column].piece.isWhite) {
                    return true;
                }
            }
        }
        return false;
    }
}

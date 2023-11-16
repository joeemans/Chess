
package chess;


public class King extends Piece{
    public King(String type, ChessAlphabet position, String color)
    {
        super(type, position,color);
        
    }

    

    @Override
    boolean isValidMove(Board board, ChessAlphabet start, ChessAlphabet end) {
        return false;
    }
    
    
}

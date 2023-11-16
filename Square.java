
package chess;

/**
 *
 * @author youss
 */
public class Square {
    boolean isOccupied;
    Piece piece;
    
    public Square(Piece piece){
        this.piece = piece;
        isOccupied = true;       
    }
    
    public void clearSquare(){
        this.isOccupied = false;
        piece=null;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chess;

/**
 *
 * @author youss
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidMoveException, InvalidSyntaxException{
        // TODO code application logic here
        ChessGame chessGame = new ChessGame();
        chessGame.loadGame("ChessGame.txt");
    }
}
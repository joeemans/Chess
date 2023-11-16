package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {

    Square[][] positions = new Square[8][8];
    int turn = 0;
    boolean whiteTurn;

    public Board() {
        initializeGame();
    }

    private void initializeGame() {
        King whiteKing = new King("king", ChessAlphabet.e1, "white");
        positions[ChessAlphabet.e1.getRank()][ChessAlphabet.e1.getFile()] = new Square(whiteKing);
        King BlackKing = new King("king", ChessAlphabet.e8, "black");
        positions[ChessAlphabet.e8.getRank()][ChessAlphabet.e8.getFile()] = new Square(BlackKing);
        Rook whiteRook1 = new Rook("rook", ChessAlphabet.a1, "white");
        positions[ChessAlphabet.a1.getRank()][ChessAlphabet.a1.getFile()] = new Square(whiteRook1);
        Rook whiteRook2 = new Rook("rook", ChessAlphabet.h1, "white");
        positions[ChessAlphabet.h1.getRank()][ChessAlphabet.h1.getFile()] = new Square(whiteRook2);
        Rook blackRook1 = new Rook("rook", ChessAlphabet.a8, "black");
        positions[ChessAlphabet.a8.getRank()][ChessAlphabet.a8.getFile()] = new Square(blackRook1);
        Rook blackRook2 = new Rook("rook", ChessAlphabet.h8, "black");
        positions[ChessAlphabet.h8.getRank()][ChessAlphabet.h8.getFile()] = new Square(blackRook2);
        Bishop whiteBishop1 = new Bishop("bishop", ChessAlphabet.c1, "white");
        positions[ChessAlphabet.c1.getRank()][ChessAlphabet.c1.getFile()] = new Square(whiteBishop1);
        Bishop whiteBishop2 = new Bishop("bishop", ChessAlphabet.f1, "white");
        positions[ChessAlphabet.f1.getRank()][ChessAlphabet.f1.getFile()] = new Square(whiteBishop2);
        Bishop blackBishop1 = new Bishop("bishop", ChessAlphabet.c8, "black");
        positions[ChessAlphabet.c8.getRank()][ChessAlphabet.c8.getFile()] = new Square(blackBishop1);
        Bishop blackBishop2 = new Bishop("bishop", ChessAlphabet.f8, "black");
        positions[ChessAlphabet.f8.getRank()][ChessAlphabet.f8.getFile()] = new Square(blackBishop2);
        Knight whiteKnight1 = new Knight("knight", ChessAlphabet.b1, "white");
        positions[ChessAlphabet.b1.getRank()][ChessAlphabet.b1.getFile()] = new Square(whiteKnight1);
        Knight whiteKnight2 = new Knight("knight", ChessAlphabet.g1, "white");
        positions[ChessAlphabet.g1.getRank()][ChessAlphabet.g1.getFile()] = new Square(whiteKnight2);
        Knight blackKnight1 = new Knight("knight", ChessAlphabet.b8, "black");
        positions[ChessAlphabet.b8.getRank()][ChessAlphabet.b8.getFile()] = new Square(blackKnight1);
        Knight blackKnight2 = new Knight("knight", ChessAlphabet.b1, "black");
        positions[ChessAlphabet.b1.getRank()][ChessAlphabet.b1.getFile()] = new Square(blackKnight2);
        Queen whiteQueen = new Queen("queen", ChessAlphabet.d1, "white");
        positions[ChessAlphabet.d1.getRank()][ChessAlphabet.d1.getFile()] = new Square(whiteQueen);
        Queen blackQueen = new Queen("queen", ChessAlphabet.d8, "black");
        positions[ChessAlphabet.d8.getRank()][ChessAlphabet.d8.getFile()] = new Square(blackQueen);

        for (int i = 0; i < 8; i++) {
            positions[1][i].piece = new Pawn("pawn", ChessAlphabet.getChessAlphabet(1, i), "white");
            positions[6][i].piece = new Pawn("pawn", ChessAlphabet.getChessAlphabet(6, i), "black");

        }
    }

    public void movePiece(ChessAlphabet start, ChessAlphabet end) throws InvalidMoveException {
        //check we have a piece to move
        if (!positions[start.getRank()][start.getFile()].isOccupied) {
            throw new InvalidMoveException("No piece is currently at the starting square!");
        }
        Piece piece = positions[start.getRank()][start.getFile()].piece;
        //check is is white turn and piece to move is white
        if ((turn % 2 == 0 && !piece.isWhite) || (turn % 2 != 0 && piece.isWhite)) {
            throw new InvalidMoveException("It is not the player's turn to move");
        }
        //check if move is valid
        if (!piece.isValidMove(this, start, end)) {
            throw new InvalidMoveException("Illegal move for selected piece");
        }
        //now our validations are done, time to move the piece
        if (positions[end.getRank()][end.getFile()] == null) {
            positions[end.getRank()][end.getFile()] = new Square(positions[start.getRank()][start.getFile()].piece);
        } else {
            positions[end.getRank()][end.getFile()].piece = positions[start.getRank()][start.getFile()].piece;
        }
        positions[start.getRank()][start.getFile()].clearSquare();

        turn += 1;
        //time to set the hasMoved boolean for pawn and rook (cuz they are needed for our special movements
        if (piece instanceof Pawn) {
            ((Pawn) piece).setHasMoved();
        } else if (piece instanceof Rook) {
            ((Rook) piece).setHasMoved();
        }
    }

    public List<Square> getAllValidMovesFromSquare(ChessAlphabet square) throws InvalidMoveException {
        List<Square> validMoves = new ArrayList<Square>();
        //check we have a piece to move
        if (!positions[square.getRank()][square.getFile()].isOccupied) {
            throw new InvalidMoveException("No piece is currently at the starting square!");
        }
        Piece piece = positions[square.getRank()][square.getFile()].piece;
        //check is is white turn and piece to move is white
        if ((turn % 2 == 0 && !piece.isWhite) || (turn % 2 != 0 && piece.isWhite)) {
            throw new InvalidMoveException("It is not the player's turn to move");
        }
        return validMoves;
    }
}

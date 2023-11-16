package chess;

import java.util.logging.Logger;

abstract class Piece {

    String type;
    ChessAlphabet position;
    String color;
    boolean isWhite;

    public Piece(String type, ChessAlphabet position, String color) {
        setType(type);
        setPosition(position);
        setColor(color);
        if (color.equals("white"))
            isWhite = true;
        else isWhite = false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPosition(ChessAlphabet position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public ChessAlphabet getPosition() {
        return position;
    }

    abstract boolean isValidMove(Board board, ChessAlphabet start, ChessAlphabet end);

}

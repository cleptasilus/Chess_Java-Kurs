package pieces;

import game.CurrentBoard;
import board.Square;

public abstract class Piece extends board.Chessboard {
	String colour;
	Square position;
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	CurrentBoard board;
	boolean hasmoved;
	// TODO
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Square getPosition() {
		return position;
	}

	public void setPosition(Square position) {
		this.position = position;
	}
}

package pieces;
import game.CurrentBoard;
import board.Square;
public class Piece extends board.Chessboard {
	String colour;
	Square position;
	CurrentBoard board; 
//TODO 
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

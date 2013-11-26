package pieces;

import board.Square;

public class Rook extends Piece implements Moveable{
boolean	hasmoved;
	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		hasmoved=true;
		this.setPosition(target);
		System.out.println("R"+ (this.position.toString()));
	}
	public Rook(String colour, Square position){
		this.colour=colour;
		this.position=position;
	}
	@Override
	public String toString() {

		return colour + " Rook on " +  position.toString();
	}
//TODO
}

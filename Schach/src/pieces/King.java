package pieces;

import board.Square;

public class King extends Piece implements Moveable{
boolean hasmoved;
boolean ischecked;
	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		this.setPosition(target);
		System.out.println("K" + (this.position.toString()));	
		hasmoved = true;
	}
	public King(String colour, Square position){
		this.colour=colour;
		this.position=position;
	}
	@Override
	public String toString() {

		return colour + " King on " +  position.toString();
	}
//TODO
}

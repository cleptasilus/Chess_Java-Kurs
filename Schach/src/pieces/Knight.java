package pieces;

import board.Square;

public class Knight extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		this.setPosition(target);
		System.out.println("N" + (this.position.toString()));
	
	}
	public Knight(String colour, Square position){
		this.colour=colour;
		this.position=position;
	}
	@Override
	public String toString() {

		return colour + " Knight on " +  position.toString();
	}
//TODO

}

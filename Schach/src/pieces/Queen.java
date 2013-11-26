package pieces;

import board.Square;

public class Queen extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		
		this.setPosition(target);
		System.out.println("Q"+ (this.position.toString()));
	
	}
	
	public Queen(String colour, Square position){
		this.colour=colour;
		this.position=position;
	}
	@Override
	public String toString() {

		return colour + " Queen on " +  position.toString();
	}
//TODO
}

package pieces;

import board.Square;

public class Pawn extends Piece implements Moveable{


	
	public void transform(){
		
	}
	//TODO

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		this.setPosition(target);
		System.out.println((this.position.toString()));
	
	}
	public Pawn(String colour, Square position){
		this.colour=colour;
		this.position=position;
	}
	@Override
	public String toString() {

		return colour + " Pawn on " +  position.toString();
	}
}

package board;

import pieces.Piece;

public class Square extends Chessboard{
	int positionx=0;
	int positiony=0;
	boolean isOccupied;
	public Piece OccupiyingPiece;
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public Square(int positionx, int positiony){
		this.positionx=positionx;
		this.positiony=positiony;
	}
	public Square(){
	}
	@Override
	public String toString() {
		String temp;
		switch(getPositionx()){
		case 1:
			temp="a";
			break;
		case 2:
			temp="b";
			break;
		case 3:
			temp="c";
			break;
		case 4:
			temp="d";
			break;
		case 5:
			temp="e";
			break;
		case 6:
			temp="f";
			break;
		case 7:
			temp="g";
			break;
		case 8:
			temp="h";
			break;
		default:
			return "ERROR";
		}
		return temp + getPositiony();
	}
	public int getPositionx() {
		return positionx;
	}
	public void setPositionx(int positionx) {
		this.positionx = positionx;
	}
	public int getPositiony() {
		return positiony;
	}
	public void setPositiony(int positiony) {
		this.positiony = positiony;
	}
}

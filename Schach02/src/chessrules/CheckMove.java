package chessrules;

import game.CurrentBoard;
import board.Square;

public class CheckMove {
	public boolean canCapture(Square start, Square target){
		if (target.OccupiyingPiece.getColour() == start.OccupiyingPiece
				.getColour()) {
			System.out
					.println("Du kannst keine eigene Figur schlagen!");
			return false;
		}
		return true;
	}

	public boolean MoveLegal(CurrentBoard board, Square start, Square target){
		//Prüft ob der Weg frei ist
		PathClear clear = new PathClear();
		if (clear.isClear(board, start, target)) {
			
			//Wenn der Weg frei ist, prüfe ob Ziel belegt
			if (target.isOccupied()) {

				//Prüfung andere Farbe Ja/Nein
				CheckMove capture = new CheckMove();
				if (capture.canCapture(start, target)) {
					target.OccupiyingPiece
							.setPosition(board.Squares[0][0]);
				} else {
					return false;
				}
			}

			return true;
		}
		return false;
		
		
	}
	public boolean MoveLegalNoCapture(CurrentBoard board, Square start, Square target){
		//Prüft ob der Weg frei ist
		PathClear clear = new PathClear();
		if (clear.isClear(board, start, target)) {
			
			//Wenn der Weg frei ist, prüfe ob Ziel belegt
			if (target.isOccupied()) {

				//Prüfung andere Farbe Ja/Nein
				CheckMove capture = new CheckMove();
				if (capture.canCapture(start, target)) {

				} else {
					return false;
				}
			}

			return true;
		}
		return false;
		
		
	}

}

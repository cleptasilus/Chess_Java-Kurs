package chessrules;

import game.CurrentBoard;
import board.Square;
import pieces.*;
public class PawnMovement {
	
	public boolean MovePawn(CurrentBoard board, Square start, Square target) {
		if ((start.OccupiyingPiece.getColour() == "White"
				&& target.getPositiony() == start.getPositiony() + 1 && !target
					.isOccupied() && target.getPositionx()==start.getPositionx())
				|| (start.OccupiyingPiece.getColour() == "Black"
						&& target.getPositiony() == start.getPositiony() - 1 && !target
							.isOccupied() && target.getPositionx()==start.getPositionx())
				|| (start.OccupiyingPiece.getColour() == "White"
						&& target.isOccupied()
						&& ((target.getPositionx() == start.getPositionx() + 1) || (target
								.getPositionx() == start.getPositionx() - 1)) && target
						.getPositiony() == start.getPositiony() + 1)
				|| (start.OccupiyingPiece.getColour() == "Black"
						&& target.isOccupied()
						&& ((target.getPositionx() == start.getPositionx() + 1) || (target
								.getPositionx() == start.getPositionx() - 1)) && target
						.getPositiony() == start.getPositiony() - 1)) {
			if (target.isOccupied()) {
				CheckMove check = new CheckMove();
				return check.canCapture(start, target);
			}
			return true;
		}
		return false;

	}

	public boolean MovePawn2(CurrentBoard board, Square start, Square target) {
		if ((start.OccupiyingPiece.getColour() == "White"
				&& target.getPositiony() == start.getPositiony() + 2
				&& !target.isOccupied() && start.getPositiony() == 2)
				|| (start.OccupiyingPiece.getColour() == "Black"
						&& target.getPositiony() == start.getPositiony() - 2
						&& !target.isOccupied() && start.getPositiony() == 7)) {
			CheckMove check = new CheckMove();
			return check.MoveLegal(board, start, target);

		}
		return false;
	}
	public boolean MovePawn3(CurrentBoard board, Square start, Square target){if((start.OccupiyingPiece.getColour() == "White"
			&& ((target.getPositionx() == start.getPositionx() + 1) || (target
					.getPositionx() == start.getPositionx() - 1)) && target
			.getPositiony() == start.getPositiony() + 1)
	|| (start.OccupiyingPiece.getColour() == "Black"
			&& ((target.getPositionx() == start.getPositionx() + 1) || (target
					.getPositionx() == start.getPositionx() - 1)) && target
			.getPositiony() == start.getPositiony() - 1)) {
		return true;
	}
	return false;	
	}

	public boolean CheckPawn(CurrentBoard board, Square start, Square target) {
		if ((start.OccupiyingPiece.getColour() == "White"
				&& target.isOccupied()
				&& ((target.getPositionx() == start.getPositionx() + 1) || (target
						.getPositionx() == start.getPositionx() - 1)) && target
				.getPositiony() == start.getPositiony() + 1)
				|| (start.OccupiyingPiece.getColour() == "Black"
						&& target.isOccupied()
						&& ((target.getPositionx() == start.getPositionx() + 1) || (target
								.getPositionx() == start.getPositionx() - 1)) && target
						.getPositiony() == start.getPositiony() - 1)) {
				return true;
			}
		return false;
	}
	public boolean CheckPawn2(CurrentBoard board, Square start, Square target, Square movedpiecestart, Square movedpiecetarget) {
		if ((start.OccupiyingPiece.getColour() == "White"
				&& target.isOccupied()
				&& ((target.getPositionx() == start.getPositionx() + 1) || (target
						.getPositionx() == start.getPositionx() - 1)) && target
				.getPositiony() == start.getPositiony() + 1)
				|| (start.OccupiyingPiece.getColour() == "Black"
						&& target.isOccupied()
						&& ((target.getPositionx() == start.getPositionx() + 1) || (target
								.getPositionx() == start.getPositionx() - 1)) && target
						.getPositiony() == start.getPositiony() - 1)) {
			if(!(movedpiecestart.OccupiyingPiece.getName()=="K")){
				return true;
			}
			else if(((start.OccupiyingPiece.getColour() == "White"
					&& movedpiecetarget.isOccupied()
					&& ((movedpiecetarget.getPositionx() == start.getPositionx() + 1) || (movedpiecetarget
							.getPositionx() == start.getPositionx() - 1)) && target
					.getPositiony() == start.getPositiony() + 1)
					|| (start.OccupiyingPiece.getColour() == "Black"
							&& movedpiecetarget.isOccupied()
							&& ((movedpiecetarget.getPositionx() == start.getPositionx() + 1) || (movedpiecetarget
									.getPositionx() == start.getPositionx() - 1)) && movedpiecetarget
							.getPositiony() == start.getPositiony() - 1))){
				return true;
				
			}

			}
		return false;
	}
	public void transform(CurrentBoard board, Square transsquare, String desiredpiece){
		String tempcolour;
		switch(desiredpiece){
		case "Q":
			tempcolour = transsquare.OccupiyingPiece.getColour();
			transsquare.OccupiyingPiece.setPosition(board.Squares[0][0]);
			board.transformedQ[board.transcount]=new Queen(board, tempcolour, transsquare);
			board.pieces.add(board.transformedQ[board.transcount]);
			board.transcount++;
			break;
		case "N":
			tempcolour = transsquare.OccupiyingPiece.getColour();
			transsquare.OccupiyingPiece.setPosition(board.Squares[0][0]);
			board.transformedN[board.transcount]=new Knight(board, tempcolour, transsquare);
			board.pieces.add(board.transformedN[board.transcount]);
			board.transcount++;
			break;
		case "B":
			tempcolour = transsquare.OccupiyingPiece.getColour();
			transsquare.OccupiyingPiece.setPosition(board.Squares[0][0]);
			board.transformedB[board.transcount]=new Bishop(board, tempcolour, transsquare);
			board.pieces.add(board.transformedB[board.transcount]);
			board.transcount++;
			break;
		case "R":	
			tempcolour = transsquare.OccupiyingPiece.getColour();
			transsquare.OccupiyingPiece.setPosition(board.Squares[0][0]);
			board.transformedR[board.transcount]=new Rook(board, tempcolour, transsquare);
			board.pieces.add(board.transformedR[board.transcount]);
			board.transcount++;
			break;
		}
	}
}
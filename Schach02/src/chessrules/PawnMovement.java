package chessrules;

import game.CurrentBoard;
import board.Square;

public class PawnMovement {
	public boolean MovePawn(CurrentBoard board, Square start, Square target) {
		if ((start.OccupiyingPiece.getColour() == "White"
				&& target.getPositiony() == start.getPositiony() + 1 && !target
					.isOccupied())
				|| (start.OccupiyingPiece.getColour() == "Black"
						&& target.getPositiony() == start.getPositiony() - 1 && !target
							.isOccupied())
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
}
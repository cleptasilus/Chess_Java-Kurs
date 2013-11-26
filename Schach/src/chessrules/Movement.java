package chessrules;

import game.CurrentBoard;
import pieces.Piece;
import board.Square;

public class Movement {
	public boolean MoveBishop(CurrentBoard board, Square start, Square target) {

		for (int n = 0; n < 8; n++) {

			if ((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n)
					&& (target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n)) {

				int difx = target.getPositionx() - start.getPositionx();
				int dify = target.getPositiony() - start.getPositiony();
				int i = 0;
				int j = 0;
				i = (difx > 0) ? difx : -difx;
//				if (target.getPositionx() < start.getPositionx()) {
//					tempx += 1;
//				} else {
//					tempx -= 1;
//				}
				j = (dify > 0) ? dify : -dify;
//				if (target.getPositiony() < start.getPositiony()) {
//					tempy += 1;
//				} else {
//					tempy -= 1;
//				}
				for (int m = 1; m < i; m++) {
					if (board.Squares[start.getPositionx() + m *(difx / i)][start
							.getPositiony() + m * (dify / j)].isOccupied()) {
						System.out.println("Figur im Weg!");
						return false;
					}
				}
					if (target.isOccupied()) {


										if (target.OccupiyingPiece.getColour() == start.OccupiyingPiece.getColour()) {
											System.out
													.println("Du kannst keine eigene Figur schlagen!");
											return false;
										}
										target.OccupiyingPiece = null;
									}

					return true;
					}
							}
						
									
				
			
		

		return false;

	}
}

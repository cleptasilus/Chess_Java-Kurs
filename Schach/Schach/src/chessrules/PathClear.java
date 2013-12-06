package chessrules;

import game.CurrentBoard;
import board.Square;

public class PathClear {
	public boolean isClear(CurrentBoard board, Square start, Square target) {
		int difx = target.getPositionx() - start.getPositionx();
		int dify = target.getPositiony() - start.getPositiony();
		int i = 0;
		int j = 0;
		i = (difx > 0) ? difx : -difx;
		j = (dify > 0) ? dify : -dify;
		for (int m = 1; m < i; m++) {
			if (difx == 0) {
				if (board.Squares[start.getPositionx()][start.getPositiony()
						+ m * (dify / j)].isOccupied()) {
					System.out.println("Figur im Weg!");
					return false;
				}

				else if (dify == 0) {
					if (board.Squares[start.getPositionx() + m * (difx / i)][start
							.getPositiony()].isOccupied()) {
						System.out.println("Figur im Weg!");
						return false;
					}
				} else if (board.Squares[start.getPositionx() + m * (difx / i)][start
						.getPositiony() + m * (dify / j)].isOccupied()) {
					System.out.println("Figur im Weg!");
					return false;
				}
			}
		}
		return true;
	}

	public boolean isClear2(CurrentBoard board, Square start, Square target,
			Square movedpiecestart, Square movedpiecetarget) {
		int difx = target.getPositionx() - start.getPositionx();
		int dify = target.getPositiony() - start.getPositiony();
		int i = 0;
		int j = 0;
		i = (difx > 0) ? difx : -difx;
		j = (dify > 0) ? dify : -dify;
		for (int m = 1; m < i; m++) {
			if (difx == 0) {
				if (board.Squares[start.getPositionx()][start.getPositiony()
						+ m * (dify / j)] == movedpiecestart) {
					continue;
				}
				if (board.Squares[start.getPositionx()][start.getPositiony()
						+ m * (dify / j)] == movedpiecetarget) {
					return false;
				}

				if (board.Squares[start.getPositionx()][start.getPositiony()
						+ m * (dify / j)].isOccupied()) {
					System.out.println("Figur im Weg!");
					return false;
				}
			}

			else if (dify == 0) {
				if (board.Squares[start.getPositionx() + m * (difx / i)][start
						.getPositiony()] == movedpiecestart) {
					continue;
				}
				if (board.Squares[start.getPositionx() + m * (difx / i)][start
						.getPositiony()] == movedpiecetarget) {
					return false;
				}
				if (board.Squares[start.getPositionx() + m * (difx / i)][start
						.getPositiony()].isOccupied()) {
					System.out.println("Figur im Weg!");
					return false;
				}
			} else {
				if (board.Squares[start.getPositionx() + m

				* (difx / i)][start.getPositiony() + m * (dify / j)] == movedpiecestart) {
					continue;
				}
				if (board.Squares[start.getPositionx() + m

				* (difx / i)][start.getPositiony() + m * (dify / j)] == movedpiecetarget) {
					return false;
				}

				if (board.Squares[start.getPositionx() + m

				* (difx / i)][start.getPositiony() + m * (dify / j)]
						.isOccupied()) {
					System.out.println("Figur im Weg!");
					return false;
				}
			}
		}
		return true;
	}

}

package board;

import pieces.MovePiece;
import players.Player;
import chessrules.CentralMovement;
import chessrules.CheckChecker;
import chessrules.CheckMove;
import chessrules.KingMovement;
import chessrules.PawnMovement;
import game.CheckLegalMoves;
import game.CurrentBoard;
import game.PreEnPassante;
import game.PreMove;

public class FullMove {
	public boolean move(CurrentBoard board, Square start, Square target,
			String desiredpiece) {
		CheckLegalMoves resultchecker = new CheckLegalMoves();
		PreMove pre = new PreMove();
		if (!pre.premove(board, start, target)) {

			if (start.OccupiyingPiece.getName() == "K"
					&& (target.getPositionx() == start.getPositionx() - 2 || target
							.getPositionx() == start.getPositionx() + 2)) {
				KingMovement king = new KingMovement();
				king.Castle(board, start, target);
				return true;
			}
			if (start.OccupiyingPiece.getName() == ""
					&& (target.getPositionx() == start.getPositionx() + 1 || target
							.getPositionx() == start.getPositionx() - 1)
					&& (target.getPositiony() == start.getPositiony() - 1 || target
							.getPositiony() == start.getPositiony() + 1)
					&& board.enPassanteSquare.getPositionx() == target
							.getPositionx()
					&& board.enPassanteSquare.getPositiony() == start
							.getPositiony()) {
				PreEnPassante pep = new PreEnPassante();
				if (!pep.premove(board, start, target)) {
					MovePiece epmover = new MovePiece();
					epmover.moveenpassante(board, start.OccupiyingPiece, target);
					CheckChecker check3 = new CheckChecker();
					CheckMove check4 = new CheckMove();
					if (check3.MoveChecks(board, target)
							|| check4.DiscoveredCheck(board, target)) {
						if (!resultchecker.LegalMoves(board,
								target.OccupiyingPiece.getColour())) {
							String epstring = start.toString().substring(0, 1)
									+ "x" + target.toString() + "#";
							System.out.println(epstring);
							switch (target.OccupiyingPiece.getColour()) {
							case "White":
								board.result = 1;
								break;
							case "Black":
								board.result = 2;
								break;
							}
						} else {
							String epstring = start.toString().substring(0, 1)
									+ "x" + target.toString() + "+";
							System.out.println(epstring);
						}
					} else {
						if (!resultchecker.LegalMoves(board,
								target.OccupiyingPiece.getColour())) {
							String epstring = start.toString().substring(0, 1)
									+ "x" + target.toString() + "Remis";
							System.out.println(epstring);
							board.result = 3;
						} else {
							String epstring = start.toString().substring(0, 1)
									+ "x" + target.toString();
							System.out.println(epstring);
						}
					}
					board.enPassanteSquare = null;
					return true;
				}

			}
			CentralMovement cent = new CentralMovement();
			if (cent.piecemoveslikethat(board, start, target)) {

				CheckMove check = new CheckMove();
				if (start.OccupiyingPiece.getName() == "N"
						|| check.MoveLegal(board, start, target)) {
					boolean captures = false;
					if (target.isOccupied()) {
						captures = true;
						target.OccupiyingPiece.setPosition(board.Squares[0][0]);
					}
					MovePiece mover = new MovePiece();
					if (!(start.OccupiyingPiece.getName() == "")
							&& (target.getPositiony() == start.getPositiony() - 2 || target
									.getPositiony() == start.getPositiony() + 2)) {
						mover.Move(board, start.OccupiyingPiece, target);
					} else {
						mover.movepawntwosquares(board, start.OccupiyingPiece,
								target);
					}
					boolean transformed = false;
					if (target.OccupiyingPiece.getName() == ""
							&& (target.getPositiony() == 1 || target
									.getPositiony() == 8)) {
						PawnMovement transformer = new PawnMovement();
						transformer.transform(board, target, desiredpiece);
						transformed = true;
					}
					String movestring;
					if (captures == true) {
						if (transformed) {
							movestring = start.toString().substring(0, 1)
									+ "x" + target.toString() + "="
									+ desiredpiece;
						}
						else{
						if (target.OccupiyingPiece.getName() == "") {
								movestring = start.toString().substring(0, 1)
										+ "x" + target.toString();
							}

						 else {
							movestring = "x"
									+ target.OccupiyingPiece.getPosition()
											.toString();

						}
						}
					} else {
						if (transformed) {
							movestring = start.toString().substring(0, 1)
									+ target.toString() + "=" + desiredpiece;
						} else {
							movestring = (target.OccupiyingPiece.getPosition()
									.toString());
						}
					}
					CheckChecker check2 = new CheckChecker();
					if (check2.MoveChecks(board, target)
							|| check.DiscoveredCheck(board, target)) {
						if (!resultchecker.LegalMoves(board,
								target.OccupiyingPiece.getColour())) {
							System.out.println(transformed ? movestring + "#" : target.OccupiyingPiece.getName()
									+ movestring + "#");
							switch (target.OccupiyingPiece.getColour()) {
							case "White":
								board.result = 1;
								break;
							case "Black":
								board.result = 2;
								break;
							}

						} else {
							System.out.println(transformed? movestring + "+" : target.OccupiyingPiece.getName()
									+ movestring + "+");
						}
					} else {
						if (!resultchecker.LegalMoves(board,
								target.OccupiyingPiece.getColour())) {
							System.out.println(transformed? movestring + "Patt":target.OccupiyingPiece.getName()
									+ movestring + "Patt");
							board.result = 3;

						} else {
							System.out.println(target.OccupiyingPiece.getName()
									+ movestring);
						}
					}
					return true;
				}
			}
		}
		return false;
	}
}

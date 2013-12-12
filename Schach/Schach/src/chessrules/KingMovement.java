package chessrules;

import pieces.MovePiece;
import pieces.Piece;
import game.CurrentBoard;
import board.Square;

public class KingMovement {
	public boolean MoveKing(CurrentBoard board, Square start, Square target) {

		if (((target.getPositionx() == start.getPositionx() + 1)
				|| (target.getPositionx() == start.getPositionx()-1) || (target
				.getPositionx() == start.getPositionx()))
				&& ((target.getPositiony() == start.getPositiony() + 1)
						|| (target.getPositiony() == start.getPositiony()-1) || (target
						.getPositiony() == start.getPositiony()))) {

			if (target.isOccupied()) {
				CheckMove check = new CheckMove();
				return check.canCapture(start, target);

			}
			return true;
		}
		return false;
	}
	public boolean Castle(CurrentBoard board, Square start, Square target){
		if (!start.OccupiyingPiece.hasmoved && !board.isChecked){
			switch(target.getPositionx()){
			case 3:
				if((!board.Squares[1][start.getPositiony()].OccupiyingPiece.hasmoved) && board.Squares[1][start.getPositiony()].OccupiyingPiece.getName()=="R"){
					boolean occupied =false;
					for(int i=2;i<=4;i++){
						if (board.Squares[i][start.getPositiony()].isOccupied()){
							occupied = true;
							break;
						}
						if(!occupied){
							boolean overattackedsquare=false;
							for (Piece piece: board.pieces){
								if (!(piece.getColour() == start.OccupiyingPiece.getColour())){
									for(int j=3;j<=4;j++){
									CheckMove check= new CheckMove();
									if(check.MoveLegalNoCapture(board, piece.getPosition(), board.Squares[j][start.getPositiony()])){
										overattackedsquare=true;
										break;
									}
									}
									
								}
							}
							if(!overattackedsquare){
								MovePiece mover = new MovePiece();
								mover.Move(board, start.OccupiyingPiece, target);
								mover.Move(board, board.Squares[1][start.getPositiony()].OccupiyingPiece, board.Squares[4][start.getPositiony()]);
								CheckChecker movechecks=new CheckChecker();
								board.isChecked=movechecks.MoveChecks(board, board.Squares[4][start.getPositiony()]);
								System.out.println(board.isChecked ? "0-0-0+":"0-0-0");
								return true;
							}
						}
					}
				}
				
			case 7:	
				if((!board.Squares[8][start.getPositiony()].OccupiyingPiece.hasmoved) && board.Squares[8][start.getPositiony()].OccupiyingPiece.getName()=="R"){
					boolean occupied =false;
					for(int i=6;i<=7;i++){
						if (board.Squares[i][start.getPositiony()].isOccupied()){
							occupied = true;
							break;
						}
						if(!occupied){
							boolean overattackedsquare=false;
							for (Piece piece: board.pieces){
								if (!(piece.getColour() == start.OccupiyingPiece.getColour())){
									for(int j=6;j<=7;j++){
//									CheckMove check= new CheckMove();
										CentralMovement cent = new CentralMovement();
									if(cent.piecemoveslikethat2(board, piece.getPosition(), board.Squares[j][start.getPositiony()])){
										overattackedsquare=true;
										break;
									}
									}
									
								}
							}
							if(!overattackedsquare){
								MovePiece mover = new MovePiece();
								mover.Move(board, start.OccupiyingPiece, target);
								mover.Move(board, board.Squares[8][start.getPositiony()].OccupiyingPiece, board.Squares[6][start.getPositiony()]);
								CheckChecker movechecks=new CheckChecker();
								board.isChecked=movechecks.MoveChecks(board, board.Squares[6][start.getPositiony()]);
								System.out.println(board.isChecked ? "0-0+":"0-0");
								return true;
							}
						}
					}
				}
			}
			
		}
		
		return false;				
	}
	public boolean MoveKing2(CurrentBoard board, Square start,
			Square target, Square movedpiecestart, Square movedpiecetarget) {
		if (movedpiecestart.OccupiyingPiece.getName()=="K"){
				if (((movedpiecetarget.getPositionx() == start.getPositionx() + 1)
						|| (movedpiecetarget.getPositionx() == start.getPositionx()) || (movedpiecetarget
						.getPositionx() == start.getPositionx()))
						&& ((movedpiecetarget.getPositiony() == start.getPositiony() + 1)
								|| (movedpiecetarget.getPositiony() == start.getPositiony()) || (movedpiecetarget
								.getPositiony() == start.getPositiony()))) {

					if (movedpiecetarget.isOccupied()) {
						CheckMove check = new CheckMove();
						return check.canCapture(start, movedpiecetarget);

					}
					return true;
				}
				return false;
		}
		if (((target.getPositionx() == start.getPositionx() + 1)
				|| (target.getPositionx() == start.getPositionx()) || (target
				.getPositionx() == start.getPositionx()))
				&& ((target.getPositiony() == start.getPositiony() + 1)
						|| (target.getPositiony() == start.getPositiony()) || (target
						.getPositiony() == start.getPositiony()))) {

			if (target.isOccupied()) {
				CheckMove check = new CheckMove();
				return check.canCapture(start, target);

			}
			return true;
		}
		return false;
	}

}

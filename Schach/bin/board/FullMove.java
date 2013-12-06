package board;

import pieces.MovePiece;
import chessrules.CheckChecker;
import chessrules.CheckMove;
import game.CurrentBoard;
import game.PreMove;

public class FullMove {
	public void move(CurrentBoard board, Square start, Square target){
		PreMove pre=new PreMove();
		if(!pre.premove(board, start, target)){
			CheckMove check = new CheckMove();
			if(check.MoveLegal(board, start, target)){
				boolean captures = false;
				if (target.isOccupied()) {
					captures = true;
					target.OccupiyingPiece.setPosition(board.Squares[0][0]);
				}
				MovePiece mover=new MovePiece();
				mover.Move(board, start.OccupiyingPiece, target);
				String movestring = captures == true ? "x" + target.OccupiyingPiece.getPosition().toString()
						: (target.OccupiyingPiece.getPosition().toString());
				CheckChecker check2 = new CheckChecker();
				if(check2.MoveChecks(board, target)){
				System.out.println(target.OccupiyingPiece.getName() + movestring + "+");
				}
				else{
					System.out.println(target.OccupiyingPiece.getName() + movestring );
				}
			}
		}
		
	}
}

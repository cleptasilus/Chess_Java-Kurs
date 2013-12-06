package chessrules;

import board.Square;
import game.CurrentBoard;

public class CentralMovement {
	public boolean piecemoveslikethat(CurrentBoard board, Square start, Square target){
		switch(start.OccupiyingPiece.getName()){
		case "K":
			KingMovement k= new KingMovement();
			return k.MoveKing(board, start, target);
		case "Q":
			QueenMovement q= new QueenMovement();
			return q.MoveQueen(board, start, target);
		case "R":
			RookMovement r= new RookMovement();
			return r.MoveRook(board, start, target);
		case "B":
			BishopMovement b= new BishopMovement();
			return b.MoveBishop(board, start, target);
		case "N":
			KnightMovement n= new KnightMovement();
			return n.MoveKnight(board, start, target);
		case "":
			PawnMovement p= new PawnMovement();
			if(!(target.getPositiony()-start.getPositiony()==2 && target.getPositionx()-start.getPositionx()==0)){
			return p.MovePawn(board, start, target);
			}
			else{
			return p.MovePawn2(board, start, target);
			}
		}
		
		return false;		
	}

}

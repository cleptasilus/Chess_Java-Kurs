package chessrules;

import game.CurrentBoard;
import board.Square;

public class CheckChecker {
	//TODO
	public boolean MoveChecks(CurrentBoard board, Square target){
		switch(target.OccupiyingPiece.getColour()){
		case "Black":
			switch(target.OccupiyingPiece.getName()){
			case"Q":
				QueenMovement q= new QueenMovement();
				return q.CheckQueen(board, target, board.pieces.get(0).getPosition());
			case"R":
				RookMovement r= new RookMovement();
				return r.CheckRook(board, target, board.pieces.get(0).getPosition());
			case"N":
			case"P":
			case"B":	
			}
		case "White":
			switch(target.OccupiyingPiece.getName()){
		case"Q":
			QueenMovement q= new QueenMovement();			
			return q.CheckQueen(board, target, board.pieces.get(1).getPosition());
		case"R":
			RookMovement r= new RookMovement();
			return r.CheckRook(board, target, board.pieces.get(1).getPosition());
		case"N":
		case"P":
		case"B":	
			}
		}
		
		
		
		return false;
	}
}

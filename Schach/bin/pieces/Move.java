package pieces;

import chessrules.*;

import board.Square;
import game.CurrentBoard;

public class Move {
public boolean MoveMe(CurrentBoard board, Square start, Square target){
	MovePiece move= new MovePiece();
	CheckChecker check = new CheckChecker();
	Piece piece = start.OccupiyingPiece;
	switch(start.OccupiyingPiece.getName()){
	case "R":
		RookMovement rook = new RookMovement();
		if (rook.MoveRook(board, start, target)){
			move.Move(board, piece, target);
			board.isChecked=check.MoveChecks(board, target);
			return true;
		}
	case "N":
		KnightMovement knight = new KnightMovement();
		if(knight.MoveKnight(board, start, target)){
			move.Move(board, piece, target);
			board.isChecked=check.MoveChecks(board, target);
			return true;
		}
	case "K": 
		KingMovement king=new KingMovement();
		if(king.MoveKing(board, start, target)){
		move.Move(board, piece, target);
		board.isChecked=check.MoveChecks(board, target);
		return true;
		}
	case "Q":
		QueenMovement queen = new QueenMovement();
		if(queen.MoveQueen(board, start, target)){
			move.Move(board, piece, target);
			board.isChecked=check.MoveChecks(board, target);
			return true;
		}
	case "B":
		BishopMovement bishop = new BishopMovement();
		if(bishop.MoveBishop(board, start, target)){
			move.Move(board, piece, target);
			board.isChecked=check.MoveChecks(board, target);
			return true;
		}
	case "":
		PawnMovement pawn = new PawnMovement();
		if(pawn.MovePawn(board, start, target)){
			move.Move(board, piece, target);
			board.isChecked=check.MoveChecks(board, target);
			return true;
		}
	}
	return false;
	}
}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		Position p = new Position(0, 0);
		boolean[][] possibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//Searching above
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}

		//Searching left-above
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}		

		//Searching left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}
		
		//Searching left-below
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}
		
		//Searching below
		p.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}

		//Searching below-right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}
		
		//Searching right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}		
		
		//Searching right-above
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			possibleMoves[p.getRow()][p.getColumn()] = true;
		}		

		return possibleMoves;
	}
}

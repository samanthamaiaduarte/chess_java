package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
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
		
		// #Special move: Castling 
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #Small castling (Kingside rook)
			Position rook = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(rook)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if(!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2)) {
					possibleMoves[p2.getRow()][p2.getColumn()] = true;
				}
			}
			
			// #Major castling (Queenside rook)
			rook = new Position(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(rook)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2) && !getBoard().thereIsAPiece(p3)) {
					possibleMoves[p2.getRow()][p2.getColumn()] = true;
				}
			}
		}

		return possibleMoves;
	}
}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		Position p = new Position(0, 0);
		boolean[][] possibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			Position p2 = new Position(p.getRow(), p.getColumn());
			p.setValues(position.getRow() - 2, position.getColumn());
			if(getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			
			// #Special move: En passant (White)
			if(position.getRow() == 3) {
				//Left
				Position pos = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(pos) && isThereOpponentPiece(pos) && getBoard().piece(pos) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[pos.getRow() - 1][pos.getColumn()] = true;
				}
				//Right
				pos = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(pos) && isThereOpponentPiece(pos) && getBoard().piece(pos) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[pos.getRow() - 1][pos.getColumn()] = true;
				}
			}
		} else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			Position p2 = new Position(p.getRow(), p.getColumn());
			p.setValues(position.getRow() + 2, position.getColumn());
			if(getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			
			// #Special move: En passant (Black)
			if(position.getRow() == 4) {
				//Left
				Position pos = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(pos) && isThereOpponentPiece(pos) && getBoard().piece(pos) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[pos.getRow() + 1][pos.getColumn()] = true;
				}
				//Right
				pos = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(pos) && isThereOpponentPiece(pos) && getBoard().piece(pos) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[pos.getRow() + 1][pos.getColumn()] = true;
				}
			}
		}
		
		return possibleMoves;
	}

}

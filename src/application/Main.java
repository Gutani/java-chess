package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardGame.Board;
import boardGame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch ac = new ChessMatch();
		while(true) {
			try {
			UI.clearScreen();
			UI.printBoard(ac.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = ac.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(ac.getPieces(),possibleMoves);
			
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = ac.performChessMove(source, target);
		}catch(ChessException msg) {
			System.out.println(msg.getMessage());
			sc.nextLine();
		}catch(InputMismatchException msg) {
			System.out.println(msg.getMessage());
			sc.nextLine();
		}
			}
		
		
	}
}

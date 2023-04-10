package picross;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author Gabriel, Maher
 * 
 * driver class
 *
 */
public class Picross extends JFrame{

	public static void main(String[] args) {
		
		GameModel gameModel = new GameModel();
		GameView gameView = new GameView();
		GameController gameController = new GameController(gameModel, gameView);
		
		gameView.createGame();
		
	}
}
//
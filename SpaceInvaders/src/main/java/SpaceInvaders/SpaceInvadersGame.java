package SpaceInvaders;

import java.awt.EventQueue;

import Framework.AbstractBoard;
import Framework.MainFrame;

public class SpaceInvadersGame extends MainFrame {


	public SpaceInvadersGame () {
		super("Space Invaders");
	}
	
	protected AbstractBoard createBoard() {
		return new SpaceInvadersBoard();
	}


	public static void main(String[] args) {
		Commons.ensureInstance();
		EventQueue.invokeLater(SpaceInvadersGame::new);
	}

}

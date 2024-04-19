package FreezeMonster;

import Framework.AbstractBoard;
import Framework.MainFrame;

import java.awt.*;

public class Main extends MainFrame {
    public Main() {
        super("FreezeMonster");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        // Centralizar na tela
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }

    @Override
    protected AbstractBoard createBoard() {
        return new FreezeMonsterBoard();
    }
}

package FreezeMonster;

import Framework.AbstractBoard;
import Framework.MainFrame;

import java.awt.*;

public class Main extends MainFrame {
    public Main() {
        super("FreezeMonster");
    }

    public static void main(String[] args) {
        Commons.ensureInstance();
        EventQueue.invokeLater(Main::new);
    }

    @Override
    protected AbstractBoard createBoard() {
        return new FreezeMonsterBoard();
    }
}

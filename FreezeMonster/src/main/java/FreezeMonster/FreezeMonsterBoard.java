package FreezeMonster;

import Framework.AbstractBoard;
import Framework.sprite.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class FreezeMonsterBoard extends AbstractBoard {
    @Override
    protected void createBadSprites() {
        // Haverão 10 inimigos em posições aleatórias espalhados pela tela
        for (int i = 0; i < 10; i++) {
            int x = ThreadLocalRandom.current().nextInt(Commons.BOARD_WIDTH - Commons.MONSTER_WIDTH);
            int y = ThreadLocalRandom.current().nextInt(Commons.BOARD_HEIGHT - Commons.MONSTER_HEIGHT);
            badSprites.add(new MonsterSprite(x, y));
        }
    }

    @Override
    protected void createOtherSprites() {

    }

    @Override
    protected void drawOtherSprites(Graphics g) {

    }

    @Override
    protected void update() {

    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {

    }
}

package FreezeMonster;

import Framework.AbstractBoard;
import Framework.sprite.BadSprite;
import Framework.sprite.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class FreezeMonsterBoard extends AbstractBoard {
    public FreezeMonsterBoard() {
        super();
        setBackground(new Color(100, 200, 100));
    }

    @Override
    protected void createBadSprites() {
        // Haverão 10 inimigos em posições aleatórias espalhados pela tela
        for (int i = 0; i < 10; i++) {
            int x = ThreadLocalRandom.current().nextInt(Commons.BOARD_WIDTH() - Commons.MONSTER_WIDTH());
            int y = ThreadLocalRandom.current().nextInt(Commons.BOARD_HEIGHT() - Commons.MONSTER_HEIGHT());
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
        for (BadSprite badSprite : badSprites) {
            switch (badSprite) {
                case MonsterSprite monsterSprite -> {
                    var counter = monsterSprite.getCounter();
                    if (counter == 0) {
                        int speedX = ThreadLocalRandom.current().nextInt(-Commons.MAX_SPEED(), Commons.MAX_SPEED());
                        int speedY = ThreadLocalRandom.current().nextInt(-Commons.MAX_SPEED(), Commons.MAX_SPEED());
                        monsterSprite.setSpeedX(speedX);
                        monsterSprite.setSpeedY(speedY);
                        monsterSprite.setCounter(ThreadLocalRandom.current().nextInt(300));
                    }

                    // Aterar a direção do monstro para que ele não vá para fora da tela
                    if (monsterSprite.getX() + monsterSprite.getImageWidth() > Commons.BOARD_WIDTH()
                            && monsterSprite.getSpeedX() > 0)
                        monsterSprite.setSpeedX(-monsterSprite.getSpeedX());

                    if (monsterSprite.getX() < 0
                            && monsterSprite.getSpeedX() < 0)
                        monsterSprite.setSpeedX(-monsterSprite.getSpeedX());

                    if (monsterSprite.getY() + monsterSprite.getImageHeight() > Commons.BOARD_HEIGHT()
                            && monsterSprite.getSpeedY() > 0)
                        monsterSprite.setSpeedY(-monsterSprite.getSpeedY());

                    if (monsterSprite.getY() < 0
                            && monsterSprite.getSpeedY() < 0)
                        monsterSprite.setSpeedY(-monsterSprite.getSpeedY());

                    monsterSprite.setCounter(monsterSprite.getCounter() - 1);
                    monsterSprite.moveX(monsterSprite.getSpeedX());
                    monsterSprite.moveY(monsterSprite.getSpeedY());
                }
                default -> throw new IllegalStateException("Unexpected value: " + badSprite);
            }
        }
    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {

    }
}

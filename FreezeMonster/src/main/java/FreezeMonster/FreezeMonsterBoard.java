package FreezeMonster;

import Framework.AbstractBoard;
import Framework.sprite.BadSprite;
import Framework.sprite.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FreezeMonsterBoard extends AbstractBoard {
    //define sprites
    private Shot shot;
    // define global control vars
    private int direction = -1;
    private int deaths = 0;

    public FreezeMonsterBoard() {
        super();
        setBackground(new Color(100, 200, 100));
    }

    @Override
    protected Player createPlayer() {
        return new Woody();
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
        shot = new Shot();
    }

    private void drawShot(Graphics g) {
        if (shot.isVisible()) {
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    @Override
    protected void drawOtherSprites(Graphics g) {
        drawShot(g);
    }

    @Override
    protected void update() {
        if (deaths == Commons.NUMBER_OF_MONSTERS_TO_DESTROY()) {
            inGame = false;
            timer.stop();
            message = "Game won!";
        }

        // player
        for (Player player : players)
            player.act();

        // shot
        if (shot.isVisible()) {
            int shotX = shot.getX();
            int shotY = shot.getY();

            for (BadSprite badSprite : badSprites) {
                switch (badSprite) {
                    case MonsterSprite monstersprite -> {
                        int monsterX = badSprite.getX();
                        int monsterY = badSprite.getY();

                        if (monstersprite.isVisible() && shot.isVisible()) {
                            if (shotX >= (monsterX) && shotX <= (monsterX + Commons.MONSTER_WIDTH()) && shotY >= (monsterY) && shotY <= (monsterY + Commons.MONSTER_HEIGHT())) {

                                //ImageIcon ii = new ImageIcon(explImg);
                                //monstersprite.setImage(ii.getImage());
                                monstersprite.setDying(true);
                                deaths++;
                                shot.die();
                            }
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + badSprite);
                }
            }

            int y = shot.getY();
            y -= 4;

            if (y < 0) {
                shot.die();
            } else {
                shot.setY(y);
            }
        }

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
        int x = player.getX();
        int y = player.getY();

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            if (inGame) {
                if (!shot.isVisible()) {
                    shot = new Shot(x, y);
                }
            }
        }
    }
}

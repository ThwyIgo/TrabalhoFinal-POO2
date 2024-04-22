package FreezeMonster;

import Framework.AbstractBoard;
import Framework.sprite.BadSprite;
import Framework.sprite.Player;
import Framework.sprite.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class FreezeMonsterBoard extends AbstractBoard {
    private Shot shot;
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
        for (int i = 0; i < Commons.NUMBER_OF_MONSTERS_TO_DESTROY(); i++) {
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

        // shot collision
        if (shot.isVisible()) {
            int shotX = shot.getX();
            int shotY = shot.getY();

            for (BadSprite badSprite : badSprites) {
                switch (badSprite) {
                    case MonsterSprite monstersprite -> {
                        if (!monstersprite.isDying() && !shot.isDying()) {
                            if (shotX >= badSprite.getX() && shotX <= badSprite.getX() + badSprite.getImageWidth()
                                    && shotY >= badSprite.getY() && shotY <= badSprite.getY() + badSprite.getImageHeight()) {
                                monstersprite.setDying(true);
                                deaths++;
                                shot.setDying(true);
                            }
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected badSprite: " + badSprite);
                }
            }

            int y = shot.getY();
            int x = shot.getX();
            switch (shot.dir) {
                case UP -> shot.setY(y - Commons.PROJECTILE_SPEED());
                case DOWN -> shot.setY(y + Commons.PROJECTILE_SPEED());
                case RIGHT -> shot.setX(x + Commons.PROJECTILE_SPEED());
                case LEFT -> shot.setX(x - Commons.PROJECTILE_SPEED());
            }

            if (y < 0 || y > Commons.BOARD_HEIGHT() || x < 0 || x > Commons.BOARD_WIDTH()) {
                shot.setDying(true);
            }
        }

        Stream.concat(players.stream(), badSprites.stream())
                .forEach(Sprite::act);
    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {
        int x = player.getX();
        int y = player.getY();

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            if (inGame) {
                if (!shot.isVisible()) {
                    shot = new Shot(x, y, player.dir);
                }
            }
        }
    }
}

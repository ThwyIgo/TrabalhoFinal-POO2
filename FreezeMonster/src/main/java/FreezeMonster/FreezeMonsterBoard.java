package FreezeMonster;

import Framework.AbstractBoard;
import Framework.sprite.BadSprite;
import Framework.sprite.Player;
import Framework.sprite.Sprite;
import FreezeMonster.fabricas.WoodyFabrica;
import FreezeMonster.visitors.FreezeMonsterCollisionVisitor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class FreezeMonsterBoard extends AbstractBoard {
    private Shot shot;
    private int deaths = 0;

    public FreezeMonsterBoard() {
        super(new WoodyFabrica());
    }

    @Override
    protected void createBadSprites() {
        for (int i = 0; i < Commons.NUMBER_OF_MONSTERS_TO_DESTROY(); i++) {
            int x, y, padding = 20;
            // Evitar que monstros apareçam na mesma posição que o Player
            if (ThreadLocalRandom.current().nextBoolean()) {
                x = ThreadLocalRandom.current().nextInt(Commons.INIT_PLAYER_X() - Commons.MONSTER_WIDTH() - padding);
                y = ThreadLocalRandom.current().nextInt(Commons.INIT_PLAYER_Y() - Commons.MONSTER_HEIGHT() - padding);
            } else {
                x = ThreadLocalRandom.current().nextInt(Commons.INIT_PLAYER_X() + Commons.PLAYER_WIDTH() + padding,
                        Commons.BOARD_WIDTH() - Commons.MONSTER_WIDTH());
                y = ThreadLocalRandom.current().nextInt(Commons.INIT_PLAYER_Y() - Commons.PLAYER_HEIGHT() + padding,
                        Commons.BOARD_HEIGHT() - Commons.MONSTER_HEIGHT());
            }
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

        for (BadSprite badSprite : badSprites) {
            if (FreezeMonsterCollisionVisitor.trataColisao(badSprite,shot)) {
                deaths++;
            }

            if(FreezeMonsterCollisionVisitor.trataColisao(players.getFirst(), badSprite) ||
                    FreezeMonsterCollisionVisitor.trataColisao(players.getFirst(), badSprite.getBadnesses().getFirst())){
                break;
            }

            badSprite.getBadnesses().forEach(badness ->
                FreezeMonsterCollisionVisitor.trataColisao(badness, shot));
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

        Stream.concat(players.stream(), badSprites.stream()).forEach(Sprite::act);
    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {
        int x = player.getX() + player.getImageWidth() / 2 - shot.getImageWidth() / 2 ;
        int y = player.getY() + player.getImageHeight() / 2 - shot.getImageHeight() / 2;

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

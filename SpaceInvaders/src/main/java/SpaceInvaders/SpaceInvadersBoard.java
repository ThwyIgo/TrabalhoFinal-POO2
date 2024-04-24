package SpaceInvaders;

import Framework.AbstractBoard;
import Framework.sprite.BadSprite;
import Framework.sprite.Player;
import SpaceInvaders.fabricas.ShipFabrica;
import SpaceInvaders.sprite.Bomb;
import SpaceInvaders.sprite.BomberSprite;
import SpaceInvaders.sprite.Shot;
import SpaceInvaders.visitors.SpaceInvadersCollisionVisitor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

public class SpaceInvadersBoard extends AbstractBoard {
    private final URL explImg = this.getClass().getResource("/images/explosion.png");
    //define sprites
    private Shot shot;
    // define global control vars
    private int direction = -1;
    private int deaths = 0;

    public SpaceInvadersBoard() {
        super(new ShipFabrica());
    }

    @Override
    protected void createBadSprites() {  // create sprites
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                BomberSprite alien = new BomberSprite(Commons.ALIEN_INIT_X() + 18 * j, Commons.ALIEN_INIT_Y() + 18 * i);
                badSprites.add(alien);
            }
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.drawLine(0, Commons.GROUND(), Commons.BOARD_WIDTH(), Commons.GROUND());
    }

    @Override
    protected void update() {
        if (deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY()) {
            inGame = false;
            timer.stop();
            message = "Game won!";
        }

        // player
        for (Player player : players)
            player.act();

        // shot
        if (shot.isVisible()) {
            for (BadSprite alien : badSprites) {
                if (SpaceInvadersCollisionVisitor.trataColisao(shot, alien, explImg))
                    deaths++;
            }

            int y = shot.getY();
            y -= 4;

            if (y < 0) {
                shot.setDying(true);
            } else {
                shot.setY(y);
            }
        }

        // aliens
        for (BadSprite alien : badSprites) {
            int x = alien.getX();

            if (x >= Commons.BOARD_WIDTH() - Commons.BORDER_RIGHT() && direction != -1) {
                direction = -1;

                for (BadSprite a2 : badSprites) {
                    a2.setY(a2.getY() + Commons.GO_DOWN());
                }
            }

            if (x <= Commons.BORDER_LEFT() && direction != 1) {
                direction = 1;

                for (BadSprite a : badSprites) {
                    a.setY(a.getY() + Commons.GO_DOWN());
                }
            }
        }

        for (BadSprite alien : badSprites) {
            if (alien.isVisible()) {
                int y = alien.getY();

                if (y > Commons.GROUND() - Commons.ALIEN_HEIGHT()) {
                    inGame = false;
                    message = "Invasion!";
                }

                alien.moveX(direction);
            }
        }

        // bombs
        updateOtherSprites();
    }

    protected void updateOtherSprites() {
        Random generator = new Random();

        for (BadSprite alien : badSprites) {
            int shot = generator.nextInt(15);
            Bomb bomb = ((BomberSprite) alien).getBomb();

            if (shot == Commons.CHANCE() && alien.isVisible() && bomb.isDying()) {
                bomb.setDying(false);
                bomb.setX(alien.getX());
                bomb.setY(alien.getY());
            }

            SpaceInvadersCollisionVisitor.trataColisao(players.getFirst(), bomb, explImg);

            if (!bomb.isDying()) {
                bomb.setY(bomb.getY() + 1);

                if (bomb.getY() >= Commons.GROUND() - Commons.BOMB_HEIGHT()) {
                    bomb.setDying(true);
                }
            }
        }
    }
}

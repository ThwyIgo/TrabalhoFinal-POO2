package SpaceInvaders.sprite;

import SpaceInvaders.Commons;

import java.awt.event.KeyEvent;

public class Ship extends Framework.sprite.Player {
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                dx = -Commons.MAX_SPEED();
                dir = Direction.LEFT;
            }
            case KeyEvent.VK_RIGHT -> {
                dx = Commons.MAX_SPEED();
                dir = Direction.RIGHT;
            }
        }
    }
}

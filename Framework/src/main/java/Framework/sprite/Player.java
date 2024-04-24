package Framework.sprite;

import Framework.Commons;

import java.awt.event.KeyEvent;

public abstract class Player extends Sprite {
    public Player() {
        loadImage();
        resetState();
    }

    protected abstract void loadImage();

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
            case KeyEvent.VK_UP -> {
                dy = -Commons.MAX_SPEED();
                dir = Direction.UP;
            }
            case KeyEvent.VK_DOWN -> {
                dy = Commons.MAX_SPEED();
                dir = Direction.DOWN;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> dx = 0;
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN -> dy = 0;
        }
    }

    private void resetState() {
        setX(Commons.INIT_PLAYER_X());
        setY(Commons.INIT_PLAYER_Y());
    }
}

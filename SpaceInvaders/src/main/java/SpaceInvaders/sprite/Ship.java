package SpaceInvaders.sprite;

import SpaceInvaders.Commons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Ship extends Framework.sprite.Player {
    @Override
    protected void loadImage() {
        Image ii = new ImageIcon(Objects.requireNonNull(this.getClass()
                .getResource("/images/player.png"))).getImage();
        setImage(ii);
    }

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

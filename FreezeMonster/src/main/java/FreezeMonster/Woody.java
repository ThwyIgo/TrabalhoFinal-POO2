package FreezeMonster;

import Framework.sprite.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Woody extends Player {
    protected int dy;
    protected int height = Commons.PLAYER_HEIGHT();

    protected void loadImage() {
        Image ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/player.png"))).getImage().getScaledInstance(Commons.PLAYER_WIDTH(),Commons.PLAYER_HEIGHT(), Image.SCALE_SMOOTH);
        width = ii.getWidth(null);
        setImage(ii);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_LEFT -> {
                dx = -5;
            }
            case KeyEvent.VK_RIGHT -> {
                dx = 5;
            }
            case KeyEvent.VK_UP -> {
                dy = -5;
            }
            case KeyEvent.VK_DOWN -> {
                dy = 5;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_LEFT -> {
                dx = 0;
            }
            case KeyEvent.VK_RIGHT -> {
                dx = 0;
            }
            case KeyEvent.VK_UP -> {
                dy = 0;
            }
            case KeyEvent.VK_DOWN -> {
                dy = 0;
            }
        }
    }

    public void act() {
        x += dx;
        y += dy;

        if (x <= 2) {
            x = 2;
        }

        if (y <= 2) {
            y = 2;
        }

        if (x >= Framework.Commons.BOARD_WIDTH() - 2 * width) {
            x = Framework.Commons.BOARD_WIDTH() - 2 * width;
        }

        if (y >= Framework.Commons.BOARD_HEIGHT() - 2 * height) {
            y = Framework.Commons.BOARD_HEIGHT() - 2 * height;
        }
    }
}

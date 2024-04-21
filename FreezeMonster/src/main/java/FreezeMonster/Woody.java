package FreezeMonster;

import Framework.sprite.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Woody extends Player {
    protected void loadImage() {
        Image ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/player.png"))).getImage()
                .getScaledInstance(Commons.PLAYER_WIDTH(), Commons.PLAYER_HEIGHT(), Image.SCALE_SMOOTH);
        setImage(ii);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        // Deixar o player mais rápido
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> dx -= 2;
            case KeyEvent.VK_RIGHT -> dx += 2;
            case KeyEvent.VK_UP -> dy -= 2;
            case KeyEvent.VK_DOWN -> dy += 2;
        }
    }
}

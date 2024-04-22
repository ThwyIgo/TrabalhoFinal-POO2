package FreezeMonster;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Gosma extends BadSprite {
    // Atraso antes da gosma ser disparada novamente
    public int counter = 0;

    public Gosma(int x, int y) {
        this.x = x;
        this.y = y;
        randomDir();

        URL sprite = this.getClass().getResource("/images/gosma.png");
        assert sprite != null;

        setImage(new ImageIcon(sprite).getImage()
                .getScaledInstance(Commons.PROJECTILE_SIZE(), Commons.PROJECTILE_SIZE(), Image.SCALE_SMOOTH));
    }

    public void randomDir() {
        this.dir = Direction.values()[ThreadLocalRandom.current().nextInt(Direction.values().length)];
    }
}

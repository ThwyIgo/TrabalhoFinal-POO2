package FreezeMonster;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Gosma extends BadSprite {
    protected boolean destroyed;
    public Woody.Dir dir;
    public int counter = 0;

    public Gosma(int x, int y) {
        this.dir = Woody.Dir.values()[ThreadLocalRandom.current().nextInt(Woody.Dir.values().length)];
        this.x = x;
        this.y = y;

        URL sprite = this.getClass().getResource("/images/gosma.png");
        assert sprite != null;

        setImage(new ImageIcon(sprite).getImage()
                .getScaledInstance(Commons.ensureInstance().PROJECTILE_SIZE(), Commons.ensureInstance().PROJECTILE_SIZE(), Image.SCALE_SMOOTH));
        getImageDimensions();
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void randomDir() {
        this.dir = Woody.Dir.values()[ThreadLocalRandom.current().nextInt(Woody.Dir.values().length)];
    }
}
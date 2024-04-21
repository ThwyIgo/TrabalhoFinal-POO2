package FreezeMonster;

import Framework.sprite.BadSprite;
import Framework.sprite.Player;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Gosma extends BadSprite {
    protected boolean destroyed;
    public int counter = 0;

    public Gosma(int x, int y) {
        this.dir = Direction.values()[ThreadLocalRandom.current().nextInt(Direction.values().length)];
        this.x = x;
        this.y = y;

        URL sprite = this.getClass().getResource("/images/gosma.png");
        assert sprite != null;

        setImage(new ImageIcon(sprite).getImage()
                .getScaledInstance(Commons.PROJECTILE_SIZE(), Commons.PROJECTILE_SIZE(), Image.SCALE_SMOOTH));
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void randomDir() {
        this.dir = Player.Direction.values()[ThreadLocalRandom.current().nextInt(Player.Direction.values().length)];
    }
}

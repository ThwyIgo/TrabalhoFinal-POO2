package SpaceInvaders.sprite;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.net.URL;

public class BomberSprite extends BadSprite {
    private Bomb bomb;

    public BomberSprite(int x, int y) {
        initBomber(x, y);
    }

    private void initBomber(int x, int y) {
        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);
        badnesses.add(bomb);

        URL alienImg = this.getClass().getResource("/images/alien.png");
        assert alienImg != null;
        ImageIcon ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }

    public Bomb getBomb() {
        return bomb;
    }
}

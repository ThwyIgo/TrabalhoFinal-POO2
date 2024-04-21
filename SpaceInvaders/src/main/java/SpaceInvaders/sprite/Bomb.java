package SpaceInvaders.sprite;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.net.URL;

public class Bomb extends BadSprite {
    public Bomb(int x, int y) {
        initBomb(x, y);
    }

    private void initBomb(int x, int y) {
        setDying(true);

        this.x = x;
        this.y = y;

        URL bombImg = this.getClass().getResource("/images/bomb.png");
        assert bombImg != null;
        ImageIcon ii = new ImageIcon(bombImg);
        setImage(ii.getImage());
    }
}

package SpaceInvaders.sprite;

import javax.swing.ImageIcon;

import Framework.sprite.BadSprite;

import java.net.URL;

public class Bomb extends BadSprite {

    private boolean destroyed;

    public Bomb(int x, int y) {

        initBomb(x, y);
    }

    private void initBomb(int x, int y) {

        setDestroyed(true);

        this.x = x;
        this.y = y;

        URL bombImg = this.getClass().getResource("/images/bomb.png");
        assert bombImg != null;
        ImageIcon ii = new ImageIcon(bombImg);
        setImage(ii.getImage());
    }

    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {

        return destroyed;
    }
    
    
}

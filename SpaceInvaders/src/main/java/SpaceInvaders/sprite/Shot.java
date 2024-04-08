package SpaceInvaders.sprite;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.net.URL;

public class Shot extends BadSprite {

    public Shot() {
    }

    public Shot(int x, int y) {
        initShot(x, y);
    }

    private void initShot(int x, int y) {
        URL shotImg = this.getClass().getResource("/images/shot.png");
        assert shotImg != null;
        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
}

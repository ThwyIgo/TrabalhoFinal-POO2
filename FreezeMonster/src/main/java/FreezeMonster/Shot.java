package FreezeMonster;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Shot extends BadSprite {

    public Woody.Dir dir = Woody.Dir.UP;

    public Shot() {
    }

    public Shot(int x, int y, Woody.Dir dir) {
        initShot(x, y, dir);
    }

    private void initShot(int x, int y, Woody.Dir dir) {
        this.dir = dir;
        URL shotImg = this.getClass().getResource("/images/ray.png");
        assert shotImg != null;
        Image ii = new ImageIcon(shotImg).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        setImage(ii);

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
}

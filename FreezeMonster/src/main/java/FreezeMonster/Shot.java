package FreezeMonster;

import Framework.sprite.BadSprite;
import Framework.sprite.Player;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Shot extends BadSprite {

    public Player.Direction dir = Player.Direction.UP;

    public Shot() {
    }

    public Shot(int x, int y, Direction dir) {
        initShot(x, y, dir);
    }

    private void initShot(int x, int y, Direction dir) {
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

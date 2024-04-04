package SpaceInvaders.sprite;

import java.net.URL;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import Framework.sprite.BadSprite;
import Framework.sprite.BadnessBoxSprite;

public class BomberSprite extends BadnessBoxSprite {

    private Bomb bomb;

    public BomberSprite(int x, int y) {

        initBomber(x, y);
    }

    private void initBomber(int x, int y) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);

        URL alienImg = this.getClass().getResource("/images/alien.png");
        assert alienImg != null;
        ImageIcon ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }



    public Bomb getBomb() {

        return bomb;
    }


	@Override
	public LinkedList<BadSprite> getBadnesses() {
		LinkedList<BadSprite> aBomb = new LinkedList<BadSprite>();
		aBomb.add(bomb);
		return aBomb;
	}
}

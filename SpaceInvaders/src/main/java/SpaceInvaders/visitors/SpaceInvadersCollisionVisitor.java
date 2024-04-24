package SpaceInvaders.visitors;

import Framework.sprite.BadSprite;
import Framework.sprite.Sprite;
import Framework.visitors.CollisionVistor;

import javax.swing.*;
import java.net.URL;

public class SpaceInvadersCollisionVisitor extends CollisionVistor {
    public static boolean trataColisao(Sprite sprite, BadSprite badSprite, URL explImg) {
        if (!badSprite.isDying() && !sprite.isDying()) {
            if (CollisionVistor.mutualOverlapping(sprite, badSprite)) {
                ImageIcon ii = new ImageIcon(explImg);
                badSprite.setImage(ii.getImage());
                badSprite.setDying(true);
                sprite.setDying(true);
                return true;
            }
        }

        return false;
    }
}

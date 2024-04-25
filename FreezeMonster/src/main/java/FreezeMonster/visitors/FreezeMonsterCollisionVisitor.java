package FreezeMonster.visitors;

import Framework.sprite.BadSprite;
import Framework.sprite.Player;
import Framework.visitors.CollisionVistor;
import FreezeMonster.Shot;

public class FreezeMonsterCollisionVisitor extends CollisionVistor {
    public static boolean trataColisao(Player p, BadSprite gosma) {
        if (!gosma.isDying() && mutualOverlapping(p, gosma)) {
            p.setDying(true);
            gosma.setDying(true);
            return true;
        }
        return false;
    }

    // colisão entre monstro e shot; e entre gosma e shot
    public static boolean trataColisao(BadSprite ms, Shot s) {
        if (!ms.isDying() && !s.isDying()) {
            if (mutualOverlapping(ms, s)) {
                ms.setDying(true);
                s.setDying(true);
                return true;
            }
        }
        return false;
    }
}

package FreezeMonster.visitors;

import Framework.sprite.BadSprite;
import Framework.sprite.Player;
import Framework.visitors.CollisionVistor;
import FreezeMonster.Gosma;
import FreezeMonster.MonsterSprite;
import FreezeMonster.Shot;

public class FreezeMonsterCollisionVisitor extends CollisionVistor {
    public static boolean trataColisao(Player p, BadSprite ms){
        if (ms.isVisible() && !ms.isDying()) {
            if (mutualOverlapping(ms,p)) {
                p.setDying(true);
                return true;
            }
        }
        return false;
    }

    public static boolean trataColisao(Player p, Gosma gosma){
        if (!gosma.isDying() && mutualOverlapping(p,gosma)) {
            p.setDying(true);
            gosma.setDying(true);
            return true;
        }
        return false;
    }

    public static boolean trataColisao(BadSprite ms, Shot s){
        if (!ms.isDying() && !s.isDying()) {
            if (mutualOverlapping(ms,s)) {
                ms.setDying(true);
                s.setDying(true);
                return true;
            }
        }
        return false;
    }
}

package Framework.visitors;
import Framework.sprite.Sprite;


public class CollisionVistor {
    public static boolean mutualOverlapping(Sprite s1, Sprite s2){
        int esqS1 = s1.getX(),
                dirS1 = s1.getX() + s1.getImageWidth(),
                cimaS1 = s1.getY(),
                baixoS1 = s1.getY() + s1.getImageHeight();

        int esqS2 = s2.getX(),
                dirS2 = s2.getX() + s2.getImageWidth(),
                cimaS2 = s2.getY(),
                baixoS2 = s2.getY() + s2.getImageHeight();

        return esqS1 < dirS2 && dirS1 > esqS2 && cimaS1 < baixoS2 && baixoS1 > cimaS2;
    }
}

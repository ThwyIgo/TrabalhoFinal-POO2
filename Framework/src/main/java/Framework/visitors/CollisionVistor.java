package Framework.visitors;
import Framework.sprite.Sprite;


public class CollisionVistor {
    public static boolean mutualOverlapping(Sprite s1, Sprite s2){
        int sx = s1.getX();
        int sy = s1.getY();
        int x = s2.getX();
        int y = s2.getY();

        boolean flag = x >= (sx) && x <= (sx + s2.getImageWidth()) && y >= (sy) && y <= (sy + s2.getImageHeight());
        flag = flag || (x+s2.getImageWidth()) >= (sx) && (x+s2.getImageWidth()) <= (sx + s2.getImageWidth()) && y >= (sy) && y <= (sy + s2.getImageHeight());
        flag = flag || x >= (sx) && x <= (sx + s2.getImageWidth()) && (y+s2.getImageHeight()) >= (sy) && (y+s2.getImageHeight()) <= (sy + s2.getImageHeight());
        flag = flag || (x+s2.getImageWidth()) >= (sx) && (x+s2.getImageWidth()) <= (sx + s2.getImageWidth()) && (y+s2.getImageHeight()) >= (sy) && (y+s2.getImageHeight()) <= (sy + s2.getImageHeight());

        sx = s2.getX();
        sy = s2.getY();
        x = s1.getX();
        y = s1.getY();

        boolean flag1 = x >= (sx) && x <= (sx + s1.getImageWidth()) && y >= (sy) && y <= (sy + s1.getImageHeight());
        flag1 = flag1 || (x+s1.getImageWidth()) >= (sx) && (x+s1.getImageWidth()) <= (sx + s1.getImageWidth()) && y >= (sy) && y <= (sy + s1.getImageHeight());
        flag1 = flag1 || x >= (sx) && x <= (sx + s1.getImageWidth()) && (y+s1.getImageHeight()) >= (sy) && (y+s1.getImageHeight()) <= (sy + s1.getImageHeight());
        flag1 = flag1 || (x+s1.getImageWidth()) >= (sx) && (x+s1.getImageWidth()) <= (sx + s1.getImageWidth()) && (y+s1.getImageHeight()) >= (sy) && (y+s1.getImageHeight()) <= (sy + s1.getImageHeight());

        return flag || flag1;
    }
}

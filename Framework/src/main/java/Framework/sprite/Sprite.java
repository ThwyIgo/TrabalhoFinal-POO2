package Framework.sprite;

import Framework.Commons;

import javax.swing.*;
import java.awt.*;

public class Sprite {
    public Direction dir;
    protected Image image;
    protected int x;
    protected int y;
    private int imageWidth;
    private int imageHeight;
    protected int dx = 0, dy = 0;
    protected boolean visible;
    protected boolean dying;

    public Sprite() {
        visible = true;
    }

    public void act() {
        x += dx;
        y += dy;

        if (x <= 0)
            x = 0;

        if (y <= 0)
            y = 0;

        if (x >= Commons.BOARD_WIDTH() - imageWidth)
            x = Commons.BOARD_WIDTH() - imageWidth;

        if (y >= Commons.BOARD_HEIGHT() - imageHeight)
            y = Commons.BOARD_HEIGHT() - imageHeight;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        getImageDimensions();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    private void getImageDimensions() {
        new ImageIcon(image); // Force image to load
        imageWidth = image.getWidth(null);
        imageHeight = image.getHeight(null);
    }

    public boolean isDying() {
        return this.dying;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
        this.visible = !dying;
    }

    public void moveX(int direction) {
        this.x += direction;
    }

    public void moveY(int direction) {
        this.y += direction;
    }

    public enum Direction {UP, DOWN, RIGHT, LEFT}

    public boolean isOverlapping(Sprite s){
        int sx = s.getX();
        int sy = s.getY();
        boolean flag = x >= (sx) && x <= (sx + s.imageWidth) && y >= (sy) && y <= (sy + s.imageHeight);
        flag = flag || (x+imageWidth) >= (sx) && (x+imageWidth) <= (sx + s.imageWidth) && y >= (sy) && y <= (sy + s.imageHeight);
        flag = flag || x >= (sx) && x <= (sx + s.imageWidth) && (y+imageHeight) >= (sy) && (y+imageHeight) <= (sy + s.imageHeight);
        flag = flag || (x+imageWidth) >= (sx) && (x+imageWidth) <= (sx + s.imageWidth) && (y+imageHeight) >= (sy) && (y+imageHeight) <= (sy + s.imageHeight);
        return flag;
    }
}

package Framework.sprite;

import java.awt.*;

public class Sprite {
    protected Image image;
    protected int x;
    protected int y;
    protected int imageWidth;
    protected int imageHeight;
    protected int dx;

    protected boolean visible;
    protected boolean dying;

    public Sprite() {
        visible = true;
    }

    public void die() {
        visible = false;
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

    public void getImageDimensions() {
        imageWidth = image.getWidth(null);
        imageHeight = image.getHeight(null);
    }

    public boolean isDying() {
        return this.dying;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }

    public void moveX(int direction) {
        this.x += direction;
    }

    public void moveY(int direction) {
        this.y += direction;
    }
}

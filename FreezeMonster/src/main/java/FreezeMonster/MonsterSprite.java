package FreezeMonster;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterSprite extends BadSprite {
    protected int imgIdx;
    protected static final int numOfImages = 9;
    protected static final URL[][] monsterImages = new URL[2][numOfImages];

    static {
        for (int i = 0; i < numOfImages; i++) {
            monsterImages[0][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + ".png");
            monsterImages[1][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + "bg.png");
        }
    }

    protected int speedX = 0;
    protected int speedY = 0;
    protected int counter = 0;

    // Cria um monstro com uma imagem aleatória e posiciona-o
    public MonsterSprite(int x, int y) {
        this.x = x;
        this.y = y;

        imgIdx = ThreadLocalRandom.current().nextInt(numOfImages);
        setImage(new ImageIcon(monsterImages[0][imgIdx]).getImage()
                .getScaledInstance(Commons.MONSTER_WIDTH(), Commons.MONSTER_HEIGHT(), Image.SCALE_SMOOTH));
        imageWidth = Commons.MONSTER_WIDTH();
        imageHeight = Commons.MONSTER_HEIGHT();
    }

    public void die() {
        visible = true;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
        setImage(new ImageIcon(monsterImages[1][imgIdx]).getImage().getScaledInstance(Commons.MONSTER_WIDTH(), Commons.MONSTER_HEIGHT(), Image.SCALE_SMOOTH));
    }
    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

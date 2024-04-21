package FreezeMonster;

import Framework.sprite.BadSprite;
import Framework.sprite.BadnessBoxSprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterSprite extends BadnessBoxSprite {
    protected static final int numOfImages = 9;
    protected static final URL[][] monsterImages = new URL[2][numOfImages];

    static {
        for (int i = 0; i < numOfImages; i++) {
            monsterImages[0][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + ".png");
            monsterImages[1][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + "bg.png");
        }
    }

    protected int imgIdx;
    protected int speedX = 0;
    protected int speedY = 0;
    protected int counter = 0;
    private final Gosma gosma;

    // Cria um monstro com uma imagem aleatória e posiciona-o
    public MonsterSprite(int x, int y) {
        this.x = x;
        this.y = y;
        gosma = new Gosma(x, y);

        imgIdx = ThreadLocalRandom.current().nextInt(numOfImages);
        setImage(new ImageIcon(monsterImages[0][imgIdx]).getImage()
                .getScaledInstance(Commons.MONSTER_WIDTH(), Commons.MONSTER_HEIGHT(), Image.SCALE_SMOOTH));
    }

    public Gosma getGosma() {
        return gosma;
    }

    public void die() {
        visible = true;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
        setImage(new ImageIcon(monsterImages[1][imgIdx]).getImage()
                .getScaledInstance(Commons.MONSTER_WIDTH(), Commons.MONSTER_HEIGHT(), Image.SCALE_SMOOTH));
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

    @Override
    public LinkedList<BadSprite> getBadnesses() {
        LinkedList<BadSprite> aBomb = new LinkedList<>();
        aBomb.add(gosma);
        return aBomb;
    }
}

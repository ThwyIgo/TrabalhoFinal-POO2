package FreezeMonster;

import Framework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterSprite extends BadSprite {
    protected static final int numOfImages = 9;
    protected static final URL[][] monsterImages = new URL[2][numOfImages];

    static {
        for (int i = 0; i < numOfImages; i++) {
            monsterImages[0][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + ".png");
            monsterImages[1][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + "bg.png");
        }
    }

    protected int imgIdx;
    protected int counter = 0;
    private final Gosma gosma;

    // Cria um monstro com uma imagem aleatória e posiciona-o
    public MonsterSprite(int x, int y) {
        this.x = x;
        this.y = y;
        gosma = new Gosma(x, y);
        badnesses.add(gosma);

        imgIdx = ThreadLocalRandom.current().nextInt(numOfImages);
        setImage(new ImageIcon(monsterImages[0][imgIdx]).getImage()
                .getScaledInstance(Commons.MONSTER_WIDTH(), Commons.MONSTER_HEIGHT(), Image.SCALE_SMOOTH));
    }

    public void setDying(boolean dying) {
        this.dying = dying;
        setImage(new ImageIcon(monsterImages[1][imgIdx]).getImage()
                .getScaledInstance(Commons.MONSTER_WIDTH(), Commons.MONSTER_HEIGHT(), Image.SCALE_SMOOTH));
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void act() {
        if (!isDying()) {
            var counter = getCounter();
            if (counter == 0) {
                int speedX = ThreadLocalRandom.current().nextInt(-Commons.MAX_SPEED(), Commons.MAX_SPEED());
                int speedY = ThreadLocalRandom.current().nextInt(-Commons.MAX_SPEED(), Commons.MAX_SPEED());
                dx = speedX;
                dy = speedY;
                setCounter(ThreadLocalRandom.current().nextInt(300));
            }

            // Aterar a direção do monstro para que ele não vá para fora da tela
            if (getX() + getImageWidth() > Commons.BOARD_WIDTH()
                    && dx > 0)
                dx = -dx;

            if (getX() < 0 && dx < 0)
                dx = -dx;

            if (getY() + getImageHeight() > Commons.BOARD_HEIGHT()
                    && dy > 0)
                dy = -dy;

            if (getY() < 0
                    && dy < 0)
                dy = -dy;

            setCounter(getCounter() - 1);
            moveX(dx);
            moveY(dy);
        }

        // Processar gosmas
        for (BadSprite foo : getBadnesses()) {
            Gosma gosma = (Gosma) foo;

            if (!this.isDying() && gosma.isDying())
                gosma.counter--;

            if (gosma.counter <= 0) {
                gosma.counter = ThreadLocalRandom.current().nextInt(300);
                gosma.setX(getX());
                gosma.setY(getY());
                gosma.randomDir();
                gosma.setDying(false);
                continue;
            }

            if (gosma.getX() < 0 || gosma.getX() > Commons.BOARD_WIDTH()
                    || gosma.getY() < 0 || gosma.getY() > Commons.BOARD_HEIGHT()) {
                gosma.setDying(true);
            }

            switch (gosma.dir) {
                case UP -> gosma.moveY(-Commons.PROJECTILE_SPEED());
                case DOWN -> gosma.moveY(Commons.PROJECTILE_SPEED());
                case LEFT -> gosma.moveX(-Commons.PROJECTILE_SPEED());
                case RIGHT -> gosma.moveX(Commons.PROJECTILE_SPEED());
            }
        }
    }

    public Gosma getGosma() {
        return gosma;
    }
}

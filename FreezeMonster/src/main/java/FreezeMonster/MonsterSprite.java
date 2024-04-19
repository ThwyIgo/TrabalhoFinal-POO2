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
        for (int i = 0; i < 9; i++) {
            monsterImages[0][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + ".png");
            monsterImages[1][i] = MonsterSprite.class.getResource("/images/monster" + (i + 1) + "bg.png");
        }
    }

    // Cria um monstro com uma imagem aleatória e posiciona-o
    public MonsterSprite(int x, int y) {
        this.x = x;
        this.y = y;

        int idx = ThreadLocalRandom.current().nextInt(numOfImages);
        setImage(new ImageIcon(monsterImages[0][idx]).getImage()
                .getScaledInstance(Commons.MONSTER_WIDTH, Commons.MONSTER_HEIGHT, Image.SCALE_SMOOTH));
    }
}

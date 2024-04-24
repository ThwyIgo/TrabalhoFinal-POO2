package FreezeMonster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterSpriteTest {

    @Test
    @DisplayName("MonsterSprite deve ficar visível após morrer")
    void setDying() {
        MonsterSprite monsterSprite = new MonsterSprite(0, 0);
        monsterSprite.setDying(true);
        assertTrue(monsterSprite.isDying());
        assertTrue(monsterSprite.isVisible());
    }
}

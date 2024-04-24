package FreezeMonster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WoodyTest {
    @Test
    @DisplayName("Tamanho inicial do player de seguir Commons")
    void playerSize() {
        Woody woody = new Woody();
        assertEquals(Commons.PLAYER_WIDTH(), woody.getImageWidth());
        assertEquals(Commons.PLAYER_HEIGHT(), woody.getImageHeight());
    }
}

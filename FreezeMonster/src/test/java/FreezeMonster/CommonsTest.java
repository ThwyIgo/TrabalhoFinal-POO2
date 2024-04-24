package FreezeMonster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonsTest {
    @Test
    void ensureInstance() {
        assertFalse(Framework.Commons.getInstance() instanceof Commons);
        Commons.ensureInstance();
        assertInstanceOf(Commons.class, Framework.Commons.getInstance());
        Framework.Commons.ensureInstance();
        assertFalse(Framework.Commons.getInstance() instanceof Commons);
    }
}

package FreezeMonster;

public class Commons extends Framework.Commons {
    protected int MONSTER_WIDTH = 80;
    protected int MONSTER_HEIGHT = 80;
    protected int MAX_SPEED = 5;

    protected Commons() {
        BOARD_WIDTH = 1280;
        BOARD_HEIGHT = 720;
    }

    // Garante que a instância seja do tipo FreezeMonster.Commons
    public static Commons ensureInstance() {
        Framework.Commons instance = getInstance();
        if (!(instance instanceof Commons))
            setInstance(new Commons());

        return (Commons) getInstance();
    }

    public static int MONSTER_WIDTH() {
        return ensureInstance().MONSTER_WIDTH;
    }

    public static int MONSTER_HEIGHT() {
        return ensureInstance().MONSTER_HEIGHT;
    }

    public static int MAX_SPEED() {
        return ensureInstance().MAX_SPEED;
    }
}

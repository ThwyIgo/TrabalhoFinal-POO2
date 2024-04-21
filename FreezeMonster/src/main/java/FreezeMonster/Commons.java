package FreezeMonster;

public class Commons extends Framework.Commons {
    protected int MONSTER_WIDTH = 80;
    protected int MONSTER_HEIGHT = 80;
    protected int PROJECTILE_SPEED = 6;
    protected int PROJECTILE_SIZE = 30;
    protected int PLAYER_WIDTH = 100;
    protected int PLAYER_HEIGHT = 50;
    protected int NUMBER_OF_MONSTERS_TO_DESTROY = 24;
    protected Commons() {
        BOARD_WIDTH = 1280;
        BOARD_HEIGHT = 720;
    }

    public static int PROJECTILE_SPEED() {
        return ensureInstance().PROJECTILE_SPEED;
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

    public static int NUMBER_OF_MONSTERS_TO_DESTROY() {
        return ensureInstance().NUMBER_OF_MONSTERS_TO_DESTROY;
    }

    public static int PLAYER_WIDTH() {
        return ensureInstance().PLAYER_WIDTH;
    }

    public static int PLAYER_HEIGHT() {
        return ensureInstance().PLAYER_HEIGHT;
    }

    public static int PROJECTILE_SIZE() {
        return ensureInstance().PROJECTILE_SIZE;
    }
}

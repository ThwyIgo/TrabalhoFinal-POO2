package SpaceInvaders;

public class Commons extends Framework.Commons {
    protected int BOMB_HEIGHT = 5;

    protected int ALIEN_HEIGHT = 12;
    protected int ALIEN_WIDTH = 12;
    protected int ALIEN_INIT_X = 150;
    protected int ALIEN_INIT_Y = 5;

    protected int GO_DOWN = 15;
    int NUMBER_OF_ALIENS_TO_DESTROY = 24;
    int CHANCE = 5;
    int PLAYER_WIDTH = 15;
    int PLAYER_HEIGHT = 10;

    protected Commons() {
    }

    public static Commons ensureInstance() {
        Framework.Commons instance = getInstance();
        if (!(instance instanceof Commons))
            setInstance(new Commons());

        return (Commons) getInstance();
    }

    public static int BOMB_HEIGHT() {
        return ensureInstance().BOMB_HEIGHT;
    }

    public static int ALIEN_HEIGHT() {
        return ensureInstance().ALIEN_HEIGHT;
    }

    public static int ALIEN_WIDTH() {
        return ensureInstance().ALIEN_WIDTH;
    }

    public static int ALIEN_INIT_X() {
        return ensureInstance().ALIEN_INIT_X;
    }

    public static int ALIEN_INIT_Y() {
        return ensureInstance().ALIEN_INIT_Y;
    }

    public static int GO_DOWN() {
        return ensureInstance().GO_DOWN;
    }

    public static int NUMBER_OF_ALIENS_TO_DESTROY() {
        return ensureInstance().NUMBER_OF_ALIENS_TO_DESTROY;
    }

    public static int CHANCE() {
        return ensureInstance().CHANCE;
    }

    public static int PLAYER_WIDTH() {
        return ensureInstance().PLAYER_WIDTH;
    }

    public static int PLAYER_HEIGHT() {
        return ensureInstance().PLAYER_HEIGHT;
    }
}

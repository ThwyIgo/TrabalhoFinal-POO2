package Framework;

public class Commons {
    private static Commons instance;

    protected int GROUND = 290;
    protected int BOARD_WIDTH = 358;
    protected int BOARD_HEIGHT = 350;
    protected int BORDER_RIGHT = 30;
    protected int BORDER_LEFT = 5;
    protected int INIT_PLAYER_X = 270;
    protected int INIT_PLAYER_Y = 280;
    protected int DELAY = 17;

    protected Commons() {
    }

    protected static Commons getInstance() {
        if (instance == null)
            setInstance(new Commons());
        return instance;
    }

    protected static void setInstance(Commons instance) {
        Commons.instance = instance;
    }

    // Reset default values
    public static Commons ensureInstance() {
        setInstance(new Commons());
        return getInstance();
    }

    public static int GROUND() {
        return getInstance().GROUND;
    }

    public static int BOARD_WIDTH() {
        return getInstance().BOARD_WIDTH;
    }

    public static int BOARD_HEIGHT() {
        return getInstance().BOARD_HEIGHT;
    }

    public static int BORDER_RIGHT() {
        return getInstance().BORDER_RIGHT;
    }

    public static int BORDER_LEFT() {
        return getInstance().BORDER_LEFT;
    }

    public static int INIT_PLAYER_X() {
        return getInstance().INIT_PLAYER_X;
    }

    public static int INIT_PLAYER_Y() {
        return getInstance().INIT_PLAYER_Y;
    }

    public static int DELAY() {
        return getInstance().DELAY;
    }
}

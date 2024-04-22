package SpaceInvaders.fabricas;

import Framework.fabricas.PlayerFabrica;
import Framework.sprite.Player;
import SpaceInvaders.sprite.Ship;

public class ShipFabrica implements PlayerFabrica {
    @Override
    public Player novoPlayer() {
        return new Ship();
    }
}

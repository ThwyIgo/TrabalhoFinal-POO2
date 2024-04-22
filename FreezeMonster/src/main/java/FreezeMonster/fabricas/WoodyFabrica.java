package FreezeMonster.fabricas;

import Framework.fabricas.PlayerFabrica;
import Framework.sprite.Player;
import FreezeMonster.Woody;


public class WoodyFabrica implements PlayerFabrica {
    @Override
    public Player novoPlayer() {
        return new Woody();
    }
}

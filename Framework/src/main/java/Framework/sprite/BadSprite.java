package Framework.sprite;

import java.util.LinkedList;

public abstract class BadSprite extends Sprite {
	protected LinkedList<BadSprite> badnesses = new LinkedList<>();

	public LinkedList<BadSprite> getBadnesses() {
		return badnesses;
	}
}

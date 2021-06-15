import java.awt.Graphics;

public class Rect extends Figure {
	@Override
	public void Draw(Graphics g) {
		super.Draw(g);
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
	}

}

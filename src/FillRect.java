import java.awt.Graphics;

public class FillRect extends Rect {
	@Override
	public void Draw(Graphics g) {
		super.Draw(g);
		g.fillRect(_position.x, _position.y, _size.x, _size.y);
	}
}


import java.awt.Graphics;

public class fillOval extends Figure {

	@Override
	public void Draw(Graphics g) {
		super.Draw(g);
		g.fillOval(_position.x, _position.y, _size.x, _size.y);
	}

}
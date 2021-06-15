import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Figure implements Cloneable {
	protected Point _position;
	protected Point _size;

	private Color color;
	private int size;

	public Figure() {
		setPenColor(PaintManager.getInstance().getPenColor());
		setPenSize(PaintManager.getInstance().getPenSize());
	}

	public void setPosition(Point p) {
		_position = p;
	}

	public void addPosition(Point p) {
		_position = new Point(_position.x + p.x, _position.y + p.y);
	}

	public void setSize(Point p) {
		_size = p;
	}

	public Point getPosition() {
		return _position;
	}

	public Point getSize() {
		return _size;
	}

	public void Draw(Graphics g) {
		if (_position == null || _size == null)
			return;
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(size));
		g2D.setColor(color);
	}

	public Boolean contains(Figure p) {
		if (_position.x <= p._position.x && _position.y <= p._position.y
				&& _size.x + _position.x >= p._position.x + p._size.x
				&& _size.y + _position.y >= p._position.y + p._size.y) {
			return true;
		}
		return false;
	}

	public Boolean contains(Point p) {
		if (_position.x <= p.x && _position.y <= p.y && _size.x + _position.x >= p.x && _size.y + _position.y >= p.y) {
			return true;
		}
		return false;
	}

	public void setPenColor(Color c) {
		color = c;
	}

	public void setPenSize(int s) {
		size = s;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

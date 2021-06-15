import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

public class Group extends Figure {
	private ArrayList<Figure> _containsList;

	public Group() {
		super();
		_containsList = new ArrayList<>();
	}

	@Override
	public void Draw(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(_position.x, _position.y, _size.x, _size.y);

		g.setColor(Color.black);
		for (Figure it : _containsList) {
			it.Draw(g);
		}
	}

	public void checkContainsFigure() {
		// 자기 사각형 안에 들어간 도형들을 자기 멤버(리스트)로 집어넣음
		// -1 로 자기자신 제외
		for (int i = 0; i < PaintManager.getInstance().getFigureList().size() - 1; i++) {
			Figure it = PaintManager.getInstance().getFigureList().get(i);
			if (contains(it)) {
				_containsList.add(it);
				// frame의 FigureList에서 삭제
				PaintManager.getInstance().removeFigure(it);
				// remove해줘서 list가 0부터 다시 시작됨
				i = -1;
			}
		}

	}

	public void resetSize() {
		Point p1 = new Point(999, 999);
		Point p2 = new Point(-999, -999);
		for (Figure it : _containsList) {
			p1.x = Math.min(p1.x, it._position.x);
			p1.y = Math.min(p1.y, it._position.y);
			p2.x = Math.max(p2.x, it._position.x + it._size.x);
			p2.y = Math.max(p2.y, it._position.y + it._size.y);
		}
		Point realSize = new Point(Math.abs(p1.x - p2.x) + 5, Math.abs(p1.y - p2.y) + 5);
		_position = new Point(p1.x - 3, p1.y - 3);
		_size = realSize;
	}

	@Override
	public void addPosition(Point p) {
		super.addPosition(p);
		for (Figure it : _containsList) {
			it.addPosition(p);
		}
	}

	public void end() {
		if (_containsList.size() <= 0) {
			PaintManager.getInstance().removeFigure(this);
		}
	}

	public ArrayList<Figure> getFigureList() {
		return _containsList;
	}

	public void addFigureList(Object object) {
		_containsList.add((Figure) object);
	}

	int count = 0;

	@Override
	public Object clone() throws CloneNotSupportedException {
		Group g = new Group();
		g.setPosition(_position);
		g.setSize(_size);
		System.out.println(_containsList.size() + " " + count);
		count++;
		for (Figure it : _containsList) {
			g.addFigureList(it.clone());
		}
		return g;
	}

}
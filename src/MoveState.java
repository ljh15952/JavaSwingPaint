import java.awt.Point;

public class MoveState implements StatePattern {

	Figure _clickedFigure = null;
	Point prevPt = null;

	private Figure getClickedFigure(Point p) {
		Figure temp = null;
		for (Figure it : PaintManager.getInstance().getFigureList()) {
			if (it.contains(p)) {
				temp = it;
			}
		}
		return temp;
	}

	@Override
	public void setUp() {
		_clickedFigure = null;
		prevPt = null;
	}

	@Override
	public void do_something(Point p1, Point p2) {
		if (_clickedFigure == null)
			_clickedFigure = getClickedFigure(p1);
		if (_clickedFigure == null)
			return;
		if (prevPt == null)
			prevPt = p1;

		Point dis = new Point(p2.x - prevPt.x, p2.y - prevPt.y);
		prevPt = p2;
		_clickedFigure.addPosition(dis);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

}

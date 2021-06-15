import java.awt.Point;

public class ReleaseGroupState implements StatePattern {

	Figure _clickedFigure = null;

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
	}

	@Override
	public void do_something(Point p1, Point p2) {

	}

	@Override
	public void end(Point p1, Point p2) {
		if (_clickedFigure == null)
			_clickedFigure = getClickedFigure(p1);
		if (_clickedFigure == null)
			return;
		if (_clickedFigure instanceof Group) {
			Group g = (Group) _clickedFigure;
			for (Figure it : g.getFigureList()) {
				PaintManager.getInstance().addFigureList(it);
			}

			PaintManager.getInstance().removeFigure(g);
		}

	}

}

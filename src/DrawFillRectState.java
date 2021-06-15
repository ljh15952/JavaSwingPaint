import java.awt.Point;

public class DrawFillRectState extends DrawState implements StatePattern {

	FillRect r;

	@Override
	public void setUp() {
		r = new FillRect();
		PaintManager.getInstance().addFigureList(r);
	}

	@Override
	public void do_something(Point p1, Point p2) {
		setFigure(r, p1, p2);
	}

	@Override
	public void end() {

	}

}

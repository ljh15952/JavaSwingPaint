import java.awt.Point;

public class DrawPenState extends DrawState implements StatePattern {

	@Override
	public void setUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void do_something(Point p1, Point p2) {
		//선형보간
		fillOval o = new fillOval();
		PaintManager.getInstance().addFigureList(o);
		setFigure(o, p2, new Point(p2.x + PaintManager.getInstance().getPenSize() + 3,
				p2.y + PaintManager.getInstance().getPenSize() + 3));
	}

	@Override
	public void end(Point p1, Point p2) {

	}

}

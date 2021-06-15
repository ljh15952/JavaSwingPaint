import java.awt.Point;

public class DrawLineState extends DrawState implements StatePattern {


	Line l;
	@Override
	public void do_something(Point p1, Point p2) {
		l.setPosition(p1);
		l.setSize(new Point((p2.x - p1.x), (p2.y - p1.y)));
	}

	@Override
	public void setUp() {
		l = new Line();
		PaintManager.getInstance().addFigureList(l);
	}

	@Override
	public void end() {
		
	}

}
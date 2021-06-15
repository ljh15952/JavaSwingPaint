import java.awt.Point;

public class DrawFillOvalState extends DrawState implements StatePattern {

	fillOval o;
	@Override
	public void setUp() {
		o = new fillOval();
		PaintManager.getInstance().addFigureList(o);
	}
	@Override
	public void do_something(Point p1, Point p2) {
		setFigure(o,p1,p2);
	}
	@Override
	public void end(Point p1,Point p2) {
		
	}

}

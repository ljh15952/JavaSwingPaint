import java.awt.Point;

public class DrawGroupState extends DrawState implements StatePattern {

	Group g;
	@Override
	public void setUp() {
		g = new Group();
		PaintManager.getInstance().addFigureList(g);
	}
	@Override
	public void do_something(Point p1, Point p2) {
		setFigure(g, p1, p2);
//		g.setPosition(getPosition(p1, p2));
//		g.setSize(getSize(p1, p2));
		g.checkContainsFigure();
		g.resetSize();
	}
}

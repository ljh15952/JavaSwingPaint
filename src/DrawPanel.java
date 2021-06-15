import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private Point firstPos;
	private Point endPos;
	private Label figureCount;

	public DrawPanel() {
		PaintManager.getInstance().setDrawPanel(this);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1280, 1280));
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		addMouseListener(clickListener);
		addMouseMotionListener(dragListener);

		figureCount = new Label("0");
		figureCount.setPreferredSize(new Dimension(1280, 10));
		add(figureCount);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (Figure it : PaintManager.getInstance().getFigureList()) {
			it.Draw(g);
		}
	}
	public void SetFigureCount() {
		figureCount.setText(Integer.toString(PaintManager.getInstance().getFigureList().size()));
	}
	private class ClickListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			PaintManager.getInstance().setUp();
			firstPos = e.getPoint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			endPos = e.getPoint();
			PaintManager.getInstance().do_something(firstPos, endPos);
			PaintManager.getInstance().endEvnet(firstPos, endPos);
			SetFigureCount();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	private class DragListener extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			endPos = e.getPoint();
			PaintManager.getInstance().do_something(firstPos, endPos);
			repaint();
		}
	}
}

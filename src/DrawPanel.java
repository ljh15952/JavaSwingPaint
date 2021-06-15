import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	public DrawPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1280, 1280));
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		addMouseListener(clickListener);
		addMouseMotionListener(dragListener);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(PaintManager.getInstance().getPenSize()));
		g2D.setColor(PaintManager.getInstance().getPenColor());
		g.drawLine(0, 0, 800, 800);
	}

	private class ClickListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("qwe");
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

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
			repaint();
		}
	}
}

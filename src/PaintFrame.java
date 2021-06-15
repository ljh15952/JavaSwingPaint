import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PaintFrame extends JFrame {

	public PaintFrame() {
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		DrawPanel drawPanel = new DrawPanel();
		MenuPanel menuPanel = new MenuPanel();
		ToolPanel toolPanel = new ToolPanel();
		PenOptionPanel penPanel = new PenOptionPanel();

		JScrollPane sc = new JScrollPane(drawPanel);

		// add(drawPanel, BorderLayout.CENTER);
		add(sc, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.NORTH);
		add(toolPanel, BorderLayout.WEST);
		add(penPanel, BorderLayout.SOUTH);

		setJMenuBar(menuPanel.menuBar);
	}
}

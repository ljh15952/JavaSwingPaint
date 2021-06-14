import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	public PaintFrame() {
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		DrawPanel drawPanel = new DrawPanel();
		MenuPanel menuPanel = new MenuPanel();
		ToolPanel toolPanel = new ToolPanel();
		PenOptionPanel penPanel = new PenOptionPanel();

		// 영역 나누기 테스트
		drawPanel.setPreferredSize(new Dimension(100, 100));
		menuPanel.setPreferredSize(new Dimension(100, 1));
		toolPanel.setPreferredSize(new Dimension(100, 100));
		penPanel.setPreferredSize(new Dimension(100, 100));

		drawPanel.setBackground(Color.RED);
		//menuPanel.setBackground(Color.GRAY);
		toolPanel.setBackground(Color.GREEN);
		penPanel.setBackground(Color.BLUE);

		add(drawPanel, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.NORTH);
		add(toolPanel, BorderLayout.WEST);
		add(penPanel, BorderLayout.SOUTH);
		
		setJMenuBar(menuPanel.menuBar);
	}
}

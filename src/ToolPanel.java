import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolPanel extends JPanel implements ActionListener {

	JButton penBtn;
	JButton rectBtn;
	JButton ovalBtn;
	JButton lineBtn;

	public ToolPanel() {
		setPreferredSize(new Dimension(120, 100));
		setBackground(Color.GREEN);
		// setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

		JToolBar toolBar = new JToolBar("Paint Menu");
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		toolBar.setPreferredSize(new Dimension(100, 300));
		// 나중에 그림으로 대체
		penBtn = new JButton("Pen");
		rectBtn = new JButton("r");
		ovalBtn = new JButton("o");
		lineBtn = new JButton("l");

		penBtn.setPreferredSize(new Dimension(40, 40));
		rectBtn.setPreferredSize(new Dimension(40, 40));
		ovalBtn.setPreferredSize(new Dimension(40, 40));
		lineBtn.setPreferredSize(new Dimension(40, 40));

		penBtn.addActionListener(this);
		rectBtn.addActionListener(this);
		ovalBtn.addActionListener(this);
		lineBtn.addActionListener(this);

		toolBar.add(penBtn);
		toolBar.add(rectBtn);
		toolBar.add(ovalBtn);
		toolBar.add(lineBtn);

		add(toolBar, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (penBtn == e.getSource()) {
			System.out.println("Press pen Button");
		} else if (rectBtn == e.getSource()) {
			System.out.println("Press rect Button");
		} else if (ovalBtn == e.getSource()) {
			System.out.println("Press oval Button");
		} else if (lineBtn == e.getSource()) {
			System.out.println("Press Line Button");
		}
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolPanel extends JPanel implements ActionListener {

	JButton penBtn;
	JButton rectBtn;
	JButton ovalBtn;
	JButton lineBtn;
	JButton groupBtn;
	JButton moveBtn;
	JButton fillRectBtn;
	JButton fillOvalBtn;
	JButton pasteBtn;
	JButton deleteGroupBtn;
	JButton releaseGroupBtn;

	public ToolPanel() {
		setPreferredSize(new Dimension(120, 100));
		setBackground(Color.LIGHT_GRAY);
		// setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

		JToolBar toolBar = new JToolBar("Paint Menu");
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		toolBar.setPreferredSize(new Dimension(100, 300));
		// 나중에 그림으로 대체
		ImageIcon penIcon = new ImageIcon("sprite/penIcon.png");
		ImageIcon rectIcon = new ImageIcon("sprite/rectIcon.png");
		ImageIcon ovalIcon = new ImageIcon("sprite/ovalIcon.png");
		ImageIcon lineIcon = new ImageIcon("sprite/lineIcon.png");
		ImageIcon groupIcon = new ImageIcon("sprite/groupIcon.png");
		ImageIcon moveIcon = new ImageIcon("sprite/moveIcon.png");
		ImageIcon fillRectIcon = new ImageIcon("sprite/fillRectIcon.png");
		ImageIcon fillOvalIcon = new ImageIcon("sprite/fillOvalIcon.png");
		ImageIcon copyIcon = new ImageIcon("sprite/copyIcon.png");
		ImageIcon deleteIcon = new ImageIcon("sprite/deleteIcon.png");
		ImageIcon releaseGroupIcon = new ImageIcon("sprite/releaseGroupIcon.png");

		penBtn = new JButton(penIcon);
		rectBtn = new JButton(rectIcon);
		ovalBtn = new JButton(ovalIcon);
		lineBtn = new JButton(lineIcon);
		groupBtn = new JButton(groupIcon);
		moveBtn = new JButton(moveIcon);
		fillRectBtn = new JButton(fillRectIcon);
		fillOvalBtn = new JButton(fillOvalIcon);
		pasteBtn = new JButton(copyIcon);
		deleteGroupBtn = new JButton(deleteIcon);
		releaseGroupBtn = new JButton(releaseGroupIcon);

		penBtn.setPreferredSize(new Dimension(40, 40));
		rectBtn.setPreferredSize(new Dimension(40, 40));
		ovalBtn.setPreferredSize(new Dimension(40, 40));
		lineBtn.setPreferredSize(new Dimension(40, 40));
		groupBtn.setPreferredSize(new Dimension(40, 40));
		moveBtn.setPreferredSize(new Dimension(40, 40));
		fillRectBtn.setPreferredSize(new Dimension(40, 40));
		fillOvalBtn.setPreferredSize(new Dimension(40, 40));
		pasteBtn.setPreferredSize(new Dimension(40, 40));
		deleteGroupBtn.setPreferredSize(new Dimension(40, 40));
		releaseGroupBtn.setPreferredSize(new Dimension(40, 40));

		penBtn.addActionListener(this);
		rectBtn.addActionListener(this);
		ovalBtn.addActionListener(this);
		lineBtn.addActionListener(this);
		groupBtn.addActionListener(this);
		moveBtn.addActionListener(this);
		fillRectBtn.addActionListener(this);
		fillOvalBtn.addActionListener(this);
		pasteBtn.addActionListener(this);
		deleteGroupBtn.addActionListener(this);
		releaseGroupBtn.addActionListener(this);

		toolBar.add(penBtn);
		toolBar.add(rectBtn);
		toolBar.add(ovalBtn);
		toolBar.add(lineBtn);
		toolBar.add(groupBtn);
		toolBar.add(moveBtn);
		toolBar.add(fillRectBtn);
		toolBar.add(fillOvalBtn);
		toolBar.add(pasteBtn);
		toolBar.add(deleteGroupBtn);
		toolBar.add(releaseGroupBtn);

		add(toolBar, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (penBtn == e.getSource()) {
			System.out.println("Press pen Button");
			PaintManager.getInstance().setStatePattern(new DrawPenState());
		} else if (rectBtn == e.getSource()) {
			System.out.println("Press rect Button");
			PaintManager.getInstance().setStatePattern(new DrawRectState());
		} else if (ovalBtn == e.getSource()) {
			System.out.println("Press oval Button");
			PaintManager.getInstance().setStatePattern(new DrawOvalState());
		} else if (lineBtn == e.getSource()) {
			System.out.println("Press Line Button");
			PaintManager.getInstance().setStatePattern(new DrawLineState());
		} else if (groupBtn == e.getSource()) {
			System.out.println("Press Group Button");
			PaintManager.getInstance().setStatePattern(new DrawGroupState());
		} else if (moveBtn == e.getSource()) {
			System.out.println("Press Move Button");
			PaintManager.getInstance().setStatePattern(new MoveState());
		} else if (fillRectBtn == e.getSource()) {
			System.out.println("Press FillRect Button");
			PaintManager.getInstance().setStatePattern(new DrawFillRectState());
		} else if (fillOvalBtn == e.getSource()) {
			System.out.println("Press fillOvalBtn Button");
			PaintManager.getInstance().setStatePattern(new DrawFillOvalState());
		} else if (pasteBtn == e.getSource()) {
			System.out.println("Press paste Button");
			PaintManager.getInstance().setStatePattern(new PasteState());
		} else if (deleteGroupBtn == e.getSource()) {
			System.out.println("Press deleteGroupBtn Button");
			PaintManager.getInstance().setStatePattern(new DeleteState());
		} else if (releaseGroupBtn == e.getSource()) {
			System.out.println("Press releaseGroupBtn Button");
			PaintManager.getInstance().setStatePattern(new ReleaseGroupState());
		}
	}
}

package com.ylw.net.tools;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class JInternalFrame1 extends JFrame implements ActionListener {

	JDesktopPane desktopPane;
	int count = 1;

	public JInternalFrame1() {
		super("JInternalFrame1");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JButton b = new JButton("Create New Internal Frames");
		b.addActionListener(this);// 当用户按下按钮时，将运行actionPerformed()中的程序
		contentPane.add(b, BorderLayout.SOUTH);
		/*
		 * 建立一个新的JDesktopPane并加入于contentPane中
		 */
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);

		setSize(350, 350);
		show();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/*
	 * 产生一个可关闭、可改变大小、具有标题、可最大化与最小化的Internal Frame.
	 */
	public void actionPerformed(ActionEvent e) {
		JInternalFrame internalFrame = new JInternalFrame("Internal Frame "
				+ (count++), true, true, true, true);

		internalFrame.setLocation(20, 20);
		internalFrame.setSize(200, 200);
		internalFrame.setVisible(true);
		// 取得JInternalFrame的Content Pane,用以加入新的组件。
		Container icontentPane = internalFrame.getContentPane();
		JTextArea textArea = new JTextArea();
		JButton b = new JButton("Internal Frame Button");
		/*
		 * 将JTextArea与JButton对象加入JInternalFrame中。由此呆知，JInteranlFrame加入组件
		 * 的方式与JFrame是一模一样。
		 */
		icontentPane.add(textArea, "Center");
		icontentPane.add(b, "South");
		// 将JInternalFrame加入JDesktopPane中，如此一来，即使产生很多JInternalFrame,JDesktopPane也
		// 能将它们之间的关系管理得相当良好。
		desktopPane.add(internalFrame);

		try {
			internalFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException ex) {
			System.out.println("Exception while selecting");
		}
	}

	public static void main(String[] args) {
		new JInternalFrame1();
	}
}

 
package frame04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame(String title) {
		super(title);
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		JButton btn1 = new JButton("버튼1");
		add(btn1, BorderLayout.NORTH);
		JButton btn2 = new JButton("버튼2");
		add(btn2, BorderLayout.EAST);
		JButton btn3 = new JButton("버튼3");
		add(btn3, BorderLayout.SOUTH);
		JButton btn4 = new JButton("버튼4");
		add(btn4, BorderLayout.WEST);

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료 됩니다.");
	}
}

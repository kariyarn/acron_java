package frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame(String title) {
		super(title);
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//FlowLayout 매니저 사용해보기
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn1 = new JButton("버튼1");
		add(btn1);//프레임에 버튼 추가하기
		
		JButton btn2 = new JButton("버튼2");
		add(btn2);//프레임에 버튼 추가하기
		
		JButton btn3 = new JButton("버튼3");
		add(btn3);//프레임에 버튼추가하기
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료 됩니다.");
	}
}

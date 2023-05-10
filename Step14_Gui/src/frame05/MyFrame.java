package frame05;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	
	public MyFrame(String title) {
		super(title);
		this.setBounds(800, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());
		
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		Component a = this;
		
		//ActionListener 인터페이스 type의 참조값을 얻어내서
		ActionListener listener1 = new ActionListener() {
			//이 리스너를 등록한 UI에 어떤 액션이 발생하면 호출되는 메소드
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ActionListener b = this;
				
				System.out.println("전송 버튼을 눌렀다.");
				//JOptionPane.showMessage(프레임의 참조값, 띄울 메시지);
				//클래스명. this하면 바깥에 있는 클래스로 생성한 객체의 참조값을 가리킬 수 있다.
				//첫번째 인자는 어떤 프레임에 띄울 것인지(프레임의 참조값) 뒤는 띄울 메시지
				JOptionPane.showMessageDialog( MyFrame.this, "전송합니다.");
			}
		};
		
		//전송버튼에 등록하기
		sendBtn.addActionListener(listener1);
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		/*
		 * deleteBtn.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("삭제 버튼을 눌렀습니다."); } });
		 */
		
		//ActionListener 인터페이스 type의 참조값을 함수 형태로 전달도 가능
		deleteBtn.addActionListener((e)->{
			System.out.println("삭제에에에엣");
			//함수 형태의 메소드에서 this는 바깥 클래스로 생성한 객체의 참조값을 가리킬 수 있다.
			JOptionPane.showMessageDialog(this, "삭제합니다");
		});
		
		JButton updateBtn=new JButton("수정");
		add(updateBtn);
		//MyFrame 을 ActionListner 인터페이스 type으로 만들수는 없을까?
		updateBtn.addActionListener(this);

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료 됩니다.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "수정합니다.");
	}
}

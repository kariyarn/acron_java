package frame07;

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
		//전송 버튼의 참조값을 필드에 저장(this.는 생략 가능)
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		JButton updateBtn=new JButton("수정");
		add(updateBtn);
		//전송, 삭제, 수정 버튼 모드다 하나의 리스너 등록하기
		sendBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		
		//각각의 버튼에 action 명령을 설정할 수 있다.
		sendBtn.setActionCommand("send");
		deleteBtn.setActionCommand("delete");
		updateBtn.setActionCommand("update");

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료 됩니다.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 읽어오기
		String cmd=e.getActionCommand();
		/*
		 * java에서 문자열의 참조값이 같은지 비교할때는 비교 연산자 ==를 이용해서 비교하면 되지만
		 * 문자열의 참조값이 아닌 내용이 같은지 비교할때는 String의 .equals()메소드를 이용해서 비교해야 한다.
		 * 왜냐하면 java에서는 문자열을 만드는 방법에 따라서 내용은 같지만 참조값이 다르게 나오는 경우도 있기 때문이다.
		 * 따라서, 문자열의 내용이 같은지 정확히 비교할때는 반드시 .equals()메소드를 이용해야 한다.
		 * 이거 까먹으면 밤샐수도 있음
		 */
		if(cmd.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송합니다.");
		}else if(cmd.equals("delete")) {
			JOptionPane.showMessageDialog(this, "삭제합니다.");			
		}else if(cmd.equals("update"))
			JOptionPane.showMessageDialog(this, "수정합니다.");
	}
}

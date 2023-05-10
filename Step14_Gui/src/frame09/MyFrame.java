package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg1;
	JTextField inputMsg2;
	JLabel label;
	
	//생성자	
	public MyFrame(String title) {
		super(title);
		//초기 위치와 크기 설정
		setBounds(100, 100, 900, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField 2개 필요
		this.inputMsg1 = new JTextField(10);
		this.inputMsg2 = new JTextField(10);
		//JButton 4개 필요
		JButton plusBtn = new JButton("+");
		JButton minusBtn = new JButton("-");
		JButton timeBtn = new JButton("*");
		JButton divideBtn = new JButton("/");
		//JLable 2개 필요
		JLabel la1 = new JLabel("=");
		JLabel la2 = new JLabel("0");
		
		//버튼에 ActionListner 등록하고
		plusBtn.addActionListener((e)->{
			//예외처리
			try {
			Double n1 = Double.parseDouble(this.inputMsg1.getText());
			Double n2 = Double.parseDouble(this.inputMsg2.getText());
			Double result = n1 + n2;
			String ans = Double.toString(result);
			la2.setText(ans);
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "숫자만 입력해주세요");
			}
		});
		minusBtn.addActionListener((e)->{
			try {
			Double n1 = Double.parseDouble(this.inputMsg1.getText());
			Double n2 = Double.parseDouble(this.inputMsg2.getText());
			Double result = n1 - n2;
			String ans = Double.toString(result);
			la2.setText(ans);
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "숫자만 입력해주세요");
			}
		});
		timeBtn.addActionListener((e)->{
			try {
			Double n1 = Double.parseDouble(this.inputMsg1.getText());
			Double n2 = Double.parseDouble(this.inputMsg2.getText());
			Double result = n1 * n2;
			String ans = Double.toString(result);
			la2.setText(ans);
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "숫자만 입력해주세요");
			}
		});
		divideBtn.addActionListener((e)->{
			try {
			Double n1 = Double.parseDouble(this.inputMsg1.getText());
			Double n2 = Double.parseDouble(this.inputMsg2.getText());
			//만일 나눌 숫자가 0이라면
			if(n2 == 0) {
				JOptionPane.showMessageDialog(this, "0은 나눌 수가 될 수 없습니다.");
			}else {
			Double result = n1 / n2;
			String ans = Double.toString(result);
			la2.setText(ans);
			}
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "숫자만 입력해주세요");
			}
		});
		add(inputMsg1);
		add(plusBtn);
		add(minusBtn);
		add(timeBtn);
		add(divideBtn);
		add(inputMsg2);
		add(la1);
		add(la2);
	
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame("계산기");
	}
	//ActionListener 인터페이스를 구현했기 때문에 강제 오버라이드된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}

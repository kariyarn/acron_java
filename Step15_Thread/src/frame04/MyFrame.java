package frame04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import test.mypac.AnotherThread;
import test.mypac.CountRunnabble;

public class MyFrame extends JFrame implements ActionListener{
	   public MyFrame(String title) {
		  super(title);
	      setBounds(100, 100, 500, 500);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLayout(new FlowLayout());
	      
	      JButton countBtn=new JButton("카운트다운");
	      countBtn.addActionListener(this);
	      add(countBtn);
	      
	      JTextField tf=new JTextField(10);
	      add(tf);
	      
	      setVisible(true);
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
//		CountRunnabble runnable = new CountRunnabble();
//		Thread t = new Thread(runnable);
//		t.start();
		
		//위의 3줄을 줄여서 아래와 같이 사용할 수도 있다.
		new Thread(new CountRunnabble()).start();
	}

	
	//run했을때 app이 시작되는 아주 특별한 main메소드
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}

}

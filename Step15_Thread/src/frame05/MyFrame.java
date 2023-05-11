package frame05;

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
//		new Thread() {
//			@Override
//			public void run() {
//				//카운트 값을 저장할 지역변수 만들고 초기 값 대입
//				int count =10;
//				while(true) {
//					System.out.println("현재 count : "+count);
//					if(count == 0) {//만일 카운트가 0이면
//						break;//반복문 탈출
//					}
//					try {
//						//1초마다
//						Thread.sleep(1000);
//					}catch(InterruptedException e){
//						e.printStackTrace();
//					}
//					//카운트를 1씩 감소시키고
//					count--;
//				}
//			}
//		}.start();
		
		new Thread(new Runnable() {
					@Override
					public void run() {
						
					}
				}).start(); 
				
				new Thread(()->{
					int count =10;
					while(true) {
						System.out.println("현재 count : "+count);
						if(count == 0) {//만일 카운트가 0이면
							break;//반복문 탈출
						}
						try {
							//1초마다
							Thread.sleep(1000);
						}catch(InterruptedException e2){
							e2.printStackTrace();
						}
						//카운트를 1씩 감소시키고
						count--;
					}
				}).start();		
	}
	//run했을때 app이 시작되는 아주 특별한 main메소드
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}

package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Quiz extends JFrame implements ActionListener {
	
	//필드
	JTextField tf_num, tf_name, tf_addr;
	//생성자
	public Quiz(String title) {		
		super(title);
		setBounds(100, 100, 900, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField 3개
		tf_num = new JTextField(10);
		tf_name = new JTextField(10);
		tf_addr = new JTextField(10);
		
		//JButton 1개
		JButton saveBtn = new JButton("저장하기");
		
		//UI를 프레임에 배치
		add(tf_num);
		add(tf_name);
		add(tf_addr);
		add(saveBtn);
		//save버튼에 액션 리스너 등록
		
		saveBtn.addActionListener((e)->{
			Connection conn=null;
			
			try {
				//오라클 드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//접속할 DB의 정보@아이피주소 : port번호 :db이름
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				conn=DriverManager.getConnection(url, "scott", "tiger");
				System.out.println("Oracle DB접속 성공");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			PreparedStatement pstmt = null;
			String oraNum = tf_num.getText();
			String oraName = tf_name.getText();
			String oraAddr = tf_addr.getText();
			try {
				Integer num = Integer.parseInt(oraNum);
				String sql = " INSERT INTO member "
						+" (num, name, addr) "
						+" VALUES (?, ?, ?) ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, oraName);
				pstmt.setString(3, oraAddr);
				pstmt.executeUpdate();
				System.out.println("회원 정보를 수정했습니다.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		});
		saveBtn.setActionCommand("save");
		setVisible(true);
		
	}
	public static void main(String[] args) {		
		new Quiz("Oracle");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

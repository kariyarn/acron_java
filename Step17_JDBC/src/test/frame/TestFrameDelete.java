package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.DeptDao;
import test.dao.MemberDao;
import test.dto.DeptDto;
import test.dto.MemberDto;

public class TestFrameDelete extends JFrame{
	//필드
	JTextField inputNum;
	
	//생성자
	public TestFrameDelete(String title) {
		super(title);
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		JLabel lebel1 = new JLabel("삭제할 번호");
		inputNum = new JTextField(10);
		JButton enterBtn = new JButton("입력");
		
		//패널에 UI를 배치하고Z
		JPanel panel = new JPanel();
		panel.add(lebel1);
		panel.add(inputNum);
		panel.add(enterBtn);
		
		//패널째로 프레임의 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		
		//부모 객체의 메소드를 마음대로 호출할 수 있음. this생략 가능
		//TextFrame객체 안쪽
		panel.setBackground(Color.yellow);
		
		JTable table = new JTable();
		String[] colNames = {"번호", "이름", "주소"};
		//테이블에 연결할 모델객체 생성(테이블에 출력할 데이터를 여기에 추가하면 테이블에 출력된다)
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능하도록 테이블을 JScrollPane에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		//테이블을 프레임의 중앙에 배치한다.
		add(scroll, BorderLayout.CENTER);
		
		enterBtn.addActionListener((e)->{
			try {
				int num = Integer.parseInt(this.inputNum.getText());
				
				boolean isSuccess = new MemberDao().delete(num);
				if(isSuccess) {
					System.out.println("삭제했습니다.");
				}				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
	}
	
	//run했을 때 실행의 흐름이 시작되는 main메소드
	public static void main(String[] args) {
		//static 메소드는 static영역에 만들어진다.
		TestFrameDelete f = new TestFrameDelete("테스트 프레임");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
		//TextFrame 클래스 안쪽
	}
}

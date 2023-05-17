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

public class TestFrameAllfunction extends JFrame{
	//필드
	JTextField inputNum;
	JTextField inputName;
	JTextField inputAddr;
	
	//생성자
	public TestFrameAllfunction(String title) {
		super(title);
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		JLabel lebel1 = new JLabel("번호");
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("주소");
		inputNum = new JTextField(10);
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);
		JButton enterBtn = new JButton("전체조회");
		JButton enterOneBtn = new JButton("한명조회");
		JButton saveBtn = new JButton("추가");
		JButton updateBtn = new JButton("수정");
		JButton deleteBtn = new JButton("삭제");
		
		//패널에 UI를 배치하고
		JPanel panel = new JPanel();
		panel.add(lebel1);
		panel.add(inputNum);
		panel.add(inputName);
		panel.add(inputAddr);
		panel.add(enterBtn);
		panel.add(enterOneBtn);
		panel.add(saveBtn);
		panel.add(updateBtn);
		panel.add(deleteBtn);
		
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
			//회원목록을 얻어오기
			List<MemberDto> list = new MemberDao().getList();
			//반복문 돌면서
			for (MemberDto tmp : list) {
				//memberDto 객체 하나당 Object[]를 하나씩 만들어서
				Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
				//모델에 추가하기
				model.addRow(row);
			}
		});
		
		saveBtn.addActionListener((e)->{
			try {
				int num = Integer.parseInt(this.inputNum.getText());
				String name = this.inputName.getText();
				String addr = this.inputAddr.getText();
				
				MemberDto dto = new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				
				MemberDao dao = new MemberDao();
				boolean isSuccess = dao.insert(dto);
				if(isSuccess) {
					System.out.println("저장했습니다.");
					Object[] row = {dto.getNum(), dto.getName(), dto.getAddr()};
					model.addRow(row);
				}				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		enterOneBtn.addActionListener((e)->{
			try {
				int num = Integer.parseInt(this.inputNum.getText());
				MemberDto dto = new MemberDao().getData(num);
				Object[] row = {dto.getNum(), dto.getName(), dto.getAddr()};
				model.addRow(row);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		updateBtn.addActionListener((e)->{
			try {
				int num = Integer.parseInt(this.inputNum.getText());
				String name = this.inputName.getText();
				String addr = this.inputAddr.getText();
				
				MemberDto dto = new MemberDto(num, name, addr);
				boolean isSuccess = new MemberDao().update(dto);
				if(isSuccess) {
					System.out.println("수정했습니다.");
					Object[] row = {dto.getNum(), dto.getName(), dto.getAddr()};
					model.addRow(row);
				}				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		deleteBtn.addActionListener((e)->{
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
		TestFrameAllfunction f = new TestFrameAllfunction("테스트 프레임");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
		//TextFrame 클래스 안쪽
	}
}

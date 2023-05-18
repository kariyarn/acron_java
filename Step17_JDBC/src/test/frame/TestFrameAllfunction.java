package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.DeptDao;
import test.dao.MemberDao;
import test.dto.DeptDto;
import test.dto.MemberDto;

public class TestFrameAllfunction extends JFrame implements ActionListener{
	//필드
	JTextField inputNum;
	JTextField inputName;
	JTextField inputAddr;
	DefaultTableModel model;
	
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
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
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
		//JTable로부터 선택된 row의 인덱스를 얻어낸다.
		int selectedRow = table.getSelectedRow();
		
		String[] colNames = {"번호", "이름", "주소"};
		//테이블에 연결할 모델객체 생성(테이블에 출력할 데이터를 여기에 추가하면 테이블에 출력된다)
		model = new DefaultTableModel(colNames, 0);
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능하도록 테이블을 JScrollPane에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		//테이블을 프레임의 중앙에 배치한다.
		add(scroll, BorderLayout.CENTER);
		
		enterBtn.addActionListener((e)->{
			displayMember();
			});
		
		saveBtn.addActionListener((e)->{
			try {
				String name = this.inputName.getText();
				String addr = this.inputAddr.getText();
				
				MemberDto dto = new MemberDto();
				dto.setName(name);
				dto.setAddr(addr);
				
				MemberDao dao = new MemberDao();
				boolean isSuccess = dao.insert(dto);
				JOptionPane.showMessageDialog(this, "저장했습니다.");
				if(isSuccess) {
					model.setRowCount(0);
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
				model.setRowCount(0);
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
				JOptionPane.showMessageDialog(this, "수정했습니다.");
				
				MemberDto dto = new MemberDto(num, name, addr);
				boolean isSuccess = new MemberDao().update(dto);
				if(isSuccess) {
					model.setRowCount(0);
					Object[] row = {dto.getNum(), dto.getName(), dto.getAddr()};
					model.addRow(row);
				}				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		deleteBtn.addActionListener((e)->{
			try {
				if(selectedRow != -1) {
					JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요.");
					return;//메소드를 여기에서 끝내라
				}else{
					//선택된 row에 해당하는 회원번호(PK)를 얻어낸다.
					int num = (int)model.getValueAt(selectedRow, 0);
					//MemberDao 객체를 이용해서 회원 정보를 삭제한다.
					boolean isSuccess = new MemberDao().delete(num);	
					if(isSuccess) {
						JOptionPane.showMessageDialog(this, "삭제했습니다.");
					}		
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
		f.setBounds(100, 100, 1000, 500);
		f.setVisible(true);
		//TextFrame 클래스 안쪽
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	//TestFrame에 메소드 추가
	public void displayMember() {
		model.setRowCount(0);
		//회원목록을 얻어오기
		List<MemberDto> list = new MemberDao().getList();
		//반복문 돌면서
		for (MemberDto tmp : list) {
			//memberDto 객체 하나당 Object[]를 하나씩 만들어서
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			//모델에 추가하기
			model.addRow(row);
	}
}
}

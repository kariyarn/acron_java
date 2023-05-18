package myTable;

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

import test.dao.MyStuffDao;
import test.dto.MyStuffDto;

public class MyStuff extends JFrame implements ActionListener{
	//필드(나중에 추가)
	JTextField inputName;
	JTextField inputStuffNum;
	JTextField inputPrice;
	JTextField inputUsage;
	JTextField inputNote;
	JTextField inputNum;
	
	DefaultTableModel model;
	JTable table;
	//생성자)
	public MyStuff(String title) {
		super(title);
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		//요소 설정
		JLabel labelNum = new JLabel("번호");
		inputNum = new JTextField(2);
		JLabel labelName = new JLabel("물건 이름");
		inputName = new JTextField(10);
		JLabel labelStuffNum = new JLabel("갯수");
		inputStuffNum = new JTextField(2);
		JLabel labelPrice = new JLabel("가격");
		inputPrice = new JTextField(10);
		JLabel labelUsage = new JLabel("용도");
		inputUsage = new JTextField(20);
		JLabel labelNote = new JLabel("주의");
		inputNote = new JTextField(20);
		
		JButton addBtn = new JButton("추가");
		addBtn.setActionCommand("add");
		addBtn.addActionListener(this);
		
		JButton updateBtn = new JButton("수정");
		updateBtn.setActionCommand("update");
		updateBtn.addActionListener(this);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		//패널에 UI를 배치
		JPanel panel = new JPanel();
		panel.add(labelNum);
		panel.add(inputNum);
		panel.add(labelName);
		panel.add(inputName);
		panel.add(labelStuffNum);
		panel.add(inputStuffNum);
		panel.add(labelPrice);
		panel.add(inputPrice);
		panel.add(labelUsage);
		panel.add(inputUsage);
		panel.add(labelNote);
		panel.add(inputNote);
		panel.add(addBtn);
		panel.add(updateBtn);
		panel.add(deleteBtn);
		
		//패널을 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.gray);
		
		//JTable
		table = new JTable();
		
		String[] colNames = {"번호", "물건 이름", "갯수", "가격", "용도", "주의점" };
		model = new DefaultTableModel(colNames, 0);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);		
		
		displayMystff();
		
	}
	
	//main 메소드
	public static void main(String[] args) {
		MyStuff f = new MyStuff("학원 물건");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1200, 500);
		f.setVisible(true);
	}
	
	//ActionPerfomed
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("add")) {
			String name = inputName.getText();
			String stuffNum = inputStuffNum.getText();
			Integer stuffNum2 = Integer.parseInt(stuffNum);
			String price = inputPrice.getText();
			Integer price2 = Integer.parseInt(price);
			String usage = inputUsage.getText();
			String note = inputNote.getText();
			MyStuffDto dto = new MyStuffDto();
			dto.setName(name);
			dto.setStuffNum(stuffNum2);
			dto.setPrice(price2);
			dto.setUsage(usage);
			dto.setNote(note);
			boolean isSuccess = new MyStuffDao().insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "저장했습니다.");
				displayMystff();
			}
		}else if(cmd.equals("delete")) {
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요");
				return;
			}
			int asnwer = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?");
			if(asnwer == JOptionPane.NO_OPTION || asnwer == JOptionPane.CANCEL_OPTION) {
				return;
			}else if(asnwer == JOptionPane.YES_OPTION) {
				int num = (int)model.getValueAt(selectedRow, 0);
				new MyStuffDao().delete(num);
				displayMystff();
			}
		}else if(cmd.equals("update")) {
			//일단 먼저 Update문 만들고 생각하자.
			//기기도 전에 뛰려고 하지 말자.
			
			String num = inputNum.getText();
			Integer num2 = Integer.parseInt(num);
			String name = inputName.getText();
			String stuffNum = inputStuffNum.getText();
			Integer stuffNum2 = Integer.parseInt(stuffNum);
			String price = inputPrice.getText();
			Integer price2 = Integer.parseInt(price);
			String usage = inputUsage.getText();
			String note = inputNote.getText();
			MyStuffDto dto = new MyStuffDto();
			dto.setNum(num2);
			dto.setName(name);
			dto.setStuffNum(stuffNum2);
			dto.setPrice(price2);
			dto.setUsage(usage);
			dto.setNote(note);
			boolean isSuccess = new MyStuffDao().update(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "수정했습니다.");
				displayMystff();
			}
		}
	}
	
	public void displayMystff() {
		model.setRowCount(0);
		List<MyStuffDto> list = new MyStuffDao().getList();
		int all = 0;
		
		for(MyStuffDto tmp : list) {
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getStuffNum(), tmp.getPrice(), tmp.getUsage(), tmp.getNote()};
			model.addRow(row);
		}
		for(MyStuffDto tmp : list) {
			all += tmp.getPrice();
		}
		Object[] row = {"", "", "총 가격", all};
		model.addRow(row);
	}
}
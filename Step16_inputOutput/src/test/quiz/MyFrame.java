package test.quiz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JButton saveBtn;
	JTextField txt;


	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 900, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		txt = new JTextField(20);
		saveBtn = new JButton("저장");
		
		add(txt);
		add(saveBtn);
		
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame("일기장");
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		try {
			String tmptxt = txt.getText();
			File f = new File("c:/acorn202304/myFolder/diary.txt");
			try {
				if(!f.exists()) {
					f.createNewFile();
				}
				FileWriter fw = new FileWriter(f, true);
				fw.write(tmptxt);
				fw.write("\r\n");
				fw.flush();
				fw.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "저장되었습니다.");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}

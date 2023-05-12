package test.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame02 extends JFrame {
   
   public MyFrame02(String title) {
      super(title);
      
      setBounds(100, 100, 500, 500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //BorderLayout 으로 설정 
      setLayout(new BorderLayout());
      
      //메뉴 바
      JMenuBar mb = new JMenuBar();
      //메뉴
      JMenu menu = new JMenu("file");
      //메뉴 아이템
      JMenuItem openItem = new JMenuItem("open");
      JMenuItem saveItem = new JMenuItem("save As");
      //메뉴에 메뉴 아이템을 순서대로 추가
      menu.add(openItem);
      menu.add(saveItem);
      //메뉴를 메뉴바에 추가
      mb.add(menu);
      //프레임의 메소드를 이용해서 메뉴바를 추가하기
      setJMenuBar(mb);
            
      //UI 를 감쌀 페널
      JPanel p1=new JPanel();
      
      JTextField inputText=new JTextField(20);
      JButton saveBtn=new JButton("저장");
      
      //페널에 UI 를 추가
      p1.add(inputText);
      p1.add(saveBtn);
      
      //open을 눌렀을 때 실행할 리스너 목록
      openItem.addActionListener((e2)->{
    	  JFileChooser fc=new JFileChooser();
    	  int result = fc.showOpenDialog(this);
    	  if(result == JFileChooser.APPROVE_OPTION) {
    		  //선택한 파일을 제어할 수 있는 File 객체가 리턴된다.
    		  File f=fc.getSelectedFile();
    	  }
      });
      
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new MyFrame02("나의 프레임");
   }
}

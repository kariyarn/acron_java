package frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class MyFrame extends JFrame {
	//현재 열려 있는 File 객체의 참조값을 저장할 필드
	//선택을 안하면 null일수도 있음에 주의
	File openedFile;
	JTextArea ta;
	
   
   public MyFrame(String title) {
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
      JMenuItem newItem = new JMenuItem("New");
      JMenuItem openItem = new JMenuItem("Open");
      JMenuItem saveItem = new JMenuItem("Save");
      JMenuItem saveAsItem = new JMenuItem("Save As");
      //메뉴에 메뉴 아이템을 순서대로 추가
      menu.add(newItem);
      menu.add(openItem);
      menu.add(saveItem);
      menu.add(saveAsItem);
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
      
      ta=new JTextArea();
      add(ta, BorderLayout.CENTER);
      
      //open을 눌렀을 때 실행할 리스너 목록
      openItem.addActionListener((e)->{
    	  //파일을 선택할 수 있는 객체
    	  JFileChooser fc=new JFileChooser("C:/acorn202304/myFolder");
    	  int result = fc.showOpenDialog(this);
    	  if(result == JFileChooser.APPROVE_OPTION) {
    		  //선택한 파일을 제어할 수 있는 File 객체가 리턴된다.(필드에 저장해두기)
    		  openedFile=fc.getSelectedFile();
    		  //선택한 파일의 경로
    		  String path = openedFile.getAbsolutePath();
    		  //프레임의 제목의 선택한 파일의 경로를 출력한다.(this.은 생략가능)
    		  this.setTitle(path);
    		  
    		  
    		  FileReader fr=null;
              BufferedReader br = null;
             try {
                fr=new FileReader(openedFile);
                br=new BufferedReader(fr);
                while(true) {
                   String line=br.readLine();
                   if(line==null)break;// 반복문 탈출 
                   ta.append(line); //개행기호는 제외된 상태로 읽어내기 때문에
                   ta.append("\r\n"); //개행기호를 따로 추가해 준다.
                }
             } catch (IOException e2) {
                e2.printStackTrace();
             }finally {
                 try {
                	 if(br!=null)br.close();
                	 if(fr!=null)fr.close();
    			} catch (IOException e3) {
    				e3.printStackTrace();
    			}
             }
    	  }
      });
      //여기까지 openItem.addActionListener;
      
      //save를 눌렀을 때 실행할 리스너 등록
      //필드에 저장해둬서 어디에서든지 사용 가능
      saveItem.addActionListener((e)->{
    	  if(openedFile == null) {
    		  JOptionPane.showMessageDialog(this, "파일을 선택해 주세요");
    		  return;//메소드를 여기에서 끝내라
    	  }
    	  //입력한 내용을 파일에 저장하기
          saveToFile();
      });
      
      saveAsItem.addActionListener((e)->{
    	  JFileChooser fc = new JFileChooser("c:/acorn202304/myFolder");
    	  int result = fc.showSaveDialog(this);
    	  if(result == JFileChooser.APPROVE_OPTION) {
    		  openedFile = fc.getSelectedFile();
    		  //title출력
    		  setTitle(openedFile.getAbsolutePath());
    		  
    		  //새로운 파일을 실제로 만들기
    		  try {
				openedFile.createNewFile();
    		  } catch (IOException e1) {
				e1.printStackTrace();
    		  }
    		  saveToFile();
    	  }
      });
      
      setVisible(true);
   }
   //파일을 저장하는 메소드
   public void saveToFile() {
	   //JTextArea에 입력한 문자열 읽어오기
	   String content = ta.getText();
	   FileWriter fw = null;
	   BufferedWriter bw = null;
	   try {
		fw=new FileWriter(openedFile);
		bw=new BufferedWriter(fw);
		bw.write(content);
		bw.flush();
		JOptionPane.showMessageDialog(this, "저장했습니다.");
	   	} catch (Exception e) {
		e.printStackTrace();
	   	}finally {
	   		try {
	   			if(bw!=null)bw.close();
	   			if(fw!=null)fw.close();
	   		} catch (Exception e2) {
	   			e2.printStackTrace();
		}
	}
   }
   
   public static void main(String[] args) {
      new MyFrame("나의 프레임");
   }
}

package team;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; //JTable 행,열
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Meterial extends JFrame{
	JLabel title;
	JTextField id;
	JPasswordField pw;   //페스워드 입력 *모양 처리.
	JButton login;
	JButton register;
	JLabel idLabel;
	JLabel pwLabel;
	JLabel dbLabel;
	JTable dbPanel;
	private DefaultTableModel model;
	public Meterial(DefaultTableModel model,String[] column) {
		title = new JLabel("LOGIN");
		title.setFont(new Font("Serif",Font.BOLD,30));
		idLabel = new JLabel("ID");
		pwLabel = new JLabel("PW");
		id = new JTextField(20);
		pw = new JPasswordField(20);
		login = new JButton("로그인");
		register = new JButton("회원가입");
		register.setBorderPainted(false);  //버튼 테두리 제거.
		register.setContentAreaFilled(false); //버튼 안쪽 색 제거.
		dbLabel = new JLabel("사용자 계정");
		this.model = model;
		dbPanel = new JTable(model);
		
		title.setBounds(190,20,100,25);  //setBounds(가로,세로,가로크기,세로크기)메서드로 1개씩 위치 설정.
		idLabel.setBounds(130,60,160,30);
		pwLabel.setBounds(130,90,160,30);
		id.setBounds(160,60,160,30);
		pw.setBounds(160,90,160,30);
		login.setBounds(160,130,160,30);
		register.setBounds(198,160,85,30);
		dbLabel.setBounds(40,190,160,30);
		dbPanel.setBounds(40,220,400,100);
	}
}

class UI extends JFrame {
	public UI() {
		String[] column = {"id","pw","name","number"};
		DefaultTableModel model = new DefaultTableModel(column,0); // DefaultTableModel 객체 생성
        DBTEST dbTest = new DBTEST();
        dbTest.JTableModel(model);    
		Meterial meterial = new Meterial(model,column);
		meterial.register.addActionListener(new ActionListener() {  //회원가입창으로 이동. implements actionListenerf를 따로 일일히 붙임.
			public void actionPerformed(ActionEvent e) {
				new RegisterUI();
			}
		});
		
		meterial.login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringPw1 = new String(meterial.pw.getPassword());
				if(meterial.id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(UI.this,"아이디를 입력해주세요.");
				}
				if(stringPw1.isEmpty()) {      //meterial.pw.getText()를 하면 막힌거라서 stringPw처럼 따로 담아야함.
					JOptionPane.showMessageDialog(UI.this,"비밀번호를 입력해주세요.");
				}
				int idCheck = 0;
				int pwCheck = 0;
				ArrayList<String> dbId = new ArrayList<String>();
				dbTest.DBId(dbId);
				ArrayList<String> dbPw = new ArrayList<String>();
				dbTest.DBPw(dbPw);
				for(String  dbIdList: dbId) {		
						if(dbIdList.equals(meterial.id.getText())) {
							idCheck = 1;
						}
				}
				for(String  dbPwList: dbPw) {		
					if(dbPwList.equals(stringPw1)) {
						pwCheck = 1;
					}
			}
				if(idCheck == 1 && pwCheck == 1) {
					JOptionPane.showMessageDialog(UI.this,"로그인 되었습니다.");
					dispose();
					new WeatherUI();
				}
				if((!meterial.id.getText().isEmpty()) && (!stringPw1.isEmpty()) && (idCheck == 0 || pwCheck == 0))
					JOptionPane.showMessageDialog(UI.this,"아이디 혹은 비밀번호를 잘못 입력하였습니다.","로그인 실패",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		Container ct = getContentPane();
		ct.setLayout(null);  //setBounds()로 위치설정을 위한 배치관리자 null상태.
		ct.add(meterial.title);
		ct.add(meterial.idLabel);
		ct.add(meterial.pwLabel);
		ct.add(meterial.id);
		ct.add(meterial.pw);
		ct.add(meterial.login);
		ct.add(meterial.register);
		ct.add(meterial.dbLabel);
		ct.add(meterial.dbPanel);
		
		setTitle("로그인 화면");
		setSize(500,400);
		setLocation(500,0);
		setVisible(true);
	}
}

public class UserInterface{
	public static void main(String[] args) {
		new UI();
	}
}

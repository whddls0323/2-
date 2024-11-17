package team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Meterial2 extends JFrame{
	JLabel[] jl = new JLabel[5];
	JTextField registerId;
	JPasswordField registerPw;
	JTextField registerName;
	JTextField registerNumber;
	JButton registerClear;
	public Meterial2() {
		String[] s = {"회원가입","아이디","비밀번호","이름","전화번호"};
		
		for(int i=0;i<jl.length;i++) {
			jl[i] = new JLabel(s[i]);
		}
		registerId = new JTextField(20);
		registerPw = new JPasswordField(20);
		registerName = new JTextField(3);
		registerNumber = new JTextField(15);
		registerClear = new JButton("완료");
		
		jl[0].setFont(new Font("Serif",Font.BOLD,30));
		jl[0].setBounds(180,20,160,30);
		jl[1].setBounds(110,60,160,30);
		jl[2].setBounds(110,120,160,30);
		jl[3].setBounds(110,180,160,30);
		jl[4].setBounds(110,240,160,30);
		registerId.setBounds(110,90,260,30);
		registerPw.setBounds(110,150,260,30);
		registerName.setBounds(110,210,260,30);
		registerNumber.setBounds(110,270,260,30);
		registerClear.setBounds(110,330,260,50);
	}
}

class Register extends JFrame{
	private Meterial2 meterial2; //입력한 값 db에 넣으려고 만듬.
	public Register() {
		meterial2 = new Meterial2();
		meterial2.registerClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringPw2 = new String(meterial2.registerPw.getPassword());
				if(meterial2.registerId.getText().isEmpty() || stringPw2.isEmpty() || 
				meterial2.registerName.getText().isEmpty() || meterial2.registerNumber.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Register.this,"입력하지 않은 문장이 있습니다.");
				}
				else {
					new DBTEST(meterial2); //db클래스 생성자로 이동.
					JOptionPane.showMessageDialog(Register.this,"회원가입 되었습니다.");
					dispose();
				}
			}
		});
		Container ct = getContentPane();
		ct.setLayout(null);
		ct.add(meterial2.registerId);
		ct.add(meterial2.registerPw);
		ct.add(meterial2.registerName);
		ct.add(meterial2.registerNumber);
		ct.add(meterial2.registerClear);
		for(int i=0;i<5;i++) {
			ct.add(meterial2.jl[i]);
		}
		setTitle("회원가입");
		setSize(500,700);
		setLocation(1000,0);  //회원가입 창 x,y위치 설정.
		setVisible(true);
	}
}

public class RegisterUI {
	public RegisterUI() {
		new Register();
	}	
}

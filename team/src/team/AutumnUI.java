package team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Autumn extends JFrame {
    JFrame frame;
    JPanel panel;
    
    public Autumn() {
        frame = new JFrame("Autumn clothes");
        frame.setSize(1200, 800);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();

        // 이미지 파일의 경로 설정 (각 버튼에 맞게 설정하세요)
        String imagePath1 = "autumn1.png";
        String imagePath2 = "autumn2.png";
        String imagePath3 = "autumn3.png";
        String imagePath4 = "autumn4.png";
        String imagePath5 = "autumn5.png";
        String imagePath6 = "autumn6.png";
        String imagePath7 = "autumn7.png";
        String imagePath8 = "autumn8.png";
        String imagePath9 = "autumn9.png";

        // 이미지 아이콘 생성
        ImageIcon icon1 = new ImageIcon(imagePath1);
        ImageIcon icon2 = new ImageIcon(imagePath2);
        ImageIcon icon3 = new ImageIcon(imagePath3);
        ImageIcon icon4 = new ImageIcon(imagePath4);
        ImageIcon icon5 = new ImageIcon(imagePath5);
        ImageIcon icon6 = new ImageIcon(imagePath6);
        ImageIcon icon7 = new ImageIcon(imagePath7);
        ImageIcon icon8 = new ImageIcon(imagePath8);
        ImageIcon icon9 = new ImageIcon(imagePath9);
       
        // 버튼 생성 및 이미지 아이콘 설정
        JButton buttonT = new JButton("상의");
        JButton buttonB = new JButton("하의");
        JButton buttonS = new JButton("신발");
        JButton button1 = new JButton(icon1);
        JButton button2 = new JButton(icon2);
        JButton button3 = new JButton(icon3);
        JButton button4 = new JButton(icon4);
        JButton button5 = new JButton(icon5);
        JButton button6 = new JButton(icon6);
        JButton button7 = new JButton(icon7);
        JButton button8 = new JButton(icon8);
        JButton button9 = new JButton(icon9);
        
        buttonT.setFont(new Font("고딕", Font.BOLD,30));
        buttonB.setFont(new Font("고딕", Font.BOLD,30));
        buttonS.setFont(new Font("고딕", Font.BOLD,30));
        
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button4.setBorderPainted(false);
        button4.setContentAreaFilled(false);
        button5.setBorderPainted(false);
        button5.setContentAreaFilled(false);
        button6.setBorderPainted(false);
        button6.setContentAreaFilled(false);
        button7.setBorderPainted(false);
        button7.setContentAreaFilled(false);
        button8.setBorderPainted(false);
        button8.setContentAreaFilled(false);
        button9.setBorderPainted(false);
        button9.setContentAreaFilled(false);
        buttonT.setBorderPainted(false);
        buttonT.setContentAreaFilled(false);
        buttonB.setBorderPainted(false);
        buttonB.setContentAreaFilled(false);
        buttonS.setBorderPainted(false);
        buttonS.setContentAreaFilled(false);
        
        // 각 버튼에 대한 ActionListener 등록
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼1에 대한 이벤트 처리
            	new Autumn1();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼2에 대한 이벤트 처리
            	new Autumn2();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼3에 대한 이벤트 처리
            	new Autumn3();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	new Autumn4();
            }
        });
        
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	new Autumn5();
            }
        });
        
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	new Autumn6();
            }
        });
        
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	new Autumn7();
            }
        });
        
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	new Autumn8();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	new Autumn9();
            }
        });

        // 패널에 버튼과 라벨 추가
        
        panel.setLayout(new GridLayout(4, 2));
        panel.add(buttonT);
        panel.add(buttonB);
        panel.add(buttonS);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4); 
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);

        // 스크롤을 위해 JScrollPane을 사용
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 수평 스크롤 바 비활성화

        // 프레임에 스크롤 패널 추가
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

public class AutumnUI {
    public AutumnUI() {
        new Autumn();
    }
}

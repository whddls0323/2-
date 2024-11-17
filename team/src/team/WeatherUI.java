package team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Weather extends JFrame {
    JFrame frame;
    JPanel panel;

    public Weather() {
        frame = new JFrame("계절 선택");
        frame.setSize(750, 500);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();

        // 이미지 파일의 경로 설정 (각 버튼에 맞게 설정하세요)
        String imagePath1 = "1.jpg";
        String imagePath2 = "2.jpg";
        String imagePath3 = "3.jpg";
        String imagePath4 = "4.jpg";

        // 이미지 아이콘 생성
        ImageIcon icon1 = new ImageIcon(imagePath1);
        ImageIcon icon2 = new ImageIcon(imagePath2);
        ImageIcon icon3 = new ImageIcon(imagePath3);
        ImageIcon icon4 = new ImageIcon(imagePath4);

        // 버튼 생성 및 이미지 아이콘 설정
        JButton button1 = new JButton(icon1);
        JButton button2 = new JButton(icon2);
        JButton button3 = new JButton(icon3);
        JButton button4 = new JButton(icon4);

        // 이미지만 보이도록 설정
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);

        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);

        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);

        button4.setBorderPainted(false);
        button4.setContentAreaFilled(false);

        // JLabel 생성
        JLabel label1 = new JLabel("봄");
        JLabel label2 = new JLabel("여름");
        JLabel label3 = new JLabel("가을");
        JLabel label4 = new JLabel("겨울");

        // 각 버튼에 대한 ActionListener 등록
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼1에 대한 이벤트 처리
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SpringUI();
                    }
                });
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼2에 대한 이벤트 처리
            	SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SummerUI();
                    }
                });
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼3에 대한 이벤트 처리
            	SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new AutumnUI();
                    }
                });
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼4에 대한 이벤트 처리
            	SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new WinterUI();
                    }
                });
            }
        });
        // 패널에 버튼과 라벨 추가
        panel.add(button1);
        panel.add(label1);
        panel.add(button2);
        panel.add(label2);
        panel.add(button3);
        panel.add(label3);
        panel.add(button4);
        panel.add(label4);

        // 프레임에 패널 추가
        frame.add(panel);

        frame.setVisible(true);
        
    }
}

public class WeatherUI {
    public WeatherUI() {
        new Weather();
    }
}

package team;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Winter2 extends JFrame {
    JFrame frame;
    JPanel panel;

    public Winter2() {
        frame = new JFrame("Winter clothes2");
        frame.setSize(1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();

        // 이미지 파일의 경로 설정 (각 버튼에 맞게 설정하세요)
        String imagePath1 = "winter2.png";

        // 이미지 아이콘 생성
        ImageIcon icon1 = new ImageIcon(imagePath1);

        // 버튼 생성 및 이미지 아이콘 설정
        JButton button1 = new JButton(icon1);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);

        // 레이블 생성
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        // MySQL에서 데이터를 조회하여 레이블에 설정
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // MySQL 데이터베이스 연결 정보 설정
            String url = "jdbc:mysql://localhost:3306/shopdb";
            String username = "root";
            String password = "1234";

            // 데이터베이스에 연결
            Connection connection = DriverManager.getConnection(url, username, password);

            // SQL 쿼리 실행
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, brand, price, size, inventory FROM winter WHERE id = 2");

            // 결과가 있다면 레이블에 설정
            if (resultSet.next()) {
                String clothesInfo1 = resultSet.getString("name");
                String clothesInfo2 = resultSet.getString("brand");
                String clothesInfo3 = resultSet.getString("price");
                String clothesInfo4 = resultSet.getString("size");
                String clothesInfo5 = resultSet.getString("inventory");

                label1.setText("<html>" + clothesInfo1.replace("\n", "<br>") + "</html>");
                label2.setText("<html>" + clothesInfo2.replace("\n", "<br>") + "</html>");
                label3.setText("<html>" + clothesInfo3.replace("\n", "<br>") + "</html>");
                label4.setText("<html>" + clothesInfo4.replace("\n", "<br>") + "</html>");
                label5.setText("<html>" + clothesInfo5.replace("\n", "<br>") + "</html>");

                // 폰트와 색상 설정 추가
                Font font = new Font("고딕", Font.BOLD, 15);
                label1.setFont(font);
                label2.setFont(font);
                label3.setFont(font);
                label4.setFont(font);
                label5.setFont(font);

                label1.setForeground(Color.BLACK);
                label2.setForeground(Color.BLACK);
                label3.setForeground(Color.BLACK);
                label4.setForeground(Color.BLACK);
                label5.setForeground(Color.BLACK);
            }

            // 연결 해제
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 패널에 버튼과 라벨 추가
        panel.setLayout(new GridLayout(1, 5));
        panel.add(button1);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);

        frame.add(panel);
        frame.setVisible(true);
    }
}

public class Winter2UI {
    public Winter2UI() {
        new Winter2();
    }
}

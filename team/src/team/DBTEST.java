package team;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DBTEST {
	private Meterial2 mt2; //입력한값을 이쪽 클래스로 이동.
	String id;
	String pw;
	String name;
	String number;
	
	public DBTEST() {
        
    }
    public DBTEST(Meterial2 meterial2) {
        this.mt2 = meterial2; 
        DBLink();
    }
    
	 public void DBLink() {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet result=null;
		String getId = null;   
		String getPw = null;
		String getName = null;
		String getNumber = null;
		String s = new String(mt2.registerPw.getPassword()); //패스워드는 getText()가 안되서 문자열로 변경.
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register?serverTimezone=UTC","root","1234");
			System.out.println("DB연결완료");
			String sql = "insert into account (id, pw, name, number) values (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            //회원가입 창에서 입력된 값들 확인 및 대입.
            if(!mt2.registerId.getText().isEmpty() || !s.isEmpty() || !mt2.registerName.getText().isEmpty() ||!mt2.registerNumber.getText().isEmpty()) {
            	getId = mt2.registerId.getText();
            	getPw = s;
            	getName = mt2.registerName.getText();
            	getNumber = mt2.registerNumber.getText();
            	
            }
            else
            	System.out.println("test 실패");
            
            pstmt.setString(1, getId); //setString을 이용한 값 삽입
            pstmt.setString(2, getPw);
            pstmt.setString(3, getName);
            pstmt.setString(4, getNumber);
            pstmt.executeUpdate(); //db에 적용
            result = pstmt.executeQuery("select * from account"); //db불러와서 result에 대입   
			while(result.next()) {
				id = result.getString("id");
				pw = result.getString("pw");
				name = result.getString("name");
				number = result.getString("number");  
				System.out.println(id + " " + pw + " " + name + " " + number);
			}
			result.close();
			pstmt.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		}catch(SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	 public void JTableModel(DefaultTableModel model) {
		 Connection conn=null;
		 PreparedStatement pstmt = null;
		 ResultSet result=null;
		 
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register?serverTimezone=UTC","root","ab@032323");
				System.out.println("DB연결완료");
				String sql = "select * from account";  
				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeQuery();
				int columnCount = result.getMetaData().getColumnCount();
				String[] columnNames = new String[columnCount];
				for (int i = 1; i <= columnCount; i++) {
	                columnNames[i - 1] = result.getMetaData().getColumnName(i);
	            }
				model.setColumnIdentifiers(columnNames);
				
				while (result.next()) {
	                Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    rowData[i - 1] = result.getObject(i);
	                }             	                
	                model.addRow(rowData);
	                
	            }
				result.close();
				pstmt.close();
				conn.close();
		 } catch(ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 오류");
			}catch(SQLException e) {
				System.out.println("DB 연결 오류");
			}
	 }
	 
	 public ArrayList DBId(ArrayList dbId) {
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet result=null;
			String getId = null;   
			String getPw = null;
			String getName = null;
			String getNumber = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register?serverTimezone=UTC","root","ab@032323");
				
				String sql = "SELECT id, pw FROM account"; 
	            pstmt = conn.prepareStatement(sql);	           	  
	            result = pstmt.executeQuery();           
				while(result.next()) {
					dbId.add(result.getString("id"));		
				}		
				result.close();
				pstmt.close();
				conn.close();
			}catch(ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 오류");
			}catch(SQLException e) {
				System.out.println("DB 연결 오류");
			}
			return dbId;
		}
	 
	 public ArrayList DBPw(ArrayList dbPw) {
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet result=null;
			String getId = null;   
			String getPw = null;
			String getName = null;
			String getNumber = null;
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register?serverTimezone=UTC","root","ab@032323");
				
				String sql = "SELECT id, pw FROM account"; 
	            pstmt = conn.prepareStatement(sql);	           	  
	            result = pstmt.executeQuery();           
				while(result.next()) {
					dbPw.add(result.getString("pw"));								
				}		
				result.close();
				pstmt.close();
				conn.close();
			}catch(ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 오류");
			}catch(SQLException e) {
				System.out.println("DB 연결 오류");
			}
			return dbPw;
		}
}
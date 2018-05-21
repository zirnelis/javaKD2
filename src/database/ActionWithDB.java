/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Elina
 */
public class ActionWithDB {
    
//    private String url;

    public ActionWithDB() {
    }
    
    private Connection connect() throws SQLException {
        Connection connection = null;
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/students.db";
        connection = DriverManager.getConnection(url, user, "");
        return connection;
    }
    public void createAndInsertDB(ArrayList<Student> students) throws SQLException {
        String sqlDropTable = "DROP TABLE IF EXISTS Student";
        String sqlClientTable = "CREATE TABLE IF NOT EXISTS Student (\n"
                + "StudentID INTEGER PRIMARY KEY AUTOINCREMENT, \n"
                + "FirstName VARCHAR(255), \n"
                + "LastName VARCHAR(255), \n"
                + "Age INTEGER, \n"
                + "); \n";
//        String insertIntoDB = "INSERT INTO Student"
//                + ""
//                + ""
//                + "";
        String sqlInsert = "INSERT INTO Student (StudentID, FirstName, LastName, Age) "
                + "VALUES (?, ?, ?, ?)";
                   
        
        try (Connection conn = this.connect();
            PreparedStatement psmt = conn.prepareStatement(sqlInsert)) {
            int i = 0;
            //for (Packet02Variation packet02Variation : variation ) {
            psmt.setInt(1,students.get(i).getId());
            psmt.setString(2, students.get(i).getFirstname());
            psmt.setString(3, students.get(i).getLastname());
            psmt.setInt(3, students.get(i).getAge());
            i++;

            psmt.executeUpdate();
                
            Statement stmt = conn.createStatement(); 
            stmt.execute(sqlDropTable);
            stmt.execute(sqlClientTable);
        
        } catch (Exception ex){
            System.out.println("Nasanaca ievietot tabula studentu datus..");
        }
        
    }
    
    public ArrayList<Student> selectAllStudentsSQL() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String nameTmp, lastnameTmp;
        int idTmp, ageTmp;
//        String selectDB = "USE mydb"; 
        String select = "SELECT * FROM Student"; 
        
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(select)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idTmp = rs.getInt("StudentID");
                nameTmp = rs.getString("FirstName");
                lastnameTmp = rs.getString("LastName");
                ageTmp = rs.getInt("Age");
                students.add(new Student(idTmp, nameTmp, lastnameTmp, ageTmp));
            }
        }
        return students;
    }
    
    public void closeDB(Connection conn) throws SQLException {
        if(conn!=null) {
            conn.close();
        }
    }
}

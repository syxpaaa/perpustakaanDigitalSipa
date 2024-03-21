/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaandigitalsipa;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB 1 PC 16
 */
public class ModelDataBase {
    Connection konek;
    java.sql.Statement st;
    ResultSet rs;

    public ModelDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //method ambil data
    public ResultSet ambilData(String sql){
        try {
            st = konek.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return  null;
        }
    }
    
    //method untuk rubah data
    public boolean rubahData(String sql){
        try {
            st=konek.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
}

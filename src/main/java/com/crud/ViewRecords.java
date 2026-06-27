package com.crud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewRecords extends JFrame {

    JTable table;

    public ViewRecords() {

        setTitle("View Records");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 300);
        add(scrollPane);

        loadData();

        setVisible(true);
    }

    public void loadData() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM records";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            
            String[] columns = {"ID", "Name", "Email", "Course", "Phone", "Date"};

            DefaultTableModel model = new DefaultTableModel(columns, 0);

            while (rs.next()) {

                int id = rs.getInt("record_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                String phone = rs.getString("phone");
                Date date = rs.getDate("created_date");

                Object[] row = {id, name, email, course, phone, date};
                model.addRow(row);
            }

            table.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e);
        }
    }
}
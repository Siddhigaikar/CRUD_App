package com.crud;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteRecord extends JFrame {

    JTextField idField;

    public DeleteRecord() {

        setTitle("Delete Record");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel idLabel = new JLabel("Enter ID:");
        idLabel.setBounds(30, 30, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 30, 120, 25);
        add(idField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(120, 80, 100, 30);
        add(deleteBtn);

        deleteBtn.addActionListener(e -> deleteRecord());

        setVisible(true);
    }

    public void deleteRecord() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM records WHERE record_id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(idField.getText()));

            int i = pst.executeUpdate();

            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Record Not Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex);
        }
    }
}
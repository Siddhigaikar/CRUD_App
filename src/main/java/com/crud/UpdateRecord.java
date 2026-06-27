package com.crud;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRecord extends JFrame {

    JTextField idField, nameField, emailField, courseField, phoneField;

    public UpdateRecord() {

        setTitle("Update Record");
        setSize(350, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(130, 30, 150, 25);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(130, 70, 150, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 110, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 110, 150, 25);
        add(emailField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 150, 100, 25);
        add(courseLabel);

        courseField = new JTextField();
        courseField.setBounds(130, 150, 150, 25);
        add(courseField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 190, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(130, 190, 150, 25);
        add(phoneField);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(130, 240, 100, 30);
        add(updateBtn);

        updateBtn.addActionListener(e -> updateRecord());

        setVisible(true);
    }

    public void updateRecord() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE records SET name=?, email=?, course=?, phone=? WHERE record_id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, nameField.getText());
            pst.setString(2, emailField.getText());
            pst.setString(3, courseField.getText());
            pst.setString(4, phoneField.getText());
            pst.setInt(5, Integer.parseInt(idField.getText()));

            int i = pst.executeUpdate();

            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Record Not Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex);
        }
    }
}
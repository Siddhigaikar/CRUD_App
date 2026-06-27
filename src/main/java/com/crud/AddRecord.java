package com.crud;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class AddRecord extends JFrame {

    JTextField nameField, emailField, courseField, phoneField;

    public AddRecord() {

        setTitle("Add Record");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(130, 30, 150, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 70, 150, 25);
        add(emailField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 110, 100, 25);
        add(courseLabel);

        courseField = new JTextField();
        courseField.setBounds(130, 110, 150, 25);
        add(courseField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 150, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(130, 150, 150, 25);
        add(phoneField);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(130, 200, 100, 30);
        add(saveBtn);

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveRecord();
            }
        });

        setVisible(true);
    }

    public void saveRecord() {

        String name = nameField.getText();
        String email = emailField.getText();
        String course = courseField.getText();
        String phone = phoneField.getText();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO records (name, email, course, phone, created_date) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, course);
            pst.setString(4, phone);
            pst.setDate(5, Date.valueOf(LocalDate.now()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Added Successfully!");

            
            nameField.setText("");
            emailField.setText("");
            courseField.setText("");
            phoneField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex);
        }
    }
}
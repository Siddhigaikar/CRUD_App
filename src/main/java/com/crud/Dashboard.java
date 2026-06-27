package com.crud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Dashboard");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to CRUD Dashboard");
        label.setBounds(150, 50, 300, 30);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem logout = new JMenuItem("Logout");

        JMenu menuRecord = new JMenu("Records");
        JMenuItem addRecord = new JMenuItem("Add Record");
        JMenuItem viewRecord = new JMenuItem("View Records");
        viewRecord.addActionListener(e -> {
            new ViewRecords();
        });
        
        JMenuItem updateRecord = new JMenuItem("Update Record");
        JMenuItem deleteRecord = new JMenuItem("Delete Record");
        updateRecord.addActionListener(e -> {
            new UpdateRecord();
        });

        deleteRecord.addActionListener(e -> {
            new DeleteRecord();
        });

        menuFile.add(logout);
        
        menuRecord.add(addRecord);
        menuRecord.add(viewRecord);

        menuBar.add(menuFile);
        menuBar.add(menuRecord);
        menuRecord.add(updateRecord);
        menuRecord.add(deleteRecord);

        setJMenuBar(menuBar);

        
        logout.addActionListener(e -> {
            new Login();
            dispose();
        });

        
        addRecord.addActionListener(e -> {
            new AddRecord();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
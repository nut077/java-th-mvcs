package com.nutfreedom.view;

import com.nutfreedom.util.FileImages;
import lombok.Data;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;

@Data
public class MainMenu extends JFrame {

    private JButton btnAddBook;
    private JButton btnShowBooks;

    public MainMenu() {
        initComponents();
    }

    private void initComponents() {
        JPanel jPanel = new JPanel();
        btnAddBook = new JButton();
        btnShowBooks = new JButton();
        JLabel bg = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java OOP");
        jPanel.setLayout(new AbsoluteLayout());

        btnAddBook.setBackground(new Color(177, 231, 223));
        btnAddBook.setFont(new Font("TH K2D july8", Font.PLAIN, 24));
        btnAddBook.setForeground(new Color(0, 101, 68));
        btnAddBook.setText("เพิ่มหนังสือ");
        btnAddBook.setBorder(null);
        btnAddBook.setBorderPainted(false);
        btnAddBook.setFocusPainted(false);
        jPanel.add(btnAddBook, new AbsoluteConstraints(70, 170, 260, 50));

        btnShowBooks.setBackground(new Color(254, 197, 222));
        btnShowBooks.setFont(new Font("TH K2D July8", Font.PLAIN, 24));
        btnShowBooks.setText("รายการหนังสือ");
        btnShowBooks.setBorder(null);
        btnShowBooks.setBorderPainted(false);
        btnShowBooks.setFocusPainted(false);
        jPanel.add(btnShowBooks, new AbsoluteConstraints(70, 100, 260, 50));

        String imageIcon = FileImages.getFileImages("bg.png");

        if (!imageIcon.equals("")) {
            bg.setIcon(new ImageIcon(imageIcon));
            jPanel.add(bg, new AbsoluteConstraints(0, 0, 400, 300));
        }


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

}

package com.nutfreedom.view;

import com.nutfreedom.model.Books;
import com.nutfreedom.util.FileImages;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShowBooks2 extends JFrame {

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBg;
    private javax.swing.JTable tableBooks;

    public ShowBooks2() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        tableBooks = new JTable();
        lblBg = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("รายการหนังสือ");

        jPanel1.setLayout(new AbsoluteLayout());

        tableBooks.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "รหัส", "ชื่อหนังสือ", "ราคา"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tableBooks.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tableBooks);
        if (tableBooks.getColumnModel().getColumnCount() > 0) {
            tableBooks.getColumnModel().getColumn(0).setResizable(false);
            tableBooks.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableBooks.getColumnModel().getColumn(1).setResizable(false);
            tableBooks.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableBooks.getColumnModel().getColumn(2).setResizable(false);
            tableBooks.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jPanel1.add(jScrollPane1, new AbsoluteConstraints(10, 80, 380, 210));

        String imageIcon = FileImages.getFileImages("bg.png");
        if (!imageIcon.equals("")) {
            lblBg.setIcon(new ImageIcon(imageIcon));
            jPanel1.add(lblBg, new AbsoluteConstraints(0, 0, 400, 300));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void showBooks(List<Books> bList) {
        DefaultTableModel model = (DefaultTableModel) tableBooks.getModel();
        Object row[] = new Object[3];
        for (Books aBList : bList) {
            row[0] = aBList.getId();
            row[1] = aBList.getTitle();
            row[2] = aBList.getPrice();
            model.addRow(row);
        }
    }
}

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 720);
        add(image);

        back = new JButton("Back");
        back.setBounds(330, 440, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            // FIX 1: Changed "back" to "bank" table
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while(rs.next()) {
                String type = rs.getString("type");
                String amountStr = rs.getString("amount").trim();  // FIX 2: Trim whitespace

                System.out.println("Type: " + type + ", Amount: " + amountStr);

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amountStr);
                } else {
                    balance -= Integer.parseInt(amountStr);
                }
            }

            System.out.println("Final Balance: " + balance);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs. " + balance);
        text.setBounds(165, 255, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);

        setSize(850, 720);
        setLocation(230, 2);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] arg) {
        new BalanceEnquiry("");  // FIX 3: Use a real PIN from your database
    }
}
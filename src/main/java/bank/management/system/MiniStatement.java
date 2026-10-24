package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try {
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println("Error fetching card details: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching card details");
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            String transactionHistory = "<html>";  // ✓ Start HTML tag once

            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");

            if (!rs.next()) {
                transactionHistory += "No transactions found<br>";
            } else {
                // Reset to beginning since we checked if data exists
                rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");

                // Add table header
                transactionHistory += "<b>Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Type &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Amount</b><br>";
                transactionHistory += "─────────────────────────────<br>";

                while(rs.next()) {
                    String date = rs.getString("date");
                    String type = rs.getString("type");  // ✓ FIXED: Was "yupr", now "type"
                    String amount = rs.getString("amount");

                    // ✓ Fixed: Proper formatting
                    transactionHistory += date + " &nbsp;&nbsp; " + type + " &nbsp;&nbsp; Rs. " + amount + "<br>";

                    // Calculate balance
                    if (type.equals("Deposit")) {
                        bal += Integer.parseInt(amount);
                    } else {
                        bal -= Integer.parseInt(amount);
                    }
                }
            }

            transactionHistory += "</html>";  // ✓ Close HTML tag once
            mini.setText(transactionHistory);
            balance.setText("Your current account balance is Rs " + bal);

            System.out.println("Balance: " + bal);  // Debug

        } catch (Exception e) {
            System.out.println("Error fetching transactions: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching transaction history: " + e.getMessage());
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] arg) {
        new MiniStatement("");
    }
}
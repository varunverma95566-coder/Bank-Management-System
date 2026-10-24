package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    JButton btn100, btn500, btn1000, btn2000, btn5000, btn10000, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 720);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(190, 255, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        btn100 = new JButton("Rs. 100");
        btn100.setBounds(160, 360, 145, 25);
        btn100.addActionListener(this);
        image.add(btn100);

        btn500 = new JButton("Rs. 500");
        btn500.setBounds(333, 360, 145, 25);
        btn500.addActionListener(this);
        image.add(btn500);

        btn1000 = new JButton("Rs. 1000");
        btn1000.setBounds(160, 390, 145, 25);
        btn1000.addActionListener(this);
        image.add(btn1000);

        btn2000 = new JButton("Rs. 2000");
        btn2000.setBounds(333, 390, 145, 25);
        btn2000.addActionListener(this);
        image.add(btn2000);

        btn5000 = new JButton("Rs. 5000");
        btn5000.setBounds(160, 420, 145, 25);
        btn5000.addActionListener(this);
        image.add(btn5000);

        btn10000 = new JButton("Rs. 10000");
        btn10000.setBounds(333, 420, 145, 25);
        btn10000.addActionListener(this);
        image.add(btn10000);

        back = new JButton("BACK");
        back.setBounds(333, 450, 145, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 720);
        setLocation(230, 2);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            try {
                // Extract only the number part from "Rs. 100" (skip 4 chars: "Rs. ")
                String amount = ((JButton)ae.getSource()).getText().substring(4).trim();
                System.out.println("Amount extracted: [" + amount + "]");

                Conn c = new Conn();

                // Query the bank table to calculate balance
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;

                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                System.out.println("Current balance: " + balance);
                System.out.println("Withdrawal amount: " + amount);

                // Check if sufficient balance
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Insert withdrawal transaction
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                int result = c.s.executeUpdate(query);

                if (result > 0) {
                    System.out.println("Transaction recorded successfully");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + "/- Debited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Transaction Failed!");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] arg) {
        new FastCash("");
    }
}
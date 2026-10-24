package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 720);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200, 255, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Left column
        deposit = new JButton("Deposit");
        deposit.setBounds(160, 360, 145, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(333, 360, 145, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160, 390, 145, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(333,390 , 145, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);


        pinchange = new JButton("Pin Change");
        pinchange.setBounds(160, 420, 145, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);


        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(333, 420, 145, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        // Exit — centered
        exit = new JButton("Exit");
        exit.setBounds(333, 450, 145, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(850, 720);
        setLocation(230, 2);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] arg) {
        new Transaction("");
    }
}
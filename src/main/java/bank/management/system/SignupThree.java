package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {

        this.formno = formno;
        setLayout(null);


        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 25));
        l1.setBounds(270, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 130, 200, 30);
        add(type);
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 170, 250, 20);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 170, 250, 20);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 210, 250, 20);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 210, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 270, 200, 30);
        add(card);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 19));
        cardnumber.setBounds(330, 270, 300, 30);
        add(cardnumber);

        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 295, 300, 20);
        add(carddetail);


        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 330, 200, 30);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 19));
        pinnumber.setBounds(330, 330, 300, 30);
        add(pinnumber);

        JLabel pindetail = new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 350, 300, 30);
        add(pindetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 400, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 440, 200, 30);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 440, 200, 30);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 480, 200, 30);
        add(c3);
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 480, 200, 30);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 520, 200, 30);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 520, 200, 30);
        add(c6);
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 570, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 630, 100, 30);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 630, 100, 30);
        cancel.addActionListener(this);
        add(cancel);


        setLocation(250, 0);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 725);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }
            Random random = new Random();
            long cardNum = 1000000000000000L + (Math.abs(random.nextLong()) % 9000000000000000L);
            String cardnumber = "" + cardNum;
            int pinNum = 1000 + (Math.abs(random.nextInt()) % 9000);
            String pinnumber = "" + pinNum;

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please accept the declaration");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber );
                }
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
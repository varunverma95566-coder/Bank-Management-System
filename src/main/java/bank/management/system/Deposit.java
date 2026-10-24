package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit , back;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,720);
        add(image);

        JLabel text  = new JLabel("Enter the amount you want to deposit :");
        text.setBounds(165,245,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(165,290,300 ,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(350,418,130,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(350,448,130,25);
        back.addActionListener(this);
        image.add(back);




        setSize(850,720);
        setLocation(230,2);
        setUndecorated(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank value('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e ) {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }

    }
    public static void main(String[] arg) {
        new Deposit("");

    }
}

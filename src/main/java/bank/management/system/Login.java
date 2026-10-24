package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(110,10,100,100);
        add(label);
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(250,50,400,40);
        add(text);
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,25));
        cardno.setBounds(130,150,150,40);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Raleway",Font.BOLD,15));
        cardTextField.setBounds(300,155,230,30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(130,220,400,40);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setEchoChar('*');
        pinTextField.setBounds(300,225,230,30);
        add(pinTextField);
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signup = new JButton("SIGNUP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setLocation(250,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Login();

    }

}
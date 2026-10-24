package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change , back;
    String pinnumber;

    PinChange(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 720);
        add(image);


        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(240,240,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(155, 275, 700, 35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(320,280,160 ,25);
        image.add(pin);


        JLabel repintext = new JLabel("Re-Enter NEW PIN:");
        repintext.setBounds(155, 320, 700, 35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,22));
        repin.setBounds(320,325,160 ,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(330, 435, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(160, 435, 150, 30);
        back.addActionListener(this);
        image.add(back);



        setSize(850,720);
        setLocation(230,2);
            setUndecorated(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does noy match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enternew PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }


    }

    public static void main(String[] arg) {
        new PinChange("").setVisible(true);
    }
}



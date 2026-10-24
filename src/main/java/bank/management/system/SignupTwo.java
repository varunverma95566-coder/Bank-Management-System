package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religionfield,categoryfield,incomefield,educationfield,occupationfield ;
    String formno;

    SignupTwo (String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,720);
        setLocation(230,2);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details " );
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,25));
        additionalDetails.setBounds(270,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:" );
        religion.setFont(new Font("Raleway", Font.BOLD,19));
        religion.setBounds(100,140,200,30);
        add(religion);
        String[] valReligion = {"Hindu","Muslim","Sikh", "Christian", "Other"};
        religionfield = new JComboBox(valReligion);
        religionfield.setBounds(300,140,400,30);
        add(religionfield);

        JLabel category = new JLabel("Category:" );
        category.setFont(new Font("Raleway", Font.BOLD,19));
        category.setBounds(100,190,200,30);
        add(category);
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        categoryfield = new JComboBox(valcategory);
        categoryfield.setBounds(300,190,400,30);
        categoryfield.setBackground(Color.WHITE);
        add(categoryfield);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD,19));
        income.setBounds(100,240,200,30);
        add(income);
        String valincome[] = {"NULL","Less than 1,50,000","Less than 2,50,000","Less than 5,00,000","Upto 10,00,000"};
        incomefield = new JComboBox(valincome);
        incomefield.setBounds(300,240,400,30);
        incomefield.setBackground(Color.WHITE);
        add(incomefield);

        JLabel education = new JLabel("Educational" );
        education.setFont(new Font("Raleway", Font.BOLD,19));
        education.setBounds(100,290,200,20);
        add(education);

        JLabel Qualification = new JLabel("Qualification:" );
        Qualification.setFont(new Font("Raleway", Font.BOLD,19));
        Qualification.setBounds(100,310,200,20);
        add(Qualification);
        String educationValues[] = {"NON-Graduation","Graduate","Post-Graduate","Doctrate","Others"};
        educationfield = new JComboBox(educationValues);
        educationfield.setBounds(300,300,400,30);
        educationfield.setBackground(Color.WHITE);
        add(educationfield);

        JLabel occupation = new JLabel("Occupation:" );
        occupation.setFont(new Font("Raleway", Font.BOLD,19));
        occupation.setBounds(100,350,200,30);
        add(occupation);
        String occupationalValues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupationfield = new JComboBox(occupationalValues);
        occupationfield.setBounds(300,350,400,30);
        occupationfield.setBackground(Color.WHITE);
        add(occupationfield);


        JLabel pan = new JLabel("PAN Number:" );
        pan.setFont(new Font("Raleway", Font.BOLD,19));
        pan.setBounds(100,400,200,30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,15));
        panTextField.setBounds(300,400,400,30);
        add(panTextField);


        JLabel aadhar = new JLabel("Aadhar Number:" );
        aadhar.setFont(new Font("Raleway", Font.BOLD,19));
        aadhar.setBounds(100,450,200,30);
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,15));
        aadharTextField.setBounds(300,450,400,30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:" );
        senior.setFont(new Font("Raleway", Font.BOLD,19));
        senior.setBounds(100,500,200,30);
        add(senior);
        syes = new JRadioButton("Yes");
        syes.setBounds(300,500,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450,500,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);


        JLabel exisiting = new JLabel("Exisiting Account:" );
        exisiting.setFont(new Font("Raleway", Font.BOLD,19));
        exisiting.setBounds(100,550,200,30);
        add(exisiting);
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,550,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450,550,100,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);

        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(620,620,100,30);
        next.addActionListener(this);
        add(next);

        setVisible (true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionfield.getSelectedItem();
        String category = (String) categoryfield.getSelectedItem();
        String income = (String) incomefield.getSelectedItem();
        String education = (String) educationfield.getSelectedItem();
        String occupation = (String) occupationfield.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen= "yes";
        }else if (sno.isSelected()) {
            seniorcitizen = "no";
        }
        String exisitingaccount= null;
        if (eyes.isSelected()){
            exisitingaccount = "yes";
        }
        else if(eno.isSelected()){
            exisitingaccount = "no";
        }
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        try {
            if (religion.equals("")) {
                JOptionPane.showMessageDialog(null,"Religion is Required");
            } else if (category.equals("")) {
                JOptionPane.showMessageDialog(null,"Category is Required");
            }else if (income.equals("")) {
                JOptionPane.showMessageDialog(null,"Income is Required");
            }else if (occupation.equals("")) {
                JOptionPane.showMessageDialog(null,"Occupation is Required");  // ✓ Fixed error message
            }else if (seniorcitizen == null || seniorcitizen.equals("")) {  // ✓ Check for null
                JOptionPane.showMessageDialog(null,"Senior Citizen Status is Required");
            }else if (exisitingaccount == null || exisitingaccount.equals("")) {  // ✓ Check for null
                JOptionPane.showMessageDialog(null,"Existing Account Status is Required");
            }else if (pan.equals("")) {
                JOptionPane.showMessageDialog(null,"PAN is Required");
            }else if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(null,"Aadhar is Required");
            }else {
                Conn c = new Conn();
                // ✓ FIXED: Corrected the SQL query - removed extra quote before pan
                String query = "insert into signupTwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+seniorcitizen+"','"+exisitingaccount+"','"+pan+"','"+aadhar+"')";

                System.out.println("Executing Query: " + query);  // ✓ Debug: Print query

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data saved successfully!");  // ✓ Add success message
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());  // ✓ Print actual error
            e.printStackTrace();  // ✓ Print full stack trace
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());  // ✓ Show error to user
        }
    }

    public static void main(String[] arg) {
        new SignupTwo("");
    }
}
package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AddCustomer extends JFrame implements ActionListener {
    JTextField tfPhone,tfName,tfNationalty,tfadhar,tfaddress,tfemail;
    JRadioButton rbmale,rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel Heading = new JLabel("ADD CUSTOMER DETAIL");
        Heading.setBounds(380,10,500,35);
        Heading.setFont(new Font("tahoma",Font.PLAIN,32));
        Heading.setForeground(Color.BLACK);
        add(Heading);

        JLabel lblable = new JLabel("Name");
        lblable.setBounds(330,80,150,25);
        lblable.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lblable);

        tfName = new JTextField();
        tfName.setBounds(480,80,150,25);
        tfName.setFont(new Font("tahoma",Font.PLAIN,16));
        add(tfName);

        JLabel lbNationality = new JLabel("Nationality");
        lbNationality.setBounds(330,130,150,25);
        lbNationality.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lbNationality);

        tfNationalty = new JTextField();
        tfNationalty.setBounds(480,130,150,25);
        tfNationalty.setFont(new Font("tahoma",Font.PLAIN,16));
        add(tfNationalty);

        JLabel lbadhar = new JLabel("Aadhar Number");
        lbadhar.setBounds(330,180,150,25);
        lbadhar.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lbadhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(480,180,150,25);
        tfadhar.setFont(new Font("tahoma",Font.PLAIN,16));
        add(tfadhar);

        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(330,230,150,25);
        lbaddress.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lbaddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(480,230,150,25);
        tfaddress.setFont(new Font("tahoma",Font.PLAIN,16));
        add(tfaddress);

        ButtonGroup gendergroup = new ButtonGroup();
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(330,280,150,25);
        lbgender.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lbgender);

        rbmale =new JRadioButton("Male");
        rbmale.setBounds(480,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale =new JRadioButton("Female");
        rbfemale.setBackground(Color.white);
        rbfemale.setBounds(550,280,70,25);
        add(rbfemale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbmale);


        JLabel lbPhone = new JLabel("Contact");
        lbPhone.setBounds(330,330,150,25);
        lbPhone.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lbPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(480,330,150,25);
        tfPhone.setFont(new Font("tahoma",Font.PLAIN,16));
        add(tfPhone);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(330,380,150,25);
        lbEmail.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lbEmail);

        tfemail = new JTextField("");
        tfemail.setBounds(480,380,180,25);
        tfemail.setFont(new Font("tahoma",Font.PLAIN,14));
        add(tfemail);

        JButton Save = new JButton("Save");
        Save.setBackground(Color.BLACK);
        Save.setForeground(Color.white);
        Save.setBounds(420,430,150,25);
        Save.addActionListener(this);
        add(Save);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/Assets/customer.png"));
        JLabel lbLimage = new JLabel(image);
        lbLimage.setBounds(-400,0,900,550);
        add(lbLimage);

        setSize(800,550);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfName.getText();
        String nationality = tfNationalty.getText();
        String phone = tfPhone.getText();
        String address = tfaddress.getText();
        String aadhar = tfadhar.getText();
        String email = tfemail.getText();
        String gender = rbmale.isSelected() ? "Male" : "Female";

        try {
            Cone conn = new Cone();

            // Use a parameterized query to match the column count
            String query = "INSERT INTO passenger (name, nationality, phone, address, aadhar, gender,email) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, nationality);
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.setString(5, aadhar);
            pstmt.setString(6, gender);
            pstmt.setString(7, email);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");

            setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new AddCustomer();
    }

}




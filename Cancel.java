package AirlineManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener {
    JTextField PNRT;
    ResultSet rs;
    JLabel Heading,PNR,name,lbname,adhar,lbadhar,cancell,lbCn,Fc,lbFc,date,lbdate;
    JButton Sdetail,cancel;
    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Heading = new JLabel("CANCELLATION");
        Heading.setBounds(100, 10, 500, 40);
        Heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        Heading.setForeground(Color.BLACK);
        add(Heading);

        PNR = new JLabel("PNR No:");
        PNR.setBounds(50, 80, 150, 25);
        PNR.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(PNR);

        PNRT = new JTextField();
        PNRT.setBounds(180, 80, 120, 25);
        PNRT.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(PNRT);

        Sdetail = new JButton("Details");
        Sdetail.setBounds(320, 80, 100, 25);
        Sdetail.setBackground(Color.black);
        Sdetail.setForeground(Color.WHITE);
        Sdetail.addActionListener(this);
        add(Sdetail);

        name = new JLabel("Name");
        name.setBounds(50, 130 ,150,32);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(name);

        lbname = new JLabel("--||--");
        lbname.setBounds(180,130,150,32);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);

        adhar = new JLabel("Adhar No");
        adhar.setBounds(50, 180 ,150,32);
        adhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(adhar);

        lbadhar = new JLabel("--||--");
        lbadhar.setBounds(180,180,150,32);
        lbadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbadhar);

        cancell = new JLabel("Cancellation No");
        cancell.setBounds(50, 230 ,150,32);
        cancell.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cancell);

        Random ran = new Random();
        lbCn = new JLabel(String.valueOf(ran.nextInt(1000000)));
        lbCn.setBounds(180,230,150,32);
        lbCn.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbCn);

        Fc= new JLabel("Flight Code");
        Fc.setBounds(50, 280 ,150,32);
        Fc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Fc);

        lbFc= new JLabel("--||--");
        lbFc.setBounds(180,280,150,32);
        lbFc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbFc);

        date= new JLabel("Date");
        date.setBounds(50, 320 ,90,25);
        date.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(date);

        lbdate = new JLabel("--||--");
        lbdate.setBounds(180,320,150,32);
        lbdate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbdate);

        cancel = new JButton("Cancel");
        cancel.setBounds(150,380,90,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/Assets/istoc.jpg"));
        JLabel lbLimage = new JLabel(image);
        lbLimage.setBounds(400, -100, 500, 800);
        add(lbLimage);

        setSize(800, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cancel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==Sdetail) {
            String pnr = PNRT.getText();
            try {
                Cone con = new Cone();
                String query = "SELECT * FROM reservation WHERE pnr = '" + pnr + "'";
                rs = con.s.executeQuery(query);

                if (rs.next()) {
                    lbname.setText(rs.getString("name"));
                    lbadhar.setText(rs.getString("aadhar"));
                    lbFc.setText(rs.getString("Flight_code"));
                    lbdate.setText(rs.getString("departure_date"));
                } else {
                    JOptionPane.showConfirmDialog(null, "Please Enter the Correct PNR...!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ((ae.getSource() ==cancel)){
            String pnr = PNRT.getText();
            String name = lbname.getText();
            String cancelno = cancell.getText();
            String fcode= lbCn.getText();
            String date = lbdate.getText();
            try {
                Cone con = new Cone();
                String query = "insert into cancel values('" + pnr + "','" + name + "','" + cancelno + "','" + fcode + "','" + date + "')";
                con.s.executeUpdate(query);
                con.s.executeUpdate("delete from reservation where pnr = '"+pnr+"'");

                JOptionPane.showMessageDialog(null, "Ticket Cancelled Succesfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


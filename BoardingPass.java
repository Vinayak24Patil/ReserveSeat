package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


class BoardingPass extends JFrame implements ActionListener {
    JLabel Heading,SubHeading,lbPNR,lbname2,lbname,lbnationality,lbnationality2,src,src2,dest,dest2 ,lbfn,lbfc,lbfc2,lbfn2,lbdate,lbdate2 ;

    JButton lbfetch;

    JTextField lbPNR2;


    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Heading = new JLabel("AIR INDIA");
        Heading.setBounds(380, 20, 450, 35);
        Heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        Heading.setForeground(Color.BLACK);
        add(Heading);

        SubHeading = new JLabel("Boarding Pass");
        SubHeading.setBounds(380, 70, 450, 35);
        SubHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(SubHeading);

        lbPNR =new JLabel("PNR DETAILS");
        lbPNR.setBounds(60,120,100,25);
        lbPNR.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbPNR);

        lbPNR2 =new JTextField();
        lbPNR2.setBounds(220,120,100,25);
        lbPNR2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbPNR2);

        lbfetch = new JButton("Fetch");
        lbfetch.setBounds(350,120,90,25);
        lbfetch.setBackground(Color.BLACK);
        lbfetch.setForeground(Color.WHITE);
        lbfetch.addActionListener(this);
        add(lbfetch);

        lbname =new JLabel("NAME");
        lbname.setBounds(60,180,90,25);
        lbname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbname);

        lbname2 = new JLabel("==||==");
        lbname2.setBounds(220,180,100,25);
        lbname2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbname2);

        lbnationality = new JLabel("NATIONALITY");
        lbnationality.setBounds(60,240,100,25);
        lbnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbnationality);

        lbnationality2 = new JLabel("==||==");
        lbnationality2.setBounds(220,240,90,25);
        lbnationality2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbnationality2);

        src = new JLabel("SRC");
        src.setBounds(60,300,100,25);
        src.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(src);

        src2 = new JLabel("==||==");
        src2.setBounds(220,300,90,25);
        src2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(src2);

        dest = new JLabel("DEST");
        dest .setBounds(320,300,100,25);
        dest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(  dest );

        dest2  = new JLabel("==||==");
        dest2 .setBounds(470,300,90,25);
        dest2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(  dest2 );

        lbfn = new JLabel("FlightName");
        lbfn.setBounds(60,360,100,25);
        lbfn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbfn);

        lbfn2 = new JLabel("==||==");
        lbfn2.setBounds(220,360,90,25);
        lbfn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbfn2);

        lbfc = new JLabel("FlightCode");
        lbfc .setBounds(320,360,100,25);
        lbfc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(  lbfc );

        lbfc2  = new JLabel("==||==");
        lbfc2 .setBounds(470,360,90,25);
        lbfc2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbfc2);

        lbdate = new JLabel("DATE");
        lbdate .setBounds(60,420,100,32);
        lbdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(  lbdate );

        lbdate2 = new JLabel("==||==");
        lbdate2 .setBounds(220,420,100,32);
        lbdate2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbdate2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/Assets/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 100, 300, 300);
        add(lblimage);

        setSize(1000, 550);
        setLocation(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoardingPass();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == lbfetch) {
            String pnr = lbPNR2.getText();
            try {
                Cone con = new Cone();
                String query = "SELECT * FROM reservation WHERE pnr = '" + pnr + "'";
                ResultSet rs = con.s.executeQuery(query);

                if (rs.next()) {
                    lbname2.setText(rs.getString("name"));
                    lbnationality2.setText(rs.getString("nationality"));
                    src2.setText(rs.getString("source"));
                    dest2.setText(rs.getString("destination"));
                    lbfn2.setText(rs.getString("flight_name"));
                    lbfc2.setText(rs.getString("flight_code"));
                    lbdate2.setText(rs.getString("departure_date"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter the PNR");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



package AirlineManagementSystem;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Random;

public class BookFlight extends JFrame implements ActionListener {
    JTextField tfAadhar;
    JLabel lbName, lbNationality, lbAddress, lbGender, lbFlightName, lbFlightCode;
    JButton btnFetchUser, btnFetchFlight, btnBookFlight;
    Choice source, destination;
    JDateChooser dcDate;

    public BookFlight() {
        setTitle("Book Flight");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel lblAadhar = new JLabel("Aadhar");
        lblAadhar.setBounds(60, 80, 150, 25);
        lblAadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAadhar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(220, 80, 150, 25);
        tfAadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfAadhar);

        btnFetchUser = new JButton("Fetch User");
        btnFetchUser.setBounds(380, 80, 120, 25);
        btnFetchUser.setBackground(Color.BLACK);
        btnFetchUser.setForeground(Color.WHITE);
        btnFetchUser.addActionListener(this);
        add(btnFetchUser);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 130, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

        lbName = new JLabel();
        lbName.setBounds(220, 130, 150, 30);
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbName);

        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);

        lbNationality = new JLabel();
        lbNationality.setBounds(220, 180, 150, 30);
        lbNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbNationality);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);

        lbAddress = new JLabel();
        lbAddress.setBounds(220, 230, 150, 30);
        lbAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbAddress);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);

        lbGender = new JLabel();
        lbGender.setBounds(220, 280, 150, 30);
        lbGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbGender);

        JLabel lblSource = new JLabel("Source");
        lblSource.setBounds(60, 330, 150, 25);
        lblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSource);

        source = new Choice();
        source.setBounds(220, 330, 150, 30);
        source.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(source);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(60, 380, 150, 25);
        lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDestination);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 30);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(destination);

        btnFetchFlight = new JButton("Fetch Flights");
        btnFetchFlight.setBounds(380, 380, 120, 25);
        btnFetchFlight.setBackground(Color.BLACK);
        btnFetchFlight.setForeground(Color.WHITE);
        btnFetchFlight.addActionListener(this);
        add(btnFetchFlight);

        JLabel lblFlightName = new JLabel("Flight Name");
        lblFlightName.setBounds(60, 430, 150, 25);
        lblFlightName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFlightName);

        lbFlightName = new JLabel();
        lbFlightName.setBounds(220, 430, 150, 30);
        lbFlightName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbFlightName);

        JLabel lblFlightCode = new JLabel("Flight Code");
        lblFlightCode.setBounds(60, 480, 150, 25);
        lblFlightCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFlightCode);

        lbFlightCode = new JLabel();
        lbFlightCode.setBounds(220, 480, 150, 30);
        lbFlightCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbFlightCode);

        JLabel lblDate = new JLabel("Date of Travel");
        lblDate.setBounds(60, 530, 150, 25);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDate);

        dcDate = new JDateChooser();
        dcDate.setBounds(220, 530, 150, 30);
        dcDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(dcDate);

        btnBookFlight = new JButton("Book Flight");
        btnBookFlight.setBounds(220, 580, 150, 25);
        btnBookFlight.setBackground(Color.BLACK);
        btnBookFlight.setForeground(Color.WHITE);
        btnBookFlight.addActionListener(this);
        add(btnBookFlight);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/Assets/Depature.jpg"));
        JLabel lbLimage = new JLabel(image);
        lbLimage.setBounds(500,0,600,650);
        add(lbLimage);

        setSize(900, 690);
        setLocation(200, 50);
        setVisible(true);

        loadFlightData();
    }

    private void loadFlightData() {
        try {
            Cone conn = new Cone();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");
            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnFetchUser) {
            String aadhar = tfAadhar.getText();

            try {
                Cone conn = new Cone();

                String query = "select * from passenger where aadhar = '"+aadhar+"'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    lbName.setText(rs.getString("name"));
                    lbNationality.setText(rs.getString("nationality"));
                    lbAddress.setText(rs.getString("address"));
                    lbGender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnFetchFlight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Cone conn = new Cone();

                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    lbFlightName.setText(rs.getString("f_name"));
                    lbFlightCode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();

            String aadhar = tfAadhar.getText();
            String name = lbName.getText();
            String nationality = lbNationality.getText();
            String flightname = lbFlightName.getText();
            String flightcode = lbFlightCode.getText();
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcDate.getDateEditor().getUiComponent()).getText();

            try {
                Cone conn = new Cone();

                // Formatting date to 'YYYY-MM-DD' format
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(dcDate.getDate());

                String query = "INSERT INTO reservation VALUES ('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "', '" +
                        aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" +
                        src + "', '" + des + "', '" + formattedDate + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new BookFlight();
    }
}

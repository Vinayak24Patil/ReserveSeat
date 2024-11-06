package AirlineManagementSystem;

import javax.swing.*; // For creating the windows
import java.awt.*; // For color package
import java.awt.event.*; // For button actions

public class Home extends JFrame implements ActionListener {
  JLabel  Heading;
  JMenuBar menuBar;
  JMenu Details, Ticket;
  JMenuItem FlightDetails, CustomerDetails, BookFlight, JourneyDetails, TicketCancellation, BoardingPass;

    public Home() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/Assets/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 902);
        add(image);

        Heading = new JLabel("AIR INDIA WELCOMES YOU");
        Heading.setBounds(500, 100, 1000, 40);
        Heading.setForeground(Color.RED);
        Heading.setFont(new Font("Tahoma", Font.PLAIN, 40));
        image.add(Heading);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        Details = new JMenu("Menu");
        menuBar.add(Details);

        FlightDetails = new JMenuItem("Flight Detail");
        FlightDetails.addActionListener(this); // Add ActionListener
        Details.add(FlightDetails);

        CustomerDetails = new JMenuItem("Add Customer Details");
        CustomerDetails.addActionListener(this); // Add ActionListener
        Details.add(CustomerDetails);

        BookFlight = new JMenuItem("Book Flight");
        BookFlight.addActionListener(this); // Add ActionListener
        Details.add(BookFlight);

        JourneyDetails = new JMenuItem("Journey Detail");
        JourneyDetails.addActionListener(this); // Add ActionListener
        Details.add(JourneyDetails);

        TicketCancellation = new JMenuItem("Cancel Ticket");
        TicketCancellation.addActionListener(this); // Add ActionListener
        Details.add(TicketCancellation);

        Ticket = new JMenu("Ticket");
        Ticket.setForeground(Color.RED);
        menuBar.add(Ticket);

        BoardingPass = new JMenuItem("Boarding Pass");
        BoardingPass.addActionListener(this); // Add ActionListener
        Ticket.add(BoardingPass);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full-screen option
        setVisible(true);
    }

    public static void main(String[] args) {
        // Launch the Home window
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Text = e.getActionCommand();
        if (Text.equals("Flight Detail")) {
//             new Flightinfo();
        } else if (Text.equals("Add Customer Details")) {
               new AddCustomer();
        } else if (Text.equals("Book Flight")) {
               new BookFlight();
        } else if (Text.equals("Journey Detail")) {
               new JourneyDetail();
        } else if (Text.equals("Cancel Ticket")) {
               new Cancel();
        } else if (Text.equals("Boarding Pass")) {
            new BoardingPass();
        }


    }
}

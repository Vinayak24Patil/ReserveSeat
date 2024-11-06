package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

class JourneyDetail extends JFrame implements ActionListener {
    JTable table;
    JLabel lbAadhar;
    JTextField aadhar;
    JButton show;
    JScrollPane jsp;

    public JourneyDetail() {
        // Set frame properties
        setTitle("Airline Journey Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 245)); // Light grey background

        // Header panel for title
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(245, 245, 245));
        JLabel title = new JLabel("Journey Details");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setForeground(new Color(60, 63, 65));
        headerPanel.add(title);
        add(headerPanel, BorderLayout.NORTH);

        // Input panel using GridBagLayout for flexible scaling
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding for components

        // Aadhar label
        lbAadhar = new JLabel("Enter Aadhar:");
        lbAadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(lbAadhar, gbc);

        // Aadhar input text field
        aadhar = new JTextField(15);
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(aadhar, gbc);

        // Show Details button
        show = new JButton("Show Details");
        show.setBackground(new Color(70, 130, 180));
        show.setForeground(Color.WHITE);
        show.setFont(new Font("Tahoma", Font.BOLD, 14));
        show.setFocusPainted(false);
        show.addActionListener(this);
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(show, gbc);

        add(inputPanel, BorderLayout.CENTER);

        // Table setup in JScrollPane for displaying data
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(20);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(211, 211, 211));
        table.getTableHeader().setReorderingAllowed(false);

        jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(700, 300));
        add(jsp, BorderLayout.SOUTH);

        // Make components resize with the window
        setMinimumSize(new Dimension(1000, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Cone con = new Cone(); // Ensure Conn is properly set up
            ResultSet rs = con.s.executeQuery("select * from reservation where aadhar = '" + aadhar.getText() + "'");

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No Information Found", "Message", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving data.", "Error", JOptionPane.ERROR_MESSAGE);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new JourneyDetail();
    }
}

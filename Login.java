package AirlineManagementSystem;

import javax.swing.*; //Creating the windows
import java.awt.*; // for Color package
import java.awt.event.*; // For the button actions
import java.sql.*; // For sql quries


public class Login extends JFrame implements ActionListener{
    JButton BClose,Bsubmit,reset;
    JTextField TUsername;
    JPasswordField TPassword;
    public Login(){
        //Backgorund Setted
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // label UserName
        JLabel lbUsername = new JLabel("Username");
        lbUsername.setBounds(20,20,100,20);
        add(lbUsername);

        // UserName TextField
        TUsername= new JTextField();
        TUsername.setBounds(130,20,200,20);
        add(TUsername);

        //Password label
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(20,60,100,20);
        add(lbpassword);

        //Password Field
        TPassword= new JPasswordField();
        TPassword.setBounds(130,60,200,20);
        add(TPassword);

        //Reset Button with ActionListner
        reset =new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);

        //Submit Button with Actionlistner
        Bsubmit =new JButton("submit");
        Bsubmit.setBounds(190,120,120,20);
        Bsubmit.addActionListener(this);
        add(Bsubmit);

        //Close Button with ActionListner
        BClose =new JButton("Close");
        BClose.setBounds(140,160,120,20);
        BClose.addActionListener(this);
        add(BClose);

        //Window display
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
    }

    public static void main(String[] args) {
            //Login called
            new Login();
    }


    //Action of Login's Buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== Bsubmit){

            String username=TUsername.getText();//To get values from TextField
            String password=TPassword.getText();//To get the values from TextField

            try {
                Cone con =new Cone();

                //wrting query
                String query="select * from login where username='"+username+"' and password='"+password+"'";

                //ResultSet is Class for the sql
                ResultSet rs = con.s.executeQuery(query);

                //checking the admin & password
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    //if invalid password or username occured
                    JOptionPane.showMessageDialog(null,"Invalid username Or Password");
                    setVisible(false);
                }

            }catch (Exception em){  
                em.printStackTrace();
            }

        } else if (e.getSource()== BClose) {

            //Close the Window
            setVisible(false);

        } else if (e.getSource()== reset) {
            //Reset The Data
            TUsername.setText("");//to set value at TextField
            TPassword.setText(""); //to set value at Textfield
        }
    }
}

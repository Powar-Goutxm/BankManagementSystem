package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

// Login class
public class Login extends JFrame implements ActionListener {
    // Global declaration
    JButton login, clear, signup;
    JTextField cardTField;
    JPasswordField pinTField;

    // Constructor of Login class
    Login() {
        // creating the Frame
        setSize(750, 500);
        setLocation(250, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bank");
        getContentPane().setBackground(Color.white);

        // Setting the Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bankk.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);

        label.setBounds(70, 10, 100, 100);
        setLayout(null);

        // setting headline
        JLabel text = new JLabel("Welcome to HBFC Bank ");
        text.setBounds(215, 40, 500, 40);
        text.setFont(new Font("Osward", Font.BOLD, 35));
        add(text);

        // card no
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Osward", Font.BOLD, 25));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        cardTField = new JTextField();
        cardTField.setFont(new Font("Arial", Font.BOLD, 15));
        cardTField.setBounds(250, 150, 250, 30);
        add(cardTField);

        // Pin no
        JLabel pin = new JLabel("PIN No: ");
        pin.setBounds(120, 220, 400, 30);
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        add(pin);
        pinTField = new JPasswordField();
        pinTField.setFont(new Font("Arial", Font.BOLD, 15));
        pinTField.setBounds(250, 220, 250, 30);
        add(pinTField);

        // login button
        login = new JButton("SIGN IN");
        login.setBounds(250, 300, 100, 30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        // Clear button
        clear = new JButton("CLEAR");
        clear.setBounds(400, 300, 100, 30);
        clear.setBackground(Color.blue);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        // signup button
        JLabel signupMsg = new JLabel("Don't have an account?");
        signupMsg.setBounds(250, 360, 190, 27);
        signupMsg.setFont(new Font("Arial", Font.PLAIN, 14));
        add(signupMsg);
        signup = new JButton("SIGN UP");
        signup.setBounds(405, 360, 82, 27);
        signup.setBackground(Color.blue);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
    }

    // Button working
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            connection conn = new connection();
            String cardnumber = cardTField.getText();
            String pinnumber = pinTField.getText();

            // Updated query to Account table
            String query = "SELECT * FROM Account WHERE Card_No = '" + cardnumber + "' AND Pin_No = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.statement.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(cardnumber, pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == clear) {
            cardTField.setText("");
            pinTField.setText("");
        } else if (e.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}

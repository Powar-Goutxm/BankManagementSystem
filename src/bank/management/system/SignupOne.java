
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame{
    //Global declaration
     JTextField nameTField;
     JTextField fnameTField;
     JTextField mnameTField;
     JTextField emailTField;
     JTextField addrTField;
     JTextField cityTField;
     JTextField stateTField;
     JTextField pcodeTField;
    
    //constructor
    SignupOne(){
        //creating the frame
    getContentPane().setBackground(Color.white);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(690,720);
    setLocation(350,10);
    setVisible(true);
    setLayout(null);
    
    //To get a random form no
    Random r = new Random();
    int random = Math.abs(r.nextInt()/100000);
   
    JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
    formno.setFont(new Font("Raleway", Font.BOLD, 32));
    formno.setBounds(99, 20, 600, 35);
    add(formno);
    
    JLabel personaldet = new JLabel("Page 1: Personal Details");
    personaldet.setFont(new Font("Raleway", Font.BOLD, 22));
    personaldet.setBounds(200, 80, 300, 25);
    add(personaldet);
    
    //Getting Personal details
                             
    JLabel name = new JLabel("Name:");
    name.setFont(new Font("Raleway", Font.BOLD, 17));
    name.setBounds(100, 130, 120, 25);
    add(name);
    nameTField = new JTextField(); 
    nameTField.setFont(new Font("Raleway",Font.BOLD,14));
    nameTField.setBounds(230, 130, 350, 25);
    add(nameTField);
    
    JLabel fname = new JLabel("Father's Name:");
    fname.setFont(new Font("Raleway", Font.BOLD, 17));
    fname.setBounds(100, 175, 200, 25);
    add(fname);
    fnameTField = new JTextField(); 
    fnameTField.setFont(new Font("Raleway",Font.BOLD,14));
    fnameTField.setBounds(230, 175, 350, 25);
    add(fnameTField);
    
    JLabel mname = new JLabel("Mother's Name:");
    mname.setFont(new Font("Raleway", Font.BOLD, 17));
    mname.setBounds(100, 220, 200, 25);
    add(mname);
    mnameTField = new JTextField(); 
    mnameTField.setFont(new Font("Raleway",Font.BOLD,14));
    mnameTField.setBounds(230, 220, 350, 25);
    add(mnameTField);

    
    JLabel gen= new JLabel("Gender:");
    gen.setFont(new Font("Raleway", Font.BOLD, 17));
    gen.setBounds(100, 265, 120, 25);
    add(gen); 
    
    
    JLabel dob = new JLabel("Date of Birth:");
    dob.setFont(new Font("Raleway", Font.BOLD, 17));
    dob.setBounds(100, 310, 120, 25);
    add(dob);
    JDateChooser datechooser = new JDateChooser();
    datechooser.setBounds(230, 310, 140, 25);
    add(datechooser);
    
     JLabel email= new JLabel("Email:");
    email.setFont(new Font("Raleway", Font.BOLD, 17));
    email.setBounds(100, 355, 120, 25);
    add(email);
    emailTField = new JTextField(); 
    emailTField.setFont(new Font("Raleway",Font.BOLD,14));
    emailTField.setBounds(230, 355, 350, 25);
    add(emailTField);

    
   
     JLabel mstatus= new JLabel("Marital Status:");
    mstatus.setFont(new Font("Raleway", Font.BOLD, 17));
    mstatus.setBounds(100, 400, 120, 25);
    add(mstatus);
    
    JLabel addr= new JLabel("Address:");
    addr.setFont(new Font("Raleway", Font.BOLD, 17));
    addr.setBounds(100, 445, 120, 25);
    add(addr);
    addrTField = new JTextField(); 
    addrTField.setFont(new Font("Raleway",Font.BOLD,14));
    addrTField.setBounds(230, 445, 350, 25);
    add(addrTField);
    
    JLabel city= new JLabel("City:");
    city.setFont(new Font("Raleway", Font.BOLD, 17));
    city.setBounds(100, 490, 120, 25);
    add(city);
    cityTField = new JTextField(); 
    cityTField.setFont(new Font("Raleway",Font.BOLD,14));
    cityTField.setBounds(230, 490, 350, 25);
    add(cityTField);
    
    JLabel state= new JLabel("State:");
    state.setFont(new Font("Raleway", Font.BOLD, 17));
    state.setBounds(100, 535, 120, 25);
    add(state);
    stateTField = new JTextField(); 
    stateTField.setFont(new Font("Raleway",Font.BOLD,14));
    stateTField.setBounds(230, 535, 350, 25);
    add(stateTField);
    
    JLabel pcode= new JLabel("Pin Code:");
    pcode.setFont(new Font("Raleway", Font.BOLD, 17));
    pcode.setBounds(100, 580, 120, 25);
    add(pcode);
    pcodeTField = new JTextField(); 
    pcodeTField.setFont(new Font("Raleway",Font.BOLD,14));
    pcodeTField.setBounds(230, 580, 350, 25);
    add(pcodeTField);
    
    }
    public static void main(String args[]){
    new SignupOne();
    }
}

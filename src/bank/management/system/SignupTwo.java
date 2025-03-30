package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

//implements ActionListener
public class SignupTwo extends JFrame  {
    //Global declaration
     JTextField aadharTField,panTField;
     JButton next;
     JRadioButton Syes,Sno,ExYes,ExNo;
     JComboBox Rel,Catg,Incm,EduQual,Occup;
    //constructor
    SignupTwo(){
        //setting the frame
    getContentPane().setBackground(Color.white);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(690,710);
    setLocation(350,10);
    setVisible(true);
    setLayout(null);
    
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

       
    JLabel additionalDet = new JLabel("Page 2: Additional Details");
    additionalDet.setFont(new Font("Raleway", Font.BOLD, 24));
    additionalDet.setBounds(200, 65, 300, 28);
    add(additionalDet);
    
    //Getting additional details 
    
    //religion
    JLabel religion = new JLabel("Religion:");
    religion.setFont(new Font("Raleway", Font.BOLD, 17));
    religion.setBounds(80, 130, 120, 25);
    add(religion);
    String valRel[] = {"Hindu" , "Muslim" , "Christian" , "Sikh" , "Other"};
    Rel = new JComboBox(valRel);
    Rel.setBounds(230, 130, 350, 30);
    Rel.setBackground(Color.white);
    add(Rel);
    
    //category
    JLabel category = new JLabel("Category:");
    category.setFont(new Font("Raleway", Font.BOLD, 17));
    category.setBounds(80, 175, 200, 25);
    add(category);
    String valCatg[] = {"General" , "OBC" , "SC" , "ST" , "Other"};
    Catg = new JComboBox(valCatg);
    Catg.setBounds(230, 175, 350, 30);
    Catg.setBackground(Color.white);
    add(Catg);    
    
    //income
    JLabel aincome = new JLabel("Annual Income:");
    aincome.setFont(new Font("Raleway", Font.BOLD, 17));
    aincome.setBounds(80, 220, 200, 25);
    add(aincome);
    
    String valIncm[] = {"< 1,00,000" , "< 2,50,000" , "< 5,00,000" , "< 8,00,000" , "< 12,00,000", "< 20,00,000", "< 50,00,000", "> 50,00,000"};
    Incm = new JComboBox(valIncm);
    Incm.setBounds(230, 220, 350, 30);
    Incm.setBackground(Color.white);
    add(Incm);    
    
    //education
    JLabel Edu= new JLabel("Educational");
    Edu.setFont(new Font("Raleway", Font.BOLD, 17));
    Edu.setBounds(80, 265, 120, 25);
    add(Edu);
    JLabel Qual = new JLabel("Qualification:");
    Qual.setFont(new Font("Raleway", Font.BOLD, 17));
    Qual.setBounds(80, 285, 120, 25);
    add(Qual);
    
    String valEducation[] = {"Non_Graduate" , "Graduate" , "Post_Graduate" , "Phd" , "Other"};
    EduQual = new JComboBox(valEducation);
    EduQual.setBounds(230, 275, 350, 30);
    EduQual.setBackground(Color.white);
    add(EduQual);    
    
    //email
     JLabel occupation= new JLabel("Occupation:");
    occupation.setFont(new Font("Raleway", Font.BOLD, 17));
    occupation.setBounds(80, 335, 120, 25);
    add(occupation);
   
    String valOccupation[] = {"Salaried" , "Self_Employed" , "Business" , "Student" , "Other"};
    Occup = new JComboBox(valOccupation);
    Occup.setBounds(230, 335, 350, 30);
    Occup.setBackground(Color.white);
    add(Occup);   
    
    //maritalstatus
     JLabel pan_no= new JLabel("PAN Number:");
    pan_no.setFont(new Font("Raleway", Font.BOLD, 17));
    pan_no.setBounds(80, 390, 120, 25);
    add(pan_no);
    panTField = new JTextField(); 
    panTField.setFont(new Font("Raleway",Font.BOLD,14));
    panTField.setBounds(230, 390, 350, 25);
    add(panTField);
    
    //address
    JLabel addr_no= new JLabel("Aadhar Number:");
    addr_no.setFont(new Font("Raleway", Font.BOLD, 17));
    addr_no.setBounds(80, 440, 150, 25);
    add(addr_no);
    aadharTField = new JTextField(); 
    aadharTField.setFont(new Font("Raleway",Font.BOLD,14));
    aadharTField.setBounds(230, 440, 350, 25);
    add(aadharTField);
    
    JLabel sencitzn= new JLabel("Senior Citizen:");
    sencitzn.setFont(new Font("Raleway", Font.BOLD, 17));
    sencitzn.setBounds(80, 490, 120, 25);
    add(sencitzn); 
    //radiobuttonsfoseniorCitizen
    Syes = new JRadioButton("Yes");
    Syes.setBounds(230, 490, 60, 30);
    Syes.setBackground(Color.white);
    add(Syes);
    Sno = new JRadioButton("No");
    Sno.setBounds(325, 490, 80, 30);
    Sno.setBackground(Color.white);
    add(Sno);
    ButtonGroup sencitzGrp = new ButtonGroup();
    sencitzGrp.add(Syes);
    sencitzGrp.add(Sno);
    
    
    JLabel state= new JLabel("Existing Account:");
    state.setFont(new Font("Raleway", Font.BOLD, 17));
    state.setBounds(80, 535, 150, 25);
    add(state);
    ExYes = new JRadioButton("Yes");
    ExYes.setBounds(230, 535, 60, 30);
    ExYes.setBackground(Color.white);
    add(ExYes);
    ExNo = new JRadioButton("No");
    ExNo.setBounds(325, 535, 80, 30);
    ExNo.setBackground(Color.white);
    add(ExNo);
    ButtonGroup ExistingGrp = new ButtonGroup();
    ExistingGrp.add(ExYes);
    ExistingGrp.add(ExNo);
    
       
    /*next = new JButton("Next");
    next.setBackground(Color.blue);
    next.setForeground(Color.white);
    next.setBounds(500, 590, 80, 30);
    next.setFont(new Font("Raleway",Font.BOLD, 14));
    next.addActionListener(this);
    add(next);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    String formno = "" + random; //explicit type conversion
    String name = nameTField.getText();
    String fname = fnameTField.getText();
    String mname = mnameTField.getText();
    String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
    String email = emailTField.getText();
    
    String locality = localityTField.getText();
    String city = cityTField.getText();
    String state = stateTField.getText();
    String pin = pcodeTField.getText();
    
     //checking radio buttons clicked
    String gender = null;
    if (m.isSelected()){
           gender = "Male";
       }else if(f.isSelected()){
           gender = "Female";
       }else if(other.isSelected()){
           gender = "Other";
       }
    String marriage = null;
    if(married.isSelected()){
           marriage = "Married";
        }else if(unmarried.isSelected()){
           marriage = "Unmarried";
        }else if(pnts.isSelected()){
           marriage = "Prefer Not to Say";
        }
       try{
        if(name.equals("") || fname.equals("") || mname.equals("") || dob.equals("") || email.equals("")
                || locality.equals("") || state.equals("") || city.equals("") || pin.equals("")){
            JOptionPane.showMessageDialog(null, "Enter All the Details");
               }else{
            connection c = new connection();
            String query = "insert into SignUp values ('"+formno+"','"+name+"','"+fname+"','"+mname+"','"+dob+"','"+gender+"','"+email+"','"+marriage+"','"+locality+"','"+state+"','"+city+"','"+pin+"')";            
            c.statement.executeUpdate(query);
        
        }
        
       }catch(Exception ae){
       System.out.println(ae);
       }*/
    }
    
    public static void main(String args[]){
    new SignupTwo();
    }
}




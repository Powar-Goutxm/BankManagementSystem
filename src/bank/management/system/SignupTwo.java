package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

//implements ActionListener
public class SignupTwo extends JFrame implements ActionListener  {
    //Global declaration
    int random;
     JButton next;
     JRadioButton ExYes,ExNo;
     JComboBox Rel,Catg,Incm,EduQual,Occup;
     String formno;
    //constructor
    SignupTwo(String formno){
        this.formno = formno;
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
    
    //occupation
    JLabel occupation= new JLabel("Occupation:");
    occupation.setFont(new Font("Raleway", Font.BOLD, 17));
    occupation.setBounds(80, 335, 120, 25);
    add(occupation);
   
    String valOccupation[] = {"Salaried" , "Self_Employed" , "Business" , "Student" , "Other"};
    Occup = new JComboBox(valOccupation);
    Occup.setBounds(230, 335, 350, 30);
    Occup.setBackground(Color.white);
    add(Occup);   
    JLabel state= new JLabel("Existing Account:");
    state.setFont(new Font("Raleway", Font.BOLD, 17));
    state.setBounds(80, 395, 150, 25);
    add(state);
    ExYes = new JRadioButton("Yes");
    ExYes.setBounds(230, 395, 60, 30);
    ExYes.setBackground(Color.white);
    add(ExYes);
    ExNo = new JRadioButton("No");
    ExNo.setBounds(325, 395, 80, 30);
    ExNo.setBackground(Color.white);
    add(ExNo);
    ButtonGroup ExistingGrp = new ButtonGroup();
    ExistingGrp.add(ExYes);
    ExistingGrp.add(ExNo);
    
       
    next = new JButton("Next");
    next.setBackground(Color.blue);
    next.setForeground(Color.white);
    next.setBounds(500, 590, 80, 30);
    next.setFont(new Font("Raleway",Font.BOLD, 14));
    next.addActionListener(this);
    add(next);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ 
    String religion = (String) Rel.getSelectedItem();
    String category = (String)Catg.getSelectedItem();
    String income = (String)Incm.getSelectedItem();
    String education = (String) EduQual.getSelectedItem();
    String occupation = (String) Occup.getSelectedItem();
    
     //checking radio buttons clicked
    String existAccount = null;
    if (ExYes.isSelected()){
           existAccount = "Yes";
       }else if(ExNo.isSelected()){
           existAccount = "No";
       }
    
       try{
        
            connection c = new connection();
            String query = "insert into SignUpTwo values ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+existAccount+"')";            
            c.statement.executeUpdate(query);
            
       }catch(Exception ae){
       System.out.println(ae);
       }
    }
    
    public static void main(String args[]){
    new SignupTwo("");
    }
}




package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

//implements ActionListener
public class SignupTwo extends JFrame implements ActionListener  {
    //Global declaration
     JButton next,previous;
     JRadioButton ExYes,ExNo;
     JComboBox Rel,Catg,Incm,EduQual,Occup;
     String customerID,formno;
     ButtonGroup ExistingGrp;
     
    //constructor
    SignupTwo(int customerID, String formno){
        this.customerID = String.valueOf(customerID);
        this.formno = formno;
        
        //setting the frame
    getContentPane().setBackground(Color.white);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(690,710);
    setLocation(350,10);
    setVisible(true);
    setLayout(null);
    
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
    JLabel l1 = new JLabel("Application Form No:");
    l1.setFont(new Font("Raleway", Font.BOLD, 29));
    l1.setBounds(160, 25, 500, 35);
    add(l1);
        
    JLabel l2 = new JLabel(formno);
    l2.setFont(new Font("Raleway", Font.BOLD, 29));
    l2.setBounds(670, 25, 150, 35);
    add(l2);
        
    JLabel additionalDet = new JLabel("Page 2: Additional Details");
    additionalDet.setFont(new Font("Raleway", Font.BOLD, 24));
    additionalDet.setBounds(210, 90, 300, 28);
    add(additionalDet);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bankk.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel iconlabel = new JLabel(i3);
        iconlabel.setBounds(30, 0, 100, 100);
        add(iconlabel);
    
    //Getting additional details
    JLabel religion = new JLabel("Religion:");
    religion.setFont(new Font("Raleway", Font.BOLD, 17));
    religion.setBounds(80, 150, 120, 25);
    add(religion);
    String valRel[] = {"Hindu" , "Muslim" , "Christian" , "Sikh" , "Other"};
    Rel = new JComboBox(valRel);
    Rel.setBounds(230, 150, 350, 30);
    Rel.setBackground(Color.white);
    add(Rel);
    
    //category
    JLabel category = new JLabel("Category:");
    category.setFont(new Font("Raleway", Font.BOLD, 17));
    category.setBounds(80, 210, 200, 25);
    add(category);
    String valCatg[] = {"General" , "OBC" , "SC" , "ST" , "Other"};
    Catg = new JComboBox(valCatg);
    Catg.setBounds(230, 210, 350, 30);
    Catg.setBackground(Color.white);
    add(Catg);    
    
    //income
    JLabel aincome = new JLabel("Annual Income:");
    aincome.setFont(new Font("Raleway", Font.BOLD, 17));
    aincome.setBounds(80, 270, 200, 25);
    add(aincome);
    
    String valIncm[] = {"< 1,00,000" , "< 2,50,000" , "< 5,00,000" , "< 8,00,000" , "< 12,00,000", "< 20,00,000", "< 50,00,000", "> 50,00,000"};
    Incm = new JComboBox(valIncm);
    Incm.setBounds(230, 270, 350, 30);
    Incm.setBackground(Color.white);
    add(Incm);    
    
    //education
    JLabel Edu= new JLabel("Educational");
    Edu.setFont(new Font("Raleway", Font.BOLD, 17));
    Edu.setBounds(80, 330, 120, 25);
    add(Edu);
    JLabel Qual = new JLabel("Qualification:");
    Qual.setFont(new Font("Raleway", Font.BOLD, 17));
    Qual.setBounds(80, 350, 120, 25);
    add(Qual);
    
    String valEducation[] = {"Non_Graduate" , "Graduate" , "Post_Graduate" , "Phd" , "Other"};
    EduQual = new JComboBox(valEducation);
    EduQual.setBounds(230, 340, 350, 30);
    EduQual.setBackground(Color.white);
    add(EduQual);
    
    //occupation
    JLabel occupation= new JLabel("Occupation:");
    occupation.setFont(new Font("Raleway", Font.BOLD, 17));
    occupation.setBounds(80, 400, 120, 25);
    add(occupation);
   
    String valOccupation[] = {"Salaried" , "Self_Employed" , "Business" , "Student" , "Other"};
    Occup = new JComboBox(valOccupation);
    Occup.setBounds(230, 400, 350, 30);
    Occup.setBackground(Color.white);
    add(Occup);   
    JLabel state= new JLabel("Existing Account:");
    state.setFont(new Font("Raleway", Font.BOLD, 17));
    state.setBounds(80, 460, 150, 25);
    add(state);
    ExYes = new JRadioButton("Yes");
    ExYes.setBounds(230, 460, 60, 30);
    ExYes.setBackground(Color.white);
    add(ExYes);
    ExNo = new JRadioButton("No");
    ExNo.setBounds(325, 460, 80, 30);
    ExNo.setBackground(Color.white);
    add(ExNo);
    ExistingGrp = new ButtonGroup();
    ExistingGrp.add(ExYes);
    ExistingGrp.add(ExNo);
    
    previous = new JButton("Previous");
    previous.setBackground(Color.BLUE);
    previous.setForeground(Color.WHITE);
    previous.setBounds(230, 550, 100, 30);
    previous.setFont(new Font("Raleway", Font.BOLD, 14));
    previous.addActionListener(this);
    add(previous);
    
    next = new JButton("Next");
    next.setBackground(Color.blue);
    next.setForeground(Color.white);
    next.setBounds(460, 550, 100, 30);
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
           
           if((e.getSource() == next) && (religion.equals("") || category.equals("") || income.equals("") || education.equals("")
           || occupation.equals("")  || ExistingGrp.getSelection() == null)){
            JOptionPane.showMessageDialog(null, "Enter All the Details");
               }
            else if(e.getSource() == previous){
            setVisible(false);
            new SignupOne().setVisible(true);
               }  
            else{
                connection c = new connection();
           String query = "UPDATE Customer SET Religion = '" + religion + "', Category = '" + category + "', Income = '"
                        + income + "', Education = '" + education + "', Occupation = '" + occupation + "', ExistingAccount = '"
                        + existAccount + "' WHERE CustomerID = '" + customerID + "'";
                         c.statement.executeUpdate(query);
            setVisible(false);
            new SignupThree(customerID,formno).setVisible(true);
           c.statement.close();
           c.conn.close();
            }
           
       }catch(Exception ae){
       System.out.println(ae);
       }
    }
    
    public static void main(String args[]){
    new SignupTwo(0,"");
    }
}




package edu.elon.contact;
import java.awt.*;
import javax.swing.*;
public class ContactUI {
  private JPanel panel;
  private Container container;
  private JFrame frame;
  
  
  
  public void createUI(){
	  frame = new JFrame();
	  frame.setTitle("Contact Display View");
	  Container container = frame.getContentPane();
	  frame.add(container);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  JLabel firstName = new JLabel("First Name");
	  JLabel middleName = new JLabel("Middle Name");
	  JLabel lastName = new JLabel("Last Name");
	  JLabel emailLabel = new JLabel("Email");
	  JLabel majorLabel = new JLabel("Major");
	  JTextField firstNameBox = new JTextField();
	  JTextField middleNameBox = new JTextField();
	  JTextField lastNameBox = new JTextField();
	  JTextField emailBox = new JTextField();
	  JTextField majorBox = new JTextField();
	  firstNameBox.setHorizontalAlignment(JTextField.RIGHT);
	  middleNameBox.setHorizontalAlignment(JTextField.RIGHT);
	  lastNameBox.setHorizontalAlignment(JTextField.RIGHT);
	  emailBox.setHorizontalAlignment(JTextField.RIGHT);
	  majorBox.setHorizontalAlignment(JTextField.RIGHT);
	  
  }
  
  
  
}

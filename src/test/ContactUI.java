package test;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactUI {

  private JFrame mainFrame;
  private JPanel labelPanel = new JPanel();
  private JPanel textPanel = new JPanel();
  
  protected JTextField firstBox;
  protected JTextField secondBox;
  protected JTextField thirdBox;
  protected JTextField fourthBox;
  protected JTextField fifthBox;
  
  
  public ContactUI(){
    mainFrame = new JFrame("Contact Display View");
    mainFrame.setSize(400, 200);
    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
  }
  public void createLabels(int type){
    labelPanel.removeAll();
    labelPanel.setLayout(new GridLayout(5,1));
    
    JLabel firstLabel = new JLabel();
    JLabel secondLabel = new JLabel();
    JLabel thirdLabel = new JLabel();
    JLabel fourthLabel = new JLabel();
    JLabel fifthLabel = new JLabel();
    
    if(type == 1){
      firstLabel.setText("First Name");
      secondLabel.setText("Middle Name");
      thirdLabel.setText("Last Name");
      fourthLabel.setText("Email");
      fifthLabel.setText("Major");
    }else{
      firstLabel.setText("Username");
      secondLabel.setText("Password");
      thirdLabel.setText("IP Address");
      fourthLabel.setText("DB Name");
      fifthLabel.setText("Table Name");
    }
    mainFrame.add(labelPanel);
  }
  public void createTextBoxes(int type){
    textPanel.removeAll();
    textPanel.setLayout(new GridLayout(5,1));
    
    firstBox = new JTextField();
    secondBox = new JTextField();
    thirdBox = new JTextField();
    fourthBox = new JTextField();
    fifthBox = new JTextField();
    
    if(type==1){
      firstBox.setText(SQLDatabaseConnector.defaultUser);
      secondBox.setText(SQLDatabaseConnector.defaultPass);
      thirdBox.setText(SQLDatabaseConnector.defaultIP);
      fourthBox.setText(SQLDatabaseConnector.defaultDB);
      fifthBox.setText(SQLDatabaseConnector.defaultTable);
    }
  }
  
}


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.sql.SQLException;  
  
 
class CreateLoginForm extends JFrame  
{  
    JPanel subPanel,Panel,buttPanel;
    JPanel userPanel, passPanel,userbuttPanel,adminbuttPanel,regisbuttPanel; 
    JLabel headLabel,userLabel ,passLabel;
    JButton b1,b2,b3;
    final JTextField  textField1, textField2;  

    CreateLoginForm()  
    { 
        Border border=BorderFactory.createLineBorder(Color.blue,3);
        ImageIcon image = new ImageIcon("deskspp/hilpro/logo.png");
        userPanel =new JPanel();
        passPanel =new JPanel();
        userbuttPanel =new JPanel();
        adminbuttPanel=new JPanel();
        regisbuttPanel=new JPanel();
        headLabel=new JLabel();
        userLabel = new JLabel();
        passLabel = new JLabel();
        ImageIcon userIcon = new ImageIcon("deskapp/hillpro/logo.png");
        ImageIcon passIcon = new ImageIcon("deskapp/hillpro/logo.png");
        this.setTitle("Login Page");
        this.setResizable(true);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);

        headLabel.setText("HILTRON COMPUTER APPLICATION LEARNING CENTER(CALC)");
        headLabel.setHorizontalTextPosition(JLabel.CENTER);
        headLabel.setVerticalTextPosition(JLabel.CENTER);
        headLabel.setFont(new Font("Consolas",Font.PLAIN,35));
        headLabel.setIcon(image);
        headLabel.setBorder(border);

        userLabel.setText("Enter Username");
        userLabel.setHorizontalTextPosition(JLabel.CENTER);
        userLabel.setVerticalTextPosition(JLabel.CENTER);
        userLabel.setFont(new Font("Consolas",Font.PLAIN,35));
        userLabel.setIcon(userIcon);
        userLabel.setIconTextGap(-50);


        passLabel.setText("Enter Password");
        passLabel.setHorizontalTextPosition(JLabel.CENTER);
        passLabel.setVerticalTextPosition(JLabel.CENTER);
        passLabel.setFont(new Font("Consolas",Font.PLAIN,35));
        passLabel.setIcon(passIcon);
        passLabel.setIconTextGap(-50);

        textField1 =new JTextField(15);
        textField1.setPreferredSize(new Dimension(250,40));
        textField1.setFont(new Font("Consolas",Font.PLAIN,35));
        textField1.setForeground(Color.CYAN);
        textField1.setBackground(Color.black);
        textField1.setCaretColor(Color.white);
        textField1.setText("username");

        textField2 =new JTextField(15);
        textField2.setPreferredSize(new Dimension(250,40));
        textField2.setFont(new Font("Consolas",Font.PLAIN,35));
        textField2.setForeground(Color.CYAN);
        textField2.setBackground(Color.black);
        textField2.setCaretColor(Color.white);
        textField2.setText("password");
        this.setIconImage(image.getImage());
        userPanel.setBackground(Color.CYAN);
        userPanel.add(userLabel);

        passPanel.setBackground(Color.CYAN);
        passPanel.add(passLabel);

        b1 = new JButton("USER LOGIN");
        b1.setFocusable(false);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLUE);
        userbuttPanel.add(b1,Component.CENTER_ALIGNMENT);

        b2 = new JButton("ADMIN LOGIN");
        b2.setFocusable(false);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLUE);
        adminbuttPanel.add(b2,Component.CENTER_ALIGNMENT);

        buttPanel=new  JPanel(new GridLayout(1, 3));
        buttPanel.add(userbuttPanel);
        buttPanel.add(adminbuttPanel);
        
        subPanel = new JPanel(new GridLayout(3, 2));  
        subPanel.add(userPanel);    
        subPanel.add(textField1);   
        subPanel.add(passPanel);    
        subPanel.add(textField2);    
        add(subPanel, BorderLayout.CENTER);

        Panel = new JPanel(new GridLayout(3, 1,10,10));  
        Panel.add(headLabel);
        Panel.add(subPanel); 
        Panel.add(buttPanel);   
        add(Panel, BorderLayout.CENTER);

        // b1.addActionListener(this);

        b1.addActionListener(e -> {
            String userValue = textField1.getText();         
            String passValue = textField2.getText();
            connect log;
            try 
            {
                log = new connect();
                boolean check=log.login_student(userValue,passValue);
                if (check==true) 
            { 
                dispose();
                NewPageStudent page=new NewPageStudent(userValue);
                page.setVisible(true);  
            }  
            else{   
                System.out.println("Please enter valid username and password");  
                JOptionPane.showMessageDialog(this, "username or password wrong");
            }
            } 
            catch (SQLException e1) 
            {
                e1.printStackTrace();
            }
        });
        b2.addActionListener(e -> {
            String userValue = textField1.getText();         
            String passValue = textField2.getText();
            connect log;
            try 
            {
                log = new connect();
                boolean check=log.login_admin(userValue,passValue);
                if (check==true) 
            { 
                dispose();
                NewPageAdmin page=new NewPageAdmin(userValue);
                page.setVisible(true);  
            }  
            else{   
                System.out.println("Please enter valid username and password");  
                JOptionPane.showMessageDialog(this, "username or password wrong");
            }
            } 
            catch (SQLException e1) 
            {
                e1.printStackTrace();
            }
        });
    }
}  

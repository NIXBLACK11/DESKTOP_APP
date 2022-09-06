import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.awt.*;

public class CreateLoginForm2 extends JFrame{
    JButton b2;
    JButton b1;
    JLabel errorLabel;
    final JTextField  userField, passField;

    boolean isValid = false;
    

    CreateLoginForm2() throws IOException
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false); 

        userField = new JTextField();
        passField = new JTextField();
        userField.setBounds(215,265, 200,25);
        passField.setBounds(215,425, 200,25);
        userField.setFont(new Font("Consolas",Font.PLAIN,25));
        userField.setText("username");
        passField.setFont(new Font("Consolas",Font.PLAIN,25));
        passField.setText("password");
        userField.setBackground(Color.decode("#0553E5"));
        userField.setForeground(Color.decode("#FDF700"));
        passField.setBackground(Color.decode("#0553E5"));
        passField.setForeground(Color.decode("#FDF700"));
        // userField.setBorder(new RoundBtn(10));
        // passField.setBorder(new RoundBtn(10));

        this.add(userField);
        this.add(passField);

        //buttons
        b2 = new JButton("Admin Login");
        b1 = new JButton("User Login");
        b2.setBounds(70, 500, 150, 20);
        b1.setBounds(400, 500, 150, 20);
        b1.setFont(new Font("MV Boli", Font.PLAIN, 18));
        b2.setFont(new Font("MV Boli", Font.PLAIN, 18));        
        b1.setBackground(Color.decode("#0553E5"));
        b1.setForeground(Color.decode("#FDF700"));
        b2.setBackground(Color.decode("#0553E5"));
        b2.setForeground(Color.decode("#FDF700"));
        b1.setBorder(new RoundBtn(10));
        b2.setBorder(new RoundBtn(10));

        this.add(b1);
        this.add(b2);

        ImageIcon background=new ImageIcon("deskspp/hilpro/loginpage.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1300,700,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,1300,700);
        this.add(back);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);

        b1.addActionListener(e -> {
            String userValue = userField.getText();         
            String passValue = passField.getText();
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
            String userValue = userField.getText();         
            String passValue = passField.getText();
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

class RoundBtn implements Border 
{
    private int r;

    RoundBtn(int r) {
        this.r = r;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, 
    int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}
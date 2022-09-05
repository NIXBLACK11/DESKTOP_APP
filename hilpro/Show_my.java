import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;  
  
class Show_my extends JFrame  
{  
    JPanel contentPanel;
    JPanel userPanel, passPanel,userbuttPanel,adminbuttPanel,regisbuttPanel; 
    JLabel headLabel,userLabel ,passLabel;
    JTable data;
    String arr[][]=new String[2][13];
    public final String columns[] = {"id", "name", "fees", "mobileNumber", "course", "courseDuration", "fathersName", "mothersName", "age", "dob", "startDate", "endDate"};
    Show_my(String name) throws Exception  
    {  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("SHOW CURRENT USERS");  
        this.setSize(1300,500);
        String arr[][]=new String[1][13];
        connect log;
            try 
            {
                log = new connect();
                
                arr=log.Show_my_det(name);
            } 
            catch (SQLException e1) 
            {
                e1.printStackTrace();
            }
            data = new JTable(arr, columns);
            JScrollPane sp = new JScrollPane(data);
            this.add(sp);
        
    }
}

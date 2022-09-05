import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;  
  
class Show extends JFrame  
{  
    JTable data;
    String arr[][]=new String[2][13];
    public final String columns[] = {"id", "name", "fees", "mobileNumber", "course", "courseDuration", "fathersName", "mothersName", "age", "dob", "startDate", "endDate"};
    Show() throws Exception  
    {  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("SHOW CURRENT USERS");  
        this.setSize(1300,500);
        String arr[][]=new String[2][13];
        connect log;
            try 
            {
                log = new connect();
                arr=log.Show_all();
            } 
            catch (SQLException e1) 
            {
                e1.printStackTrace();
            }
            data = new JTable(arr, columns);
            JScrollPane sp = new JScrollPane(data);
            this.add(sp);
            this.setVisible(true);
        
    }
}
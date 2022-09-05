import java.awt.*;

import javax.swing.*; 
  
class search extends JFrame  
{  
    JTable data;
    public final String columns[] = {"id", "name", "fees", "mobileNumber", "course", "courseDuration", "fathersName", "mothersName", "age", "dob", "startDate", "endDate"};
    search(String[][] arr) throws Exception  
    {  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("SEARCH CURRENT USERS");  
        this.setSize(1300,500);

        data = new JTable(arr, columns);
        JScrollPane sp = new JScrollPane(data);
        this.add(sp);
        this.setVisible(true);
    }
}
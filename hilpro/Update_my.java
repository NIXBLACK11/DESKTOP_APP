import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;  
  
class Update_my extends JFrame  
{   
    JPanel contentPanel;
    JPanel userPanel, passPanel,userbuttPanel,adminbuttPanel,regisbuttPanel; 
    JLabel headLabel,userLabel ,passLabel;
    JTable data;
    String arr[][]=new String[2][13];
    public final String columns[] = {"id", "name", "fees", "mobileNumber", "course", "courseDuration", "fathersName", "mothersName", "age", "dob", "startDate", "endDate"};
    Update_my(String name) throws Exception  
    {  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("CLICK TO UPDATE USERS");  
        this.setSize(1300,500);
        String arr[][]=new String[2][13];
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
            data.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int row = data.rowAtPoint(evt.getPoint());
                    int col = data.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0) {
                        //System.out.println("row"+row+"column"+col);
                        display(col,row);
                    }
                }
            });
        
    }
    void display(int col,int row)
    {
        String input = JOptionPane.showInputDialog(null, "enter the new "+columns[col]+"value:");
        connect log;
        boolean check;
        try 
        {
            log = new connect();
            check=log.update(col,row,input);
            if(check==true)
            {
                JOptionPane.showMessageDialog(this, "successfully updated");
            } 
            else
            {
                JOptionPane.showMessageDialog(this, "unsuccessfull");
            } 
        } 
        catch (SQLException e1) 
        {
            e1.printStackTrace();
        }      
    }
}
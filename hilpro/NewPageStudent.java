
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;  
  
class NewPageStudent extends JFrame  
{  
    JPanel Panel;
    JPanel update,Show_all;
    JLabel updateLabel,Show_allLabel;
    JButton b2,b4;
    String name1;
    NewPageStudent(String name)  
    {  
        name1=name;
        Border border=BorderFactory.createLineBorder(Color.blue,3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("Welcome admin "+name);  
        this.setSize(1300,500);

        updateLabel =new JLabel();
        Show_allLabel =new JLabel();

        updateLabel.setText("Enter Username to be updated");
        updateLabel.setHorizontalTextPosition(JLabel.CENTER);
        updateLabel.setVerticalTextPosition(JLabel.CENTER);
        updateLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        Show_allLabel.setText("This button shows all users");
        Show_allLabel.setHorizontalTextPosition(JLabel.CENTER);
        Show_allLabel.setVerticalTextPosition(JLabel.CENTER);
        Show_allLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        b2 = new JButton("UPDATE YOUR DATA");
        b2.setFocusable(false);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLUE);

        b4 = new JButton("SHOW YOUR DATA");
        b4.setFocusable(false);
        b4.setBackground(Color.CYAN);
        b4.setForeground(Color.BLUE);

        update = new JPanel(new GridLayout(3, 1,10,10));
        update.add(updateLabel);
        update.add(b2);

        Show_all = new JPanel(new GridLayout(3, 1,10,10));
        Show_all.add(Show_allLabel);
        Show_all.add(b4);

        update.setBorder(border);
        Show_all.setBorder(border);
        Panel = new JPanel(new GridLayout(2, 2,10,10));  
        Panel.add(update); 
        Panel.add(Show_all);
        Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.getContentPane().add(Panel);
        
        b2.addActionListener(e -> {
            Update_my page;
            try {
                page = new Update_my(name1);
                page.setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        b4.addActionListener(e -> {
            Show_my page;
            try {
                page = new Show_my(name1);
                page.setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            
        });
    }  
}

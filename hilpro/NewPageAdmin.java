
import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;  
  
class NewPageAdmin extends JFrame  
{  
    JPanel Panel;
    JPanel register,update,delete,Show_all,search;
    JLabel registerLabel,updateLabel,deleteLabel,Show_allLabel,searchLabel;
    JButton b1,b2,b3,b4,b5;
    String arr[][]=new String[2][13];
    final JTextField  regis_TextField,delete_TextField,search_TextField;
    NewPageAdmin(String name)  
    {  
        Border border=BorderFactory.createLineBorder(Color.blue,3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("Welcome admin "+name);  
        this.setSize(1300,500);

        registerLabel =new JLabel();
        updateLabel =new JLabel();
        deleteLabel =new JLabel();
        Show_allLabel =new JLabel();
        searchLabel =new JLabel();

        regis_TextField =new JTextField(15);
        regis_TextField.setPreferredSize(new Dimension(250,40));
        regis_TextField.setFont(new Font("Consolas",Font.PLAIN,35));
        regis_TextField.setForeground(Color.CYAN);
        regis_TextField.setBackground(Color.black);
        regis_TextField.setCaretColor(Color.white);

        delete_TextField=new JTextField(15);
        delete_TextField.setPreferredSize(new Dimension(250,40));
        delete_TextField.setFont(new Font("Consolas",Font.PLAIN,35));
        delete_TextField.setForeground(Color.CYAN);
        delete_TextField.setBackground(Color.black);
        delete_TextField.setCaretColor(Color.white);

        search_TextField=new JTextField(15);
        search_TextField.setPreferredSize(new Dimension(250,40));
        search_TextField.setFont(new Font("Consolas",Font.PLAIN,35));
        search_TextField.setForeground(Color.CYAN);
        search_TextField.setBackground(Color.black);
        search_TextField.setCaretColor(Color.white);

        registerLabel.setText("Enter Username to be registered");
        registerLabel.setHorizontalTextPosition(JLabel.CENTER);
        registerLabel.setVerticalTextPosition(JLabel.CENTER);
        registerLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        updateLabel.setText("This button takes to the update menu");
        updateLabel.setHorizontalTextPosition(JLabel.CENTER);
        updateLabel.setVerticalTextPosition(JLabel.CENTER);
        updateLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        deleteLabel.setText("Enter Username to be deleted");
        deleteLabel.setHorizontalTextPosition(JLabel.CENTER);
        deleteLabel.setVerticalTextPosition(JLabel.CENTER);
        deleteLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        Show_allLabel.setText("This button shows all users");
        Show_allLabel.setHorizontalTextPosition(JLabel.CENTER);
        Show_allLabel.setVerticalTextPosition(JLabel.CENTER);
        Show_allLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        searchLabel.setText("click to search from users");
        searchLabel.setHorizontalTextPosition(JLabel.CENTER);
        searchLabel.setVerticalTextPosition(JLabel.CENTER);
        searchLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        b1 = new JButton("REGISTER NEW USER");
        b1.setFocusable(false);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLUE);

        b2 = new JButton("UPDATE USER");
        b2.setFocusable(false);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLUE);

        b3 = new JButton("DELETE USER");
        b3.setFocusable(false);
        b3.setBackground(Color.CYAN);
        b3.setForeground(Color.BLUE);

        b4 = new JButton("SHOW ALL USERS");
        b4.setFocusable(false);
        b4.setBackground(Color.CYAN);
        b4.setForeground(Color.BLUE);

        b5 = new JButton("SEARCH USERS");
        b5.setFocusable(false);
        b5.setBackground(Color.CYAN);
        b5.setForeground(Color.BLUE);

        register = new JPanel(new GridLayout(3, 1,10,10));
        register.add(registerLabel);
        register.add(regis_TextField);
        register.add(b1);

        update = new JPanel(new GridLayout(3, 1,10,10));
        update.add(updateLabel);
        update.add(b2);

        delete = new JPanel(new GridLayout(3, 1,10,10));
        delete.add(deleteLabel);
        delete.add(delete_TextField);
        delete.add(b3);

        Show_all = new JPanel(new GridLayout(3, 1,10,10));
        Show_all.add(Show_allLabel);
        Show_all.add(b4);

        search = new JPanel(new GridLayout(3, 1,10,10));
        search.add(searchLabel);
        search.add(search_TextField);
        search.add(b5);

        register.setBorder(border);
        update.setBorder(border);
        delete.setBorder(border);
        Show_all.setBorder(border);
        search.setBorder(border);
        Panel = new JPanel(new GridLayout(3, 2,10,10));  
        Panel.add(register);
        Panel.add(update); 
        Panel.add(delete); 
        Panel.add(Show_all);
        Panel.add(search);
        // Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // add(Panel, BorderLayout.CENTER);
        Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.getContentPane().add(Panel);

        b1.addActionListener(e -> {
            String userValue = regis_TextField.getText();
            Register page = new Register(userValue);
            page.setVisible(true);
        });
        b2.addActionListener(e -> {
            update page;
            try {
                page = new update();
                page.setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            
        });
        b3.addActionListener(e -> {
            String userValue = delete_TextField.getText();
            connect log;
            try 
            {
                log = new connect();
                boolean check=log.delete(userValue);
                if (check==true) 
                {
                    JOptionPane.showMessageDialog(this, "successfully deleted");
                }  
                else{ 
                    JOptionPane.showMessageDialog(this, "user does not exist");
                }
            } 
            catch (SQLException e1) 
            {
                e1.printStackTrace();
            }
        });
        b4.addActionListener(e -> {
            Show page;
            try {
                page = new Show();
                page.setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            
        });
        b5.addActionListener(e -> {
            String userValue = search_TextField.getText();
            connect log;
            try 
            {
                log = new connect();
                arr=log.search_all(userValue);
                search page;
                try {
                    page = new search(arr);
                    page.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
            }
            } 
            catch (SQLException e1) 
            {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            } 
        });
    }  
}
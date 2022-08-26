
import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;  
  
class Register extends JFrame  
{  
    JPanel Panel,subPanel,buttPanel;
    JButton b1;
    JPanel fees,password,mobileNumber,course,courseDuration,Fathersname,Mothersname,age,dob,startDate,endDate;
    JLabel feesLabel,passwordLabel,mobileNumberLabel,courseLabel,courseDurationLabel,FathersnameLabel,MothersnameLabel,ageLabel,dobLabel,startDateLabel,endDateLabel;
    final JTextField  feesText,passwordText,mobileNumberText,courseText,courseDurationText,FathersnameText,MothersnameText,ageText,dobText,startDateText,endDateText;
    Register(String name)  
    {  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("Register "+name);  
        this.setSize(1300,950);

        feesLabel=new JLabel();
        passwordLabel =new JLabel();
        mobileNumberLabel=new JLabel();
        courseLabel=new JLabel();
        courseDurationLabel=new JLabel();
        FathersnameLabel=new JLabel();
        MothersnameLabel=new JLabel();
        ageLabel=new JLabel();
        dobLabel=new JLabel();
        startDateLabel=new JLabel();
        endDateLabel=new JLabel();

        feesText =new JTextField(15);
        feesText.setPreferredSize(new Dimension(250,40));
        feesText.setFont(new Font("Consolas",Font.PLAIN,35));
        feesText.setForeground(Color.CYAN);
        feesText.setBackground(Color.black);
        feesText.setCaretColor(Color.white);

        passwordText =new JTextField(15);
        passwordText.setPreferredSize(new Dimension(250,40));
        passwordText.setFont(new Font("Consolas",Font.PLAIN,35));
        passwordText.setForeground(Color.CYAN);
        passwordText.setBackground(Color.black);
        passwordText.setCaretColor(Color.white);

        mobileNumberText=new JTextField(15);
        mobileNumberText.setPreferredSize(new Dimension(250,40));
        mobileNumberText.setFont(new Font("Consolas",Font.PLAIN,35));
        mobileNumberText.setForeground(Color.CYAN);
        mobileNumberText.setBackground(Color.black);
        mobileNumberText.setCaretColor(Color.white);

        courseDurationText=new JTextField(15);
        courseDurationText.setPreferredSize(new Dimension(250,40));
        courseDurationText.setFont(new Font("Consolas",Font.PLAIN,35));
        courseDurationText.setForeground(Color.CYAN);
        courseDurationText.setBackground(Color.black);
        courseDurationText.setCaretColor(Color.white);

        courseText=new JTextField(15);
        courseText.setPreferredSize(new Dimension(250,40));
        courseText.setFont(new Font("Consolas",Font.PLAIN,35));
        courseText.setForeground(Color.CYAN);
        courseText.setBackground(Color.black);
        courseText.setCaretColor(Color.white);

        MothersnameText=new JTextField(15);
        MothersnameText.setPreferredSize(new Dimension(250,40));
        MothersnameText.setFont(new Font("Consolas",Font.PLAIN,35));
        MothersnameText.setForeground(Color.CYAN);
        MothersnameText.setBackground(Color.black);
        MothersnameText.setCaretColor(Color.white);

        FathersnameText=new JTextField(15);
        FathersnameText.setPreferredSize(new Dimension(250,40));
        FathersnameText.setFont(new Font("Consolas",Font.PLAIN,35));
        FathersnameText.setForeground(Color.CYAN);
        FathersnameText.setBackground(Color.black);
        FathersnameText.setCaretColor(Color.white);

        ageText=new JTextField(15);
        ageText.setPreferredSize(new Dimension(250,40));
        ageText.setFont(new Font("Consolas",Font.PLAIN,35));
        ageText.setForeground(Color.CYAN);
        ageText.setBackground(Color.black);
        ageText.setCaretColor(Color.white);

        dobText=new JTextField(15);
        dobText.setPreferredSize(new Dimension(250,40));
        dobText.setFont(new Font("Consolas",Font.PLAIN,35));
        dobText.setForeground(Color.CYAN);
        dobText.setBackground(Color.black);
        dobText.setCaretColor(Color.white);

        startDateText=new JTextField(15);
        startDateText.setPreferredSize(new Dimension(250,40));
        startDateText.setFont(new Font("Consolas",Font.PLAIN,35));
        startDateText.setForeground(Color.CYAN);
        startDateText.setBackground(Color.black);
        startDateText.setCaretColor(Color.white);

        endDateText=new JTextField(15);
        endDateText.setPreferredSize(new Dimension(250,40));
        endDateText.setFont(new Font("Consolas",Font.PLAIN,35));
        endDateText.setForeground(Color.CYAN);
        endDateText.setBackground(Color.black);
        endDateText.setCaretColor(Color.white);

        feesLabel.setText("Enter fees submitted true or false");
        feesLabel.setHorizontalTextPosition(JLabel.CENTER);
        feesLabel.setVerticalTextPosition(JLabel.CENTER);
        feesLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        passwordLabel.setText("Enter password");
        passwordLabel.setHorizontalTextPosition(JLabel.CENTER);
        passwordLabel.setVerticalTextPosition(JLabel.CENTER);
        passwordLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        mobileNumberLabel.setText("Enter mobile number");
        mobileNumberLabel.setHorizontalTextPosition(JLabel.CENTER);
        mobileNumberLabel.setVerticalTextPosition(JLabel.CENTER);
        mobileNumberLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        courseLabel.setText("Enter course name");
        courseLabel.setHorizontalTextPosition(JLabel.CENTER);
        courseLabel.setVerticalTextPosition(JLabel.CENTER);
        courseLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        courseDurationLabel.setText("Enter course duration");
        courseDurationLabel.setHorizontalTextPosition(JLabel.CENTER);
        courseDurationLabel.setVerticalTextPosition(JLabel.CENTER);
        courseDurationLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        FathersnameLabel.setText("Enter father's name");
        FathersnameLabel.setHorizontalTextPosition(JLabel.CENTER);
        FathersnameLabel.setVerticalTextPosition(JLabel.CENTER);
        FathersnameLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        MothersnameLabel.setText("Enter mother's name");
        MothersnameLabel.setHorizontalTextPosition(JLabel.CENTER);
        MothersnameLabel.setVerticalTextPosition(JLabel.CENTER);
        MothersnameLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        ageLabel.setText("Enter age");
        ageLabel.setHorizontalTextPosition(JLabel.CENTER);
        ageLabel.setVerticalTextPosition(JLabel.CENTER);
        ageLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        dobLabel.setText("Enter date of birth");
        dobLabel.setHorizontalTextPosition(JLabel.CENTER);
        dobLabel.setVerticalTextPosition(JLabel.CENTER);
        dobLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        startDateLabel.setText("Enter start date");
        startDateLabel.setHorizontalTextPosition(JLabel.CENTER);
        startDateLabel.setVerticalTextPosition(JLabel.CENTER);
        startDateLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        endDateLabel.setText("Enter end date");
        endDateLabel.setHorizontalTextPosition(JLabel.CENTER);
        endDateLabel.setVerticalTextPosition(JLabel.CENTER);
        endDateLabel.setFont(new Font("Consolas",Font.PLAIN,35));

        fees = new  JPanel(new GridLayout(2, 1));
        fees.add(feesLabel);
        fees.add(feesText);

        password = new  JPanel(new GridLayout(2, 1));
        password.add(passwordLabel);
        password.add(passwordText);

        mobileNumber = new  JPanel(new GridLayout(2, 1));
        mobileNumber.add(mobileNumberLabel);
        mobileNumber.add(mobileNumberText);

        course = new  JPanel(new GridLayout(2, 1));
        course.add(courseLabel);
        course.add(courseText);

        courseDuration = new  JPanel(new GridLayout(2, 1));
        courseDuration.add(courseDurationLabel);
        courseDuration.add(courseDurationText);

        Fathersname = new  JPanel(new GridLayout(2, 1));
        Fathersname.add(FathersnameLabel);
        Fathersname.add(FathersnameText);

        Mothersname = new  JPanel(new GridLayout(2, 1));
        Mothersname.add(MothersnameLabel);
        Mothersname.add(MothersnameText);

        age = new  JPanel(new GridLayout(2, 1));
        age.add(ageLabel);
        age.add(ageText);

        dob = new  JPanel(new GridLayout(2, 1));
        dob.add(dobLabel);
        dob.add(dobText);

        startDate = new  JPanel(new GridLayout(2, 1));
        startDate.add(startDateLabel);
        startDate.add(startDateText);

        endDate = new  JPanel(new GridLayout(2, 1));
        endDate.add(endDateLabel);
        endDate.add(endDateText);

        course = new  JPanel(new GridLayout(2, 1));
        course.add(courseLabel);
        course.add(courseText);

        b1 = new JButton("REGISTER USER");
        b1.setFocusable(false);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLUE);

        buttPanel =new JPanel();
        buttPanel.add(b1);

        subPanel = new  JPanel(new GridLayout(6, 2));
        subPanel.add(fees);
        subPanel.add(password);
        subPanel.add(mobileNumber);
        subPanel.add(course);
        subPanel.add(courseDuration);
        subPanel.add(Fathersname);
        subPanel.add(Mothersname);
        subPanel.add(age);
        subPanel.add(dob);
        subPanel.add(startDate);
        subPanel.add(endDate);
        subPanel.add(buttPanel);
        this.add(subPanel);

        b1.addActionListener(e -> {
                String fees = feesText.getText();
                String password = passwordText.getText();         
                String mobile = mobileNumberText.getText();
                String course = courseText.getText();
                String duration = courseDurationText.getText();
                String father = FathersnameText.getText();
                String mother = MothersnameText.getText();
                int age = Integer.parseInt(ageText.getText());
                String dob = dobText.getText();
                String start = startDateText.getText();
                String end = endDateText.getText();
                connect log;
                try 
                {
                    log = new connect();
                    boolean check=log.register(name,fees,password,mobile,course,duration,father,mother,age,dob,start,end);
                    if(check==true)
                    {
                        JOptionPane.showMessageDialog(this, "successfully registered");
                        dispose();
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
            });
    }
}
import javax.swing.JOptionPane;

class LoginFormDemo  
{  
    public static void main(String arg[])  
    {  
        try  
        {  
            CreateLoginForm2 form = new CreateLoginForm2();  
            form.setSize(1300,500);
            form.setVisible(true);    
        }  
        catch(Exception e)  
        {       
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}  

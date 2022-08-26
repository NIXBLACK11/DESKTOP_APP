import javax.swing.JOptionPane;

class LoginFormDemo  
{  
    public static void main(String arg[])  
    {  
        try  
        {  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(1300,500);
            form.setVisible(true);    
        }  
        catch(Exception e)  
        {       
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}  

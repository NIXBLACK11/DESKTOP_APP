import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

   public class connect
   {
    Connection conn = null;
    java.sql.Statement stm;
    ResultSet rs;
    public final String columns[] = {"id", "name", "fees", "mobileNumber", "course", "courseDuration", "fathersName", "mothersName", "age", "dob", "startDate", "endDate"};
    public final int tableColumns = columns.length;
       connect()throws SQLException
       {
           System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
		   //Connection conn = null;
           try
            {
               String userName = "root";
               String password = "2004";
               String url = "jdbc:mysql://localhost:3306/hiltron"; 
               Class.forName("com.mysql.cj.jdbc.Driver");       
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("\nDatabase Connection Established...");
               stm=conn.createStatement();
           }
          catch (Exception ex)
           {
		       System.err.println ("Cannot connect to database server");
			   ex.printStackTrace();
           }      
       }
       boolean login_student(String name,String password) throws SQLException
       {
        //java.sql.Statement stm=conn.createStatement();
        //String sql="select * from student where name=\""+name+"\"and password=\""+password+";";
        //"SELECT password FROM employees WHERE username=\""+username+"\";"
        //String sql="SELECT password FROM student WHERE name=\""+name+"\";";
        String sql="Select Id from student where name= '" + name + "' and password= '" + password + "' ";
        rs=((java.sql.Statement) stm).executeQuery(sql);
        boolean t=rs.next();
        if (conn != null)
               {
                   try
                   {
                       System.out.println("\n***** Let terminate the Connection *****");
					   conn.close ();					   
                       System.out.println ("\nDatabase connection terminated...");
                   }
                   catch (Exception ex)
				   {
				   System.out.println ("Error in connection termination!");
				   }
               }
        if(t)
        {

            return true;

        }
        else{
             return false;
        }
       }
       boolean login_admin(String name,String password) throws SQLException
       {
        String sql="Select Id from admin where name= '" + name + "' and password= '" + password + "' ";
        rs=((java.sql.Statement) stm).executeQuery(sql);
        boolean t=rs.next();
        if (conn != null)
               {
                   try
                   {
                       System.out.println("\n***** Let terminate the Connection *****");
					   conn.close ();					   
                       System.out.println ("\nDatabase connection terminated...");
                   }
                   catch (Exception ex)
				   {
				   System.out.println ("Error in connection termination!");
				   }
               }
        if(t)
        {

            return true;

        }
        else{
             return false;
        }
       }
       //or use ResultSetMetaData rsmd=rs.getMetaData();
       //int cols=rsmd.getColumnCount();
        int countRows()
        {
            String query = "select count(*) from student;";
            int count = 0;
            try 
            {
                rs = stm.executeQuery(query);
                rs.next();
                count = rs.getInt(1);
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
            return count;
        }
        boolean register(String name,String fees,String password,String mobile,String course,String duration,String father,String mother,int age,String dob,String start,String end) throws SQLException
        {
            int id=countRows();
            String sql="insert into student values('" +(id+1)+ "', '" +name+ "', '" +fees+ "', '" +password+ "', '" +mobile+ "', '" +course+ "', '" +duration+ "', '" +father+ "', '" +mother+ "', '" +age+ "', '" +dob+ "', '" +start+ "', '" +end+ "')";
            int x = stm.executeUpdate(sql);
            if (conn != null)
            {
                try
                {
                    System.out.println("\n***** Let terminate the Connection *****");
                    conn.close ();					   
                    System.out.println ("\nDatabase connection terminated...");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
            if(x==1)
            {
                return true;
            }
            return false;
        }
        boolean delete(String name) throws SQLException
        {
            String sql="DELETE FROM student WHERE name= '" + name + "' ;";
            int x = stm.executeUpdate(sql);
            if (conn != null)
            {
                try
                {
                    System.out.println("\n***** Let terminate the Connection *****");
                    conn.close ();					   
                    System.out.println ("\nDatabase connection terminated...");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
            if(x==1)
            {
                return true;
            }
            return false;
        }
        
       String[][] Show_all()throws Exception
        {
        int count = countRows();
        String data[][] = new String[count][tableColumns];
        String query = "SELECT * FROM student";
        try {
            rs = stm.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (int i=0; i<count; i++) 
        {
            rs.next();
            for(int j=0;j<tableColumns;j++)
            {
                data[i][j] = rs.getString(columns[j]);
                //System.out.println(data[i][j]);
            }
        }
        if (conn != null)
            {
                try
                {
                    System.out.println("\n***** Let terminate the Connection *****");
                    conn.close ();					   
                    System.out.println ("\nDatabase connection terminated...");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
        return data;
        }
        String[][] update_show()throws Exception
        {
        int count = countRows();
        String data[][] = new String[count][tableColumns];
        String query = "SELECT * FROM student";
        try {
            rs = stm.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (int i=0; i<count; i++) 
        {
            rs.next();
            for(int j=0;j<tableColumns;j++)
            {
                data[i][j] = rs.getString(columns[j]);
                //System.out.println(data[i][j]);
            }
        }
        if (conn != null)
            {
                try
                {
                    System.out.println("\n***** Let terminate the Connection *****");
                    conn.close ();					   
                    System.out.println ("\nDatabase connection terminated...");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
        return data;
        }
        boolean update(int col,int row,String input) throws SQLException
        {
            //\""+userData[1]+"\"
            String sql="UPDATE student SET " +columns[col]+ "='" +input+ "' WHERE id = " +(row+1)+ ";";
            //System.out.println(sql);
            int x = stm.executeUpdate(sql);
            if (conn != null)
            {
                try
                {
                    System.out.println("\n***** Let terminate the Connection *****");
                    conn.close ();					   
                    System.out.println ("\nDatabase connection terminated...");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
            if(x==1)
            {
                return true;
            }
            return false;
        }
        String[][] Show_my_det(String name)throws Exception
        {
        int count = countRows();
        String data[][] = new String[1][tableColumns];
        String query = "SELECT * FROM student";
        try {
            rs = stm.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (int i=0;i<count; i++) 
        {
            rs.next();
            for(int j=0;j<tableColumns;j++)
            {
                if(rs.getString("name").equals(name))
                {
                    data[0][j] = rs.getString(columns[j]);
                }
                //System.out.println(data[i][j]);
            }
        }
        if (conn != null)
            {
                try
                {
                    System.out.println("\n***** Let terminate the Connection *****");
                    conn.close ();					   
                    System.out.println ("\nDatabase connection terminated...");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
        return data;
        }
}
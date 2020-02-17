package Hybrid_with_datadriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class Read_OR {
 
  
         
       
        
      
        static Properties  prop = new Properties();
        public static Properties getObjectRepository() throws IOException{
        InputStream  is = new FileInputStream(new File("object.Properties"));
            prop.load(is);
            System.out.println("username:"+prop.getProperty("username"));
            System.out.println("password:"+prop.getProperty("password"));
            System.out.println("login:"+prop.getProperty("login"));
            return prop;
         
}
}
/*import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class Read_OR {

   static Properties prop = new Properties();
    public Properties getObjectRepository() throws IOException{
    	
        //Read object repository file
        InputStream stream = new FileInputStream(new File(System.getProperty("object.Properties")));
        //load all objects                                      
        prop.load(stream);
        //System.out.println(""************oooooorrrrrrrrrrrrr*********"+stream.toString());
         return prop;
    }
    
}
*/

/*import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	static Properties prop = new Properties();
	static InputStream input = null;
	
	public static Properties getProperties(){
		try {

	        input = new FileInputStream("config.properties");
	        prop.load(input);

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		return prop;
	}
	
}*/

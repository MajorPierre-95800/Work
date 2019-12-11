import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Temperature {
	
	public static void main(String[] args) {
		
	    BufferedReader file1 = null;
	    FileReader file2 = null;
	    try 
	    {
	      file2 = new FileReader("/sys/class/thermal/thermal_zone0/temp");
	      file1 = new BufferedReader(file2);
	      String Line;
	      while ((Line = file1.readLine()) != null) 
	      {
	        System.out.println(Line);
	      }
	    } 
	    catch (IOException e) 
	    {
	      e.printStackTrace();
	    } 
	    finally 
	    {
	      try 
	      {
	        if (file1 != null)
	          file1.close();
	        if (file2 != null)
	          file2.close();
	      } 
	      catch (IOException e) 
	      {
	        e.printStackTrace();
	      }
	    }
	  }

}
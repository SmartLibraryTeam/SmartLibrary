package business;

public class DirectoryCorrente
{
	     
	public String curDir;
	
	
	public  String getDir() 
	     
	     {
	       
	    	curDir = System.getProperty("user.dir");
	    	
	    	return curDir;
	     
	     }
	  
	  
	     public  void showDir() 
	     
	     {
		       curDir = System.getProperty("user.dir");
		       
		       System.out.println("\nIn questo momento ti trovi nella directory:");
		       
		       System.out.println(curDir);
		         
		         
		  }
		  
	

}

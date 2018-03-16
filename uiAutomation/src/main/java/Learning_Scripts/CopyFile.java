package Learning_Scripts;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.AnsiOutputStream;
import org.fusesource.jansi.AnsiRenderWriter;
import org.fusesource.jansi.AnsiString;

public class CopyFile {
	
	/* ************************************************************************
	* Copying the source file to make a backup file.
	* Checking the Colorful output.
	*
	*
	*
	*
	*
	*******************************************************************************/
	
	
	public static void main(String []Args) throws IOException {
		
		
		
		 File srcDir = new File ("C:\\Users\\ACER\\Downloads\\Photo");
		 File destDir = new File(srcDir+ "\\BackUpFile");
		 
		 if (srcDir.exists()) {
			
				 FileUtils.copyDirectory(srcDir, destDir); 
				 System.out.println("Copied contents from "+srcDir +" to "+ destDir+".");
				 
				
			
		 }
			 else {
				System.out.println("Source Directory- "+"'"+srcDir+"'"+" does not exist."); 
				 
				 AnsiConsole.err.println("Source Directory- "+"'"+srcDir+"'"+" does not exist.");
				 AnsiConsole.system_err.println("Please correct the directory.");
				
				 AnsiConsole.out.println("------------------------------------------");
				 
			
			 }
		 }
		
		 
		
		 
	}



package poker.app.XML;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilePassiveReader {
	
	
	public void Read() throws IOException{

	    // Identify your log file
	    File file = new File("path/to/your/logs/example.log");

	    // Work out the length at the start (before Weblogic starts writing again)
	    long size = file.length();

	    // Read in the data using a buffer
	    InputStream is = new FileInputStream(file);
	    BufferedInputStream bis = new BufferedInputStream(is);

	    long byteCount=0;

	    int result;
	    do {
	      // Read a single byte
	      result = bis.read();
	      if (result != -1)
	      {
	        // Do something with your log
	        System.out.write(result);
	      } else {
	        // Reached EOF
	        break;
	      }
	      byteCount++;
	    } while (byteCount<size);

	    // Printing this causes a final flush of the System.out buffer
	    System.out.printf("%nBytes read=%d",byteCount);

	    bis.close();
	    is.close();
	}
	
	
}

package poker.utils.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class XMLHelper {
	XStream x = new XStream();
	
	/*
	 * Will not create folder if doesnot exist
	 */
	public File getFile(File Folder, String FileName){
		File requestedFile = new File(Folder.getAbsolutePath() + Folder.separator + FileName);
		return requestedFile;
	}	

	
	/*
	 * Will create folder if doesnot exist
	 */
	public File loadFile(File Folder, String FileName){
		createFolderIfNotExists(Folder);
		return new File(Folder.getAbsolutePath()+ Folder.separator + FileName);
	}
	
	public Boolean createFolderIfNotExists(File Folder) {
		Boolean folderExists = false;		
		
		if(Folder.isFile()){
			folderExists = true;
		} else {
			folderExists = Folder.mkdir();			
		}
		return folderExists;
	}
	
	public Boolean createFile(File Folder, String FileName){
		Boolean isFileCreated = false;
		File newFile = new File(Folder.getAbsolutePath() + Folder.separator + FileName);
		try {
			isFileCreated = newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFileCreated;
	}
	
	public FileInputStream getInputStream(File Folder, String FileName){
		FileInputStream FIS = null;
		File fileToStream = loadFile(Folder, FileName);
		
		try {
			FIS = new FileInputStream(fileToStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return FIS;
	}
	
	public FileOutputStream getOutputStream(File Folder, String FileName){
		FileOutputStream FOS = null;
		File fileToStream = loadFile(Folder, FileName);
		
		try {
			FOS = new FileOutputStream(fileToStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return FOS;
	}
	
	
	public void Read(){
		
	}
	
	public void Write(File FileToWrite, String Text){
		
	}
	
	public Boolean SaveObj(Object obj, FileOutputStream FOS){
		Boolean isSaved = false;
		x.toXML(obj, FOS);
		isSaved = true;
		return isSaved;
	}
	
	public Object LoadObj(FileInputStream FIS, Object emptyObject){
		Object o = x.fromXML(FIS, emptyObject);
		return o;
	}

}


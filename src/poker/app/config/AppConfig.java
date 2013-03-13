package poker.app.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class AppConfig {
	public String directoryName = "Settings";
	public File folderSettings = new File(System.getProperty("user.dir") + "\\"
			+ directoryName);
	public Boolean isVMWare = true;
	public String pokerApp = "PlayNow";

	public AppConfig() {
			
	}

	public void main(String[] args) {
		XMLWriter();
	}

	public void createIfNotExist() {
		// if the directory does not exist, create it
		if (!folderSettings.exists()) {
			System.out.println("creating directory: "
					+ folderSettings.toString());
			boolean result = folderSettings.mkdir();
			if (result) {
				System.out.println("DIR created");
			}
		}
	}

	public void XMLWriter() {
		XStream xs = new XStream();	
		AppConfig wac = new AppConfig();
		String fileName = "appconfig";
		String filePath = wac.folderSettings + "\\" + fileName + ".xml";
		System.out.println("Wring to " + filePath.toString());

		try {

			FileOutputStream fos = new FileOutputStream(filePath);
			xs.toXML(wac, fos);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}

	public void XMLReader() {
		XStream xs = new XStream(new DomDriver());
		AppConfig ac = new AppConfig();
		String fileName = "appconfig";

		try {
			FileInputStream fis = new FileInputStream(folderSettings + "\\"
					+ fileName + ".xml");
			xs.fromXML(fis, ac);

			// print the data from the object that has been read
			System.out.println(ac.toString());

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

	}

}
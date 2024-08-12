package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\commandata.properties.txt");
        Properties pobj=new Properties();
        pobj.load(fis);
        System.out.println(pobj.getProperty("Url"));
        System.out.println(pobj.getProperty("Browser"));
        System.out.println(pobj.getProperty("Username"));
        String BROWSER = System.getProperty("Browser");
		String URL = System.getProperty("Url");
		String USERNAME = System.getProperty("Username");
		String PASSWORD = System.getProperty("password");
		
        
	}

}

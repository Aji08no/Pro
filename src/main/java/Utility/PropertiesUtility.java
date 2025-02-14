package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    private Properties pro;

    public  PropertiesUtility(String path) throws IOException {
        pro=new Properties();
        FileInputStream file=new FileInputStream(path);
        pro.load(file);
    }

    public String getProperty(String key){
        return pro.getProperty(key);
    }


    public void testData(){
        XSSFWorkbook book=new XSSFWorkbook();
        XSSFSheet sheet = book.getSheet("");
        int row = sheet.getPhysicalNumberOfRows();
        int  columns=sheet.getRow(1).getPhysicalNumberOfCells();

    }
}

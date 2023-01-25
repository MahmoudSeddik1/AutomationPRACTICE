package excellib;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Excel {
    String excelpath;
    public Excel(String excelpath){
        this.excelpath=excelpath;
    }
    public void Write(String sheetname, String val, int row, int col) throws Exception{
//        String excelpath = "C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx";
        String filename= "TestData";
        File file = new File(excelpath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetname);
        sheet.getRow(row).createCell(col).setCellValue(val);
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        wb.close();
        fos.close();
    }
    public String ReadString (String SheetName,int row, int col) throws Exception {
//        String excelpath = "C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx";
        String filename = "TestData";
        File file = new File(excelpath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(SheetName);
        String CellValue = sheet.getRow(row).getCell(col).getStringCellValue();
        return CellValue;
    }


}


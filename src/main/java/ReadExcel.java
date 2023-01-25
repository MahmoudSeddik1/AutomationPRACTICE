import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcel {
    @Test
    public void excel() throws Exception {
        String excelpath = "C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx";
        String filename= "TestData";
        String sheetname = "Tabelle1";
        File file = new File(excelpath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetname);
        System.out.println(sheet.getLastRowNum());
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(sheet.getLastRowNum()).getLastCellNum();
        System.out.println(rowCount+" " + columnCount);
        for(int i =0;i < rowCount+1;i++ ){
            Row row = sheet.getRow(i);
            for(int j =0;j < row.getLastCellNum();j++){
                System.out.print(sheet.getRow(i).getCell(j)+",");

            }
            System.out.println(" ");

        }
        System.out.println();

    }




}

package tests;

import excellib.Excel;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void testingtest() throws Exception {
        Excel excel = new Excel("C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx");
        System.out.println(excel.ReadString("Tabelle1",0,4));



    }

}

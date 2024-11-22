package Pages.Attendance;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyRecordsPage {
    // Driver
    WebDriver myRecordsDriver;

    // Locators
    By attendanceMenu = By.xpath("//span[contains(text(),'Attendance ')]");
    By myRecordAttendance = By.xpath("//a[contains(text(),'My Records')]");
    By tableData = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']");

    // Elements
    WebElement attendanceMenuElement;
    WebElement myRecordAttendanceElement;
    List<WebElement> tableDataElements;

    // Constructor
    public MyRecordsPage(WebDriver driver) {
        myRecordsDriver = driver;
    }

    // Methods
    public void navigateToMyRecords(){
        attendanceMenuElement = myRecordsDriver.findElement(attendanceMenu);
        Helper.click(attendanceMenuElement);
        myRecordAttendanceElement = myRecordsDriver.findElement(myRecordAttendance);
        Helper.click(myRecordAttendanceElement);

    }


    public int getTableDataSize(){
        tableDataElements = myRecordsDriver.findElements(tableData);
        return tableDataElements.size();
    }

}

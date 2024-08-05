package tests;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ExcelHandler;
import utils.WebDriverManage;

import java.io.IOException;

public class TestBase {

    protected WebDriver driver;



    @BeforeClass
    public void setUp() {
        driver = WebDriverManage.getDriver();
    }


    @AfterClass
    public void tearDown() {
        WebDriverManage.quitDriver();
    }



    public  String firstName;
    public  String lastName;
    public  String email;
    public  String phone;
    public  String company;
    public  String country;
    public  String message;



    public void setExcelHandler( ) throws IOException {

        ExcelHandler  excelHandler = new ExcelHandler ("ContactUsData.xlsx");

         firstName = excelHandler.getCellData(0, 1, 0);
         lastName = excelHandler.getCellData(0, 1, 1);
         email = excelHandler.getCellData(0, 1, 2);
         phone = excelHandler.getCellData(0, 1, 3);
         company = excelHandler.getCellData(0, 1, 4);
         country = excelHandler.getCellData(0, 1, 5);
         message = excelHandler.getCellData(0, 1, 6);


        RandomDataGenerator random = new RandomDataGenerator();
        int randomNumber1  = random.nextInt(1000,100000);
        int randomNumber2  = random.nextInt(10,90);
        firstName = firstName + randomNumber1;
        lastName = lastName + randomNumber1;
        email =  randomNumber1  + email ;
        phone = phone.substring(1, phone.length() - 1);
        phone = randomNumber2 + phone;
        company = company + randomNumber1;
        message = message + randomNumber1;

    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import org.openqa.selenium.By;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 *
 * @author HP
 */
public class TestNgTest {
    
    // initializing the driver and setting the headless property
    
    WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
    
        
    public TestNgTest() {
    }
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver.get("https://hassanajmal531.github.io/");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       driver.close();
        
    }
    
    @Test
    public void checkIfSubmitClickable() throws Exception {
       WebElement button = driver.findElement(By.xpath(".//button[@id = 'contactBtn']"));
        
       assertTrue(button.isDisplayed());
        assertTrue(button.isEnabled());
    }
    
    @Test
    public void checkRedirectWithoutInfo()throws Exception {
        
      
        WebElement button = driver.findElement(By.xpath(".//button[@id = 'contactBtn']"));
        button.click();
        WebElement error = driver.findElement(By.xpath("//*[@id=\"my-form\"]/div[1]/div[2]"));
        assertTrue(error.isDisplayed());
        
        
    }
    
    @Test
    public void checkifRedirectwithInfo() throws Exception{
       driver.findElement(By.xpath(".//input[@name = 'name']")).sendKeys("hassan");
       driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("hassan@gmail.com");
       driver.findElement(By.xpath(".//textarea[@name = 'message']")).sendKeys("hello");
       driver.findElement(By.xpath(".//button[@id = 'contactBtn']")).click();

       Thread.sleep(5000);
       String title = driver.getTitle();
       assertEquals(title,"Formspree");

    }
    
    @Test
    public void checkEmail()throws Exception{
        driver.findElement(By.xpath(".//input[@name = 'name']")).sendKeys("hassan");
       driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys("abcsfedf");
       driver.findElement(By.xpath(".//textarea[@name = 'message']")).sendKeys("hello");
       driver.findElement(By.xpath(".//button[@id = 'contactBtn']")).click();
       Thread.sleep(2000);
       WebElement error = driver.findElement(By.xpath("//*[@id=\"my-form\"]/div[2]/div[2]"));
       assertTrue(error.isDisplayed());
    }
    
    @Test
    public void checkResourcesButtonWorks() throws Exception{
        WebElement ResourcesBtn = driver.findElement(By.xpath("//*[@id=\"navResourceBtn\"]"));
        assertTrue(ResourcesBtn.isEnabled());
        ResourcesBtn.click();
        Thread.sleep(1000);
        WebElement tag = driver.findElement(By.xpath("//*[@id=\"contriHead\"]"));
        assertTrue(tag.isDisplayed());
        
    }
}

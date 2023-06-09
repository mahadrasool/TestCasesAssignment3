
package com.mycompany.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

    public static void main(String[] args) {
         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
        
        driver.get("https://ec-client-six.vercel.app/");
        
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        registerButton.click();
        
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
        nameField.sendKeys("Osama1122132@example.com");
       
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
        passwordField.sendKeys("password123");
        
        // Click on the Register button
        WebElement registerButton2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/button"));
        registerButton2.click();
        
        if (isHomePage(driver)) {
            System.out.println("Login Test Passed Login page opened.");
        } else {
            System.out.println("Login  test Failed!.");
        }
        
        
        
    }
    private static boolean isHomePage(WebDriver driver) {
        try {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo01\"]"));
            return loginButton.isDisplayed() && loginButton.getText().equals("ECOMMERCE APP");
        } catch (Exception e) {
            return false;
        }
    }
}

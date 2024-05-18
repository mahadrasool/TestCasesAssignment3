/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author mahad
 */
public class SignUpTestCase {
    public static void main(String[] args) {
         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
        
        driver.get("https://ec-client-six.vercel.app/");
        
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"register\"]"));
        registerButton.click();
        
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
        nameField.sendKeys("Osama ");
        
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail2\"]"));
        emailField.sendKeys("Osama1122132@example.com");
        
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
        passwordField.sendKeys("password123");
        
        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail3\"]"));
        phoneField.sendKeys("1234567890");
        
        WebElement addressField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail4\"]"));
        addressField.sendKeys("123 Street, City");
        
        WebElement sportsField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail5\"]"));
        sportsField.sendKeys("Football");
        
        // Click on the Register button
        WebElement registerButton2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/button"));
        registerButton2.click();
        
        if (isLoginPage(driver)) {
            System.out.println("Registration test Failed! Login page opened.");
        } else {
            System.out.println("Registration test Passed! Login page not opened.");
        }
        
        
        
    }
    private static boolean isLoginPage(WebDriver driver) {
        try {
            WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
            return loginButton.isDisplayed() && loginButton.getText().equals("LOGIN");
        } catch (Exception e) {
            return false;
        }
    }
}


package com.mycompany.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

// AddToCart Class for E-commerce app
public class AddToCart {

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div[1]/div[1]/div/div[2]/button[2]"));
        addToCartButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Click on the cart icon to navigate to the cart page
        WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo01\"]/ul/li[5]/a"));
        cartIcon.click();

        // Verify that the cart contains a product
        if (isProductInCart(driver)) {
            System.out.println("Product added to cart successfully!");
        } else {
            System.out.println("Failed to add product to cart!");
        }

        
        
        
    }
    private static boolean isProductInCart(WebDriver driver) {
        try {
            // Check if a product is present in the cart
            WebElement productElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div[1]/div/div[2]"));
            return productElement.getText().contains("Black Shirt");
        } catch (Exception e) {
            return false;
        }
    }
}

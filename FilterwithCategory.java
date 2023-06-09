
package com.mycompany.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

 
public class FilterwithCategory {

    public static void main(String[] args) {
         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
        
        driver.get("https://ec-client-six.vercel.app/");
        
        

        WebElement categoriesToggle = driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo01\"]/ul/li[2]/a"));
        categoriesToggle.click();
        // Select the "jeans" category from the dropdown
        
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        WebElement category = driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo01\"]/ul/li[2]/ul/li[2]/a"));
        category.click();

       if (areProductsFiltered(driver, "Jeans")) {
            System.out.println("Products filtered by category 'Jeans' successfully!");
        } else {
            System.out.println("Failed to filter products by category 'Jeans'!");
        }
        
        

        
        
        
    }
    private static boolean areProductsFiltered(WebDriver driver, String category) {
        try {
            // Check if the filtered products belong to the specified category
            WebElement productElement = driver.findElement(By.className("card"));
            String productCategory = productElement.getAttribute("data-category");
            return productCategory.equals(category);
        } catch (Exception e) {
            return false;
        }
    }
}

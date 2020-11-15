package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        register(driver);

        sleep(2);
        
        toMainPage(driver);
        
        sleep(2);
        
        logout(driver);
        
        sleep(2);
        
        login(driver, "pekka", "pekka");

        sleep(3);
        
        driver.quit();
    }
    
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }

    private static void register(WebDriver driver){
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);
        
        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("user"+r.nextInt(100000));       
        element = driver.findElement(By.name("password"));
        element.sendKeys("password1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("password1");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
    }



    private static void login(WebDriver driver, String username, String password){
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
    }
    
    private static void toMainPage(WebDriver driver){
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
    }
    
    
    private static void logout(WebDriver driver){
        WebElement element  = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(2);
    }

}

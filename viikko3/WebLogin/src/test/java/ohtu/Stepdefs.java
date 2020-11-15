package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
// import ohtu.authentication.*;
// import ohtu.data_access.*;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    // AuthenticationService auth = new AuthenticationService(new InMemoryUserDao());

    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    

    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        createUser(username, password, password);
    }
    
    @Then("a new user is created")
    public void userIsCreated() {
        pageHasContent("Welcome to Ohtu Application");
    }
    
    
    
    @When("a too short username {string} and a password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        createUser(username, password, password);
    }   
    
    @Then("user is not created and too short username error is reported")
    public void userIsNotCreatedAndTooShortUsernameErrorIsReported(){
        pageHasContent("username should have at least 3 characters");
        pageHasContent("Create username and give password");
    }
    
    
    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void validUsernameAndTooShortPasswordAreGiven(String username, String password) throws Throwable {
        createUser(username, password, password);
    }
    
    @Then("user is not created and too short password error is reported")
    public void userIsNotCreatedAndTooShortPasswordErrorIsReported(){
        pageHasContent("password should have at least 8 characters");
        pageHasContent("Create username and give password");
    }
    
    
    @When("a valid username {string} and password {string} and non-matching password confirmation {string} are entered")
    public void validUsernameAndPasswordAnNonMatcingConfirmationAreGiven(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @Then("user is not created and non-matching confirmation error is reported")
    public void userIsNotCreatedAndNonMatchingConfirmationErrorIsReported(){
        pageHasContent("password and password confirmation do not match");
        pageHasContent("Create username and give password");
    }

    
    
    @Given("user with username {string} with password {string} is successfully created")
    public void newUserIsSuccesfullyCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        createUser(username, password, password);
        pageHasContent("Welcome to Ohtu Application");
    }   

    @Given("user with username {string} and password {string} is tried to be created")
    public void newUserIsTriedToBeCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        createUser(username, password, password);
    }
    
    
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createUser(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    } 
}

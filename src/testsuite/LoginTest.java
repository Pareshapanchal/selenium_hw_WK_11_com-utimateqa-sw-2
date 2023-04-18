package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    //initialise base url link
    String baseUrl =" https://courses.ultimateqa.com/";
    // public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
   public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){openBrowser(baseUrl,browser); }
    @Test
    //1. userShouldNavigateToLoginPageSuccessfully
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //* Verify the text ‘Welcome Back!’
        String acctualMessage = driver.findElement(By.xpath("//h2[@class ='page__heading']")).getText();
        String expectedMessage ="Welcome Back!";
        Assert.assertEquals("Not Match",expectedMessage,acctualMessage);
    }
    @Test
    //2. verifyTheErrorMessage
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id ='user[email]']")).sendKeys("susandavis@gmail.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id ='user[password]']")).sendKeys("susan123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //Verify the error message ‘Invalid email
        String actualErrorMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        String expectedErrorMessage ="Invalid email or password.";
        Assert.assertEquals("Not Match",expectedErrorMessage,actualErrorMessage);

        //or password.’
    }
    @After// closing browser
    public void tearDown(){closeBrowser();}
}

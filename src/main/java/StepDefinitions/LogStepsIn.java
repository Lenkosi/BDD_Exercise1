package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LogStepsIn {
    WebDriver driver;
    String OrderNumber;
    ExtentReports extent;

    ExtentTest test1;
    @Given("a user is on the home page")
    public void a_user_is_on_the_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://adactinhotelapp.com/");
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Khwezilenkosi.Myeni\\IdeaProjects\\BDD_Exercise1\\src\\main\\java\\Reports\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        test1 = extent.createTest("BookHotel").assignAuthor("Khwezi").assignCategory("Smoke test").assignDevice("Chrome");
        test1.log(Status.PASS, "User Fills in Login credentials");
        test1.pass("User successfully logged in");
    }

    @When("a user navigates to the Login page")
    public void a_user_navigates_to_the_login_page() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        //Assert.assertTrue("Title is incorrect. Should be Existing User Login - Build 1," , title.equals("Existing User Login - Build 1"));

    }

    @When("a user enter username and password")
    public void a_user_enter_username_and_password() {

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("WowToTheGreat");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123456789");

    }

    @When("a user clicks the login button")
    public void a_user_clicks_the_login_button() {

        driver.findElement(By.name("login")).click();
        //test1.pass("Loggin In successful");
    }

    @Then("a user is login in successfully")
    public void a_user_is_login_in_successfully() {

        String welcome = driver.getTitle();


    }
    @When("user searches for the desired hotel")
    public void user_searches_for_the_desired_hotel() {

        WebElement staticDropdown = driver.findElement(By.id("location"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);

        Select Hotels =new Select(driver.findElement(By.name("hotels")));
        Hotels.selectByVisibleText("Hotel Creek");

        Select Room_Type =new Select(driver.findElement(By.name("room_type")));
        Room_Type.selectByVisibleText("Double");

        Select AdultPerRoom = new Select(driver.findElement(By.id("adult_room")));
        AdultPerRoom.selectByVisibleText("1 - One");

        Select ChildrenPerRoom = new Select(driver.findElement(By.id("child_room")));
        ChildrenPerRoom.selectByVisibleText("1 - One");

        driver.findElement(By.id("Submit")).click();

        driver.findElement(By.id("radiobutton_0")).click();

        driver.findElement(By.id("continue")).click();

        //test1.pass("Booking successful");
    }
    @When("user enter {string} , {string} , {string}, {string} , {string},  {string}")
    public void user_enter(String Firstname, String Lastname, String Bill, String card_no, String card_card, String Cvv) {
        driver.findElement(By.id("first_name")).sendKeys(Firstname);
        driver.findElement(By.id("last_name")).sendKeys(Lastname);
        driver.findElement(By.id("address")).sendKeys(Bill);
        driver.findElement(By.id("cc_num")).sendKeys(card_no);
        driver.findElement(By.id("cc_type")).sendKeys(card_card);

        Select ExpiryMonth = new Select(driver.findElement(By.name("cc_exp_month")));
        ExpiryMonth.selectByVisibleText("January");
        Select ExpiryYear = new Select(driver.findElement(By.id("cc_exp_year")));
        ExpiryYear.selectByVisibleText("2022");

        driver.findElement(By.id("cc_cvv")).sendKeys(Cvv);
        driver.findElement(By.name("book_now")).click();

    }
    @Then("hotel booked successfully")
    public void hotel_booked_successfully() throws InterruptedException {
        Thread.sleep(3000);
        if (!driver.findElement(By.id("order_no")).isDisplayed()){
            test1.fail("hotel booking unsuccessful");
            Assert.fail();}
        else{

            //test1.pass("search successful");


        }
    }


    @Then("hotel booked unsuccessfully")
    public void hotelBookedUnsuccessfully() {
    }

    @And("a user copy an order ID and Paste at the search bar")
    public void aUserCopyAnOrderIDAndPasteAtTheSearchBar() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderNumber= driver.findElement(By.id("order_no")).getAttribute("value");
        driver.findElement(By.id("my_itinerary")).click();
        driver.findElement(By.id("order_id_text")).sendKeys(OrderNumber);
        Thread.sleep(3000);


    }

    @And("a user clicks the go button")
    public void aUserClicksTheGoButton() {

        driver.findElement(By.name("search_hotel_id")).click();
    }

    @Then("Results of search shows")
    public void resultsOfSearchShows() {
      // String Output = driver.findElement(By.name("search_result_error")).getText();

       //if ( Output=="1 result(s) found.")
       //{
         //  System.out.println("Success Booking");
         //  driver.findElement(By.name("logout")).click();
       //}
       //else
       //{
           //System.out.println("unsuccessful Booking");
           //driver.findElement(By.name("search_hotel")).click();
       //}
        if (!driver.findElement(By.id("search_result_error")).isDisplayed())
            Assert.fail();

        driver.findElement(By.id("logout")).click();






    }

}

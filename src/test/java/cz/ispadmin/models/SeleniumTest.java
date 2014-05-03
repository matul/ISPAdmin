//package cz.ispadmin.models;
//
//import java.net.URI;
//import static org.junit.Assert.assertTrue;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//
///**
// * Selenium Test
// * @author Roman
// */
//public class SeleniumTest extends ModelTest {
//
//  @Autowired
//  private URI baseUrl;
//
//  @Autowired
//  private WebDriver driver;
//
//  @Override
//  protected void setUp() throws Exception {
//    super.setUp();
////    this.baseUrl = new URI("http://localhost:10001/selenuim-tutorial/");
////    this.driver = new FirefoxDriver();
//  }
//
////  @Test
////  public void testWeSeeHelloWorld() {
////    this.driver.get(this.baseUrl.toString());
////    assertTrue(this.driver.getPageSource().contains("404"));
////  }
//
////  @Test
////  public void testWeSeeHelloWorld() {
////    fail();
////  }
////  private Selenium selenium;
////
////  @Before
////  public void setUp() throws Exception {
////    selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.seznam.cz/");
////    selenium.start();
////  }
////  @Test
////  public void testJavaRemote() throws Exception {
////    selenium.open("/");
////    selenium.type("id=inet-field", "Ahoj");
////    selenium.click("id=hledej");
////    selenium.waitForPageToLoad("30000");
////  }
////
////  @After
////  public void tearDown() throws Exception {
////    selenium.stop();
////  }
////private WebDriver driver;
////  private URI baseUrl;
////  @Autowired
////  public void setWebDriver(WebDriver driver) {
////    this.driver = driver;
////  }
////  @Autowired
////  public void setBaseUrl(URI baseUrl) {
////    this.baseUrl = baseUrl;
////  }
////  @Test
////  public void testWeSeeHelloWorld() {
////    assertTrue(true);
//////    this.driver.get(this.baseUrl.toString());
//////    assertTrue(this.driver.getPageSource().contains("Hello World"));
////  }
//}

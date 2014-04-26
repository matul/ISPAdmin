package cz.ispadmin.models;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Roman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  locations = {
    "file:src/main/webapp/WEB-INF/spring-servlet.xml",
    "file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-data-source-test.xml",
  }
)
public class ModelTest extends TestCase {
  
  @Test
  public void exampleTest() {
    assertTrue(true);
  }
  
}

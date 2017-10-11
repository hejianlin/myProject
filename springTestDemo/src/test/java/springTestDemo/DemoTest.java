package springTestDemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hejianlin.main.config.TestConfig;
import com.hejianlin.main.service.TestBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@ActiveProfiles("prod")
public class DemoTest {
	@Autowired
	private TestBean testBean;
	
	@Test
	public void  testProdBean(){
		String expected="from prod profile";
		String actual=testBean.getContent();
		Assert.assertEquals(expected, actual);
	}
}

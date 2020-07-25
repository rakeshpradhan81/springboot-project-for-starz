package com.example;

//import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("junit")
@SpringBootTest(classes = {SpringbootProjectForStarzApplicationTests.class })
public class SpringbootProjectForStarzApplicationTests {

	//@Ignore
	@Test
	public void contextLoads() {
	}

}

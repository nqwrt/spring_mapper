package edu.bit.mapper;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.mapper.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SampleMapperTest {

	@Inject
	private SampleMapper sampleMapper;	
	
	@Test
	public void testGetTime() {
		String  now = sampleMapper.getTime();
		System.out.println("now = " + now);
	}

}

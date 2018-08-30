package com.sanaimam.validic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JobsServiceImplTest {
	
	private JobsServiceImpl jobsService = new JobsServiceImpl();

	@Test
	public void testSearchJobsInCityByLanguage() {
		Result result = new Result("Boston");
		
		List<Response> responses = new ArrayList<Response>();
		Response r1 = new Response();
		r1.setId("1");
		r1.setLocation("Boston");
		r1.setTitle("Full Stack Developer");
		r1.setDescription("This is a python job");
		r1.setType("Full time");
		
		Response r2 = new Response();
		r2.setId("2");
		r2.setLocation("Boston");
		r2.setTitle("Front end Developer");
		r2.setDescription("This job uses python");
		r2.setType("Part time");
		
		responses.add(r1);
		responses.add(r2);
		
		String language = "python";
		
		JobLanguage jobLanguage = new JobLanguage();
		jobLanguage.setTitle(language);
		jobLanguage.setFullTime(1);
		jobLanguage.setPartTime(1);
		result.getLanguages().add(jobLanguage);
		
		JobLanguage testJobLanguage = this.jobsService.searchJobsInCityByLanguage(result, responses, language);
		Assert.assertEquals(jobLanguage, testJobLanguage);
	}

}

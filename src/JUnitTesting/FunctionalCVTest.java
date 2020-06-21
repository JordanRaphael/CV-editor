package JUnitTesting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import CVConstruction.CareerSummary;
import CVConstruction.FunctionalCV;
import CVConstruction.SkillsAndExperience;

public class FunctionalCVTest {
	
	@Test
	public void skillsAndExperienceTest(){
		FunctionalCV tester = new FunctionalCV();	
		
		tester.skillsAndExperienceSaveTitle("title1");
		tester.skillsAndExperienceSaveParagraph("paragraph1");
		tester.skillsAndExperienceSaveTitle("title2");
		tester.skillsAndExperienceSaveParagraph("paragraph2");
		
		ArrayList<SkillsAndExperience> skillsAndExperienceObjects = tester.getSkillsAndExperienceObjects();
		
		SkillsAndExperience testObj1 = new SkillsAndExperience();
		SkillsAndExperience testObj2 = new SkillsAndExperience();
		
		testObj1 = skillsAndExperienceObjects.get(0);
		testObj2 = skillsAndExperienceObjects.get(1);
		String paragraph1 = testObj1.getParagraph().get(0);
		String paragraph2 = testObj2.getParagraph().get(0);
		
		assertEquals("title1", testObj1.getTitle());
		assertEquals("paragraph1", paragraph1);
		assertEquals("title2", testObj2.getTitle());
		assertEquals("paragraph2", paragraph2);
	}
	
	@Test
	public void updateSkillsAndExperienceTest(){
		FunctionalCV tester = new FunctionalCV();
		
		tester.skillsAndExperienceSaveTitle("title1");
		tester.skillsAndExperienceSaveParagraph("paragraph1");
		tester.skillsAndExperienceSaveTitle("title2");
		tester.skillsAndExperienceSaveParagraph("paragraph2");
		
		ArrayList<SkillsAndExperience> arrayToUpdate = tester.getSkillsAndExperienceObjects();

		SkillsAndExperience testObj1 = arrayToUpdate.get(0);
		SkillsAndExperience testObj2 = arrayToUpdate.get(1);
		
		tester.updateSkillsAndExperienceTitle(testObj1, "titleUpdated1");
		tester.updateSkillsAndExperienceParagraph(testObj1, "paragraphUpdated1", testObj1.getParagraph().get(0));
		tester.updateSkillsAndExperienceTitle(testObj2, "titleUpdated2");
		tester.updateSkillsAndExperienceParagraph(testObj2, "paragraphUpdated2", testObj2.getParagraph().get(0));
		
		
		ArrayList<SkillsAndExperience> skillsAndExperienceObjectsToCheck = tester.getSkillsAndExperienceObjects();
		
		SkillsAndExperience testObjToCheck1 = skillsAndExperienceObjectsToCheck.get(0);
		SkillsAndExperience testObjToCheck2 = skillsAndExperienceObjectsToCheck.get(1);
		
		String paragraphToCheck1 = testObjToCheck1.getParagraph().get(0);
		String paragraphToCheck2 = testObjToCheck2.getParagraph().get(0);
		
		assertEquals("titleUpdated1", testObjToCheck1.getTitle());
		assertEquals("paragraphUpdated1", paragraphToCheck1);
		assertEquals("titleUpdated2", testObjToCheck2.getTitle());
		assertEquals("paragraphUpdated2", paragraphToCheck2);
	}
	
	@Test
	public void deleteSkillsAndExperienceTest(){
		FunctionalCV tester = new FunctionalCV();
		
		tester.skillsAndExperienceSaveTitle("title1");
		tester.skillsAndExperienceSaveParagraph("paragraph1");
		tester.skillsAndExperienceSaveTitle("title2");
		tester.skillsAndExperienceSaveParagraph("paragraph2");
		
		ArrayList<SkillsAndExperience> arrayToDelete = tester.getSkillsAndExperienceObjects();
		
		SkillsAndExperience testObjToCheck1 = arrayToDelete.get(0);
		SkillsAndExperience testObjToCheck2 = arrayToDelete.get(1);
		
		tester.deleteSkillsAndExperienceParagraph(testObjToCheck1, "paragraph1");
		tester.deleteSkillsAndExperienceParagraph(testObjToCheck2, "paragraph2");
		
		ArrayList<SkillsAndExperience> arrayToCheckIfDeleted = tester.getSkillsAndExperienceObjects();
		
		ArrayList<String> paragraphToCheckIfDeleted1 = arrayToCheckIfDeleted.get(0).getParagraph();
		ArrayList<String> paragraphToCheckIfDeleted2 = arrayToCheckIfDeleted.get(1).getParagraph();
		
		assertEquals(true, paragraphToCheckIfDeleted1.isEmpty());
		assertEquals(true, paragraphToCheckIfDeleted2.isEmpty());
		
		SkillsAndExperience objToCheckIfDeleted1 = arrayToDelete.get(0);
		SkillsAndExperience objToCheckIfDeleted2 = arrayToDelete.get(1);
		
		tester.deleteSkillsAndExperienceTitle(objToCheckIfDeleted1);
		tester.deleteSkillsAndExperienceTitle(objToCheckIfDeleted2);
		
		arrayToCheckIfDeleted = tester.getSkillsAndExperienceObjects();
		
		assertEquals(true, arrayToCheckIfDeleted.isEmpty());
	}
	
	@Test
	public void careerSummaryTest(){
		FunctionalCV tester = new FunctionalCV();
		
		ArrayList<CareerSummary> testArray = new ArrayList<CareerSummary>();
		CareerSummary testObj1 = new CareerSummary();
		CareerSummary testObj2 = new CareerSummary();
		testObj1.saveFields("company2", "jobtitle2", "2/2/2");
		testObj2.saveFields("company1", "jobtitle1", "1/1/1");
		testArray.add(testObj1);
		testArray.add(testObj2);
		
		tester.careerSummarySave("company2", "jobtitle2", "2/2/2");
		tester.careerSummarySave("company1", "jobtitle1", "1/1/1");
		
		assertEquals(testArray, tester.getCareerSummaryObjects());
		
	}
	
	@Test
	public void updateCareerSummaryTest(){
		FunctionalCV tester = new FunctionalCV();
		
		ArrayList<CareerSummary> testArrayUpdated = new ArrayList<CareerSummary>();
		
		CareerSummary testObj1 = new CareerSummary();
		CareerSummary testObj2 = new CareerSummary();
		
		CareerSummary testObj1Updated = new CareerSummary();
		CareerSummary testObj2Updated = new CareerSummary();
		
		testObj1Updated.saveFields("companyUpdated2", "jobtitleUpdated2", "2/2/2Updated2");
		testObj2Updated.saveFields("companyUpdated1", "jobtitleUpdated1", "1/1/1Updated1");
		
		testArrayUpdated.add(testObj1Updated);
		testArrayUpdated.add(testObj2Updated);
		
		tester.careerSummarySave("company2", "jobtitle2", "2/2/2");
		tester.careerSummarySave("company1", "jobtitle1", "1/1/1");
		
		ArrayList<CareerSummary> arrayToUpdate = tester.getCareerSummaryObjects();

		testObj1 = arrayToUpdate.get(0);
		testObj2 = arrayToUpdate.get(1);
		
		tester.updateCareerSummary(testObj1, "companyUpdated2", "jobtitleUpdated2", "2/2/2Updated2");
		tester.updateCareerSummary(testObj2, "companyUpdated1", "jobtitleUpdated1", "1/1/1Updated1");
		
		assertEquals(testArrayUpdated, tester.getCareerSummaryObjects());
	}
	
	@Test
	public void deleteFurtherCoursesTest(){
		FunctionalCV tester = new FunctionalCV();
		
		tester.careerSummarySave("company1", "jobtitle1", "1/1/1");
		tester.careerSummarySave("company2", "jobtitle2", "2/2/2");
		
		ArrayList<CareerSummary> arrayToDelete = tester.getCareerSummaryObjects();

		CareerSummary objToDelete1 = arrayToDelete.get(0);
		CareerSummary objToDelete2 = arrayToDelete.get(1);
		
		tester.deleteCareerSummary(objToDelete1);
		tester.deleteCareerSummary(objToDelete2);
		
		ArrayList<CareerSummary> arrayToCheckIfDeleted = tester.getCareerSummaryObjects();

		assertEquals(true, arrayToCheckIfDeleted.isEmpty());
	}

}

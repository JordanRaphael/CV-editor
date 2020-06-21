package JUnitTesting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import CVConstruction.ChronologicalCV;
import CVConstruction.ProfessionalExperience;

public class ChronologicalCVTest {
	
	@Test
	public void coreStrengthsTest(){
		ChronologicalCV tester = new ChronologicalCV();
		
		tester.coreStrengthsSave("This is core strength's test paragraph!");
		assertEquals("This is core strength's test paragraph!", tester.getCoreStrengthsParagraph());
	}
	
	@Test
	public void professionalExperienceTest(){
		ChronologicalCV tester = new ChronologicalCV();
		
		ArrayList<String> achievementArr1 = new ArrayList<String>();
		achievementArr1.add("achievement1");
		tester.professionalExperienceSave("company1", "jobtitle1", "1/1/1", "paragraph1", achievementArr1);
		
		ArrayList<String> achievementArr2 = new ArrayList<String>();
		achievementArr2.add("achievement2");
		tester.professionalExperienceSave("company2", "jobtitle2", "2/2/2", "paragraph2", achievementArr2);
		
		ArrayList<ProfessionalExperience> professionalExperienceObjects = tester.getProfessionalExperienceObjects();

		ProfessionalExperience testObj1 = new ProfessionalExperience();
		ProfessionalExperience testObj2 = new ProfessionalExperience();
		
		testObj1 = professionalExperienceObjects.get(1);
		testObj2 = professionalExperienceObjects.get(0);
		String achievement1 = testObj1.getAchievements().get(0);
		String achievement2 = testObj2.getAchievements().get(0);
		
		assertEquals("company1", testObj1.getCompanyName());
		assertEquals("jobtitle1", testObj1.getJobTitle());
		assertEquals("1/1/1", testObj1.getDate());
		assertEquals("paragraph1", testObj1.getParagraph());
		assertEquals("achievement1", achievement1);
		
		assertEquals("company2", testObj2.getCompanyName());
		assertEquals("jobtitle2", testObj2.getJobTitle());
		assertEquals("2/2/2", testObj2.getDate());
		assertEquals("paragraph2", testObj2.getParagraph());
		assertEquals("achievement2", achievement2);
	}
	
	@Test
	public void updateProfessionalExperienceTest(){
		ChronologicalCV tester = new ChronologicalCV();
		
		ArrayList<String> achievementArr1 = new ArrayList<String>();
		achievementArr1.add("achievement1");
		
		tester.professionalExperienceSave("company1", "jobtitle1", "1/1/1", "paragraph1", achievementArr1);
		
		ArrayList<String> achievementArr2 = new ArrayList<String>();
		achievementArr2.add("achievement2");
		
		tester.professionalExperienceSave("company2", "jobtitle2", "2/2/2", "paragraph2", achievementArr2);
		
		ArrayList<ProfessionalExperience> arrayToUpdate = tester.getProfessionalExperienceObjects();

		ProfessionalExperience testObj1 = arrayToUpdate.get(0);
		ProfessionalExperience testObj2 = arrayToUpdate.get(1);
		
		tester.updateProfessionalExperience(testObj2, "companyUpdated1", "jobtitleUpdated1", "1/1/1Updated", "paragraph1Updated", new ArrayList<String>());
		tester.updateProfessionalExperienceAchievements(testObj2, "achievementUpdated1", "achievement1");
		
		tester.updateProfessionalExperience(testObj1, "companyUpdated2", "jobtitleUpdated2", "2/2/2Updated", "paragraph2Updated",new ArrayList<String>());
		tester.updateProfessionalExperienceAchievements(testObj1, "achievementUpdated2", "achievement2");
		
		ArrayList<ProfessionalExperience> professionalExperienceObjectsToCheck = tester.getProfessionalExperienceObjects();
		
		ProfessionalExperience testObjToCheck1 = professionalExperienceObjectsToCheck.get(1);
		ProfessionalExperience testObjToCheck2 = professionalExperienceObjectsToCheck.get(0);
		
		String achievementToCheck1 = testObjToCheck1.getAchievements().get(0);
		String achievementToCheck2 = testObjToCheck2.getAchievements().get(0);
		
		assertEquals("companyUpdated1", testObjToCheck1.getCompanyName());
		assertEquals("jobtitleUpdated1", testObjToCheck1.getJobTitle());
		assertEquals("1/1/1Updated", testObjToCheck1.getDate());
		assertEquals("paragraph1Updated", testObjToCheck1.getParagraph());
		assertEquals("achievementUpdated1", achievementToCheck1);
		
		assertEquals("companyUpdated2", testObjToCheck2.getCompanyName());
		assertEquals("jobtitleUpdated2", testObjToCheck2.getJobTitle());
		assertEquals("2/2/2Updated", testObjToCheck2.getDate());
		assertEquals("paragraph2Updated", testObjToCheck2.getParagraph());
		assertEquals("achievementUpdated2", achievementToCheck2);
	}
	
	@Test
	public void deleteProfessionalExperienceTest(){
		ChronologicalCV tester = new ChronologicalCV();
		
		ArrayList<String> achievementArr1 = new ArrayList<String>();
		achievementArr1.add("achievement1");
		
		tester.professionalExperienceSave("company1", "jobtitle1", "1/1/1", "paragraph1", achievementArr1);
		
		ArrayList<String> achievementArr2 = new ArrayList<String>();
		achievementArr2.add("achievement2");
		
		tester.professionalExperienceSave("company2", "jobtitle2", "2/2/2", "paragraph2", achievementArr2);
		
		ArrayList<ProfessionalExperience> arrayToDelete = tester.getProfessionalExperienceObjects();
		
		ProfessionalExperience testObjToCheck1 = arrayToDelete.get(1);
		ProfessionalExperience testObjToCheck2 = arrayToDelete.get(0);
		
		tester.deleteProfessionalExperienceAchievement(testObjToCheck1, "achievement1");
		tester.deleteProfessionalExperienceAchievement(testObjToCheck2, "achievement2");
		
		ArrayList<ProfessionalExperience> arrayToCheckIfDeleted = tester.getProfessionalExperienceObjects();
		
		ArrayList<String> paragraphToCheckIfDeleted1 = arrayToCheckIfDeleted.get(0).getAchievements();
		ArrayList<String> paragraphToCheckIfDeleted2 = arrayToCheckIfDeleted.get(1).getAchievements();
		
		assertEquals(true, paragraphToCheckIfDeleted1.isEmpty());
		assertEquals(true, paragraphToCheckIfDeleted2.isEmpty());
		
		ProfessionalExperience objToCheckIfDeleted1 = arrayToDelete.get(0);
		ProfessionalExperience objToCheckIfDeleted2 = arrayToDelete.get(1);
		
		tester.deleteProfessionalExperience(objToCheckIfDeleted1);
		tester.deleteProfessionalExperience(objToCheckIfDeleted2);
		
		arrayToCheckIfDeleted = tester.getProfessionalExperienceObjects();
		
		assertEquals(true, arrayToCheckIfDeleted.isEmpty());
	}

}

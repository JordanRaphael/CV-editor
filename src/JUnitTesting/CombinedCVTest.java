package JUnitTesting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import CVConstruction.CombinedCV;
import CVConstruction.ProfessionalExperience;
import CVConstruction.SkillsAndExperience;

public class CombinedCVTest {

	@Test
	public void skillsAndExperienceTest(){
		CombinedCV tester = new CombinedCV();	
		
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
		CombinedCV tester = new CombinedCV();
		
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
		CombinedCV tester = new CombinedCV();
		
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
	public void professionalExperienceTest(){
		CombinedCV tester = new CombinedCV();
		
		ArrayList<String> achievementArr1 = new ArrayList<String>();
		achievementArr1.add("achievement1");
		tester.professionalExperienceSave("company1", "jobtitle1", "1/1/1", "paragraph1", achievementArr1);
		
		ArrayList<String> achievementArr2 = new ArrayList<String>();
		achievementArr2.add("achievement2");
		tester.professionalExperienceSave("company2", "jobtitle2", "2/2/2", "paragraph2", achievementArr2);
		
		
		
		ArrayList<ProfessionalExperience> professionalExperienceObjects = tester.getProfessionalExperienceObjects();
		
		
		
		ProfessionalExperience testObj1 = professionalExperienceObjects.get(0);
		ProfessionalExperience testObj2 = professionalExperienceObjects.get(1);
		
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
		CombinedCV tester = new CombinedCV();
		
		ArrayList<String> achievementArr1 = new ArrayList<String>();
		achievementArr1.add("achievement2");
		
		tester.professionalExperienceSave("company1", "jobtitle1", "1/1/1", "paragraph1", achievementArr1);
		
		ArrayList<String> achievementArr2 = new ArrayList<String>();
		achievementArr2.add("achievement1");
		
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

}

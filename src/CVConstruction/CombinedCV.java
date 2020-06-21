package CVConstruction;

import java.util.ArrayList;

public class CombinedCV extends GenericCV{
	
	// Skills and Experience objects
	private ArrayList<SkillsAndExperience> skillsAndExperienceObjects = new ArrayList<SkillsAndExperience>();

	// Professional Experience objects
	private ArrayList<ProfessionalExperience> professionalExperienceObjects = new ArrayList<ProfessionalExperience>();
	
	public ArrayList<SkillsAndExperience> getSkillsAndExperienceObjects() {
		return skillsAndExperienceObjects;
	}

	public ArrayList<ProfessionalExperience> getProfessionalExperienceObjects() {
		return professionalExperienceObjects;
	}
	
	public void skillsAndExperienceSaveTitle(String newTitle){
		SkillsAndExperience object = new SkillsAndExperience();
		object.saveTitle(newTitle);
		skillsAndExperienceObjects.add(object);
	}
	
	public void skillsAndExperienceSaveParagraph(String newParagraph){
		skillsAndExperienceObjects.get(skillsAndExperienceObjects.size()-1).saveParagraph(newParagraph);
	}
	
	public void professionalExperienceSave(String newCompanyName, String newJobTitle, String newDate, String newParagraph, ArrayList<String> newAchievements){
		ProfessionalExperience object = new ProfessionalExperience();
		object.save(newCompanyName, newJobTitle, newDate, newParagraph,newAchievements);
		professionalExperienceObjects.add(object);
	}
	
	public void updateProfessionalExperience(ProfessionalExperience objectToEdit,
			String newCompanyName, String newJobTitle, String newDate,
			String newParagraph, ArrayList<String> newAchievements){
		
		objectToEdit.save(newCompanyName, newJobTitle, newDate, newParagraph, newAchievements);
	}
	
	public void deleteSkillsAndExperienceTitle(SkillsAndExperience objectToDelete){
		for (SkillsAndExperience object : skillsAndExperienceObjects){
			if(object.getTitle().equals(objectToDelete.getTitle())){
				skillsAndExperienceObjects.remove(object);
				return;
			}
		}
	}
	
	public void deleteProfessionalExperience(ProfessionalExperience objectToDelete){
		for (ProfessionalExperience object : professionalExperienceObjects){
			if(equalsProfessionalExperience(object,objectToDelete)){
				professionalExperienceObjects.remove(object);
				return;
			}
		}
	}
	
	public void deleteProfessionalExperienceAchievement(ProfessionalExperience objectToDelete, String achievementToDelete){
		for (ProfessionalExperience object : professionalExperienceObjects){
			if (equalsProfessionalExperience(object,objectToDelete)){
				ArrayList<String> achievements = object.getAchievements();
				for (String achievement : achievements){
					if (achievement.equals(achievementToDelete)){
						achievements.remove(achievement);
						return;
					}
				}
			}
		}
	}
	
	public void deleteSkillsAndExperienceParagraph(SkillsAndExperience objectToDelete, String paragraphToDelete){
		for (SkillsAndExperience object : skillsAndExperienceObjects){
			if(object.getTitle().equals(objectToDelete.getTitle())){
				ArrayList<String> paragraphs = object.getParagraph();
				for (String paragraph : paragraphs){
					if (paragraph.equals(paragraphToDelete)){
						paragraphs.remove(paragraph);
						return;
					}
				}
			}
		}
	}
	
	public void updateProfessionalExperienceAchievements(ProfessionalExperience objectToEdit, String newAchievement, String achievementToEdit) {
		objectToEdit.updateAchievement(newAchievement, achievementToEdit);
	}

	public void updateSkillsAndExperienceTitle(SkillsAndExperience objectToEdit, String newTitle) {
		objectToEdit.saveTitle(newTitle);
	}
	
	public void updateSkillsAndExperienceParagraph(SkillsAndExperience objectToEdit, String newParagraph, String paragraphToEdit) {
		objectToEdit.updateParagraph(newParagraph, paragraphToEdit);
	}
	
	private boolean equalsProfessionalExperience(ProfessionalExperience object,ProfessionalExperience objectToDelete){
		return (object.getCompanyName().equals(objectToDelete.getCompanyName())
		&& object.getJobTitle().equals(objectToDelete.getJobTitle())
		&& object.getDate().equals(objectToDelete.getDate()));
	}

	public void setSkillsAndExperienceObjects(ArrayList<SkillsAndExperience> objectToSet) {
		skillsAndExperienceObjects = objectToSet;
	}

	public void setProfessionalExperience(ArrayList<ProfessionalExperience> objectsToSet) {
		professionalExperienceObjects = objectsToSet;
	}
}

package CVConstruction;

import java.util.ArrayList;

public class ChronologicalCV extends GenericCV{

	// Core Strengths fields
	private String coreStrengthsParagraph;
	
	// Professional Experience objects
	private ArrayList<ProfessionalExperience> professionalExperienceObjects = new ArrayList<ProfessionalExperience>();
	
	public ArrayList<ProfessionalExperience> getProfessionalExperienceObjects() {
		professionalExperienceObjects.sort(new ProfessionalExperience());
		return professionalExperienceObjects;
	}
	
	public String getCoreStrengthsParagraph() {
		return coreStrengthsParagraph;
	}
	
	public void coreStrengthsSave(String newParagraph){
		coreStrengthsParagraph = newParagraph;
	}
	
	public void setProfessionalExperience(ArrayList<ProfessionalExperience> objectToSet){
		professionalExperienceObjects = objectToSet;
	}
	
	public void updateProfessionalExperience(ProfessionalExperience objectToEdit,
			String newCompanyName, String newJobTitle, String newDate,
			String newParagraph, ArrayList<String> newAchievements){
		
		objectToEdit.save(newCompanyName, newJobTitle, newDate, newParagraph, newAchievements);
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
	
	public void updateProfessionalExperienceAchievements(ProfessionalExperience objectToEdit, String newAchievement, String achievementToEdit) {
		objectToEdit.updateAchievement(newAchievement, achievementToEdit);
	}
	
	public void professionalExperienceSave(String newCompanyName, String newJobTitle, String newDate, String newParagraph, ArrayList<String> newAchievements){
		ProfessionalExperience object = new ProfessionalExperience();
		object.save(newCompanyName, newJobTitle, newDate, newParagraph,newAchievements);
		professionalExperienceObjects.add(object);
	}
	
	private boolean equalsProfessionalExperience(ProfessionalExperience object,ProfessionalExperience objectToDelete){
		return (object.getCompanyName().equals(objectToDelete.getCompanyName())
		&& object.getJobTitle().equals(objectToDelete.getJobTitle())
		&& object.getDate().equals(objectToDelete.getDate()));
	}
	
	
}

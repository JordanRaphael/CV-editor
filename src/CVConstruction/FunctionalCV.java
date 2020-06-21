package CVConstruction;

import java.util.ArrayList;

public class FunctionalCV extends GenericCV{

	// Skills and Experience objects
	private ArrayList<SkillsAndExperience> skillsAndExperienceObjects = new ArrayList<SkillsAndExperience>();

	// Career Summary objects
	private ArrayList<CareerSummary> careerSummaryObjects = new ArrayList<CareerSummary>();
	
	public ArrayList<SkillsAndExperience> getSkillsAndExperienceObjects() {
		return skillsAndExperienceObjects;
	}

	public ArrayList<CareerSummary> getCareerSummaryObjects() {
		careerSummaryObjects.sort(new CareerSummary());
		return careerSummaryObjects;
	}
	
	public void setCareerSummaryObjects(ArrayList<CareerSummary> objectsToSave){
		careerSummaryObjects = objectsToSave;
	}
	
	public void setSkillsAndExperienceObjects(ArrayList<SkillsAndExperience> skillsAndExperienceArrayList){
		skillsAndExperienceObjects = skillsAndExperienceArrayList;
	}
	
	public void skillsAndExperienceSaveTitle(String newTitle){
		SkillsAndExperience object = new SkillsAndExperience();
		object.saveTitle(newTitle);
		skillsAndExperienceObjects.add(object);
	}
	
	public void updateCareerSummary(CareerSummary objectToEdit, String newCompanyName, String newJobTitle, String newDate){
		objectToEdit.saveFields(newCompanyName, newJobTitle, newDate);
	}
	
	public void deleteCareerSummary(CareerSummary objectToDelete){
		careerSummaryObjects.remove(objectToDelete);
	}
	
	public void skillsAndExperienceSaveParagraph(String newParagraph){
		skillsAndExperienceObjects.get(skillsAndExperienceObjects.size()-1).saveParagraph(newParagraph);
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
	
	public void deleteSkillsAndExperienceTitle(SkillsAndExperience objectToDelete){
		for (SkillsAndExperience object : skillsAndExperienceObjects){
			if(object.getTitle().equals(objectToDelete.getTitle())){
				skillsAndExperienceObjects.remove(object);
				return;
			}
		}
	}
	
	public void careerSummarySave(String newCompanyName, String newJobTitle, String newDate){
		CareerSummary object = new CareerSummary();
		object.saveFields(newCompanyName, newJobTitle, newDate);
		careerSummaryObjects.add(object);
	}

	public void updateSkillsAndExperienceTitle(SkillsAndExperience objectToEdit, String newTitle) {
		objectToEdit.saveTitle(newTitle);
	}
	
	public void updateSkillsAndExperienceParagraph(SkillsAndExperience objectToEdit, String newParagraph, String paragraphToEdit) {
		objectToEdit.updateParagraph(newParagraph, paragraphToEdit);
	}
}

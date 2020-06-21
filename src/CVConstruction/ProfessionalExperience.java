package CVConstruction;

import java.util.ArrayList;
import java.util.Comparator;

public class ProfessionalExperience implements Comparator<ProfessionalExperience>{

	// Professional Experience fields
	private String companyName; 
	private String jobTitle;
	private String date;
	private String paragraph;
	private ArrayList<String> achievements = new ArrayList<String>();
	
	public String getCompanyName() {
		return companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getDate() {
		return date;
	}

	public String getParagraph() {
		return paragraph;
	}

	public ArrayList<String> getAchievements() {
		return achievements;
	}
	
	public void printInfo(){
		System.out.println(companyName+" "+jobTitle+" "+date+" "+paragraph);
		for (String obj : achievements){
			System.out.println(obj);
		}
	}
	
	public void save(String newCompanyName, String newJobTitle, String newDate,
			String newParagraph, ArrayList<String> newAchievements){
		companyName = newCompanyName;
		jobTitle = newJobTitle;
		date = newDate;
		paragraph = newParagraph;
		
	    for (String obj : newAchievements){
	    	
	    	achievements.add(new String(obj));
	    }
	}
	
	public void updateAchievement(String newAchievement, String achievementToEdit){
		int i = 0;
		for(String obj : achievements){
			if(obj.compareTo(achievementToEdit) == 0){
				achievements.set(i, newAchievement);
			}
			i++;
		}
	}

	@Override
	public String toString(){
		return companyName+","+jobTitle+","+date;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof ProfessionalExperience)) return false;
		ProfessionalExperience obj2 = (ProfessionalExperience)obj;
		if ((this.companyName.equals(obj2.getCompanyName())) && (this.jobTitle.equals(obj2.getJobTitle())) && (this.date.equals(obj2.getDate())) && (this.paragraph.equals(obj2.getParagraph()))){
			return true;
		}
		return false;
	}
	
	@Override
	public int compare(ProfessionalExperience obj1, ProfessionalExperience obj2){
		String[] date1 = obj1.getDate().split("/",-1);
		String[] date2 = obj2.getDate().split("/",-1);
		try{
			if (date2[2].compareTo(date1[2]) > 0){
				return 1;
			} else if (date2[2].compareTo(date1[2]) < 0){
				return -1;
			} else if (date2[1].compareTo(date1[1]) > 0){
				return 1;
			} else if (date2[1].compareTo(date1[1]) < 0){
				return -1;
			} else if (date2[0].compareTo(date1[0]) > 0){
				return 1;
			} else if (date2[0].compareTo(date1[0]) < 0){
				return -1;
			}
			return 0;
		} catch(Exception e){
			return 0;
		}
	}
}

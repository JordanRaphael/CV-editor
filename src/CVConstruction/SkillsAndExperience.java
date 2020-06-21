package CVConstruction;

import java.util.ArrayList;

public class SkillsAndExperience {

	// Skills and Experience fields
	private String title;
	private ArrayList<String> paragraphs = new ArrayList<String>();

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getParagraph() {
		return paragraphs;
	}
	
	public void printInfo(){
		System.out.println(title);
		for (String obj : paragraphs){
			System.out.println("Pargraph: "+obj);
		}
	}
	
	public void saveTitle(String newTitle){
		title = newTitle;
	}
	
	public void saveParagraph(String newParagraph){
		paragraphs.add(newParagraph);
	}
	
	public void updateParagraph(String newParagraph, String paragraphToEdit){
		int i = 0;
		for(String obj : paragraphs){
			if(obj.compareTo(paragraphToEdit) == 0){
				paragraphs.set(i, newParagraph);
			}
			i++;
		}
	}

	@Override
	public String toString(){
		return title;
	}
	
}

package CVConstruction;

import java.util.Comparator;

public class CareerSummary implements Comparator<CareerSummary>{

	private String companyName;
	private String jobTitle;
	private String date;
	
	public String getCompanyName() {
		return companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getDate() {
		return date;
	}

	
	public void printInfo(){
		System.out.println(companyName+"\n"+jobTitle+"\n"+date);
	}
	
	public void saveFields(String newCompanyName, String newJobTitle, String newDate){
		companyName = newCompanyName;
		jobTitle = newJobTitle;
		date = newDate;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof CareerSummary)) return false;
		CareerSummary obj2 = (CareerSummary)obj;
		if ((this.companyName.equals(obj2.getCompanyName())) && (this.jobTitle.equals(obj2.getJobTitle())) && (this.date.equals(obj2.getDate()))){
			return true;
		}
		return false;
	}

	@Override
	public String toString(){
		return companyName+","+jobTitle+","+date;
	}
	
	@Override
	public int compare(CareerSummary obj1, CareerSummary obj2){
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

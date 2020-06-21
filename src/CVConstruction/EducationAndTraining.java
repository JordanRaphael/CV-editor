package CVConstruction;

import java.util.Comparator;

public class EducationAndTraining implements Comparator<EducationAndTraining>{

	// Education and Training fields
	private String qualification;
	private String establishment;
	private String location;
	private String date;
	
	public String getQualification() {
		return qualification;
	}

	public String getEstablishment() {
		return establishment;
	}

	public String getLocation() {
		return location;
	}

	public String getDate() {
		return date;
	}

	public void printInfo(){
		System.out.println(qualification+"\n"+establishment+"\n"+location+"\n"+date);
	}
	
	public void saveFields(String newQualification, String newEstablishment, String newLocation, String newDate){
		qualification = newQualification;
		establishment = newEstablishment;
		location = newLocation;
		date = newDate;
	}
	
	public boolean equals(EducationAndTraining other){
			return (this.qualification.equals(other.qualification)
					&& this.establishment.equals(other.establishment)
					&& this.location.equals(other.location)
					&& this.date.equals(other.date));
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof EducationAndTraining)) return false;
		return equals((EducationAndTraining)obj);
	}

	
	@Override
	public String toString(){
		return qualification+","+establishment+","+location+","+date;
	}
	
	@Override
	public int compare(EducationAndTraining obj1, EducationAndTraining obj2){
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
	
	
	public int compareObjects(EducationAndTraining otherObj){
		String otherQualification = otherObj.getQualification();
		String otherEstablishment = otherObj.getEstablishment();
		String otherLocation = otherObj.getLocation();
		String otherDate = otherObj.getDate();
		
		if (!this.date.equals(otherDate)){
			return 1;
		} else if (!this.establishment.equals(otherEstablishment)) {
			return 1;
		} else if (!this.location.equals(otherLocation)){
			return 1;
		} else if (!this.qualification.equals(otherQualification)) {
			return 1;
		}
		
		return 0;
	}
	
}

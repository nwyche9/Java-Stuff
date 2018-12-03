// house number, number of people

public class House {
	String houseNumber;
	Person[] people;
	
	public House() {// default constructor
		houseNumber = null;
		people = null;
	}
	public House(String houseNumber, int numberOfPeople) {//constructor where the information is known
		this.houseNumber = houseNumber;
		people = new Person[numberOfPeople];
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Person[] getPeople() {
		return people;
	}
	public void setPeople(Person[] people) {
		this.people = people;
	}
	public String toString() {
		String peopleString = "";
		for(int indexPeople = 0; indexPeople < people.length; indexPeople++) {
			peopleString = peopleString + people[indexPeople] + "\n";
		}
		if(peopleString == "") {
			return ("House number is " + houseNumber + "\n" + "Unknown at the moment");
		}else {
			return ("House number is " + houseNumber + "\n" + peopleString);
		}
	}
}

import javax.swing.JOptionPane;
// becomes spacecardealer
// street name and how many houses on that street


public class Street {
	House[] houses;
	public static int totalNumberOfHouses = 0;
	
	public Street() {
		houses = null;
	}
	
	public Street(int numberOfHouses) {
		houses = new House[numberOfHouses];
		totalNumberOfHouses = totalNumberOfHouses + numberOfHouses;
	}
	
	public static void main(String[] args) {
		/*House myHouse = new House("10",20);
		myHouse.people[0] = new Person("A", 30);
		myHouse.people[1] = new Person("B", 40);
		System.out.println(myHouse);*/
		
		Street mainStreet = new Street();
		String input;
		int response = 0;
		
		String[] option = {"Exit","Analyze","Create"};
		
		do {
			response = JOptionPane.showOptionDialog(null, mainStreet.houses, "Household Database", 0, JOptionPane.INFORMATION_MESSAGE, null, option, option[1]);

			switch(response) {
			case 0:
				break;
			case 1:
				mainStreet.analyzeData();
			case 2:
				input = JOptionPane.showInputDialog("Enter the number of houses please: ");
				mainStreet = new Street(Integer.parseInt(input));
				
				int indexHouse = 0;
				int indexPeople = 0;
				String tempHouseNumber;
				int tempNumberOfPeople;
				
				String tempName;
				int tempAge;
				
				for(indexHouse = 0; indexHouse < mainStreet.houses.length; indexHouse++) {
					tempHouseNumber = JOptionPane.showInputDialog((indexHouse + 1) + ". house number: ");
					input = JOptionPane.showInputDialog((indexHouse + 1)+ ". house, how many people?: ");
					tempNumberOfPeople = Integer.parseInt(input);
					mainStreet.houses[indexHouse] = new House(tempHouseNumber, tempNumberOfPeople);
					
					for(indexPeople = 0; indexPeople < mainStreet.houses[indexHouse].people.length; indexPeople++) { // for loop that gets name and age of inhabitants
						tempName = JOptionPane.showInputDialog("Enter the name of the " + (indexPeople + 1) + ". person: ");
						input = JOptionPane.showInputDialog("Enter the age of the " + tempName+ " : ");
						tempAge = Integer.parseInt(input);
						mainStreet.houses[indexHouse].people[indexPeople] = new Person(tempName, tempAge); // creating a person with the inputted name and age
					}
					
				}
				break;
			}
		}while(response != 0);

	}

	public void analyzeData() {
		// TODO Auto-generated method stub
		double total = 0;
		double average = 0;
		for(int indexHouse =0;indexHouse < this.houses.length; indexHouse++) {//going through houses array
			total = 0;
			average = 0;
			for(int indexPeople=0;indexPeople < this.houses[indexHouse].people.length; indexPeople++) { //going into the people array at that specific house and getting info
				total = total + this.houses[indexHouse].people[indexPeople].age;  // at a house and need to get age of people in this house
			}
			average = total / this.houses[indexHouse].people.length;
			if(this.houses[indexHouse].people.length != 0) {
				JOptionPane.showMessageDialog(null, "House number: "+ this.houses[indexHouse].houseNumber + "\nThe average age is "+ average );
		}else {
			JOptionPane.showMessageDialog(null, "House number: "+ this.houses[indexHouse].houseNumber + "\nThis house is vacant. ");}
		}
	}

	public House[] getHouses() {
		return houses;
	}

	public void setHouses(House[] houses) {
		this.houses = houses;
	}

	public static int getTotalNumberOfHouses() {
		return totalNumberOfHouses;
	}

	public static void setTotalNumberOfHouses(int totalNumberOfHouses) {
		Street.totalNumberOfHouses = totalNumberOfHouses;
	}
	
}

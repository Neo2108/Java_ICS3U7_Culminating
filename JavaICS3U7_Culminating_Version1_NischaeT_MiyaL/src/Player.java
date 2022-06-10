
// Player class is to come up with initializations of what makes up a player, and this class is used mainly for the 'Multiplayer game mode'
public class Player {

	public String name;
	public int age;
	public String occupation;
	public String nationality;
	
	// Constructor
	public Player (String name, int age, String occupation, String nationality) {
		
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.nationality = nationality;
	}
	// Getter method for name
	public String getName() {
		return name;
	}
	
	// Getter method for age
	public int getAge() {
		return age;
	}
	
	// Getter method for occupation
	public String getJob() {
		return occupation;
	}
	
	// Getter method for nationality
	public String getNationality() {
		return nationality;
	}
	
	// toString method for returning string
	public String toString() {
		return "Name: " + name + "\nAge: " + age + "\nJob: " + occupation + "\nNationality: " + nationality;
	}
	
	

}


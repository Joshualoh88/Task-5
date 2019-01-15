package task4;


/**
 * This class represents the ImagingService
 *  
 * @author 
 */
public class ImagingService {
	
	/**
	 * Fields
	 */
	private String name;
	private String phoneNumber;
	private ImagingServiceSpecialty specialty;
	
	/**
	 * Creating Crew object
	 */ 
	Crew staffMembers = new Crew(); 
	
	/**
	 * Constructor with three parameters for initializing the fields of the ImagingService
	 * 
	 * @param specialty
	 * @param name
	 * @param phoneNumber
	 */
	public ImagingService(ImagingServiceSpecialty specialty,String name,String phoneNumber) {
		this.specialty = specialty;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * This method returns the specialty of ImagingService object
	 * 
	 * @return ImagingServiceSpecialty
	 */
	public ImagingServiceSpecialty getSpecialty() {
		return specialty;
	}
	/**
	 * This method assigns the given crew to the current service object
	 * 
	 * @param crew
	 */
	public void assignCrew(Crew crew) {
		this.staffMembers = crew;
	}
	
	/**
	 * This method checks whether the given crew meets the 3 rules or not:
	 * 1. Crew contains at most 4 members
	 * 2. Crew must contains at least one physician staff
	 * 3. Total skills of the members of the crew must not be less than 120
	 * 
	 * @param crew
	 * @param specialty
	 * @return true if no rule is violated, false otherwise 
	 */
	public boolean isValidCrew(Crew crew, ImagingServiceSpecialty specialty) {
		//check if members are more than 4
		if(crew.members.size()>4)
			return false;
		
		//checks if crew has at least one physician staff or not
		boolean containsPhyician = false;
		for(StaffMember member: crew.members) 
			if(member instanceof PhysicianStaff)
				containsPhyician = true;
		
		if(!containsPhyician)
			return false;
		else if(crew.getSkillsSum(specialty)<120)//checks if total skills of the crew are less than 120
			return false;

		return true;//returns true if no rule is voilated
	}
	
	/**
	 * This method returns the ImagingService object as string
	 * 
	 * @return String
	 */
	public String description(){
			return name +" , "+ phoneNumber;
	}
	
	/**
	 * This methods gets the total skills of the crew and returns the total as int number
	 * 
	 * @return int
	 */
	public int totalOfSkills() {
		
		return staffMembers.getSkillsSum(specialty);
	}
}

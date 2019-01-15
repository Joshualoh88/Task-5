package task4;


import java.util.HashMap; //importing HashMap
import java.util.Map;//importing Map

/**
 * This class extends the StaffMember for Physician staff and also contains its own method addSkill
 * 
 * @author 
 *
 */
public class PhysicianStaff extends StaffMember {
	//Collection of service specialty and skills in that specialty. 
	private Map<ImagingServiceSpecialty,Integer> skillsSet = new HashMap<ImagingServiceSpecialty,Integer>();

	/**
	 * Constructor which takes an string argument and initializes the staffMemberId
	 * with the given string
	 * 
	 * @param staffMemberId
	 */
	public PhysicianStaff(String staffMemberId) {
		super(staffMemberId);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for initializing all fields of the physician staff member
	 * 
	 * @param staffMemberId
	 * @param givenName
	 * @param familyName
	 */
	public PhysicianStaff(String staffMemberId, String givenName, String familyName) {
		super(staffMemberId, givenName, familyName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overriding the getSkill method of super class i.e StaffMember
	 */
	@Override
	public int getSkill(ImagingServiceSpecialty specialty) {
		//check and return the skills in given specialty
		if(skillsSet.get(specialty)!=null) {
			return skillsSet.get(specialty);
		}
		
		return 0;//returns 0 if physician dont have the skills of given specialty
	}
	
	/**
	 * This method takes two arguments, service specialty and skills in that specialty
	 * physician and adds them to the collection 
	 * 
	 * @param specialty
	 * @param skill
	 */
	public void addSkill(ImagingServiceSpecialty specialty, Integer skill) {
		skillsSet.put(specialty, skill);
	}

}

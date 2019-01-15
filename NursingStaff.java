package task4;


/**
 * This class extends the StaffMember for Nursing staff
 * 
 * @author 
 *
 */
public class NursingStaff extends StaffMember {

	/**
	 * Constructor for initializing all fields of the physician staff member
	 * 
	 * @param staffMemberId
	 * @param givenName
	 * @param familyName
	 */
	public NursingStaff(String staffMemberId, String givenName, String familyName) {
		super(staffMemberId, givenName, familyName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor which takes an string argument and initializes the staffMemberId
	 * with the given string
	 * 
	 * @param staffMemberId
	 */
	public NursingStaff(String staffMemberId) {
		super(staffMemberId);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overriding the getSkill method of super class i.e StaffMember
	 */
	@Override
	public int getSkill(ImagingServiceSpecialty specialty) {
		// TODO Auto-generated method stub
		return 20; // return 20 for all nursing staff
	}

}

package task4;


import java.util.regex.Matcher; //importing Matcher class for the pattern matching
import java.util.regex.Pattern; //importing Pattern class for the pattern matching

/**
 * This is an abstract class for the staff members
 *  
 * @author 
 * 
 */
public abstract class StaffMember {
	
	/**
	 * Fields
	 */
	private String staffMemberId;
	private String givenName;
	private String familyName;

	/**
	 * pattern(regular expression) for checking the staff member ID
	 */
	private static final String VALID_ID_PATTERN = "[A-Z]\\d{7}";

	/**
	 * Constructor with String parameter initializes the ID of the staff member
	 * 
	 * @param staffMemberID
	 */
	public StaffMember(String staffMemberId) {
		this.staffMemberId = staffMemberId;
	}
	
	/**
	 * Constructor which takes three string arguments and initializes the fields
	 * of the staff member(i.e ID, Name, Family Name)
	 * 
	 * @param staffMemberId
	 * @param givenName
	 * @param familyName
	 * 
	 */
	public StaffMember(String staffMemberId, String givenName, String familyName) {
		Pattern p = Pattern.compile(VALID_ID_PATTERN);
		Matcher m = p.matcher(staffMemberId);

		if (m.find()) {			
			this.staffMemberId = staffMemberId;
			this.givenName = givenName;
			this.familyName = familyName;
		} else {
			System.out.println(new AssertionError("Incorrect input found for Staff ID!"));
		}


	}


	/**
	 * Abstract method which takes ImagingServiceSpecialty as argument and returns the skill 
	 * of the staff member for the specialty
	 * 
	 * @param specialty
	 * @return int
	 */
	public abstract int getSkill(ImagingServiceSpecialty specialty);

	/**
	 * Method which takes String argument and sets the given string to givenName
	 * field of the staff member for the specialty
	 * 
	 * @param givenName
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	/**
	 * Method which takes String argument and sets the given string to familyName
	 * field of the staff member for the specialty
	 * 
	 * @param familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**
	 * Method which returns the staff member object as string
	 * 
	 * @return String
	 */
	public String description() {
		return staffMemberId + " " + givenName + " " + familyName;
	}
}

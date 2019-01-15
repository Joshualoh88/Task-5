package task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StaffMember {
	private String staffMemberId;
	private String givenName;
	private String familyName;

	private static final String VALID_ID_PATTERN = "[A-Z]\\d{7}";

	public StaffMember(String staffMemberId) {
		this.staffMemberId = staffMemberId;
	}

	public abstract int getSkill(ImagingServiceSpecialty specialty);

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

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String description() {
		return staffMemberId + " " + givenName + " " + familyName;
	}
}

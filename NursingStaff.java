package task3;

public class NursingStaff extends StaffMember {

	public NursingStaff(String staffMemberId, String givenName, String familyName) {
		super(staffMemberId, givenName, familyName);
		// TODO Auto-generated constructor stub
	}

	public NursingStaff(String staffMemberId) {
		super(staffMemberId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkill(ImagingServiceSpecialty specialty) {
		// TODO Auto-generated method stub
		return 20;
	}

}

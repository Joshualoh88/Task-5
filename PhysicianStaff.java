package task3;

import java.util.HashMap;
import java.util.Map;

public class PhysicianStaff extends StaffMember {
	private Map<ImagingServiceSpecialty,Integer> skillsSet = new HashMap<ImagingServiceSpecialty,Integer>();

	public PhysicianStaff(String staffMemberId) {
		super(staffMemberId);
		// TODO Auto-generated constructor stub
	}

	public PhysicianStaff(String staffMemberId, String givenName, String familyName) {
		super(staffMemberId, givenName, familyName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkill(ImagingServiceSpecialty specialty) {
		if(skillsSet.get(specialty)!=null) {
			return skillsSet.get(specialty);
		}
		return 0;
	}
	
	public void addSkill(ImagingServiceSpecialty specialty, Integer skill) {
		skillsSet.put(specialty, skill);
	}

}

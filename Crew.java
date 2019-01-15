package task3;

import java.util.ArrayList;

public class Crew {
	ArrayList<StaffMember> members = new ArrayList<StaffMember>();
	
	public void addStaffMember(StaffMember staff){
		members.add(staff);
	}
	
	public void removeStaffMember(int index) {
		members.remove(index);
	}
	
	public ArrayList<StaffMember> getAllStaff(){
		return members;
	}
	
	public int getSkillsSum(ImagingServiceSpecialty specialty) {
		int total=0;
		for(StaffMember staff: members) {
			total += staff.getSkill(specialty);
		}
		return total;
	}
}

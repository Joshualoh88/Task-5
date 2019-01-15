package task4;


import java.util.ArrayList; //importing ArrayList collection

/**
 * This class represents the Crew
 * 
 * @author 
 *
 */
public class Crew {
	//creating a list of staff members
	ArrayList<StaffMember> members = new ArrayList<StaffMember>();
	
	/**
	 * This methods takes a StaffMember and adds him in the members list
	 * 
	 * @param staff
	 */
	public void addStaffMember(StaffMember staff){
		members.add(staff);
	}
	
	/**
	 * This method takes and index number as argument and deletes the staff
	 * at that index
	 * 
	 * @param index
	 */
	public void removeStaffMember(int index) {
		members.remove(index);
	}
	
	/**
	 * This method returns the complete list of members
	 * 
	 * @return ArrayList<StaffMember>
	 */
	public ArrayList<StaffMember> getAllStaff(){
		return members;
	}
	
	/**
	 * This method takes service specialty as argument, calculates and returns the
	 * total of skills crew have in the service.
	 * 
	 * @param specialty
	 * @return int
	 */
	public int getSkillsSum(ImagingServiceSpecialty specialty) {
		int total=0;
		for(StaffMember staff: members) {
			total += staff.getSkill(specialty);
		}
		return total;
	}
}

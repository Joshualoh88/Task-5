package task3;

public class ImagingService {
	private String name;
	private String phoneNumber;
	private int total=0;
	private ImagingServiceSpecialty specialty;
	
	Crew staffMembers = new Crew(); 
	
	public ImagingService(ImagingServiceSpecialty specialty,String name,String phoneNumber) {
		this.specialty = specialty;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public ImagingServiceSpecialty getSpecialty() {
		return specialty;
	}
	
	public void assignCrew(Crew crew) {
		this.staffMembers = crew;
	}
	
	public boolean isValidCrew(Crew crew, ImagingServiceSpecialty specialty) {
		
		if(crew.members.size()>4)
			return false;
		
		boolean containsPhyician = false;
		for(StaffMember member: crew.members) 
			if(member instanceof PhysicianStaff)
				containsPhyician = true;
		
		if(!containsPhyician)
			return false;
		else if(crew.getSkillsSum(specialty)<120)
			return false;

		return true;
	}
	
	public String description(){
			return name +" , "+ phoneNumber;
	}
	
	public int totalOfSkills() {
		
		return staffMembers.getSkillsSum(specialty);
	}
}

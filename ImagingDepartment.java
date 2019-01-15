package task3;

import java.util.Random;
import java.util.Scanner;

public class ImagingDepartment {
	ImagingService[] servicesArray = new ImagingService[4];
	Crew staff = new Crew();
	Scanner sc=new Scanner(System.in);
	
	public ImagingDepartment() {

	}

	public void createImagingService() {
		servicesArray[0] = new ImagingService(ImagingServiceSpecialty.MRI,"MRI", "1234567");
		servicesArray[1] = new ImagingService(ImagingServiceSpecialty.ULTRASOUND,"Ultrasound", "7654321");
		servicesArray[2] = new ImagingService(ImagingServiceSpecialty.ANGIOGRAPHY,"Angiography", "02468");
		servicesArray[3] = new ImagingService(ImagingServiceSpecialty.XRAY,"XRAY", "13579");
	}
	
	public void assignCrew() {
		
		String id,fname,lname,staffType="",input="1";
		
		do {
		System.out.println("Choose a type of staff:");
		System.out.println("1. Nurse");
		System.out.println("2. Physician");
		if(sc.hasNextInt()) {
			staffType = sc.next();
		}
		
		System.out.println("Enter first name of staff:");
		fname = sc.next();
		
		System.out.println("Enter last name of staff:");
		lname = sc.next();
		
		System.out.println("Enter id of staff:");
		id = sc.next();
		
		if(Integer.parseInt(staffType)==1) {
			staff.addStaffMember(new NursingStaff(id, fname, lname));
		}else if(Integer.parseInt(staffType)==2) {
			PhysicianStaff pStaff = new PhysicianStaff(id, fname, lname);
			
			for(ImagingServiceSpecialty specialty:ImagingServiceSpecialty.values())
				pStaff.addSkill(specialty, new Random().nextInt(100));
			
			staff.addStaffMember(pStaff);
		}else {
			
		}
		
		System.out.println("Do you want to register another staff?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		if(sc.hasNextInt()) {
			input = sc.next();
		}
		}while(Integer.parseInt(input)==1);
		
		for(ImagingService service:servicesArray) {	
			if(service.isValidCrew(staff, service.getSpecialty()))
				service.assignCrew(staff);
			else
				System.out.println(new AssertionError("Crew doesn't meet the rules!"));
		}
	}
	
	public ImagingServiceSpecialty randomSpecialty() {
		Random r = new Random();
		return ImagingServiceSpecialty.values()[r.nextInt(ImagingServiceSpecialty.values().length-1)];
		
	}

	public void displayImagingServices() {
		for(ImagingService service: servicesArray) {
			System.out.println(service.description());
			
			for(StaffMember staffMember: service.staffMembers.members) 
				System.out.println(" "+staffMember.description());
			
			System.out.println("Total Skills Assigned: "+service.totalOfSkills());
			System.out.println("");
		}
	}

	public void printStatus() {
		System.out.println("Welcome to Java Imaging Department");
		System.out.println();
		createImagingService();
		assignCrew();
		displayImagingServices();
		System.out.println();
		System.out.println("Good-bye. Thank you for using Java Imaging Department");
	}
}

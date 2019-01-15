package task4;


import java.util.Random;
import java.util.Scanner;

/**
 * This class is responsible for the interaction between all other entities
 * 
 * @author 
 */
public class ImagingDepartment {
	//Fields
	int noOfServices = ImagingServiceSpecialty.values().length; // no of available services
	ImagingService[] servicesArray = new ImagingService[noOfServices];// list of services
	Crew[] staff = new Crew[noOfServices];//creating list of crew for each service
	Scanner sc = new Scanner(System.in);

	/**
	 * This method initializes the servicesArray by adding all services available 
	 */
	public void createImagingService() {
		servicesArray[0] = new ImagingService(ImagingServiceSpecialty.MRI, "MRI", "1234567");
		servicesArray[1] = new ImagingService(ImagingServiceSpecialty.ULTRASOUND, "Ultrasound", "7654321");
		servicesArray[2] = new ImagingService(ImagingServiceSpecialty.ANGIOGRAPHY, "Angiography", "02468");
		servicesArray[3] = new ImagingService(ImagingServiceSpecialty.XRAY, "XRAY", "13579");
	}

	/**
	 * This method creates and assigns crew to the service by asking details from the user
	 */
	public void assignCrew() {

		String id, fname, lname, staffType = "", input = "1";
		System.out.println("We provide " + noOfServices + " types of Imaging services.");

		int counter = 0;
		
		//loop for all services available
		for (ImagingService service : servicesArray) {

			staff[counter] = new Crew();

			System.out.println("\nLets add staff for " + service.getSpecialty().toString() + " service.");

			//loop for getting details and creating crew for the service
			do {
				System.out.println("Choose an option to proceed:");
				System.out.println("1. Add Nurse");
				System.out.println("2. Add Physician");
				System.out.println("3. Skip");
				if (sc.hasNextInt()) {
					staffType = sc.next();
				}

				if (Integer.parseInt(staffType) == 3)
					break;

				System.out.println("Enter first name of staff:");
				fname = sc.next();

				System.out.println("Enter last name of staff:");
				lname = sc.next();

				System.out.println("Enter id of staff:");
				id = sc.next();

				if (Integer.parseInt(staffType) == 1) {
					staff[counter].addStaffMember(new NursingStaff(id, fname, lname));
				} else{
					PhysicianStaff pStaff = new PhysicianStaff(id, fname, lname);

					for (ImagingServiceSpecialty s : ImagingServiceSpecialty.values())
						pStaff.addSkill(s, new Random().nextInt(100));

					staff[counter].addStaffMember(pStaff);
				}

				System.out.println("Do you want to register another staff?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				if (sc.hasNextInt()) {
					input = sc.next();
				}
			} while (Integer.parseInt(input) == 1);

			
			//Verify the crew and assign it to service if crew meets all rules
			if (service.isValidCrew(staff[counter], service.getSpecialty()))
				service.assignCrew(staff[counter]);
			else
				System.out.println(new AssertionError("Crew doesn't meet the rules!"));

			counter++;
		}
	}

	/**
	 * This method displays the details of all services
	 */
	public void displayImagingServices() {
		for (ImagingService service : servicesArray) {
			System.out.println(service.description());//prints description of the service

			for (StaffMember staffMember : service.staffMembers.members)
				System.out.println(" " + staffMember.description());//prints all staff members of the service

			System.out.println("Total Skills Assigned: " + service.totalOfSkills());// prints total skills of the staff members for the service
			System.out.println("");
		}
	}
	
	/**
	 * This method prints the complete status of all services
	 */
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

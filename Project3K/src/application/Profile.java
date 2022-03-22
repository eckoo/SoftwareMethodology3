package application;

/**
 * This is the Profile class represents a profile.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Profile {

	/**
	 * Creates a string of the first name.
	 */
	private String fname;
	
	/**
	 * Creates a string of the last name.
	 */
	private String lname;
	
	/**
	 * Creates a Date of the date of birth.
	 */
	private Date dob;

	/**
	 * This is the Profile constructor method.
	 * 
	 * @param fname Object of type String.
	 * @param lname Object of type String.
	 * @param dob Object of type Date.
	 */
	public Profile(String fname, String lname, Date dob) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}

	/**
	 * This is the toString method.
	 * @return the string representation of the profile.
	 */
	@Override
	public String toString() {
		return this.fname + " " + this.lname + " " + this.dob.toString();
	}

	/**
	 * The equals method determines if the profile inputted equals the profile in the system.
	 *
	 * @param obj Object of type Object.
	 * @return true if patient's equal, false if not.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Profile)) {
			return false;
		}
		Profile profile = (Profile) obj;
		if (!this.fname.toLowerCase().equals(profile.fname.toLowerCase())) {
			return false;
		}
		if (!this.lname.toLowerCase().equals(profile.lname.toLowerCase())) {
			return false;
		}
		if (!this.dob.equals(profile.dob)) {
			return false;
		}
		return true;
	}
}

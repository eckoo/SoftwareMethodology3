package application;

/**
 * This is the Profile class represents a profile.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Profile {

	/**
	 * This is fname
	 */
	private String fname;

	/**
	 * This is lname
	 */
	private String lname;

	/**
	 * This is dob
	 */
	private Date dob;

	/**
	 * This is the Profile constructor.
	 *
	 * @param fname the fname
	 * @param lname the lname
	 * @param dob   the dob
	 */
	public Profile(String fname, String lname, Date dob) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}

	/**
	 * This is the toString method.
	 *
	 * @return the string.
	 */
	@Override
	public String toString() {
		return this.fname + " " + this.lname + " " + this.dob.toString();
	}

	/**
	 * This is the equals method.
	 *
	 * @param obj the obj
	 * @return true if equals
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

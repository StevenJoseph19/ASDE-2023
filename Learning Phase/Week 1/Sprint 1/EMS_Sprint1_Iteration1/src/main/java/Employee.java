import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {

	int empID;
	String empName;
	long empContact;
	String empDepartment;
	String empEmail;
	String empAddress;

	public Employee() {

	}

	public Employee(int empID, String empName, long empContact, String empDepartment, String empEmail,
			String empAddress) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empContact = empContact;
		this.empDepartment = empDepartment;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpContact() {
		return empContact;
	}

	public void setEmpContact(long empContact) {
		this.empContact = empContact;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empContact=" + empContact + ", empDepartment="
				+ empDepartment + ", empEmail=" + empEmail + ", empAddress=" + empAddress + "]";
	}

}
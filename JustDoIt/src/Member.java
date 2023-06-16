import java.io.IOException;
import java.util.Scanner;

public class Member {
	String Name;
	String ID;
	String Password;
	String Department;
	boolean is_manager = false;
	MemberDB DB;
	Member(String Name, String ID, String Password, String Department, Scanner sc) {
		this.Name = Name;
		this.ID = ID;
		this.Password = Password;
		this.Department = Department;

		if (ID == "21912042") {
			is_manager = true;
		}
	}

	void showinfo() {
		System.out.println("Name:" + this.Name);
		System.out.println("ID:" + this.ID);
		System.out.println("Department:" + this.Department);
	}
	
	void PWchange() throws IOException {
		DB.ModifyPassword(this);
	}
}
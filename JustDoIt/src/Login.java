import java.util.Scanner;

public class Login {
	String ID;
	String PW;
	MemberDB DB;
	Scanner sc;

	public Login(Scanner sc) {
		this.sc = sc;
		DB = new MemberDB(sc);
	}

	Member InputData() {
		System.out.print("Enter the ID: ");
		ID = sc.nextLine();
		System.out.print("Enter the PW: ");
		PW = sc.nextLine();
		if (DB.CheckPassword(ID, PW)) {
			Member my = DB.MemberLoad(ID);
			return my;
		} else {
			System.out.println("ID or Password is wrong");
			return null;
		}
	}
}

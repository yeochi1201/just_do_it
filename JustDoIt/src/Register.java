import java.util.Scanner;

public class Register {
	String Name;
	String ID;
	String Password;
	String Department;
	MemberDB DB;
	Scanner sc;

	Register(Scanner sc) {
		this.sc = sc;
		DB = new MemberDB(sc);
	}

	void regist() {

		System.out.print("Enter the Name: ");
		Name = sc.nextLine();
		while (true) {
			System.out.print("Enter the ID: ");
			ID = sc.nextLine();
			if (DB.IDExist(ID))
				break;
			else
				System.out.println("exist ID");
		}
		System.out.print("Enter the PW: ");
		Name = sc.nextLine();
		System.out.print("Enter the Deparment: ");
		Name = sc.nextLine();

		Member member = new Member(Name, ID, Password, Department,sc);
		DB.MakeMember(member);

		return;
	}
}

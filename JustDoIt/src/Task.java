import java.util.Scanner;

public class Task {
	String Todo;
	String Date;
	int is_complete = 0;
	Scanner sc;
	Member member;
	public Task(Member member, Scanner sc) {
		this.member = member;
		this.sc = sc;
	}
	
	void makeTask() {
		System.out.println("Enter the Limit Date(YYYY-MM-DD)");
		Date = sc.nextLine();
		
		System.out.println("What to do?");
		Todo = sc.nextLine();
	}
}

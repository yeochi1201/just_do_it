import java.util.Scanner;

public class Plan {
	Scanner sc;
	Member member;
	PlanDB DB;
	public Plan(Member member, Scanner sc) {
		this.member = member;
		this.sc = sc;
	}
	
	void makeTask() {
		Task temp = new Task(member, sc);
		temp.makeTask();
		DB.TaskMake(temp);
	}
	
	void showTask() {
		System.out.println("Enter the Date(YYYY-MM-DD)");
		String Date = sc.nextLine();
		String[] list = DB.GetList(Date);
		
		for(String todo : list) {
			System.out.println(todo);
		}
	}
	
	void completeTask() {
		showTask();
		System.out.println("Enter the complete task");
		sc.nextLine();
	}
}

import java.time.LocalDate;
import java.util.Scanner;

public class Page {
	String Date;
	String Title;
	String Article = "";
	Scanner sc;

	Page(Scanner sc) {
		this.sc = sc;
	}

	void write() {
		System.out.println("Enter the Article (quit : BrEaK)");
		String Temp;
		while (true) {
			Temp = sc.nextLine();
			if (Temp == "BrEaK")
				break;
			else
				Article += Temp;
		}
		this.Date = LocalDate.now().toString();
	}

}

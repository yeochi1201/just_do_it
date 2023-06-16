import java.io.IOException;
import java.util.Scanner;

public class Board {
	BoardDB DB;
	String Department;
	Scanner sc;

	public Board(Scanner sc, String Department) {
		this.Department = Department;
		this.sc = sc;
		DB = new BoardDB(sc);
		DB.MakeBoard(Department);
	}

	void Writepage(Member writer) {
		int ret;
		Page pg = new Page(sc);
		pg.write();
		ret = DB.PageMake(pg);
		if (ret == 0)
			System.out.println("Success");
		else
			System.out.println("Failed to make Page");
	}
	
	void DeletePage() {
		showBoard();
		System.out.println("Enter the name of Page");
		DB.PageDel(sc.nextLine());
	}
	
	void showBoard() {
		String[] list = DB.getlist();
		for(String filename : list) {
			System.out.println(filename);
		}
	}
	
	void showPage() throws IOException {
		System.out.println("Enter the name of Page");
		Page temp = DB.LoadPage(sc.nextLine());
		
		System.out.println(temp.Title);
		System.out.println(temp.Article);
		
	}
}

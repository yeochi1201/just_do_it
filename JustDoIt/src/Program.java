import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		DataBase DB = new DataBase();
		DB.MakeDB();
		int select;
		Scanner sc = new Scanner(System.in);
		Login login = new Login(sc);
		Register register = new Register(sc);
		Member my = null;
		Board board;
		Plan plan;
		// login and regist
		while (true) {
			System.out.println("1. login 2. regist 3. exit");
			select = sc.nextInt();
			sc.nextLine();
			switch (select) {
			case 1:
				my = login.InputData();
				if (my == null)
					System.out.println("Cannot Login");
				break;
			case 2:
				register.regist();
				break;
			case 3:
				return;
			}
			if (my != null)
				break;
		}
		// menu and function
		board = new Board(sc, my.Department);
		plan = new Plan(my, sc);
		if (my.is_manager == true) {
			while (true) {
				System.out.println("1. Show board 2. Del Page 3. Write Page");
				select = sc.nextInt();
				sc.nextLine();
				switch (select) {
				case 1:
					board.showBoard();
					break;
				case 2:
					board.DeletePage();
					break;
				case 3:
					board.Writepage(my);
					break;
				}
			}
		}
		else {
			while(true) {
				int select2 = 0;
				System.out.println("1. My Page 2. Plan 3. Board");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
				case 1:
					my.showinfo();
					System.out.println("1. modify password 2. exit");
					select2 = sc.nextInt();
					sc.nextLine();
					if(select2==1)my.PWchange();
					break;
				case 2:
					while(true) {
						System.out.println("1. show task 2. write task 3. complete task 4.exit");
						select2 = sc.nextInt();
						sc.nextLine();
						switch(select2) {
						case 1:
							plan.showTask();
							break;
						case 2:
							plan.makeTask();
							break;
						case 3:
							plan.completeTask();
							break;
						}
						if(select2==4)break;
					}
				case 3:
					while(true) {
						System.out.println("1. Show Board 2. Show Page 3. exit");
						select2 = sc.nextInt();
						switch(select2) {
						case 1:
							board.showBoard();
							break;
						case 2:
							board.showPage();
							break;
						}
						if(select2 == 3)break;
					}
				}
			}
		}
	}
}

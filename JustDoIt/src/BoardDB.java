import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BoardDB {
	Scanner sc;
	String Department;

	public BoardDB(Scanner sc) {
		this.sc = sc;
		final String Path = "C:\\JustDoIt\\Board";
		File folder = new File(Path);
		if (!folder.exists()) {
			try {
				folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

	int MakeBoard(String Department) {
		this.Department = Department;
		String Path = "C:\\JustDoIt\\Board\\" + Department;
		File folder = new File(Path);
		if (!folder.exists()) {
			try {
				folder.mkdir();
				return 0;
			} catch (Exception e) {
				e.getStackTrace();
				return -1;
			}
		}
		return 0;
	}

	int PageMake(Page page) {
		File file = new File("C:\\JustDoIt\\Board\\" + Department + "\\" + page.Title + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(page.Date + "\r\n");
				bw.write(page.Article + "\r\n");

				return 0;
			} catch (Exception e) {
				e.getStackTrace();
				return -1;
			}
		}
		return -2;
	}
	
	void PageDel(String page) {
		File file = new File("C:\\JustDoIt\\Board\\"+Department+"\\"+page+".txt");
		if(file.exists()) {
			if(file.delete())System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	String[] getlist() {
		File file = new File("C:\\JustDoIt\\Board\\"+Department);
		String[] list = file.list();
		return list;
	}
	
	Page LoadPage(String title) throws IOException {
		File file = new File("C:\\JustDoIt\\Board\\"+Department+"\\"+title+".txt");
		if(file.exists()) {
			Page temp = new Page(sc);
			temp.Title = title;
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			temp.Article = br.readLine();
			return temp;
		}
		return null;
	}
}
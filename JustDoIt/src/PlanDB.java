import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PlanDB {
	Scanner sc;
	Member member;
	String Path = "C:\\JustDoIt\\Plan";
	public PlanDB(Scanner sc, Member member) {
		this.sc = sc;
		this.member = member;
		File folder = new File(Path);
		if (!folder.exists()) {
			try {
				folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		Path += member.ID;
		folder = new File(Path);
		if (!folder.exists()) {
			try {
				folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	void TaskMake(Task task) {
		File folder = new File(Path+"\\"+task.Date);
		if (!folder.exists()) {
			try {
				folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		folder = new File(Path+"\\"+task.Date+"\\"+task.Todo+".txt");
		if (!folder.exists()) {
			try {
				folder.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(folder));
				bw.write(task.is_complete);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	void TaskComplete(Task task) throws IOException {
		File file = new File(Path+"\\"+task.Date+"\\"+task.Todo+".txt");
		if (file.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(task.is_complete);
		}
	}
	
	String[] GetList(String Date) {
		File file = new File(Path+"\\"+Date);
		String[] list = file.list();
		return list;
	}
}

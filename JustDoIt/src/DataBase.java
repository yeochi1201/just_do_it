import java.io.File;

public class DataBase {
	void MakeDB() {
		final String Path = "C:\\JustDoIt";
		File folder = new File(Path);
		if (!folder.exists()) {
			try {
				folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}

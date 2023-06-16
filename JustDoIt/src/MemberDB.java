import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemberDB {
	Scanner sc;

	public MemberDB(Scanner sc) {
		this.sc = sc;
		final String Path = "C:\\JustDoIt\\Member";
		File folder = new File(Path);
		if (!folder.exists()) {
			try {
				folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

	int MakeMember(Member member) {
		File file = new File("C:\\JustDoIt\\Member\\" + member.ID + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(member.Name + "\r\n");
				bw.write(member.ID + "\r\n");
				bw.write(member.Password + "\r\n");
				bw.write(member.Department + "\r\n");

				return 0; // 생성 완료
			} catch (IOException e) {
				e.printStackTrace();
				return -1; // 생성 실패
			}
		} else {
			return -2; // 이미 존재하는 회원
		}
	}

	int ModifyPassword(Member member) throws IOException {
		File file = new File("C:\\JustDoIt\\Member\\" + member.ID + ".txt");
		if (!file.exists()) {
			return -1; // 회원 정보 조회 실패
		} else {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			System.out.print("New Password :");
			String password = sc.nextLine();
			String[] temp = new String[4];
			temp[0] = br.readLine();
			temp[1] = br.readLine();
			br.readLine();
			temp[2] = password;
			temp[3] = br.readLine();
			for (int i = 0; i < 4; i++) {
				bw.write(temp[i] + "\r\n");
			}
			return 0;
		}
	}

	Member MemberLoad(String ID) {
		File file = new File("C:\\JustDoIt\\Member\\" + ID + ".txt");
		Member member = null;
		String Name, m_ID, PW, Department;
		if (!file.exists()) {
			return member;// Member 존재 X
		} else {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				Name = br.readLine();
				m_ID = br.readLine();
				PW = br.readLine();
				Department = br.readLine();
				member = new Member(Name, m_ID, PW, Department,sc);
				return member;
			} catch (IOException e) {
				e.printStackTrace(); // 오류 발생
				return member;
			}
		}
	}

	Boolean CheckPassword(String ID, String PW) {
		Member member = MemberLoad(ID);
		if (member.equals(null))
			return false; // 오류 발생
		else {
			if (member.Password == PW)
				return true;
			else
				return false;
		}
	}

	Boolean IDExist(String ID) {
		File file = new File("C:\\JustDoIt\\Member\\" + ID + ".txt");
		if (!file.exists()) {
			return true;// Member 존재 X
		} else
			return false;
	}
}

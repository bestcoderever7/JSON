import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	public static void main(String[] args) {
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader("src/input_test.txt");
			br = new BufferedReader(fr);
			String line = "";
			String firstName = "";
			String lastName = "";
			String locationId = "";
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length() - 12; i++) {
					if (line.substring(i, i + 10).equalsIgnoreCase("first_name")) {
						i += 13;
						if (line.substring(i, i + 3).equals("TA-")) {
							i += 3;
						}
						boolean completed = false;
						while (!completed) {
							String character = line.substring(i, i + 1);
							if (character.equals("\""))
								completed = true;
							else
								firstName += character;
							i++;
						}
						// System.out.println(firstName);
					}
					if (line.substring(i, i + 9).equalsIgnoreCase("last_name")) {
						i += 12;
						boolean completed = false;
						while (!completed) {
							String character = line.substring(i, i + 1);
							if (character.equals("\""))
								completed = true;
							else
								lastName += character;
							i++;
						}
						// System.out.println(lastName);
					}
					if (line.substring(i, i + 11).equalsIgnoreCase("location_id")) {
						i += 13;
						boolean completed = false;
						while (!completed) {
							String character = line.substring(i, i + 1);
							if (character.equals(","))
								completed = true;
							else
								locationId += character;
							i++;
						}
						// System.out.println(locationId);
					}
					if (!(firstName.equals("")) && !(lastName.equals("")) && !(locationId.equals(""))) {
						// Student s = new Student(firstName, lastName, Integer.parseInt(locationId));
						System.out.println(firstName + " " + lastName + " " + locationId);
						firstName = "";
						lastName = "";
						locationId = "";
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

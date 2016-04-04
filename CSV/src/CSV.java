import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {

	public static void main(String[] args) {

		String csvFile = "C:\\2.csv";
		BufferedReader br = null;
		BufferedWriter br2;
		String line = "";
		String cvsSplitBy = ";";

		try {
			List<Company> companies = new ArrayList<Company>();
			br = new BufferedReader(new FileReader(csvFile));
			br2 = new BufferedWriter(new FileWriter("C:\\java\\result.csv"));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] country = line.split(cvsSplitBy, -1);
				companies.add(new Company(country[0], Integer.parseInt(country[1]), Integer.parseInt(country[2])));
			}

			File[] fList;
			File F = new File("C:\\task");
			fList = F.listFiles();
			boolean flag = true;
			for (int i = 0; i < fList.length; i++) {
				br = null;
				br = new BufferedReader(new FileReader(fList[i]));
				br.readLine();
				while ((line = br.readLine()) != null) {
					String[] str = line.split(cvsSplitBy, -1);
					Company A = companies.stream().filter(e -> e.getNumber() == Integer.parseInt(str[1])).findFirst()
							.get();
					Company B = companies.stream().filter(e -> e.getNumber() == Integer.parseInt(str[3])).findFirst()
							.get();
					int sum = Integer.parseInt(str[4]);
					if (A.check(sum)) {
						A.subMoney(sum);
						B.addMoney(sum);
					} else {
						System.out.println("Error "+A.getTitle()+" to "+B.getTitle()+" "+sum);
					    
					}
					
				}
			}
			
			br2.append("Название компании;Лицевой счет;Первоначальный бюджет");
			br2.newLine();
			for (Company c : companies)
			{
				br2.append(c.getTitle()+";"+c.getNumber()+";"+c.getMoney());
				br2.newLine();
			}
			br2.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}

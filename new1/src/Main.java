/**
 * Created by vakssl on 19.01.2016.
 */
import java.util.Locale;
import java.util.Scanner;
import java.util.Calendar;
public class Main {
    public static void main(String[] args){
        getMonth();
    }

    private static void getYear() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter month:");
        int month = in.nextInt();
        if (month > 0 && month <= 12) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE, 13);
            calendar.set(Calendar.MONTH, month-1);
            for (int i = 1800; i < 2017; i++) {
                calendar.set(Calendar.YEAR, i);
                String s = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
                if (s.equals("Fri"))
                    System.out.println(i);
            }
        }
        else System.out.println("Incorrect input");
    }

    private static void getMonth() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter year:");
        int year = in.nextInt();

        if (year >= 1800 && year <= 2016) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        for(int i=0;i<12;i++){
        calendar.set(Calendar.MONTH, i);
            calendar.set(Calendar.DATE, 13);
        String s = calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.US);
            if (s == "Fri")
        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US));
    }
    }
    else System.out.println("Incorrect input");}
}

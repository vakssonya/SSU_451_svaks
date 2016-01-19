/**
 * Created by vakssl on 19.01.2016.
 */
import java.util.Locale;
import java.util.Scanner;
import java.util.Calendar;
public class Main {
    public static void main(String[] args){

        getYear();
    }

    private static void getYear() {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 13);
        calendar.set(Calendar.MONTH,month);
        for(int i=1800;i<2017;i++){
            calendar.set(Calendar.YEAR, i);
            String s = calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.US);
            if (s.equals("Fri"))
                System.out.println(i);
        }
    }

    private static void getMonth() {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        for(int i=0;i<12;i++){
        calendar.set(Calendar.MONTH, i);
            calendar.set(Calendar.DATE, 13);
        String s =calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.US);
            if (s == "Fri")
        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US));
    }
    }
}

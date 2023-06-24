import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int nDays = Integer.parseInt(str[0]);
        String weekday = str[1];
        System.out.println(getCalenderForMonth(nDays, weekday));
    }

    public static String getCalenderForMonth(int nDays, String weekday) {
        Map<String, Integer> weekDays = new HashMap<>();
        weekDays.put("Monday", 1);
        weekDays.put("Tuesday", 2);
        weekDays.put("Wednesday", 3);
        weekDays.put("Thursday", 4);
        weekDays.put("Friday", 5);
        weekDays.put("Saturday", 6);
        weekDays.put("Sunday", 7);

        int first = weekDays.get(weekday);
        int count = 1, curDay = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < first; i++) {
            sb.append("..");
            sb.append(" ");
            count++;
        }
        while (curDay <= nDays) {
            if (curDay < 10) {
                sb.append(".");
            }
            sb.append(curDay);
            sb.append(" ");
            if (count % 7 == 0) {
                sb.append("\n");
            }
            curDay++;
            count++;
        }

        return sb.toString();
    }
}
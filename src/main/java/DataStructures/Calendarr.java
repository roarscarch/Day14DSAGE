package DataStructures;

import java.util.GregorianCalendar;

public class Calendar {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Calendar <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]) - 1;
        int year = Integer.parseInt(args[1]);

        GregorianCalendar calendar = new GregorianCalendar(year, month, 1);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int[][] monthCalendar = new int[6][7];

        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int currentWeek = 0;

        for (int day = 1; day <= daysInMonth; day++) {
            monthCalendar[currentWeek][startDay] = day;
            startDay++;
            if (startDay > Calendar.SATURDAY) {
                startDay = Calendar.SUNDAY;
                currentWeek++;
            }
        }

        printCalendar(monthCalendar);
    }

    private static void printCalendar(int[][] monthCalendar) {
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        System.out.println("  " + String.join("  ", daysOfWeek));

        for (int[] week : monthCalendar) {
            for (int day : week) {
                if (day == 0) {
                    System.out.print("    ");
                } else {
                    System.out.printf("%2d  ", day);
                }
            }
            System.out.println();
        }
    }
}

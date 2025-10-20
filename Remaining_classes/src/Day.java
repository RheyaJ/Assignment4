public enum Day {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int dayNumber;

    Day(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public boolean isWeekend() {
        return false;
    }

    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Today is: MONDAY");
                break;
            case TUESDAY:
                System.out.println("Today is: TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("Today is: WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("Today is: THURSDAY");
                break;
            case FRIDAY:
                System.out.println("Today is: FRIDAY");
                break;
            case SATURDAY:
                System.out.println("Today is: SATURDAY");
                break;
            case SUNDAY:
                System.out.println("Today is: SUNDAY");
                break;
        }

        for (Day day : Day.values()) {
            System.out.println("Day: " + day + ", Number: " + day.getDayNumber());
        }
    }
}

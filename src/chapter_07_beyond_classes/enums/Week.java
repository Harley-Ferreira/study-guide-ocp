package chapter_07_beyond_classes.enums;

public enum Week {


    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final Integer dayOfTheWeek;

    // (private) is optional
    private Week(Integer dayOfTheWeek) {
        System.out.println("Initializing enum...");
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public static void main(String[] args) {
        // When you use an enum all the constructor will be call just one time for each element of de enum
        Week sunday = Week.SUNDAY;
        /*  Initializing enum...
            Initializing enum...
            Initializing enum...
            Initializing enum...
            Initializing enum...
            Initializing enum...
            Initializing enum...    */

    }
}

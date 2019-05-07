public class TimeConverter {
    /*
    Converts hh:mm:ss time format strings into seconds as int
     */

    //Return "hh:mm:ss" as int in seconds
    public static int convert(String time) {
        String[] s = time.split(":");
        return (3600 * Integer.parseInt(s[0]) + 60 * Integer.parseInt(s[1]) + Integer.parseInt(s[2]));
    }

    //Return int in seconds as "hh:mm:ss"
    public static String revert(int seconds) {
        if (seconds >= 3600)
            return seconds/3600 +"h "+ revert(seconds%3600);
        if (seconds >= 60)
            return seconds/60 + "m " + seconds%60 + "s";
        else
            return seconds + "s";
    }

    //Return the difference between two time data as int in seconds
    public static int subtract(String timeA, String timeB) {
        return convert(timeA) - convert(timeB);
    }
}

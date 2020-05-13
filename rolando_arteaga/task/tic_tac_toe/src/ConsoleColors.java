public class ConsoleColors {
    private static boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
    // Reset
    public static final String RESET = isWindows ? "" : "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = isWindows ? "" : "\033[0;30m";   // BLACK
    public static final String RED = isWindows ? "" : "\033[0;31m";     // RED
    public static final String GREEN = isWindows ? "" : "\033[0;32m";   // GREEN
    public static final String YELLOW = isWindows ? "" : "\033[0;33m";  // YELLOW
    public static final String BLUE = isWindows ? "" : "\033[0;34m";    // BLUE
    public static final String PURPLE = isWindows ? "" : "\033[0;35m";  // PURPLE
    public static final String CYAN = isWindows ? "" : "\033[0;36m";    // CYAN
    public static final String WHITE = isWindows ? "" : "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = isWindows ? "" : "\033[1;30m";  // BLACK
    public static final String RED_BOLD = isWindows ? "" : "\033[1;31m";    // RED
    public static final String GREEN_BOLD = isWindows ? "" : "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = isWindows ? "" : "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = isWindows ? "" : "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = isWindows ? "" : "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = isWindows ? "" : "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = isWindows ? "" : "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = isWindows ? "" : "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = isWindows ? "" : "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = isWindows ? "" : "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = isWindows ? "" : "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = isWindows ? "" : "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = isWindows ? "" : "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = isWindows ? "" : "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = isWindows ? "" : "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = isWindows ? "" : "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = isWindows ? "" : "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = isWindows ? "" : "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = isWindows ? "" : "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = isWindows ? "" : "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = isWindows ? "" : "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = isWindows ? "" : "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = isWindows ? "" : "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = isWindows ? "" : "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = isWindows ? "" : "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = isWindows ? "" : "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = isWindows ? "" : "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = isWindows ? "" : "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = isWindows ? "" : "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = isWindows ? "" : "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = isWindows ? "" : "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = isWindows ? "" : "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = isWindows ? "" : "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = isWindows ? "" : "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = isWindows ? "" : "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = isWindows ? "" : "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = isWindows ? "" : "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = isWindows ? "" : "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = isWindows ? "" : "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = isWindows ? "" : "\033[0;107m";   // WHITE
}

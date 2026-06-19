package archivedCode;

import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;

import java.io.IOException;


public class MenuTest {

    private static void clearScreen(Terminal terminal) {
        terminal.writer().print("\033[H\033[2J");
        terminal.flush();
    }
}

class Menu {

    private final Terminal terminal;
    private final String title;
    private final String[] options;

    private int selected = 0;

    public Menu(Terminal terminal, String title, String[] options) {
        this.terminal = terminal;
        this.title = title;
        this.options = options;
    }

    public int show() throws IOException {

        while (true) {

            draw();

            int ch = terminal.reader().read();

            if (ch == 27) {

                int second = terminal.reader().read();
                int third = terminal.reader().read();

                if (second == 91) {

                    // UP
                    if (third == 65) {
                        moveUp();
                    }

                    // DOWN
                    else if (third == 66) {
                        moveDown();
                    }
                }
            }

            // W key
            else if (ch == 'w' || ch == 'W') {
                moveUp();
            }

            // S key
            else if (ch == 's' || ch == 'S') {
                moveDown();
            }

            // ENTER
            else if (ch == 10 || ch == 13) {
                return selected;
            }
        }
    }

    public String getOption(int index) {
        return options[index];
    }

    private void moveUp() {

        selected--;

        if (selected < 0) {
            selected = options.length - 1;
        }
    }

    private void moveDown() {

        selected++;

        if (selected >= options.length) {
            selected = 0;
        }
    }

    private void draw() {

        clearScreen();

        terminal.writer().println(title);
        terminal.writer().println(repeat("=", title.length()));
        terminal.writer().println();

        for (int i = 0; i < options.length; i++) {

            if (i == selected) {

                // Highlight selected option
                terminal.writer().println(
                        "\033[7m> " + options[i] + "\033[0m"
                );

            } else {
                terminal.writer().println("  " + options[i]);
            }
        }
        terminal.flush();

        terminal.writer().println();
        terminal.writer().println("Use ↑ ↓ or W/S. Press Enter to confirm.");

        terminal.flush();
    }

    private void clearScreen() {

        terminal.puts(InfoCmp.Capability.clear_screen);
        terminal.flush();
    }

    private String repeat(String s, int count) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(s);
        }

        return builder.toString();
    }
}
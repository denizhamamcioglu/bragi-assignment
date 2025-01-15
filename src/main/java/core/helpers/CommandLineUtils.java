package core.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineUtils {
    private static final Logger log = LoggerFactory.getLogger(CommandLineUtils.class);

    /**
     * Executes the given command using the command line interface of the current OS. Can adapt to Linux, Windows and MacOS operating systems.
     * @param command - Command to be executed.
     * @return - Console output.
     * @throws IOException
     * @throws InterruptedException
     */
    public static String executeCommand(String command) throws IOException, InterruptedException {
        log.info(String.format("Executing command: %s", command));

        StringBuilder output = new StringBuilder();

        String currentOs = System.getProperty("os.name").toLowerCase();
        ProcessBuilder processBuilder;

        if (currentOs.contains("win")) {
            processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
        } else {
            processBuilder = new ProcessBuilder("bash", "-c", command);
        }

        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while((line = reader.readLine()) != null) {
                output.append(line).append(System.lineSeparator());
            }
        }

        process.waitFor();
        return output.toString();
    }
}

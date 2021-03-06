package com.sinlov.java.gradle.probe.cmd;

import com.sinlov.java.gradle.probe.NativeOutOfMemory;
import com.sinlov.java.gradle.probe.XssParams;
import org.apache.commons.cli.*;

import java.util.Arrays;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 17/10/19.
 */
public class Main {
    private static boolean isVerbose = false;
    // private static boolean isForce = false;

    private static Options configOptions() {
        Options options = new Options();
        options.addOption("h", "help", false, "print help");
        options.addOption("v", "verbose", false, "print verbose");
        options.addOption("deepCall", false, "print deepCall count\nLet [ java -jar -Xms1024m -Xmx1024m -Xss1024k ] for test");
        options.addOption("maxThread", false, "print maxThread\nLet [ java -jar -Xms1024m -Xmx1024m -Xss1024k ] for test");
        options.addOption("threadOOM", false, "print thread OOM");
        return options;
    }

    private static void controlOption(CommandLine cmd) {
        if (cmd.hasOption("threadOOM")) {
            NativeOutOfMemory.threadOOM();
            System.exit(0);
        }

        if (cmd.hasOption("maxThread")) {
            NativeOutOfMemory.maxThreadCount();
            System.exit(0);
        }

        if (cmd.hasOption("deepCall")) {
            int deepCall = XssParams.deepCall();
            System.out.println("deepCall = " + deepCall);
            System.exit(0);
        }
    }

    private static void verboseSysOut(final String msg, String... args) {
        if (isVerbose) {
            System.out.println(msg + ": " + Arrays.toString(args));
        }
    }

    private static boolean isStringEmpty(String str) {
        return null == str || str.equals("");
    }

    private static void isExitCilWhenOptionSizeError(CommandLine cmd, int lessSize) {
        isExitCilWhenOptionSizeError(cmd, lessSize, 9);
    }

    private static void isExitCilWhenOptionSizeError(CommandLine cmd, int lessSize, int maxSize) {
        if (lessSize < 0) {
            lessSize = 0;
        }
        if (maxSize < 0) {
            maxSize = 9;
        }
        int optionCount = cmd.getOptions().length;
        if (optionCount < lessSize || optionCount > maxSize) {
            System.out.println(Contents.CMD_PARAMS_ERROR_SIZE_INFO);
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        Options options = configOptions();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            isExitCilWhenOptionSizeError(cmd, 1);
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                //TODO set usage
                formatter.printHelp(Contents.CMD_HELP_HEAD, options);
                System.exit(0);
            }
            if (cmd.hasOption("v")) {
                Main.isVerbose = true;
            }
            controlOption(cmd);
        } catch (Exception e) {
            System.err.println(Contents.CMD_PARAMS_ERROR_SIZE_INFO);
            e.printStackTrace();
            System.exit(Contents.EXIT_CODE_PARAMS_ERROR);
        }

    }
}

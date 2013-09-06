package com.thechange.projects.quickboot;

import java.io.IOException;

import android.widget.Toast;

public class CommandUtil {

	public static enum Command {
		reboot, reboot_recovery, reboot_bootloader, power_off
	}

	public static void exeCommand(Command command) {
		final String[] commands = getCommands(command);
		exeRootCommand(commands);
	}

	private static String[] getCommands(Command command) {
		switch (command) {
		case reboot:
			return new String[] { "su", "-c", "reboot" };

		case reboot_recovery:
			return new String[] { "su", "-c", "reboot recovery" };
		case reboot_bootloader:
			return new String[] { "su", "-c", "reboot bootloader" };
		case power_off:
			return new String[] { "su", "-c", "reboot -p" };
		default:
			return null;
		}
	}

	private static void exeRootCommand(String[] commands) {
		try {
			if (commands == null) {
				return;
			}
			Runtime.getRuntime().exec(commands);
		} catch (IOException e) {
			Toast.makeText(App.getContext(), e.getMessage(), Toast.LENGTH_LONG)
					.show();
		}
	}
}

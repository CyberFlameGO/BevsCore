package games.bevs.core.commons.server;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Console 
{
	public static void log(String header, String message)
	{
		CommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(header + " ]> " + message);
	}
}

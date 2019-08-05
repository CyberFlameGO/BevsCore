package games.bevs.core.module.essentials;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.plugin.java.JavaPlugin;

import games.bevs.core.commons.utils.ClassGetterUtils;
import games.bevs.core.module.ModInfo;
import games.bevs.core.module.Module;
import games.bevs.core.module.commandv2.CommandModule;
import games.bevs.core.module.commandv2.types.BevsCommand;
import games.bevs.core.module.player.PlayerDataModule;

@ModInfo(name = "Essentials")
public class EssentialsModule extends Module
{

	public EssentialsModule(JavaPlugin plugin, CommandModule commandModule, PlayerDataModule clientModule) {
		super(plugin, commandModule, clientModule);
	}

	@Override
	public void onEnable()
	{
		loadCommands();
	}
	
	/**
	 * Reigster all class within {@link games.bevs.core.module.essentials.commands}
	 */
	public void loadCommands()
	{
		ClassGetterUtils.getClassesForPackage(this.getPlugin(), 
				"games.bevs.core.module.essentials.commands").forEach(clazz -> {
			try {
				
				BevsCommand command = (BevsCommand) clazz.getConstructor(PlayerDataModule.class).newInstance(this.getClientModule());
				this.registerCommand(command);
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		});
	}
}

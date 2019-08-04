package games.bevs.core;

import org.bukkit.plugin.java.JavaPlugin;

import games.bevs.core.module.abilties.AbilityModule;
import games.bevs.core.module.client.ClientModule;
import games.bevs.core.module.combat.CombatModule;
import games.bevs.core.module.commands.CommandModule;

public class CorePlugin extends JavaPlugin {

	@Override
	public void onEnable() 
	{
		CommandModule commandModule = new CommandModule(this);
		ClientModule clientModule = new ClientModule(this, commandModule);
		commandModule.setClientModule(clientModule); //this allows us to check ranks
		
		new CombatModule(this, commandModule, clientModule);
		new AbilityModule(this, commandModule, true);
	}


}

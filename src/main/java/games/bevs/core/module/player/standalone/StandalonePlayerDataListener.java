package games.bevs.core.module.player.standalone;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import games.bevs.core.commons.database.DatabaseSettings;
import games.bevs.core.commons.database.mysql.MySQLManager;
import games.bevs.core.commons.database.operations.LoadPlayerData;
import games.bevs.core.commons.player.PlayerData;
import games.bevs.core.module.player.PlayerDataModule;

public class StandalonePlayerDataListener implements Listener
{
	
	
	private PlayerDataModule playerDataModule;
	private MySQLManager mySQLManager;
	private DatabaseSettings databaseSetting;
	
	public StandalonePlayerDataListener(PlayerDataModule playerDataModule, MySQLManager mySQLManager)
	{
		this.playerDataModule = playerDataModule;
		this.mySQLManager = mySQLManager;
		this.databaseSetting = new DatabaseSettings(null, mySQLManager);
	}
	
	public void queryPlayerData(PlayerData playerData)
	{
		
//		mySQLManager.getConnection().prepareStatement(sql);
	}
	
	@EventHandler
	public void onPreLogin(AsyncPlayerPreLoginEvent e)
	{
		UUID uniqueId = e.getUniqueId();
		String username = e.getName();
		
		//load from database
		PlayerData playerData = new PlayerData(uniqueId);
		this.playerDataModule.log(username + " is waitng for their PlayerData to load...");
		new LoadPlayerData(this.databaseSetting, playerData);
		
		this.playerDataModule.log(username + "'s PlayerData has been loaded");
	}
}

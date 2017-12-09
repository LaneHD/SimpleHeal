package ch.lanehd.heal.main;

//IMPORTS
import org.bukkit.plugin.java.JavaPlugin;

import ch.lanehd.heal.commands.FeedCmd;
import ch.lanehd.heal.commands.HealCmd;
import ch.lanehd.heal.wip.SimpleHealCmd;
import de.stealthcoders.spu.SpigotPluginUpdater;

public class Main extends JavaPlugin {
	public void onEnable() {
		boolean heal = true;
		boolean feed = true;
		boolean autoupdate = true;
		boolean simpleheal = false;
		System.out.println("SimpleHeal v" + getDescription().getVersion() + " wurde erfolgreich geladen!");
		if (heal)
			getCommand("heal").setExecutor(new HealCmd());

		if (feed)
			getCommand("feed").setExecutor(new FeedCmd());

		if (simpleheal)
			getCommand("simpleheal").setExecutor(new SimpleHealCmd());
		SpigotPluginUpdater spu = new SpigotPluginUpdater(this/* Your Plugin */,
				"http://update.lanehd.bplaced.net/simpleheal.html");
		spu.enableOut(); // Enables an Output if there is a new Update and if the file was downloaded

		// spu.disableOut(); Disables the output
		if (spu.needsUpdate() && autoupdate) { // Check if there is an Update available
			spu.update(); // The Plugin will be automatically update
		} else if (autoupdate == false)
			System.out
					.println("SimpleHeal AutoUpdate ist deaktiviert! Bitte benutze /simpleheal update um zu updaten!");
		else
			System.out.println("SimpleHeal ist auf der neuesten Version!");
		// ...
		
		
		//METRICS
		// All you have to do is adding this line in your onEnable method:
        Metrics metrics = new Metrics(this);

        // Optional: Add custom charts
        //metrics.addCustomChart(new Metrics.SimplePie("chart_id", new Callable<String>() {
        //    @Override
        //    public String call() throws Exception {
        //        return "My value";
        //    }
        //}));

        // If you use Java 8 you can use Lambdas:
        // metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
	}
}

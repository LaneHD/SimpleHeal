package ch.lanehd.heal.wip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.stealthcoders.spu.SpigotPluginUpdater;

public class SimpleHealCmd extends JavaPlugin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("SimpleHeal.maincmd.help") || p.hasPermission("SimpleHeal.maincmd.*")
						|| p.hasPermission("SimpleHeal.*")) {
					p.sendMessage("§6----------------");
					p.sendMessage("§6SimpleHeal Hilfe");
					p.sendMessage("§6/heal [Spieler]");
					p.sendMessage("§6/feed [Spieler]");
					p.sendMessage("§6/simpleheal [update]");
					p.sendMessage("§6Seite 1/1");
					p.sendMessage("§6----------------");

				} else
					p.sendMessage("§8[§bHeal§8] §cDu hast nicht die benötigten Berechtigungen, um das zu tun!");
			}

			else if (args.length == 1) {
				SpigotPluginUpdater spu = new SpigotPluginUpdater(this/* Your Plugin */,
						"http://update.lanehd.bplaced.net/simpleheal.html");
				if (args[0] == "update")
					spu.update();
			}

		}
		return false;
	}
}

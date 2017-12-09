package ch.lanehd.heal.commands;

//IMPORTS
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("SimpleHeal.feed.self") || p.hasPermission("SimpleHeal.feed.*")
						|| p.hasPermission("SimpleHeal.*")) {
					p.setFoodLevel(20);
					p.sendMessage("§8[§bHeal§8] §aDu wurdest gefüttert!");

				} else
					p.sendMessage("§8[§bHeal§8] §cDu hast nicht die benötigten Berechtigungen, um das zu tun!");
			}

			else if (args.length == 1) {
				if (p.hasPermission("SimpleHeal.feed.others") || p.hasPermission("SimpleHeal.feed.*")
						|| p.hasPermission("SimpleHeal.*")) {
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null) {
						if (p == target) {
							p.setFoodLevel(20);
							p.sendMessage("§8[§bHeal§8] §aDu wurdest gefüttert!");

						} else {
							target.setHealth(20);
							target.sendMessage("§8[§bHeal§8] §aDu wurdest von §6" + p.getName() + "§a gefüttert!");
							p.sendMessage("§8[§bHeal§8] §aDu hast §6" + target.getName() + "§a gefüttert!");

						}

					} else {
						String t = args[0];
						p.sendMessage("§8[§bHeal§8] §cDer Spieler §6" + t + "§c ist nicht Online!");

					}
				} else
					p.sendMessage("§8[§bHeal§8] §cDu hast nicht die benötigten Berechtigungen, um das zu tun!");

			} else if (args.length >= 1)
				p.sendMessage("§8[§bHeal§8] §cBitte benutze /feed §6[Spieler]");

		} else if (args.length == 0)
			System.out.println("[Heal] Die Konsole hat nie Hunger!");
		else if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if (target != null) {
				target.setHealth(20);
				target.sendMessage("§8[§bHeal§8] §aDu wurdest von der Konsole gefüttert!");
				System.out.println("[§bHeal] Du hast " + target.getName() + " gefüttert!");

			} else {
				String t = args[0];
				System.out.println("[Heal] Der Spieler " + t + " ist nicht Online!");

			}

		} else if (args.length >= 1)
			System.out.println("[Heal] Bitte benutze /feed [Spieler]");
		return false;

	}

}

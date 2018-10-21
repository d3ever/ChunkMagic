/*******************************************************
 * Copyright (C) 2016-2018 D3EVER <root@d3ever.cf>
 *
 * This file is part of SexyCode.
 *
 * sexy can not be copied and/or distributed without the express
 * permission of D3EVER
 *
 * Date: 21/10/2018 - 15:52 Sunday
 *
 *******************************************************/
package sexy.criss.sexymagic.sexy_part.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sexy.criss.sexymagic.main.Main;
import sexy.criss.sexymagic.sexy_part.data.SexyBlock;
import sexy.criss.sexymagic.utils.ACommand;
import sexy.criss.sexymagic.utils.Utils;

import java.util.Iterator;
import java.util.List;

public class MagicChunkCommand extends ACommand {

    public MagicChunkCommand() {
        super("magicchunk", "mchunk", "magicc", "mc");
        this.unavailableFromConsole();
        this.unavailableWithoutPermission(Main.getInstance().getConfig().getString("permission-use"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        switch (args.length) {
            //'&7Использование: &c/{command} <add/remove/list> <type:data> <limit>'
            case 1:
                switch (args[0].toLowerCase()) {
                    case "list":
                        Main._types.values().forEach(b -> p.sendMessage(Utils.f("&c" + Material.getMaterial(b.getId()).toString() + "&7:&a" + b.getData() + " &7с лимитом \"&c" + b.getLimit() + "&7\"")));
                        p.sendMessage(Utils.f(Main.getInstance().getConfig().getString("messages.4").replace("{size}", String.valueOf((long) Main._types.values().size()))));
                        break;
                    default:
                        help(p, label);
                        break;
                }
                break;
            case 2:
                switch (args[0].toLowerCase()) {
                    case "remove":
                        String data = args[1];
                        try {
                            if(!(data.contains(":"))) data.concat(":0");
                            Main._types.remove(data);
                            p.sendMessage(Utils.f(Main.getInstance().getConfig().getString("messages.6")
                            .replace("{block}", Material.getMaterial(Integer.parseInt(data.split(":")[0])).toString())));
                        } catch (Exception ex) {
                            p.sendMessage(Utils.f("&4Произошла критическая ошибка: \n" + ex.getMessage()));
                        }
                        break;
                    default:
                        help(p, label);
                        break;
                }
                break;
            case 3:
                String method = args[0].toLowerCase();
                String data = args[1];
                if(!(data.contains(":"))) data = data.concat(":0");
                String[] d = data.split(":");
                int limit = 0;
                try { limit = Integer.parseInt(args[2]); } catch (Exception ignored) {}

                switch (method) {
                    case "add":
                        Main._types.put(data, new SexyBlock(Integer.parseInt(d[0]), Byte.parseByte(d[1]), limit));
                        p.sendMessage(Utils.f(Main.getInstance().getConfig().getString("messages.5")
                                .replace("{limit}", String.valueOf(limit))
                                .replace("{block}", data)));
                        break;
                    default:
                        help(p, label);
                        break;
                }
                break;
            default:
                help(p, label);
                break;
        }
        return false;
    }

    public void help(Player p, String label) {
        List<String> help_arr = Utils.f(Main.getInstance().getConfig().getStringList("messages.3"));
        for(int i = 0; i < help_arr.size(); i++) help_arr.set(i, help_arr.get(i).replace("{command}", label));

        help_arr.forEach(p::sendMessage);
    }

}

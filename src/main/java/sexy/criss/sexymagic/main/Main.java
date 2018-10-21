package sexy.criss.sexymagic.main;

import com.google.common.collect.Maps;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import sexy.criss.sexymagic.logger.Logger;
import sexy.criss.sexymagic.logger.Type;
import sexy.criss.sexymagic.sexy_part.BlockPlaceHandler;

import java.util.Map;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    public static Map<Material, Integer> _types = Maps.newHashMap();

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();

        getConfig().getStringList("block-types").forEach(s -> {
            String[] v = s.split(":");
            Material mat = Material.getMaterial(v[0]);
            if(mat != null)
                try {
                    _types.put(Material.getMaterial(v[0]), Integer.parseInt(v[1]));
                    Logger.log(Type.SUCCESS, "Successfully loading block &c%s with limit %s", v[0].toUpperCase(), v[1]);
                } catch (Exception ignored) { }

        });

        new BlockPlaceHandler();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }


}

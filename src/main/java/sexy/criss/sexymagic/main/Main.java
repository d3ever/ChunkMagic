package sexy.criss.sexymagic.main;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import sexy.criss.sexymagic.logger.Logger;
import sexy.criss.sexymagic.logger.Type;
import sexy.criss.sexymagic.sexy_part.BlockPlaceHandler;
import sexy.criss.sexymagic.sexy_part.commands.MagicChunkCommand;
import sexy.criss.sexymagic.sexy_part.data.SexyBlock;

import java.util.List;
import java.util.Map;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    public static Map<String, SexyBlock> _types = Maps.newHashMap();

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
            int limit = Integer.parseInt(s.split("=")[1]);
            s = s.split("=")[0];
            String[] t = s.split(":");
            Material mat = Material.getMaterial(Integer.parseInt(t[0]));
            if(mat != null)
                try {
                    _types.put(mat.getId() + ":" + t[1], new SexyBlock(mat.getId(), Byte.parseByte(t[1]), limit));
                    Logger.log(Type.SUCCESS, "Successfully loading block &c%s with limit %s", mat.toString(), String.valueOf(limit));
                } catch (Exception ignored) { }

        });

        new MagicChunkCommand().register();
        new BlockPlaceHandler();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        List<String> types = Lists.newArrayList();
        _types.values().forEach(b -> types.add(b.getId() + ":" + b.getData() + "=" + b.getLimit()));
        getConfig().set("block-types", types);

        saveConfig();
    }


}

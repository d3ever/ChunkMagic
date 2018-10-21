/*******************************************************
 * Copyright (C) 2016-2018 D3EVER <root@d3ever.cf>
 *
 * This file is part of SexyCode.
 *
 * sexy can not be copied and/or distributed without the express
 * permission of D3EVER
 *
 * Date: 20/10/2018 - 21:40 Saturday
 *
 *******************************************************/
package sexy.criss.sexymagic.sexy_part;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import sexy.criss.sexymagic.main.Main;
import sexy.criss.sexymagic.utils.SexyEvent;
import sexy.criss.sexymagic.utils.Utils;

import static sexy.criss.sexymagic.utils.Utils.f;

public class BlockPlaceHandler extends SexyEvent {

    @EventHandler
    public void onChunkMagic(BlockPlaceEvent e) {
        String msg = Main.getInstance().getConfig().getString("messages.1");
        Player p = e.getPlayer();
        Block b = e.getBlockPlaced();
        Location l = b.getLocation();
        Chunk c = l.getChunk();

        int bx = c.getX() << 4;
        int bz = c.getZ() << 4;

        World w = b.getWorld();
        int count = 0;
        for(int x = bx; x < bx + 16; x++) {
            for(int z = bz; z < bz + 16; z++) {
                for(int y = 0; y < 128; y++) {
                    Block target = w.getBlockAt(x, y, z);
                    if(target.getType().equals(b.getType())) {
                        if(Main._types.containsKey(b.getType())) {
                            if (count >= Main._types.get(b.getType())) {
                                p.sendMessage(Utils.f(msg
                                        .replace("{block}", b.getType().toString())
                                        .replace("{limit}", Main._types.get(b.getType()).toString())));
                                e.setCancelled(true);
                                return;
                            }
                            count++;
                        }
                    }
                }
            }
        }
    }

}

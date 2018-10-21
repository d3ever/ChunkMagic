/*******************************************************
 * Copyright (C) 2016-2018 D3EVER <root@d3ever.cf>
 *
 * This file is part of SexyCode.
 *
 * sexy can not be copied and/or distributed without the express
 * permission of D3EVER
 *
 * Date: 20/10/2018 - 21:39 Saturday
 *
 *******************************************************/
package sexy.criss.sexymagic.utils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import sexy.criss.sexymagic.main.Main;

public class SexyEvent implements Listener {

    public SexyEvent() {
        Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
    }

}

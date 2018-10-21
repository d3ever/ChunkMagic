/*******************************************************
 * Copyright (C) 2016-2018 D3EVER <root@d3ever.cf>
 *
 * This file is part of SexyCode.
 *
 * sexy can not be copied and/or distributed without the express
 * permission of D3EVER
 *
 * Date: 20/10/2018 - 21:45 Saturday
 *
 *******************************************************/
package sexy.criss.sexymagic.logger;

import org.bukkit.ChatColor;
import sexy.criss.sexymagic.utils.Utils;

public enum Type {
    SUCCESS("SUCCESS", ChatColor.GREEN),
    WARNING("WARNING", ChatColor.YELLOW),
    ERROR("ERROR", ChatColor.RED),
    INFO("INFO", ChatColor.AQUA);

    private String s;
    private ChatColor c;

    Type(String s, ChatColor c) {
        this.s = s;
        this.c = c;
    }

    public String toString() {
        String format = "&7[%s&7] ~ &r%s";
        return Utils.f(format, s, c.toString());
    }


}

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

import org.bukkit.Bukkit;
import sexy.criss.sexymagic.utils.Utils;

public class Logger {

    public static void log(Type type, String s) {
        Bukkit.getConsoleSender().sendMessage(Utils.f(type.toString() + s));
    }

    public static void log(Type type, String s, Object... args) {
        log(type, Utils.f(s, args));
    }

    public static void log(String s) {
        log(Type.INFO, s);
    }

    public static void log(String s, Object... args) {
        log(Utils.f(s, args));
    }

}

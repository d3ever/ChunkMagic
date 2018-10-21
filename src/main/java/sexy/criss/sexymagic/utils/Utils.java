/*******************************************************
 * Copyright (C) 2016-2018 D3EVER <root@d3ever.cf>
 *
 * This file is part of SexyCode.
 *
 * sexy can not be copied and/or distributed without the express
 * permission of D3EVER
 *
 * Date: 20/10/2018 - 21:37 Saturday
 *
 *******************************************************/
package sexy.criss.sexymagic.utils;

import com.sun.istack.internal.NotNull;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class Utils {

    @NotNull
    public static String f(@NotNull String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @NotNull
    public static String f(@NotNull String s, @NotNull Object... args) {
        String out;
        try {
            out = f(String.format(s, args));
        }catch (Exception ex) {
            out = f(s.concat(" [" + Arrays.toString(args) + "]"));
        }
        return out;
    }

}

/*******************************************************
 * Copyright (C) 2016-2018 D3EVER <root@d3ever.cf>
 *
 * This file is part of SexyCode.
 *
 * sexy can not be copied and/or distributed without the express
 * permission of D3EVER
 *
 * Date: 21/10/2018 - 14:17 Sunday
 *
 *******************************************************/
package sexy.criss.sexymagic.sexy_part.data;

public class SexyBlock {

    private byte data;
    private int id;
    private int limit;

    public SexyBlock(int id, byte data, int limit) {
        this.id = id;
        this.data = data;
        this.limit = limit;
    }

    public byte getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }
}

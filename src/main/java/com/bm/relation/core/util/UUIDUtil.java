package com.bm.relation.core.util;

import java.util.UUID;

/**
 * id生成器.
 *
 * @author : zyg
 * @since : 2022/08/02
 **/
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}

package com.company.designpattern.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
public class VipCardFactory {
    private static Map<String, VipCard> map = new ConcurrentHashMap<>();
    static {
        map.put("gold", new GoldCard());
        map.put("silver", new SilverCard());
        map.put("copper", new CopperCard());
    }
    public static VipCard getVIPCard(String level) {
        return map.get(level) != null ? map.get(level) : new Normal();
    }
}

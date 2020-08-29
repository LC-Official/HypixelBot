package cn.czynb.hypixelbot.api;

import cn.czynb.hypixelbot.api.InfoFactory.BasicInfo;
import cn.czynb.hypixelbot.config.HypixelAPIConfig;
import net.hypixel.api.HypixelAPI;

import java.util.Map;
import java.util.UUID;

public class API {

    public static final HypixelAPI api = new HypixelAPI(HypixelAPIConfig.HYPIXEL_API_KEY);

    public static Map<String, Object> get(String type, String user /* Name */) {

        switch (type) {
            case "basic":
                return BasicInfo.build(api.getPlayerByName(user));
                break;

        }

    }

}

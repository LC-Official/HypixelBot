package cn.czynb.hypixelbot.config;

import java.util.UUID;

public class HypixelAPIConfig {
    public static final UUID HYPIXEL_API_KEY = UUID.fromString(GlobalConfig.getConfig().getProperty("hypixel.api_key"));
}

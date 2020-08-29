package cn.czynb.hypixelbot.config;

public class BotConfig {
    public static final Long BOT_QQ = Long.parseLong(GlobalConfig.getConfig().getProperty("botQQ", "3495317334"));
    public static final String BOT_Password = GlobalConfig.getConfig().getProperty("botPassword");
}

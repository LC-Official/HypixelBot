package cn.czynb.hypixelbot.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public class GlobalConfig {

    private static final File CONFIG_FILE = new File("./config.properties");
    private static FileReader CONFIG_READER;

    private static final Properties CONFIG = new Properties();

    public static final String MYSQL_ADDRESS = CONFIG.getProperty("mysql.address", "127.0.0.1");;
    public static final String MYSQL_PORT = CONFIG.getProperty("mysql.port", "3306");
    public static final String MYSQL_DATABASE = CONFIG.getProperty("mysql.database", "data");
    public static final String MYSQL_USER = CONFIG.getProperty("mysql.user", "root");
    public static final String MYSQL_PASSWORD = CONFIG.getProperty("mysql.password", "root");

    private boolean createConfig() {
        try {
            CONFIG_FILE.createNewFile();
            CONFIG.load(CONFIG_READER);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        CONFIG.setProperty("botQQ", "");
        CONFIG.setProperty("botPassword", "");
        CONFIG.setProperty("mysql.address", "127.0.0.1");
        CONFIG.setProperty("mysql.port", "3306");
        CONFIG.setProperty("mysql.database", "data");
        CONFIG.setProperty("mysql.user", "root");
        CONFIG.setProperty("mysql.password", "root");
        CONFIG.setProperty("hypixel.api_key", "*");

        return true;
    }

    private boolean loadConfig()
    {
        try {
            CONFIG.load(CONFIG_READER);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static Properties getConfig() {
        return CONFIG;
    }


    static {
        try {
            CONFIG_READER = new FileReader(CONFIG_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!CONFIG_FILE.exists()) {
        }

        try {CONFIG.load(CONFIG_READER);} catch (IOException e) {e.printStackTrace();}
    }

}

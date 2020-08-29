package cn.czynb.hypixelbot.api.InfoFactory;

import cn.czynb.hypixelbot.api.Json;
import net.hypixel.api.reply.PlayerReply;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class BasicInfo {

    private static final Map<String, String> ranks = new HashMap<String, String>(){
        {
            put("N/A", "");
            put("VIP", "[VIP]");
            put("VIP_PLUS", "[VIP+]");
            put("MVP", "[MVP]");
            put("MVP_PLUS", "[MVP+]");
        }
    };

    public static Map<String, Object> build(CompletableFuture<PlayerReply> source, String guildName) {
        Map<String, Object> info = new HashMap<String, Object>();

        source.whenComplete(new BiConsumer<PlayerReply, Throwable>() {
            @Override
            public void accept(PlayerReply reply, Throwable throwable) {
                if (!Json.getFieldOrNA("monthlyPackageRank", reply.getPlayer()).trim().equalsIgnoreCase("N/A")) {
                    info.put("ID", "[MVP++]" + Json.getFieldOrNA("playername", reply.getPlayer()).trim());
                } else {
                    info.put("ID", ranks.get(Json.getFieldOrNA("newPackageRank", reply.getPlayer()) + Json.getFieldOrNA("playername", reply.getPlayer())));
                    info.put("等级", getLevel(Integer.parseInt(Json.getFieldOrNA("networkExp", reply.getPlayer()))));
                }
            }
        });

        return info;
    }

    private static double getLevel(int networkExp) {
        double exp = networkExp;

        double level = 1;

        double upgradeNeed = 10000;

        for (double upgradeTo = 12500; upgradeTo < 79680000; upgradeTo += 2500) {

            if (exp > upgradeNeed) {
                level ++;
            } else {
                upgradeNeed -= upgradeTo;

                double floatLevel = (-(upgradeNeed - exp)) / upgradeTo;

                String floatLevelStr = String.valueOf(floatLevel);
                floatLevelStr = floatLevelStr.substring(2,4).concat(".").concat(String.valueOf(floatLevelStr.charAt(4)));
                level += Double.parseDouble("0." + Math.round(Double.parseDouble(floatLevelStr)));

                break;
            }

            upgradeNeed += upgradeTo;
        }
        return level;
    }

}

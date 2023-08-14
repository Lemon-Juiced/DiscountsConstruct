package lemon_juice.discounts_construct.item.custom.register.util;

import net.minecraft.world.item.Tier;

public class TierUtils {
    public static String getTierName(Tier tier){
        return switch (tier.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };
    }
}

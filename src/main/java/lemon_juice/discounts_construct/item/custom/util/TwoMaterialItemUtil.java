package lemon_juice.discounts_construct.item.custom.util;

import net.minecraft.world.item.Tier;

public class TwoMaterialItemUtil {

    /**
     * Get the max of both tiers attack damage
     *
     * @param t1 The first tier
     * @param t2 The second tier
     * @return The max of both tiers attack damage
     */
    public static int getAttackDamage(Tier t1, Tier t2){
        return (int) Math.max(t1.getAttackDamageBonus(), t2.getAttackDamageBonus());
    }

    /**
     * Get the max of both tiers attack speed
     * @param t1 The first tier
     * @param t2 The second tier
     * @return The max of both tiers attack speed
     */
    public static float getAttackSpeed(Tier t1, Tier t2){
        return Math.max(t1.getSpeed(), t2.getSpeed());
    }
}

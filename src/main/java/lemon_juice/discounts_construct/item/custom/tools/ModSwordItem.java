package lemon_juice.discounts_construct.item.custom.tools;

import lemon_juice.discounts_construct.item.custom.util.TierGenerator;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ModSwordItem extends SwordItem {
    Tier tier1;
    Tier tier2;

    public ModSwordItem(Tier tier1, Tier tier2, Properties properties) {
        super(TierGenerator.generateTier(tier1, tier2),
              getAttackDamage(tier1, tier2),
              -2.4F,
              properties);

        this.tier1 = tier1;
        this.tier2 = tier2;
    }

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
}

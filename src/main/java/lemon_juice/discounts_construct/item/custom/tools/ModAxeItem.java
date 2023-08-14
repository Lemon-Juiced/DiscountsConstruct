package lemon_juice.discounts_construct.item.custom.tools;

import lemon_juice.discounts_construct.item.custom.util.TierGenerator;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class ModAxeItem extends AxeItem {
    Tier tier1;
    Tier tier2;
    Tier tier3;

    public ModAxeItem(Tier tier1, Tier tier2, Tier tier3, Properties properties) {
        super(TierGenerator.generateTier(tier1, tier2, tier3),
              getAttackDamage(tier1, tier2, tier3),
              -3.2F,
              properties);

        this.tier1 = tier1;
        this.tier2 = tier2;
        this.tier3 = tier3;
    }

    /**
     * Get the max of both tiers attack damage
     *
     * @param t1 The first tier
     * @param t2 The second tier
     * @param t3 The third tier
     * @return The max of all three tiers attack damage
     */
    public static int getAttackDamage(Tier t1, Tier t2, Tier t3){
        return (int) Math.max(Math.max(t1.getAttackDamageBonus(), t2.getAttackDamageBonus()), t3.getAttackDamageBonus());
    }
}

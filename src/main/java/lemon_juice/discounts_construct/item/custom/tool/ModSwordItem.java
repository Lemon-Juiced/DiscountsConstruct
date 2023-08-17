package lemon_juice.discounts_construct.item.custom.tool;

import lemon_juice.discounts_construct.item.custom.tier.TierGenerator;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ModSwordItem extends SwordItem {
    Tier tier1;
    Tier tier2;

    public ModSwordItem(Tier tier1, Tier tier2, Properties properties) {
        super(TierGenerator.generateTier(tier1, tier2), 3, -2.4F, properties);
        this.tier1 = tier1;
        this.tier2 = tier2;
    }

}

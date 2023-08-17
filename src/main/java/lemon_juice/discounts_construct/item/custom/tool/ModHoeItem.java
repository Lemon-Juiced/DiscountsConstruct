package lemon_juice.discounts_construct.item.custom.tool;

import lemon_juice.discounts_construct.item.custom.tier.TierGenerator;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class ModHoeItem extends HoeItem {
    Tier tier1;
    Tier tier2;

    public ModHoeItem(Tier tier1, Tier tier2, Properties properties) {
        super(TierGenerator.generateTier(tier1, tier2), 0, -3.0F, properties);
        this.tier1 = tier1;
        this.tier2 = tier2;
    }
}

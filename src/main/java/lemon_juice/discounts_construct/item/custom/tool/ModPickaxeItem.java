package lemon_juice.discounts_construct.item.custom.tool;

import lemon_juice.discounts_construct.item.custom.tier.TierGenerator;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ModPickaxeItem extends PickaxeItem {
    Tier tier1;
    Tier tier2;
    Tier tier3;

    public ModPickaxeItem(Tier tier1, Tier tier2, Tier tier3, Properties properties) {
        super(TierGenerator.generateTier(tier1, tier2, tier3), 1, -2.8F, properties);
        this.tier1 = tier1;
        this.tier2 = tier2;
        this.tier3 = tier3;
    }
}

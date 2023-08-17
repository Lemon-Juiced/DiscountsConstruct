package lemon_juice.discounts_construct.item.custom.tool;

import lemon_juice.discounts_construct.item.custom.tier.TierGenerator;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class ModAxeItem extends AxeItem {
    Tier tier1;
    Tier tier2;
    Tier tier3;

    public ModAxeItem(Tier tier1, Tier tier2, Tier tier3, Properties properties) {
        super(TierGenerator.generateAxeTier(tier1, tier2, tier3), 6.0F, -3.2F, properties);
        this.tier1 = tier1;
        this.tier2 = tier2;
        this.tier3 = tier3;
    }
}

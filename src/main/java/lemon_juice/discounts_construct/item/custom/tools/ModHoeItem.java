package lemon_juice.discounts_construct.item.custom.tools;

import lemon_juice.discounts_construct.item.custom.util.TierGenerator;
import lemon_juice.discounts_construct.item.custom.util.TwoMaterialItemUtil;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class ModHoeItem extends HoeItem {
    Tier tier1;
    Tier tier2;

    public ModHoeItem(Tier tier1, Tier tier2, Properties properties) {
        super(TierGenerator.generateTier(tier1, tier2),
              TwoMaterialItemUtil.getAttackDamage(tier1, tier2),
              TwoMaterialItemUtil.getAttackSpeed(tier1, tier2),
              properties);

        this.tier1 = tier1;
        this.tier2 = tier2;
    }
}

package lemon_juice.discounts_construct.item.custom.register.util;

import net.minecraft.world.item.Tier;

public class TierPair {
    Tier tier1;
    Tier tier2;

    public TierPair(Tier tier1, Tier tier2){
        this.tier1 = tier1;
        this.tier2 = tier2;
    }

    public Tier getTier1() {
        return tier1;
    }

    public Tier getTier2() {
        return tier2;
    }

    public String getTier1Name(){
        return TierUtils.getTierName(tier1);
    }

    public String getTier2Name(){
        return TierUtils.getTierName(tier2);
    }
}

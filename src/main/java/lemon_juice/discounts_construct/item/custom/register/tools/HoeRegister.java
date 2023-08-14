package lemon_juice.discounts_construct.item.custom.register.tools;

import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.register.MainToolRegister;
import lemon_juice.discounts_construct.item.custom.register.util.TierPair;
import lemon_juice.discounts_construct.item.custom.tools.ModSwordItem;
import net.minecraft.world.item.Item;

public class HoeRegister {
    public static void registerAllHoes(){
        for (int i = 0; i < MainToolRegister.ALL_TIER_PAIRS.size(); i++) {
            TierPair tierPair = MainToolRegister.ALL_TIER_PAIRS.get(i);
            String name1 = tierPair.getTier1Name();
            String name2 = tierPair.getTier2Name();
            ModItems.ITEMS.register(name1 + "_" + name2 + "_hoe", () -> new ModSwordItem(tierPair.getTier1(), tierPair.getTier2(), new Item.Properties()));
        }
    }
}

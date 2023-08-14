package lemon_juice.discounts_construct.item.custom.register;

import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.tools.ModSwordItem;
import lemon_juice.discounts_construct.item.custom.register.util.TierPair;
import net.minecraft.world.item.Item;

public class SwordRegister {
    public static void registerAllSwords(){
        for (int i = 0; i < MainToolRegister.ALL_TIER_PAIRS.size(); i++) {
            TierPair tierPair = MainToolRegister.ALL_TIER_PAIRS.get(i);
            String name1 = tierPair.getTier1Name();
            String name2 = tierPair.getTier2Name();
            ModItems.ITEMS.register(name1 + "_" + name2 + "_sword", () -> new ModSwordItem(tierPair.getTier1(), tierPair.getTier2(), new Item.Properties()));
        }
    }
}

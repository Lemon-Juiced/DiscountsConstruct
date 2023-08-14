package lemon_juice.discounts_construct.item.custom.register.tools;

import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.register.MainToolRegister;
import lemon_juice.discounts_construct.item.custom.register.util.TierTriplet;
import lemon_juice.discounts_construct.item.custom.tools.ModPickaxeItem;
import net.minecraft.world.item.Item;

public class PickaxeRegister {
    public static void registerAllPickaxes(){
        for (int i = 0; i < MainToolRegister.ALL_TIER_TRIPLETS.size(); i++) {
            TierTriplet tierTriplet = MainToolRegister.ALL_TIER_TRIPLETS.get(i);
            String name1 = tierTriplet.getTier1Name();
            String name2 = tierTriplet.getTier2Name();
            String name3 = tierTriplet.getTier3Name();
            ModItems.ITEMS.register(name1 + "_" + name2 + "_" + name3 + "_pickaxe", () -> new ModPickaxeItem(tierTriplet.getTier1(), tierTriplet.getTier2(), tierTriplet.getTier3(), new Item.Properties()));
        }
    }
}

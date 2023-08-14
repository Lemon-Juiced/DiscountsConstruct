package lemon_juice.discounts_construct.creativetab.util;

import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.tool.ModAxeItem;
import lemon_juice.discounts_construct.item.custom.tool.ModHoeItem;
import lemon_juice.discounts_construct.item.custom.tool.ModPickaxeItem;
import lemon_juice.discounts_construct.item.custom.tool.ModSwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabUtils {
    public static Item getFirstItem(String itemType){
        Item tabItem = null;

        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            if (itemType.equals("axe")) {
                if (item.get() instanceof ModAxeItem) {
                    tabItem = item.get();
                    break; //Out of the for-loop
                }
            }

            if (itemType.equals("hoe")) {
                if (item.get() instanceof ModHoeItem) {
                    tabItem = item.get();
                    break; //Out of the for-loop
                }
            }

            if (itemType.equals("pickaxe")) {
                if (item.get() instanceof ModPickaxeItem) {
                    tabItem = item.get();
                    break; //Out of the for-loop
                }
            }

            if (itemType.equals("sword")) {
                if (item.get() instanceof ModSwordItem) {
                    tabItem = item.get();
                    break; //Out of the for-loop
                }
            }

        }

        return tabItem;
    }
}

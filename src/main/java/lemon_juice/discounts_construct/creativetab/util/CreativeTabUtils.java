package lemon_juice.discounts_construct.creativetab.util;

import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.tools.ModSwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabUtils {
    public static Item getFirstItem(){
        Item tabItem = null;

        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries())
            if(item.get() instanceof ModSwordItem) {
                tabItem = item.get();
                break; //Out of the for-loop
            }

        return tabItem;
    }
}

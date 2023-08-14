package lemon_juice.discounts_construct.creativetab.util;

import lemon_juice.discounts_construct.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabUtils {
    public static Item getFirstItem(){
        Item tabItem = null;

        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries())
            if(item.get() instanceof SwordItem) {
                tabItem = item.get();
                break; //Out of the for-loop
            }

        return tabItem;
    }
}

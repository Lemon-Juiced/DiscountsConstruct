package lemon_juice.discounts_construct.utilities;

import lemon_juice.discounts_construct.DiscountsConstruct;
import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.tools.ModSwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class UtilityLogger {

    public static void outputItems(){
        ArrayList<String> buffer = new ArrayList<>();

        for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) {
                String itemID = String.valueOf(item.getId());
                String itemName = itemID.substring(itemID.indexOf(':')+1);

                buffer.add("\"item.discounts_construct." + itemName + "\": \"" + "\"");
        }

        for (int i = 0; i < buffer.size(); i++) {
            DiscountsConstruct.LOGGER.info(buffer.get(i));
        }
    }
}

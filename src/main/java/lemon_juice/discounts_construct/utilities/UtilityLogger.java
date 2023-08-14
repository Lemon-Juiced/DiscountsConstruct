package lemon_juice.discounts_construct.utilities;

import lemon_juice.discounts_construct.DiscountsConstruct;
import lemon_juice.discounts_construct.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class UtilityLogger {

    public static void outputItems(){
        ArrayList<String> buffer = new ArrayList<>();

        for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) {
            String itemID = String.valueOf(item.getId());
            String itemName = itemID.substring(itemID.indexOf(':')+1);

            String[] parts = itemName.split("_");
            String secondarySection = "";
            for (int i = 0; i < parts.length; i++) {
                if(i == parts.length - 1) secondarySection += getToolName(parts[i]);
                else {
                    secondarySection += getMaterialName(parts[i]);
                    if(i != parts.length - 2) secondarySection += "-";
                    else secondarySection += " ";
                }
            }

            buffer.add("\"item.discounts_construct." + itemName + "\": \"" + secondarySection + "\"");
        }

        for (int i = 0; i < buffer.size(); i++) {
            DiscountsConstruct.LOGGER.info(buffer.get(i));
        }
    }

    public static String getMaterialName(String string){
        switch (string) {
            case "diamond" -> {
                return "Diamond";
            }
            case "gold" -> {
                return "Gold";
            }
            case "iron" -> {
                return "Iron";
            }
            case "netherite" -> {
                return "Netherite";
            }
            case "stone" -> {
                return "Stone";
            }
            case "wood" -> {
                return "Wood";
            }
            default -> {
                return "";
            }
        }
    }

    public static String getToolName(String string){
        switch (string) {
            case "sword" -> {
                return "Sword";
            }
            case "hoe" -> {
                return "Hoe";
            }
            case "axe" -> {
                return "Axe";
            }
            case "pickaxe" -> {
                return "Pickaxe";
            }
        }
        return string; //Should be unreachable
    }
}

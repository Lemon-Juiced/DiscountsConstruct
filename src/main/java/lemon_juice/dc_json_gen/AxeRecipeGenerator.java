package lemon_juice.dc_json_gen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class AxeRecipeGenerator {
    public static String[] TIERS = {"netherite", "diamond", "iron", "stone", "gold", "wood"};

    public static void main(String[] args){

        try{
            for (int i = 0; i < TIERS.length; i++) {
                for (int j = 0; j < TIERS.length; j++) {
                    for (int k = 0; k < TIERS.length; k++) {
                        File file = new File(generateRecipeName(TIERS[i], TIERS[j], TIERS[k]));

                        if(!file.exists()) file.createNewFile();

                        PrintWriter writer = new PrintWriter(file);

                        writer.println("{");
                        writer.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer.println("    \"pattern\": [");
                        writer.println("        \"ij\",");
                        writer.println("        \"k/\",");
                        writer.println("        \" /\"");
                        writer.println("    ],");
                        writer.println("    \"key\": {");
                        writer.println("        \"i\": {");
                        writer.println(getResourceLine(TIERS[i]));
                        writer.println("        },");
                        writer.println("        \"j\": {");
                        writer.println(getResourceLine(TIERS[j]));
                        writer.println("        },");
                        writer.println("        \"k\": {");
                        writer.println(getResourceLine(TIERS[k]));
                        writer.println("        },");
                        writer.println("        \"/\": {");
                        writer.println("            \"item\": \"minecraft:stick\"");
                        writer.println("        }");
                        writer.println("    },");
                        writer.println("    \"result\": {");
                        writer.println("    \"item\": \"" + getOutputLine(TIERS[i], TIERS[j], TIERS[k]) + "\"");
                        writer.println("    }");
                        writer.println("}");

                        writer.close();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a recipe name
     *
     * @param tier1 The first tier
     * @param tier2 The second tier
     * @param tier3 The third tier
     * @return The recipe name
     */
    public static String generateRecipeName(String tier1, String tier2, String tier3){
        String recipeName = "";

        recipeName += tier1 + "_";
        recipeName += tier2 + "_";
        recipeName += tier3;

        recipeName += "_axe.json";
        return recipeName;
    }

    /**
     * Gets the specific line for a given tier
     *
     * @param tier
     * @return
     */
    public static String getResourceLine(String tier){
        String itemLine = "         \"item\": ";
        String tagLine = "          \"tag\": ";

        if(tier.equals("netherite")) return itemLine + "\"minecraft:netherite_ingot\"";
        else if(tier.equals("diamond")) return itemLine + "\"minecraft:diamond\"";
        else if(tier.equals("iron")) return itemLine + "\"minecraft:iron_ingot\"";
        else if(tier.equals("stone")) return tagLine + "\"minecraft:stone_tool_materials\"";
        else if(tier.equals("gold")) return itemLine + "\"minecraft:gold_ingot\"";
        else return tagLine + "\"minecraft:planks\"";
    }

    public static String getOutputLine(String tier1, String tier2, String tier3){
        return "discounts_construct:" + tier1 + "_" + tier2 + "_" +  tier3 + "_axe";
    }
}

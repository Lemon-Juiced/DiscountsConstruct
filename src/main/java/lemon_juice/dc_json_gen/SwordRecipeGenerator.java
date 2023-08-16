package lemon_juice.dc_json_gen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SwordRecipeGenerator {
    public static String[] TIERS = {"netherite", "diamond", "iron", "stone", "gold", "wood"};

    public static void main(String[] args){

        try{
            for (int i = 0; i < TIERS.length; i++) {
                for (int j = 0; j < TIERS.length; j++) {
                        File file1 = new File(generateRecipeName(TIERS[i], TIERS[j], 1));
                        File file2 = new File(generateRecipeName(TIERS[i], TIERS[j], 2));

                        if(TIERS[i] != TIERS[j] && !(j <= i)){
                            if(!file1.exists()) file1.createNewFile();

                            PrintWriter writer1 = new PrintWriter(file1);

                            writer1.println("{");
                            writer1.println("    \"type\": \"minecraft:crafting_shaped\",");
                            writer1.println("    \"pattern\": [");
                            writer1.println("        \"i\",");
                            writer1.println("        \"j\",");
                            writer1.println("        \"/\"");
                            writer1.println("    ],");
                            writer1.println("    \"key\": {");
                            writer1.println("        \"i\": {");
                            writer1.println(getResourceLine(TIERS[i]));
                            writer1.println("        },");
                            writer1.println("        \"j\": {");
                            writer1.println(getResourceLine(TIERS[j]));
                            writer1.println("        },");
                            writer1.println("        \"/\": {");
                            writer1.println("            \"item\": \"minecraft:stick\"");
                            writer1.println("        }");
                            writer1.println("    },");
                            writer1.println("    \"result\": {");
                            writer1.println("    \"item\": \"" + getOutputLine(TIERS[i], TIERS[j]) + "\"");
                            writer1.println("    }");
                            writer1.println("}");

                            writer1.close();

                            if(!file2.exists()) file2.createNewFile();

                            PrintWriter writer2 = new PrintWriter(file2);

                            writer2.println("{");
                            writer2.println("    \"type\": \"minecraft:crafting_shaped\",");
                            writer2.println("    \"pattern\": [");
                            writer2.println("        \"i\",");
                            writer2.println("        \"j\",");
                            writer2.println("        \"/\"");
                            writer2.println("    ],");
                            writer2.println("    \"key\": {");
                            writer2.println("        \"i\": {");
                            writer2.println(getResourceLine(TIERS[j]));
                            writer2.println("        },");
                            writer2.println("        \"j\": {");
                            writer2.println(getResourceLine(TIERS[i]));
                            writer2.println("        },");
                            writer2.println("        \"/\": {");
                            writer2.println("            \"item\": \"minecraft:stick\"");
                            writer2.println("        }");
                            writer2.println("    },");
                            writer2.println("    \"result\": {");
                            writer2.println("    \"item\": \"" + getOutputLine(TIERS[i], TIERS[j]) + "\"");
                            writer2.println("    }");
                            writer2.println("}");

                            writer2.close();
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
     * @param count The number of the file
     * @return The recipe name
     */
    public static String generateRecipeName(String tier1, String tier2, int count){
        String recipeName = "src/main/resources/data/discounts_construct/recipes/swords/";

        recipeName += tier1 + "_";
        recipeName += tier2;

        recipeName += "_sword_" + count + ".json";
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

    public static String getOutputLine(String tier1, String tier2){
        return "discounts_construct:" + tier1 + "_" + tier2 + "_sword";
    }
}

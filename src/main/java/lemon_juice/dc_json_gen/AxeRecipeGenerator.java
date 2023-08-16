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
                        String tier1 = TIERS[i], tier2 = TIERS[j], tier3 = TIERS[k];
                        File file1 = new File(generateRecipeName(tier1, tier2, tier3, 1));
                        File file2 = new File(generateRecipeName(tier1, tier2, tier3, 2));
                        File file3 = new File(generateRecipeName(tier1, tier2, tier3, 3));
                        File file4 = new File(generateRecipeName(tier1, tier2, tier3, 4));
                        File file5 = new File(generateRecipeName(tier1, tier2, tier3, 5));
                        File file6 = new File(generateRecipeName(tier1, tier2, tier3, 6));

                        if (!file1.exists()) file1.createNewFile();
                        PrintWriter writer1 = new PrintWriter(file1);
                        writer1.println("{");
                        writer1.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer1.println("    \"pattern\": [");
                        writer1.println("        \"ij\",");
                        writer1.println("        \"k/\",");
                        writer1.println("        \" /\"");
                        writer1.println("    ],");
                        writer1.println("    \"key\": {");
                        writer1.println("        \"i\": {");
                        writer1.println(getResourceLine(tier1));
                        writer1.println("        },");
                        writer1.println("        \"j\": {");
                        writer1.println(getResourceLine(tier2));
                        writer1.println("        },");
                        writer1.println("        \"k\": {");
                        writer1.println(getResourceLine(tier3));
                        writer1.println("        },");
                        writer1.println("        \"/\": {");
                        writer1.println("            \"item\": \"minecraft:stick\"");
                        writer1.println("        }");
                        writer1.println("    },");
                        writer1.println("    \"result\": {");
                        writer1.println("    \"item\": \"" + getOutputLine(tier1, tier2, tier3) + "\"");
                        writer1.println("    }");
                        writer1.println("}");
                        writer1.close();

                        if (!file2.exists()) file2.createNewFile();
                        PrintWriter writer2 = new PrintWriter(file2);
                        writer2.println("{");
                        writer2.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer2.println("    \"pattern\": [");
                        writer2.println("        \"ij\",");
                        writer2.println("        \"k/\",");
                        writer2.println("        \" /\"");
                        writer2.println("    ],");
                        writer2.println("    \"key\": {");
                        writer2.println("        \"i\": {");
                        writer2.println(getResourceLine(tier1));
                        writer2.println("        },");
                        writer2.println("        \"j\": {");
                        writer2.println(getResourceLine(tier3));
                        writer2.println("        },");
                        writer2.println("        \"k\": {");
                        writer2.println(getResourceLine(tier2));
                        writer2.println("        },");
                        writer2.println("        \"/\": {");
                        writer2.println("            \"item\": \"minecraft:stick\"");
                        writer2.println("        }");
                        writer2.println("    },");
                        writer2.println("    \"result\": {");
                        writer2.println("    \"item\": \"" + getOutputLine(tier1, tier2, tier3) + "\"");
                        writer2.println("    }");
                        writer2.println("}");
                        writer2.close();

                        if (!file3.exists()) file3.createNewFile();
                        PrintWriter writer3 = new PrintWriter(file3);
                        writer3.println("{");
                        writer3.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer3.println("    \"pattern\": [");
                        writer3.println("        \"ij\",");
                        writer3.println("        \"k/\",");
                        writer3.println("        \" /\"");
                        writer3.println("    ],");
                        writer3.println("    \"key\": {");
                        writer3.println("        \"i\": {");
                        writer3.println(getResourceLine(tier2));
                        writer3.println("        },");
                        writer3.println("        \"j\": {");
                        writer3.println(getResourceLine(tier1));
                        writer3.println("        },");
                        writer3.println("        \"k\": {");
                        writer3.println(getResourceLine(tier3));
                        writer3.println("        },");
                        writer3.println("        \"/\": {");
                        writer3.println("            \"item\": \"minecraft:stick\"");
                        writer3.println("        }");
                        writer3.println("    },");
                        writer3.println("    \"result\": {");
                        writer3.println("    \"item\": \"" + getOutputLine(tier1, tier2, tier3) + "\"");
                        writer3.println("    }");
                        writer3.println("}");
                        writer3.close();

                        if (!file4.exists()) file4.createNewFile();
                        PrintWriter writer4 = new PrintWriter(file4);
                        writer4.println("{");
                        writer4.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer4.println("    \"pattern\": [");
                        writer4.println("        \"ij\",");
                        writer4.println("        \"k/\",");
                        writer4.println("        \" /\"");
                        writer4.println("    ],");
                        writer4.println("    \"key\": {");
                        writer4.println("        \"i\": {");
                        writer4.println(getResourceLine(tier2));
                        writer4.println("        },");
                        writer4.println("        \"j\": {");
                        writer4.println(getResourceLine(tier3));
                        writer4.println("        },");
                        writer4.println("        \"k\": {");
                        writer4.println(getResourceLine(tier1));
                        writer4.println("        },");
                        writer4.println("        \"/\": {");
                        writer4.println("            \"item\": \"minecraft:stick\"");
                        writer4.println("        }");
                        writer4.println("    },");
                        writer4.println("    \"result\": {");
                        writer4.println("    \"item\": \"" + getOutputLine(tier1, tier2, tier3) + "\"");
                        writer4.println("    }");
                        writer4.println("}");
                        writer4.close();

                        if (!file5.exists()) file5.createNewFile();
                        PrintWriter writer5 = new PrintWriter(file5);
                        writer5.println("{");
                        writer5.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer5.println("    \"pattern\": [");
                        writer5.println("        \"ij\",");
                        writer5.println("        \"k/\",");
                        writer5.println("        \" /\"");
                        writer5.println("    ],");
                        writer5.println("    \"key\": {");
                        writer5.println("        \"i\": {");
                        writer5.println(getResourceLine(tier3));
                        writer5.println("        },");
                        writer5.println("        \"j\": {");
                        writer5.println(getResourceLine(tier1));
                        writer5.println("        },");
                        writer5.println("        \"k\": {");
                        writer5.println(getResourceLine(tier2));
                        writer5.println("        },");
                        writer5.println("        \"/\": {");
                        writer5.println("            \"item\": \"minecraft:stick\"");
                        writer5.println("        }");
                        writer5.println("    },");
                        writer5.println("    \"result\": {");
                        writer5.println("    \"item\": \"" + getOutputLine(tier1, tier2, tier3) + "\"");
                        writer5.println("    }");
                        writer5.println("}");
                        writer5.close();

                        if (!file6.exists()) file6.createNewFile();
                        PrintWriter writer6 = new PrintWriter(file6);
                        writer6.println("{");
                        writer6.println("    \"type\": \"minecraft:crafting_shaped\",");
                        writer6.println("    \"pattern\": [");
                        writer6.println("        \"ij\",");
                        writer6.println("        \"k/\",");
                        writer6.println("        \" /\"");
                        writer6.println("    ],");
                        writer6.println("    \"key\": {");
                        writer6.println("        \"i\": {");
                        writer6.println(getResourceLine(tier3));
                        writer6.println("        },");
                        writer6.println("        \"j\": {");
                        writer6.println(getResourceLine(tier2));
                        writer6.println("        },");
                        writer6.println("        \"k\": {");
                        writer6.println(getResourceLine(tier1));
                        writer6.println("        },");
                        writer6.println("        \"/\": {");
                        writer6.println("            \"item\": \"minecraft:stick\"");
                        writer6.println("        }");
                        writer6.println("    },");
                        writer6.println("    \"result\": {");
                        writer6.println("    \"item\": \"" + getOutputLine(tier1, tier2, tier3) + "\"");
                        writer6.println("    }");
                        writer6.println("}");
                        writer6.close();
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
     * @param count The number of the file
     * @return The recipe name
     */
    public static String generateRecipeName(String tier1, String tier2, String tier3, int count){
        String recipeName = "src/main/resources/data/discounts_construct/recipes/axes/";

        recipeName += tier1 + "_";
        recipeName += tier2 + "_";
        recipeName += tier3;

        recipeName += "_axe_" + count + ".json";
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

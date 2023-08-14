package lemon_juice.discounts_construct.item.custom.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;

public class TierGenerator {

    /**
     * Creates a tier for a specific item
     *
     * @param tier1 The first tier to use as a reference
     * @param tier2 The first tier to use as a reference
     * @return The tier for a specific item
     */
    public static Tier generateTier(Tier tier1, Tier tier2){
        int level = Math.max(tier1.getLevel(), tier2.getLevel());
        int uses = (tier1.getUses()/2) + (tier2.getUses()/2);
        float speed = Math.max(tier1.getSpeed(), tier2.getSpeed());
        float damage = Math.max(tier1.getAttackDamageBonus(), tier2.getAttackDamageBonus());
        int enchantmentValue = Math.max(tier1.getEnchantmentValue(), tier2.getEnchantmentValue());

        Tier generatedTier = new ForgeTier(level, uses, speed, damage, enchantmentValue, getBlockTag(tier1, tier2),
                () -> getRepairIngredientItem(tier1, tier2));

        return generatedTier;
    }

    public static TagKey<Block> getBlockTag(Tier tier1, Tier tier2){
        // Determine what the tiers are
        // Uses durability as it is different for all tiers
        String ingredient1 = switch (tier1.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };

        String ingredient2 = switch (tier2.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };

        // Return the better of the two
        if(ingredient1.equals("netherite") || ingredient2.equals("netherite")) return BlockTags.NEEDS_DIAMOND_TOOL;
        else if(ingredient1.equals("diamond") || ingredient2.equals("diamond")) return BlockTags.NEEDS_DIAMOND_TOOL;
        else if(ingredient1.equals("gold") || ingredient2.equals("gold")) return BlockTags.SWORD_EFFICIENT; // This is temporary
        else if(ingredient1.equals("iron") || ingredient2.equals("iron")) return BlockTags.NEEDS_IRON_TOOL;
        else if(ingredient1.equals("stone") || ingredient2.equals("stone")) return BlockTags.NEEDS_STONE_TOOL;
        else return BlockTags.SWORD_EFFICIENT;// This is temporary
    }

    public static Ingredient getRepairIngredientItem(Tier tier1, Tier tier2){
        // Determine what the repair ingredients of the other two are
        // Uses durability as it is different for all tiers
        String ingredient1 = switch (tier1.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };

        String ingredient2 = switch (tier2.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };

        // Return the more expensive of the two
        if(ingredient1.equals("netherite") || ingredient2.equals("netherite")) return Tiers.NETHERITE.getRepairIngredient();
        else if(ingredient1.equals("diamond") || ingredient2.equals("diamond")) return Tiers.DIAMOND.getRepairIngredient();
        else if(ingredient1.equals("gold") || ingredient2.equals("gold")) return Tiers.GOLD.getRepairIngredient();
        else if(ingredient1.equals("iron") || ingredient2.equals("iron")) return Tiers.IRON.getRepairIngredient();
        else if(ingredient1.equals("stone") || ingredient2.equals("stone")) return Tiers.STONE.getRepairIngredient();
        else return Tiers.WOOD.getRepairIngredient();
    }
}

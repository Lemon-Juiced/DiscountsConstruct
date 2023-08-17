package lemon_juice.discounts_construct.item.custom.tier;

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
     * @param tier2 The second tier to use as a reference
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

    /**
     * Creates a tier for a specific item
     *
     * @param tier1 The first tier to use as a reference
     * @param tier2 The second tier to use as a reference
     * @param tier3 The third tier to use as a reference
     * @return The tier for a specific item
     */
    public static Tier generateTier(Tier tier1, Tier tier2, Tier tier3){
        int level = Math.max(Math.max(tier1.getLevel(), tier2.getLevel()), tier3.getLevel());
        int uses = (tier1.getUses()/3) + (tier2.getUses()/3) + (tier3.getUses()/3);
        float speed = Math.max(Math.max(tier1.getSpeed(), tier2.getSpeed()), tier3.getSpeed());
        float damage = Math.max(Math.max(tier1.getAttackDamageBonus(), tier2.getAttackDamageBonus()), tier3.getAttackDamageBonus());
        int enchantmentValue = Math.max(Math.max(tier1.getEnchantmentValue(), tier2.getEnchantmentValue()), tier3.getEnchantmentValue());

        Tier generatedTier = new ForgeTier(level, uses, speed, damage, enchantmentValue, getBlockTag(tier1, tier2, tier3),
                () -> getRepairIngredientItem(tier1, tier2, tier3));

        return generatedTier;
    }

    /**
     * Creates a tier for specifically axes
     *
     * @param tier1 The first tier to use as a reference
     * @param tier2 The second tier to use as a reference
     * @param tier3 The third tier to use as a reference
     * @return The tier for a specific item
     */
    public static Tier generateAxeTier(Tier tier1, Tier tier2, Tier tier3){
        int level = Math.max(Math.max(tier1.getLevel(), tier2.getLevel()), tier3.getLevel());
        int uses = (tier1.getUses()/3) + (tier2.getUses()/3) + (tier3.getUses()/3);
        float speed = Math.max(Math.max(tier1.getSpeed(), tier2.getSpeed()), tier3.getSpeed());

        int tier1DamageModifier = 0;
        int tier2DamageModifier = 0;
        int tier3DamageModifier = 0;
        if(tier1 == Tiers.NETHERITE || tier1 == Tiers.DIAMOND) tier1DamageModifier--;
        if(tier2 == Tiers.NETHERITE || tier2 == Tiers.DIAMOND) tier2DamageModifier--;
        if(tier3 == Tiers.NETHERITE || tier3 == Tiers.DIAMOND) tier3DamageModifier--;

        float damage = Math.max(Math.max(tier1.getAttackDamageBonus() + tier1DamageModifier, tier2.getAttackDamageBonus() + tier2DamageModifier), tier3.getAttackDamageBonus() + tier3DamageModifier);
        int enchantmentValue = Math.max(Math.max(tier1.getEnchantmentValue(), tier2.getEnchantmentValue()), tier3.getEnchantmentValue());

        Tier generatedTier = new ForgeTier(level, uses, speed, damage, enchantmentValue, getBlockTag(tier1, tier2, tier3),
                () -> getRepairIngredientItem(tier1, tier2, tier3));

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

    public static TagKey<Block> getBlockTag(Tier tier1, Tier tier2, Tier tier3){
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

        String ingredient3 = switch (tier3.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };

        // Return the better of the two
        if(ingredient1.equals("netherite") || ingredient2.equals("netherite") || ingredient3.equals("netherite")) return BlockTags.NEEDS_DIAMOND_TOOL;
        else if(ingredient1.equals("diamond") || ingredient2.equals("diamond") || ingredient3.equals("diamond")) return BlockTags.NEEDS_DIAMOND_TOOL;
        else if(ingredient1.equals("gold") || ingredient2.equals("gold") || ingredient3.equals("gold")) return BlockTags.SWORD_EFFICIENT; // This is temporary
        else if(ingredient1.equals("iron") || ingredient2.equals("iron") || ingredient3.equals("iron")) return BlockTags.NEEDS_IRON_TOOL;
        else if(ingredient1.equals("stone") || ingredient2.equals("stone") || ingredient3.equals("stone")) return BlockTags.NEEDS_STONE_TOOL;
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

    public static Ingredient getRepairIngredientItem(Tier tier1, Tier tier2, Tier tier3){
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

        String ingredient3 = switch (tier3.getUses()) {
            case 59 -> "wood";
            case 131 -> "stone";
            case 250 -> "iron";
            case 1561 -> "diamond";
            case 2031 -> "netherite";
            default -> "gold";
        };

        // Return the more expensive of the two
        if(ingredient1.equals("netherite") || ingredient2.equals("netherite") || ingredient3.equals("netherite")) return Tiers.NETHERITE.getRepairIngredient();
        else if(ingredient1.equals("diamond") || ingredient2.equals("diamond") || ingredient3.equals("diamond")) return Tiers.DIAMOND.getRepairIngredient();
        else if(ingredient1.equals("gold") || ingredient2.equals("gold") || ingredient3.equals("gold")) return Tiers.GOLD.getRepairIngredient();
        else if(ingredient1.equals("iron") || ingredient2.equals("iron") || ingredient3.equals("iron")) return Tiers.IRON.getRepairIngredient();
        else if(ingredient1.equals("stone") || ingredient2.equals("stone") || ingredient3.equals("stone")) return Tiers.STONE.getRepairIngredient();
        else return Tiers.WOOD.getRepairIngredient();
    }
}

package lemon_juice.discounts_construct.item.custom.register;

import lemon_juice.discounts_construct.item.custom.register.tools.HoeRegister;
import lemon_juice.discounts_construct.item.custom.register.tools.SwordRegister;
import lemon_juice.discounts_construct.item.custom.register.util.TierPair;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

import java.util.ArrayList;

public class MainToolRegister {
    public static Tier[] TIERS = {Tiers.DIAMOND, Tiers.GOLD, Tiers.IRON, Tiers.NETHERITE, Tiers.STONE, Tiers.WOOD};
    public static ArrayList<TierPair> ALL_TIER_PAIRS = new ArrayList<>();

    public static void generateAllTierPairs(){
        for (int i = 0; i < TIERS.length; i++) {
            for (int j = 0; j < TIERS.length; j++) {
                // If the tier isn't the same and another permutation of this tier doesn't already exist
                if(TIERS[i] != TIERS[j] && !(j <= i)){
                    ALL_TIER_PAIRS.add(new TierPair(TIERS[i], TIERS[j]));
                }
            }
        }
    }

    public static void registerAllTools(){
        // Generate all TierPairs
        generateAllTierPairs();

        // Swords and Hoes
        SwordRegister.registerAllSwords();
        HoeRegister.registerAllHoes();

        //Generate all TierTriplets

        // Pickaxes and Axes

    }
}

package lemon_juice.discounts_construct.item.custom.register;

import lemon_juice.discounts_construct.item.custom.register.tools.AxeRegister;
import lemon_juice.discounts_construct.item.custom.register.tools.HoeRegister;
import lemon_juice.discounts_construct.item.custom.register.tools.PickaxeRegister;
import lemon_juice.discounts_construct.item.custom.register.tools.SwordRegister;
import lemon_juice.discounts_construct.item.custom.register.util.TierPair;
import lemon_juice.discounts_construct.item.custom.register.util.TierTriplet;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

import java.util.ArrayList;

public class MainToolRegister {
    public static Tier[] TIERS = {Tiers.DIAMOND, Tiers.GOLD, Tiers.IRON, Tiers.NETHERITE, Tiers.STONE, Tiers.WOOD};
    public static ArrayList<TierPair> ALL_TIER_PAIRS = new ArrayList<>();
    public static ArrayList<TierTriplet> ALL_TIER_TRIPLETS = new ArrayList<>();

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

    public static void generateAllTierTriplets(){
        for (int i = 0; i < TIERS.length; i++) {
            for (int j = 0; j < TIERS.length; j++) {
                for (int k = 0; k < TIERS.length; k++) {
                    // If the tier isn't 3 of the same
                    if(TIERS[i] != TIERS[j] && TIERS[i] != TIERS[k]){
                        // If another permutation of this tier doesn't already exist
                        if(!(k <= i) && !(j <= i)){ //This is almost correct (its missing the 112 cases)
                            ALL_TIER_TRIPLETS.add(new TierTriplet(TIERS[i], TIERS[j], TIERS[k]));
                        }
                    }
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
        generateAllTierTriplets();

        // Pickaxes and Axes
        PickaxeRegister.registerAllPickaxes();
        AxeRegister.registerAllAxes();
    }
}

package lemon_juice.discounts_construct.item.custom.register;

import lemon_juice.discounts_construct.item.custom.register.tool.AxeRegister;
import lemon_juice.discounts_construct.item.custom.register.tool.HoeRegister;
import lemon_juice.discounts_construct.item.custom.register.tool.PickaxeRegister;
import lemon_juice.discounts_construct.item.custom.register.tool.SwordRegister;
import lemon_juice.discounts_construct.item.custom.register.util.TierPair;
import lemon_juice.discounts_construct.item.custom.register.util.TierTriplet;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class MainToolRegister {
    public static Tier[] TIERS = {Tiers.NETHERITE, Tiers.DIAMOND, Tiers.IRON, Tiers.STONE, Tiers.GOLD, Tiers.WOOD};
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
        // Case 1: All Different Tiers
        for (int i = 0; i < TIERS.length; i++) {
            for (int j = 0; j < TIERS.length; j++) {
                for (int k = 0; k < TIERS.length; k++) {
                    // Make sure all 3 are indeed different tiers
                    Tier tier1 = TIERS[i];
                    Tier tier2 = TIERS[j];
                    Tier tier3 = TIERS[k];

                    if(tier1 == tier2 || tier1 == tier3 || tier2 == tier3) break;

                    // Make sure all 3 tiers are in the correct order
                    String tier1Name = getTierName(tier1);
                    String tier2Name = getTierName(tier2);
                    String tier3Name = getTierName(tier3);

                    ArrayList<String> organizedTierNames = new ArrayList<>();

                    if(tier1Name.equals("netherite")) organizedTierNames.add("netherite");
                    if(tier2Name.equals("netherite")) organizedTierNames.add("netherite");
                    if(tier3Name.equals("netherite")) organizedTierNames.add("netherite");

                    if(tier1Name.equals("diamond")) organizedTierNames.add("diamond");
                    if(tier2Name.equals("diamond")) organizedTierNames.add("diamond");
                    if(tier3Name.equals("diamond")) organizedTierNames.add("diamond");

                    if(tier1Name.equals("iron")) organizedTierNames.add("iron");
                    if(tier2Name.equals("iron")) organizedTierNames.add("iron");
                    if(tier3Name.equals("iron")) organizedTierNames.add("iron");

                    if(tier1Name.equals("stone")) organizedTierNames.add("stone");
                    if(tier2Name.equals("stone")) organizedTierNames.add("stone");
                    if(tier3Name.equals("stone")) organizedTierNames.add("stone");

                    if(tier1Name.equals("gold")) organizedTierNames.add("gold");
                    if(tier2Name.equals("gold")) organizedTierNames.add("gold");
                    if(tier3Name.equals("gold")) organizedTierNames.add("gold");

                    if(tier1Name.equals("wood")) organizedTierNames.add("wood");
                    if(tier2Name.equals("wood")) organizedTierNames.add("wood");
                    if(tier3Name.equals("wood")) organizedTierNames.add("wood");

                    // Convert to TierTriplet
                    Tier t1 = getTierFromName(organizedTierNames.get(0));
                    Tier t2 = getTierFromName(organizedTierNames.get(1));
                    Tier t3 = getTierFromName(organizedTierNames.get(2));

                    TierTriplet tierTriplet = new TierTriplet(t1, t2, t3);

                    // Check to make sure what we have isn't a duplicate
                    boolean duplicate = false;
                    if(!ALL_TIER_TRIPLETS.isEmpty()) {
                        for (int l = 0; l < ALL_TIER_TRIPLETS.size(); l++) {
                            if(tierTriplet.getTier1() == ALL_TIER_TRIPLETS.get(l).getTier1()){
                                if(tierTriplet.getTier2() == ALL_TIER_TRIPLETS.get(l).getTier2()){
                                    if(tierTriplet.getTier3() == ALL_TIER_TRIPLETS.get(l).getTier3()){
                                        duplicate = true;
                                    }
                                }
                            }
                        }
                    }

                    // Add to ALL_TIER_TRIPLETS
                    if(!duplicate){
                        ALL_TIER_TRIPLETS.add(tierTriplet);
                    }
                }
            }
        }

        // Case 2: Two Different Tiers (But Only In Form tier1_tier1_tier2)







        /*
        for (int i = 0; i < TIERS.length; i++) {
            for (int j = 0; j < TIERS.length; j++) {
                for (int k = 0; k < TIERS.length; k++) {
                    // If all three aren't the same
                    if(!(TIERS[i] == TIERS[j] && TIERS[i] == TIERS[k])){
                        // At this point: i could equal j, i could equal k, j could equal k (but not all at once)

                        // Easiest case (3 different tiers)
                        if(TIERS[i] != TIERS[j] && TIERS[i] != TIERS[k] && TIERS[j] != TIERS[k]){
                            // Ensure this isn't a duplicate of a previously listed entry
                            // searchTripletsForDuplicates returns true if it is a duplicate
                            if(!searchTripletsForDuplicates(TIERS[i], TIERS[j], TIERS[k]))
                                ALL_TIER_TRIPLETS.add(new TierTriplet(TIERS[i], TIERS[j], TIERS[k]));
                        }

                        // Cases where only 2 different tiers are involved
                        // Order 1: tier1-tier1-tier2
                        if(TIERS[i] == TIERS[j] && TIERS[i] != TIERS[k]){
                            // Ensure this isn't a duplicate of a previously listed entry
                            // searchTripletsForDuplicates returns true if it is a duplicate
                            if(!searchTripletsForDuplicates(TIERS[i], TIERS[j], TIERS[k]))
                                ALL_TIER_TRIPLETS.add(new TierTriplet(TIERS[i], TIERS[j], TIERS[k]));
                        }
                        // Order 2: tier1-tier2-tier1 - Skip
                        // Order 3: tier2-tier1-tier1 - Skip
                    }

                    /*
                    // Isn't 100% Perfect Doesn't Recognize tier1-tier1-tier2 = tier2-tier1-tier1
                    // The second case below misses tier1-tier1-tier2 cases (this accounts for them)
                    // If the first two are the same, just loop on the final one
                    if(TIERS[i] == TIERS[j] && TIERS[i] != TIERS[k]){
                        ALL_TIER_TRIPLETS.add(new TierTriplet(TIERS[i], TIERS[j], TIERS[k]));
                    }

                    // If the tier isn't 3 of the same
                    if(TIERS[i] != TIERS[j] && TIERS[i] != TIERS[k]){

                        //This is almost correct (its misses the tier1-tier1-tier2 cases)
                        // If another permutation of this tier doesn't already exist
                        if(!(k <= i) && !(j <= i)){
                            if(j != k) //Filters out tier2-tier2-tier1
                                ALL_TIER_TRIPLETS.add(new TierTriplet(TIERS[i], TIERS[j], TIERS[k]));
                        }
                    }
                }
            }
        }
        */
    }

    /**
     * Determines if 3 tiers are already in the ALL_TIER_TRIPLETS ArrayList
     *
     * @param tier1 The first tier
     * @param tier2 The second tier
     * @param tier3 The third tier
     * @return true if there is a duplicate, false otherwise
     */
    public static boolean searchTripletsForDuplicates(Tier tier1, Tier tier2, Tier tier3){
        // First organize the tiers into the form they would have in the ALL_TIER_TRIPLETS ArrayList
        ArrayList<Tier> organizedTierList = new ArrayList<>();

        // Add the tiers to the list in order
        if(getTierName(tier1).equals("netherite")) organizedTierList.add(Tiers.NETHERITE);
        if(getTierName(tier2).equals("netherite")) organizedTierList.add(Tiers.NETHERITE);
        if(getTierName(tier3).equals("netherite")) organizedTierList.add(Tiers.NETHERITE);

        if(getTierName(tier1).equals("diamond")) organizedTierList.add(Tiers.DIAMOND);
        if(getTierName(tier2).equals("diamond")) organizedTierList.add(Tiers.DIAMOND);
        if(getTierName(tier3).equals("diamond")) organizedTierList.add(Tiers.DIAMOND);

        if(getTierName(tier1).equals("iron")) organizedTierList.add(Tiers.IRON);
        if(getTierName(tier2).equals("iron")) organizedTierList.add(Tiers.IRON);
        if(getTierName(tier3).equals("iron")) organizedTierList.add(Tiers.IRON);

        if(getTierName(tier1).equals("stone")) organizedTierList.add(Tiers.STONE);
        if(getTierName(tier2).equals("stone")) organizedTierList.add(Tiers.STONE);
        if(getTierName(tier3).equals("stone")) organizedTierList.add(Tiers.STONE);

        if(getTierName(tier1).equals("gold")) organizedTierList.add(Tiers.GOLD);
        if(getTierName(tier2).equals("gold")) organizedTierList.add(Tiers.GOLD);
        if(getTierName(tier3).equals("gold")) organizedTierList.add(Tiers.GOLD);

        if(getTierName(tier1).equals("wood")) organizedTierList.add(Tiers.WOOD);
        if(getTierName(tier2).equals("wood")) organizedTierList.add(Tiers.WOOD);
        if(getTierName(tier3).equals("wood")) organizedTierList.add(Tiers.WOOD);

        // Turns the organizedTierList into the tierTriplet itself
        TierTriplet tierTriplet = new TierTriplet(organizedTierList.get(0), organizedTierList.get(1), organizedTierList.get(2));

        // Returns true if it is a duplicate, false otherwise
        for (int i = 0; i < ALL_TIER_TRIPLETS.size(); i++) {
            if(tierTriplet == ALL_TIER_TRIPLETS.get(i)) return true;
        }

        return false;
    }

    public static String getTierName(Tier tier){
        int durability = tier.getUses();
        if(durability == 59) return "wood";
        else if(durability == 131) return "stone";
        else if(durability == 250) return "iron";
        else if(durability == 1561) return "diamond";
        else if(durability == 2031) return "netherite";
        else return "gold";
    }

    public static Tier getTierFromName(String name){
        if(name.equals("wood")) return Tiers.WOOD;
        else if(name.equals("stone")) return Tiers.STONE;
        else if(name.equals("iron")) return Tiers.IRON;
        else if(name.equals("diamond")) return Tiers.DIAMOND;
        else if(name.equals("netherite")) return Tiers.NETHERITE;
        else return Tiers.GOLD;
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

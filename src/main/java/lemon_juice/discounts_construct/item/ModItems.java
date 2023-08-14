package lemon_juice.discounts_construct.item;

import lemon_juice.discounts_construct.DiscountsConstruct;
import lemon_juice.discounts_construct.item.custom.register.MainToolRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DiscountsConstruct.MOD_ID);

    public static void register(IEventBus eventBus){
        MainToolRegister.registerAllTools();

        ITEMS.register(eventBus);
    }
}

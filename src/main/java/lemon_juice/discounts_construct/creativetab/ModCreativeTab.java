package lemon_juice.discounts_construct.creativetab;

import lemon_juice.discounts_construct.DiscountsConstruct;
import lemon_juice.discounts_construct.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static lemon_juice.discounts_construct.creativetab.util.CreativeTabUtils.getFirstItem;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DiscountsConstruct.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DISCOUNTS_CONSTRUCT_TAB = CREATIVE_MODE_TABS.register("discounts_construct", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.discounts_construct"))
            .icon(() -> new ItemStack(getFirstItem()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == DISCOUNTS_CONSTRUCT_TAB.get()) {
            for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) if(item.get() instanceof SwordItem) event.accept(item.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

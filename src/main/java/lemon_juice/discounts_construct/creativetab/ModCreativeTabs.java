package lemon_juice.discounts_construct.creativetab;

import lemon_juice.discounts_construct.DiscountsConstruct;
import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.item.custom.tool.ModAxeItem;
import lemon_juice.discounts_construct.item.custom.tool.ModHoeItem;
import lemon_juice.discounts_construct.item.custom.tool.ModPickaxeItem;
import lemon_juice.discounts_construct.item.custom.tool.ModSwordItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static lemon_juice.discounts_construct.creativetab.util.CreativeTabUtils.getFirstItem;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DiscountsConstruct.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DISCOUNTS_CONSTRUCT_AXES_TAB = CREATIVE_MODE_TABS.register("discounts_construct_axes", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.discounts_construct_axes"))
            .icon(() -> new ItemStack(getFirstItem("axe")))
            .build());

    public static final RegistryObject<CreativeModeTab> DISCOUNTS_CONSTRUCT_HOES_TAB = CREATIVE_MODE_TABS.register("discounts_construct_hoes", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.discounts_construct_hoes"))
            .icon(() -> new ItemStack(getFirstItem("hoe")))
            .build());

    public static final RegistryObject<CreativeModeTab> DISCOUNTS_CONSTRUCT_PICKAXES_TAB = CREATIVE_MODE_TABS.register("discounts_construct_pickaxes", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.discounts_construct_pickaxes"))
            .icon(() -> new ItemStack(getFirstItem("pickaxe")))
            .build());

    public static final RegistryObject<CreativeModeTab> DISCOUNTS_CONSTRUCT_SWORDS_TAB = CREATIVE_MODE_TABS.register("discounts_construct_swords", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.discounts_construct_swords"))
            .icon(() -> new ItemStack(getFirstItem("sword")))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == DISCOUNTS_CONSTRUCT_AXES_TAB.get()) {
            for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) if(item.get() instanceof ModAxeItem) event.accept(item.get());
        }

        if (event.getTab() == DISCOUNTS_CONSTRUCT_HOES_TAB.get()) {
            for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) if(item.get() instanceof ModHoeItem) event.accept(item.get());
        }

        if (event.getTab() == DISCOUNTS_CONSTRUCT_PICKAXES_TAB.get()) {
            for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) if(item.get() instanceof ModPickaxeItem) event.accept(item.get());
        }

        if (event.getTab() == DISCOUNTS_CONSTRUCT_SWORDS_TAB.get()) {
            for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) if(item.get() instanceof ModSwordItem) event.accept(item.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

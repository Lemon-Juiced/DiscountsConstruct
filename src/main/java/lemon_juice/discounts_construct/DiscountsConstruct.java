package lemon_juice.discounts_construct;

import com.mojang.logging.LogUtils;
import lemon_juice.discounts_construct.creativetab.ModCreativeTabs;
import lemon_juice.discounts_construct.item.ModItems;
import lemon_juice.discounts_construct.utilities.UtilityLogger;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DiscountsConstruct.MOD_ID)
public class DiscountsConstruct {
    public static final String MOD_ID = "discounts_construct";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DiscountsConstruct() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register Items
        ModItems.register(modEventBus);

        // Activate the UtilityLogger (No Longer Really Needed)
        // UtilityLogger.outputItems();

        // Register Creative Tab
        ModCreativeTabs.register(modEventBus);
        modEventBus.addListener(ModCreativeTabs::registerTabs);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}

package mod.author.simplemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.author.simplemod.config.ConfigHolder;
import mod.author.simplemod.init.ModBlocks;
import mod.author.simplemod.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimpleMod.MODID)
public class SimpleMod
{
    // modid 
    public static final String MODID = "simplemod";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public SimpleMod()
    {
        LOGGER.info("Hello from SimpleMod!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        
        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
    } // end SimpleOres()

} // end class SimpleOres

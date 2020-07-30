package mod.author.simplemod.config;

import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
        SimpleModConfig.makeBlockFlame = ConfigHolder.CLIENT.clientMakeBlockFlame.get();
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        // general stuff
        SimpleModConfig.enable_foo = ConfigHolder.SERVER.serverEnableFooOre.get();
        SimpleModConfig.foo_veinsize = ConfigHolder.SERVER.serverFooVeinSize.get();
        SimpleModConfig.foo_cfg = 
                new CountRangeConfig(ConfigHolder.SERVER.serverFooVeinCount.get(),
                        ConfigHolder.SERVER.serverFooBottomHeight.get(),
                        0, ConfigHolder.SERVER.serverFooMaxHeight.get());

        SimpleModConfig.enable_bar = ConfigHolder.SERVER.serverEnableBarOre.get();
        SimpleModConfig.bar_veinsize = ConfigHolder.SERVER.serverBarVeinSize.get();
        SimpleModConfig.bar_cfg = 
                new CountRangeConfig(ConfigHolder.SERVER.serverBarVeinCount.get(),
                        ConfigHolder.SERVER.serverBarBottomHeight.get(),
                        0, ConfigHolder.SERVER.serverBarMaxHeight.get());

        
        // recipe flags.
        SimpleModConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
        
                       
    } // end bakeServer
} // end-class

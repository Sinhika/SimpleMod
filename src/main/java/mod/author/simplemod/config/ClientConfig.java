package mod.author.simplemod.config;

import mod.author.simplemod.SimpleMod;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ClientConfig
{
    final ForgeConfigSpec.BooleanValue clientMakeBlockFlame;
    
    ClientConfig(final ForgeConfigSpec.Builder builder) 
    {
        builder.push("General");
        clientMakeBlockFlame = builder.comment("Hadite Block emits flames")
                .translation(SimpleMod.MODID + "config.MakeBlockFlame")
                .define("MakeBlockFlame", true);
        builder.pop();
    }
} // end-class


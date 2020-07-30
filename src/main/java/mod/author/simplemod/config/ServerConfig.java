package mod.author.simplemod.config;

import mod.author.simplemod.SimpleMod;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    final ForgeConfigSpec.BooleanValue serverEnableRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableFooOre;
    final ForgeConfigSpec.BooleanValue serverEnableBarOre;
    
    // ore generation
    final ForgeConfigSpec.IntValue serverFooVeinSize;
    final ForgeConfigSpec.IntValue serverFooVeinCount;
    final ForgeConfigSpec.IntValue serverFooBottomHeight;
    final ForgeConfigSpec.IntValue serverFooMaxHeight;

    final ForgeConfigSpec.IntValue serverBarVeinSize;
    final ForgeConfigSpec.IntValue serverBarVeinCount;
    final ForgeConfigSpec.IntValue serverBarBottomHeight;
    final ForgeConfigSpec.IntValue serverBarMaxHeight;
    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverEnableRecycling = 
                builder.comment("Enable fusion furnace recycling of hadite and onyx items")
                .translation(SimpleMod.MODID + "config.EnableRecycling")
                .define("EnableRecycling", true);
        builder.pop();
        
        builder.push("Ore Generation");
        builder.push("Foo");
        serverEnableFooOre = 
                builder.comment("Enable foo ore generation")
                .translation(SimpleMod.MODID + "config.EnableFooOre")
                .define("EnableFooOre", true);
        
        serverFooVeinSize = builder.comment("Hadite Coal ore vein size")
                .translation(SimpleMod.MODID + "config.FooVeinSize")
                .defineInRange("FooVeinSize",  17, 0, Integer.MAX_VALUE);
        serverFooVeinCount = builder.comment("Hadite Coal ore vein count per chunk")
                .translation(SimpleMod.MODID + "config.FooVeinCount")
                .defineInRange("FooVeinCount",  9, 0, Integer.MAX_VALUE);
        serverFooBottomHeight = builder
                .comment("Foo ore minimum height")
                .translation(SimpleMod.MODID + ".config.serverFooBottomHeight")
                .defineInRange("FooBottomHeight", 0, 1, 127);
        serverFooMaxHeight = builder
                .comment("Foo ore maximum height")
                .translation(SimpleMod.MODID + ".config.serverFooMaxHeight")
                .defineInRange("FooMaxHeight", 128, 1, 128);
        builder.pop();
        builder.push("Bar");
        serverEnableBarOre = 
                builder.comment("Enable foo ore generation")
                .translation(SimpleMod.MODID + "config.EnableBarOre")
                .define("EnableBarOre", true);
        
        serverBarVeinSize = builder.comment("Hadite Coal ore vein size")
                .translation(SimpleMod.MODID + "config.BarVeinSize")
                .defineInRange("BarVeinSize",  17, 0, Integer.MAX_VALUE);
        serverBarVeinCount = builder.comment("Hadite Coal ore vein count per chunk")
                .translation(SimpleMod.MODID + "config.BarVeinCount")
                .defineInRange("BarVeinCount",  9, 0, Integer.MAX_VALUE);
        serverBarBottomHeight = builder
                .comment("Bar ore minimum height")
                .translation(SimpleMod.MODID + ".config.serverBarBottomHeight")
                .defineInRange("BarBottomHeight", 0, 1, 127);
        serverBarMaxHeight = builder
                .comment("Bar ore maximum height")
                .translation(SimpleMod.MODID + ".config.serverBarMaxHeight")
                .defineInRange("BarMaxHeight", 128, 1, 128);
        
        builder.pop();
        builder.pop();
    } // end ctor

} // end-class

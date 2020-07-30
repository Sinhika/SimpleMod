package mod.author.simplemod.generation;

import mod.author.simplemod.config.SimpleModConfig;
import mod.author.simplemod.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation master-class for SimpleMod.
 */
public class OreGeneration
{

    /**
     * called in setup to generate overworld ores; should respect config entries.
     */
    public static void setupOreGen()
    {
        for (Biome biome : ForgeRegistries.BIOMES.getValues())
        {
            if (biome.getCategory() == Biome.Category.THEEND)
            {
                // We have no ores for the End dimension, so this if statement is just so that
                // we skip biomes in that dimension.
                continue;
            }
            else if (biome.getCategory() == Biome.Category.NETHER)
            {
                // Nether
                if (SimpleModConfig.enable_foo)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Feature.ORE
                                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                            ModBlocks.foo_ore.get().getDefaultState(), SimpleModConfig.foo_veinsize))
                                    .withPlacement(Placement.COUNT_RANGE.configure(SimpleModConfig.foo_cfg)));
                }
            } // end-else NETHER
            else
            {
                // Overworld
                if (SimpleModConfig.enable_bar)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                            .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                    ModBlocks.bar_ore.get().getDefaultState(), SimpleModConfig.bar_veinsize))
                            .withPlacement(Placement.COUNT_RANGE.configure(SimpleModConfig.bar_cfg)));
                }

            } // end-else all others
        } // end-for Biome
    } // end setupOreGen()

} // end class OreGeneration

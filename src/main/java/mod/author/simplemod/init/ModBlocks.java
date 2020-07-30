package mod.author.simplemod.init;

import mod.alexndr.simpleores.api.content.SimpleMetalBlock;
import mod.author.simplemod.SimpleMod;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
           DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleMod.MODID);

    // Ore Blocks
    public static final RegistryObject<OreBlock> foo_ore = BLOCKS.register("foo_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 1.7F, 3.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<OreBlock> bar_ore = BLOCKS.register("bar_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 3.0F, 3.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    // Metal Blocks
    public static final RegistryObject<SimpleMetalBlock> foo_block = BLOCKS.register("foo_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON,
                    MaterialColor.ORANGE_TERRACOTTA)
                    .hardnessAndResistance(3.0F, 6.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    public static final RegistryObject<SimpleMetalBlock> bar_block = BLOCKS.register("bar_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(4.0F, 6.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));

}  // end class ModBlocks

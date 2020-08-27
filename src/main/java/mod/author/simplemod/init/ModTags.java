package mod.author.simplemod.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags
{

    public static class Items
    {
        public static final Tag<Item> INGOTS_FOO = forgeTag("ingots/foo");
        public static final Tag<Item> NUGGETS_FOO = forgeTag("nuggets/foo");
        public static final Tag<Item> BLOCK_FOO = forgeTag("storage_blocks/foo");
        public static final Tag<Item> RODS_FOO = forgeTag("rods/foo");
        
//        private static Tag<Item> tag(String name) {
//            return new ItemTags.Wrapper(new ResourceLocation(OnlySilver.MODID, name));
//        }

        private static Tag<Item> forgeTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end class Items
    
    
    public static class Blocks
    {
        public static final Tag<Block> BLOCK_FOO = forgeTag("storage_blocks/foo");
        
//        private static Tag<Block> tag(String name) {
//            return new BlockTags.Wrapper(new ResourceLocation(OnlySilver.MODID, name));
//        }

        private static Tag<Block> forgeTag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end class Blocks

    
} // end class ModTags

package mod.author.simplemod;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simpleores.api.config.FlagCondition;
import mod.author.simplemod.config.ConfigHelper;
import mod.author.simplemod.config.ConfigHolder;
import mod.author.simplemod.config.SimpleModConfig;
import mod.author.simplemod.generation.OreGeneration;
import mod.author.simplemod.init.ModBlocks;
import mod.author.simplemod.init.ModTabGroups;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = SimpleMod.MODID, bus = MOD)
public final class ModEventSubscriber 
{
	private static final Logger LOGGER = LogManager.getLogger(SimpleMod.MODID + " Mod Event Subscriber");

    /**
     * For best inter-mod compatibility, run ore generation in a DeferredWorkQueue, per dieseiben07.
     * @param event
     */
    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater( ()-> {
            OreGeneration.setupOreGen();
        });
        LOGGER.debug("Common setup done");
    } // end onCommonSetup

	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();

		// We need to go over the entire registry so that we include any potential Registry Overrides
        // Automatically register BlockItems for all our Blocks
        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                // You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
                // .filter(block -> needsItemBlock(block))
                // Register the BlockItem for the block
                .forEach(block -> {
                    // Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
                    final Item.Properties properties = 
                            new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Set the new BlockItem's registry name to the block's registry name
                    blockItem.setRegistryName(block.getRegistryName());
                    // Register the BlockItem
                    registry.register(blockItem);
                });
		LOGGER.debug("Registered BlockItems");
	}  // end onRegisterItems()

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
	{
		final ModConfig config = event.getConfig();

		// Rebake the configs when they change
		if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
			ConfigHelper.bakeServer(config);
		}
	} // onModConfigEvent

	
	@SubscribeEvent
	public static void onRegisterRecipeSerializers(
	        @Nonnull final RegistryEvent.Register<IRecipeSerializer<?>> event)
	{
	       CraftingHelper.register(new FlagCondition.Serializer(SimpleModConfig.INSTANCE, 
                                                   new ResourceLocation(SimpleMod.MODID, "flag")));	    
	} // end registerRecipeSerializers
	
} // end class ModEventSubscriber

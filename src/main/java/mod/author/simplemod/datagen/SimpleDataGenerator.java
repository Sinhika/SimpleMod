package mod.author.simplemod.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.function.Consumer;
import mod.author.simplemod.SimpleMod;
import mod.author.simplemod.init.ModBlocks;
import mod.author.simplemod.init.ModItems;
import mod.author.simplemod.init.ModTags;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = SimpleMod.MODID, bus = MOD)
public class SimpleDataGenerator
{

    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
        }
     } // end gatherData()

    /** 
     * RecipeProvider for SimpleMod.
     * @author Sinhika
     *
     */
    public static class Recipes extends RecipeProvider implements IConditionBuilder
    {

        public Recipes(DataGenerator generatorIn)
        {
            super(generatorIn);
        }

        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerStorageRecipes(consumer);
            registerMiscRecipes(consumer);
            registerToolRecipes(consumer);
            registerArmorRecipes(consumer);
            registerFurnaceRecipes(consumer);
        } // end registerRecipes() 
        
        protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // axe
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_axe.get())
                .key('S', ModTags.Items.INGOTS_FOO)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine("SS")
                .patternLine("ST")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            
            // hoe
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_hoe.get())
                .key('S', ModTags.Items.INGOTS_FOO)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine("SS")
                .patternLine(" T")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            
            // pickaxe
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_pickaxe.get())
                .key('S', ModTags.Items.INGOTS_FOO)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine("SSS")
                .patternLine(" T ")
                .patternLine(" T ")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            
            // sword
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_sword.get())
                .key('S', ModTags.Items.INGOTS_FOO)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine(" S")
                .patternLine(" S")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            
            // shovel
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_shovel.get())
                .key('S', ModTags.Items.INGOTS_FOO)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine(" S")
                .patternLine(" T")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            
        } // end registerToolRecipes()
        
        protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
        {
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_helmet.get())
                .key('S', ModItems.foo_ingot.get())
                .patternLine("SSS")
                .patternLine("S S")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_chestplate.get())
                .key('S', ModItems.foo_ingot.get())
                .patternLine("S S")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_leggings.get())
                .key('S', ModItems.foo_ingot.get())
                .patternLine("SSS")
                .patternLine("S S")
                .patternLine("S S")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_boots.get())
                .key('S', ModItems.foo_ingot.get())
                .patternLine("   ")
                .patternLine("S S")
                .patternLine("S S")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
                
        } // end registerArmorRecipes()
        
        protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // block <=> ingots
            ShapelessRecipeBuilder.shapelessRecipe(ModItems.foo_ingot.get(), 9)
                .addIngredient(ModBlocks.foo_block.get())
                .addCriterion("has_item", hasItem(ModTags.Items.BLOCK_FOO))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModBlocks.foo_block.get())
                .key('S', ModItems.foo_ingot.get())
                .patternLine("SSS")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            
            // ingot <=> nuggets
            ShapelessRecipeBuilder.shapelessRecipe(ModItems.foo_nugget.get(), 9)
                .addIngredient(ModItems.foo_ingot.get())
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_FOO))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.foo_ingot.get())
                .key('S', ModItems.foo_nugget.get())
                .patternLine("SSS")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", hasItem(ModTags.Items.NUGGETS_FOO))
                .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_ingot_from_nugget"));
        } // end registerStorageRecipes()
        
        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {
            
        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // ore => ingots
            CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.foo_ore.get()), 
                                                ModItems.foo_ingot.get(), 0.8F, 200)
                .addCriterion("has_item", hasItem(ModBlocks.foo_ore.get()))
                .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_ingot_from_smelting"));
            CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ModBlocks.foo_ore.get()), 
                                                ModItems.foo_ingot.get(), 0.8F, 100)
                    .addCriterion("has_item", hasItem(ModBlocks.foo_ore.get()))
                    .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_ingot_from_blasting"));
            
            // vanilla recycling, tools/armor => nuggets
            // smelting
            CookingRecipeBuilder
                    .smeltingRecipe(
                            Ingredient.fromItems(ModItems.foo_axe.get(),
                                    ModItems.foo_hoe.get(), ModItems.foo_pickaxe.get(),
                                    ModItems.foo_shovel.get(), ModItems.foo_sword.get()),
                            ModItems.foo_nugget.get(), 0.4F, 200)
                    .addCriterion("has_item", hasItem(ModItems.foo_axe.get()))
                    .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_nugget_from_smelting_tools"));

            CookingRecipeBuilder
                    .smeltingRecipe(
                            Ingredient.fromItems(ModItems.foo_boots.get(), ModItems.foo_chestplate.get(),
                                    ModItems.foo_helmet.get(), ModItems.foo_leggings.get()),
                            ModItems.foo_nugget.get(), 0.4F, 200)
                    .addCriterion("has_item", hasItem(ModItems.foo_boots.get()))
                    .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_nugget_from_smelting_armor"));
          
            // blasting
            CookingRecipeBuilder
            .blastingRecipe(
                    Ingredient.fromItems(ModItems.foo_axe.get(),
                            ModItems.foo_hoe.get(), ModItems.foo_pickaxe.get(),
                            ModItems.foo_shovel.get(), ModItems.foo_sword.get()),
                    ModItems.foo_nugget.get(), 0.4F, 100)
            .addCriterion("has_item", hasItem(ModItems.foo_axe.get()))
            .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_nugget_from_blasting_tools"));

            CookingRecipeBuilder
                    .blastingRecipe(
                            Ingredient.fromItems(ModItems.foo_boots.get(), ModItems.foo_chestplate.get(),
                                    ModItems.foo_helmet.get(), ModItems.foo_leggings.get()),
                            ModItems.foo_nugget.get(), 0.4F, 100)
                    .addCriterion("has_item", hasItem(ModItems.foo_boots.get()))
                    .build(consumer, new ResourceLocation(SimpleMod.MODID, "foo_nugget_from_blasting_armor"));

        } // end registerFurnaceRecipes()

    } // end subclass SimpleModDataGenerator$Recipes.
    
} // end-class SimpleModDataGenerator

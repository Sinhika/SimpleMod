package mod.author.simplemod.content;

import java.util.function.Supplier;

import mod.author.simplemod.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum SimpleModItemTier implements IItemTier
{
   FOO(1, 185, 4.0F, 1.0F, 8, ()->{ return Ingredient.fromItems( ModItems.foo_ingot.get()); }),
   BAR(1, 220, 3.5F, 1.0F, 8, ()->{ return Ingredient.fromItems( ModItems.bar_ingot.get()); });

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyValue<Ingredient> repairMaterial;

   private SimpleModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                    Supplier<Ingredient> repairMaterialIn)
   {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyValue<>(repairMaterialIn);
   }

   @Override
   public int getMaxUses() {
      return this.maxUses;
   }

   @Override
   public float getEfficiency() {
      return this.efficiency;
   }

   @Override
   public float getAttackDamage() {
      return this.attackDamage;
   }

   @Override
   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   @Override
   public int getEnchantability() {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}  // end class SimpleOresItemTier

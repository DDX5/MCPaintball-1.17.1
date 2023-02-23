package org.multicoder.mcpaintball.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum PaintballArmor implements ArmorMaterial
{
    Red("red"),
    Blue("blue"),
    Green("green");
    private static final int[] HEALTH_PER_SLOT;

    private final String name;

    private final int durabilityMultiplier;

    private final int[] slotProtections;

    private final int enchantmentValue;

    private final SoundEvent sound;

    private final float toughness;
    private final float knockbackResistance;

    private final Supplier<Ingredient> repairIngredient;

    static {
        HEALTH_PER_SLOT = new int[]{1,1,1,1};
    }

    PaintballArmor(String name){
        this.name = name;
        this.durabilityMultiplier = 1000;
        this.slotProtections = new int[] {0,0,0,0};
        this.enchantmentValue = 0;
        this.toughness = 0.0f;
        this.knockbackResistance = 0.0f;
        this.sound = SoundEvents.ARMOR_EQUIP_LEATHER;
        this.repairIngredient = () -> Ingredient.of(Blocks.WHITE_WOOL);
    }


    @Override
    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName()
    {
        return "mcpaintball:" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

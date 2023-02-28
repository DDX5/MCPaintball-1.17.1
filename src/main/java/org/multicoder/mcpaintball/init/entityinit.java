package org.multicoder.mcpaintball.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.*;

public class entityinit
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MCPaintball.MODID);

    public static final RegistryObject<EntityType<?>> RED_PAINTBALL = ENTITY_TYPES.register("red_paintball",() -> EntityType.Builder.of(RedPaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("red_paintball"));
    public static final RegistryObject<EntityType<?>> BLUE_PAINTBALL = ENTITY_TYPES.register("blue_paintball",() -> EntityType.Builder.of(BluePaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("blue_paintball"));
    public static final RegistryObject<EntityType<?>> GREEN_PAINTBALL = ENTITY_TYPES.register("green_paintball",() -> EntityType.Builder.of(GreenPaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("green_paintball"));

    public static final RegistryObject<EntityType<?>> RED_PAINTBALL_HEAVY = ENTITY_TYPES.register("red_paintball_heavy",() -> EntityType.Builder.of(RedPaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("red_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> BLUE_PAINTBALL_HEAVY = ENTITY_TYPES.register("blue_paintball_heavy",() -> EntityType.Builder.of(BluePaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("blue_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> GREEN_PAINTBALL_HEAVY = ENTITY_TYPES.register("green_paintball_heavy",() -> EntityType.Builder.of(GreenPaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("green_paintball_heavy"));

    public static final RegistryObject<EntityType<RedGrenade>> RED_GRENADE = ENTITY_TYPES.register("red_grenade",() -> EntityType.Builder.<RedGrenade>of(RedGrenade::new, MobCategory.MISC).sized(1f,1f).build("red_grenade"));
    public static final RegistryObject<EntityType<GreenGrenade>> GREEN_GRENADE = ENTITY_TYPES.register("green_grenade",() -> EntityType.Builder.<GreenGrenade>of(GreenGrenade::new, MobCategory.MISC).sized(1f,1f).build("green_grenade"));
    public static final RegistryObject<EntityType<BlueGrenade>> BLUE_GRENADE = ENTITY_TYPES.register("blue_grenade",() -> EntityType.Builder.<BlueGrenade>of(BlueGrenade::new, MobCategory.MISC).sized(1f,1f).build("blue_grenade"));

}

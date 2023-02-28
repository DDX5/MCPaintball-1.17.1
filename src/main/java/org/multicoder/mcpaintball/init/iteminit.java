package org.multicoder.mcpaintball.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.*;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.armor.boots.*;
import org.multicoder.mcpaintball.item.armor.chestplate.*;
import org.multicoder.mcpaintball.item.armor.helmet.*;
import org.multicoder.mcpaintball.item.armor.leggings.*;
import org.multicoder.mcpaintball.item.utility.crafting.BlueWeaponBase;
import org.multicoder.mcpaintball.item.utility.crafting.GreenWeaponBase;
import org.multicoder.mcpaintball.item.utility.crafting.RedWeaponBase;
import org.multicoder.mcpaintball.item.utility.extra.TabletItem;
import org.multicoder.mcpaintball.item.utility.grenades.BlueGrenadeItem;
import org.multicoder.mcpaintball.item.utility.grenades.GreenGrenadeItem;
import org.multicoder.mcpaintball.item.utility.grenades.RedGrenadeItem;
import org.multicoder.mcpaintball.item.utility.kits.*;
import org.multicoder.mcpaintball.item.utility.remote.BlueRemote;
import org.multicoder.mcpaintball.item.utility.remote.GreenRemote;
import org.multicoder.mcpaintball.item.utility.remote.RedRemote;
import org.multicoder.mcpaintball.item.weapons.bazooka.*;
import org.multicoder.mcpaintball.item.weapons.pistol.*;
import org.multicoder.mcpaintball.item.weapons.rifle.*;
import org.multicoder.mcpaintball.item.weapons.shotgun.*;


public class iteminit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCPaintball.MODID);

    //  Weapons //
    public static final RegistryObject<Item> RED_PISTOL = ITEMS.register("weapon/pistol/red_pistol", RedPistolItem::new);
    public static final RegistryObject<Item> BLUE_PISTOL = ITEMS.register("weapon/pistol/blue_pistol", BluePistolItem::new);
    public static final RegistryObject<Item> GREEN_PISTOL = ITEMS.register("weapon/pistol/green_pistol", GreenPistolItem::new);

    public static final RegistryObject<Item> RED_SHOTGUN = ITEMS.register("weapon/shotgun/red_shotgun", RedShotgunItem::new);
    public static final RegistryObject<Item> BLUE_SHOTGUN = ITEMS.register("weapon/shotgun/blue_shotgun", BlueShotgunItem::new);
    public static final RegistryObject<Item> GREEN_SHOTGUN = ITEMS.register("weapon/shotgun/green_shotgun", GreenShotgunItem::new);

    public static final RegistryObject<Item> RED_RIFLE = ITEMS.register("weapon/rifle/red_rifle", RedRifleItem::new);
    public static final RegistryObject<Item> BLUE_RIFLE = ITEMS.register("weapon/rifle/blue_rifle", BlueRifleItem::new);
    public static final RegistryObject<Item> GREEN_RIFLE = ITEMS.register("weapon/rifle/green_rifle", GreenRifleItem::new);

    public static final RegistryObject<Item> RED_BAZOOKA = ITEMS.register("weapon/bazooka/red_bazooka", RedBazookaItem::new);
    public static final RegistryObject<Item> BLUE_BAZOOKA = ITEMS.register("weapon/bazooka/blue_bazooka", BlueBazookaItem::new);
    public static final RegistryObject<Item> GREEN_BAZOOKA = ITEMS.register("weapon/bazooka/green_bazooka", GreenBazookaItem::new);

    //  Armor //
    public static final RegistryObject<Item> RED_BOOTS = ITEMS.register("armor/red_boots", RedBoots::new);
    public static final RegistryObject<Item> BLUE_BOOTS = ITEMS.register("armor/blue_boots", BlueBoots::new);
    public static final RegistryObject<Item> GREEN_BOOTS = ITEMS.register("armor/green_boots", GreenBoots::new);

    public static final RegistryObject<Item> RED_LEGGINGS = ITEMS.register("armor/red_leggings", RedLeggings::new);
    public static final RegistryObject<Item> BLUE_LEGGINGS = ITEMS.register("armor/blue_leggings", BlueLeggings::new);
    public static final RegistryObject<Item> GREEN_LEGGINGS = ITEMS.register("armor/green_leggings", GreenLeggings::new);

    public static final RegistryObject<Item> RED_CHESTPLATE = ITEMS.register("armor/red_chestplate", RedChestplate::new);
    public static final RegistryObject<Item> BLUE_CHESTPLATE = ITEMS.register("armor/blue_chestplate", BlueChestplate::new);
    public static final RegistryObject<Item> GREEN_CHESTPLATE = ITEMS.register("armor/green_chestplate", GreenChestplate::new);

    public static final RegistryObject<Item> RED_HELMET = ITEMS.register("armor/red_helmet", RedHelmet::new);
    public static final RegistryObject<Item> BLUE_HELMET = ITEMS.register("armor/blue_helmet", BlueHelmet::new);
    public static final RegistryObject<Item> GREEN_HELMET = ITEMS.register("armor/green_helmet", GreenHelmet::new);

    //  Remote //
    public static final RegistryObject<Item> RED_REMOTE = ITEMS.register("utility/red_remote", RedRemote::new);
    public static final RegistryObject<Item> BLUE_REMOTE = ITEMS.register("utility/blue_remote", BlueRemote::new);
    public static final RegistryObject<Item> GREEN_REMOTE = ITEMS.register("utility/green_remote", GreenRemote::new);

    //  Weapons Base //
    public static final RegistryObject<Item> RED_WEAPONS_BASE = ITEMS.register("utility/crafting/red_weapon_base", RedWeaponBase::new);
    public static final RegistryObject<Item> BLUE_WEAPONS_BASE = ITEMS.register("utility/crafting/blue_weapon_base", BlueWeaponBase::new);
    public static final RegistryObject<Item> GREEN_WEAPONS_BASE = ITEMS.register("utility/crafting/green_weapon_base", GreenWeaponBase::new);

    // Team Kits //
    public static final RegistryObject<Item> RED_STANDARD = ITEMS.register("utility/kits/red_standard", RedTeamStandard::new);
    public static final RegistryObject<Item> BLUE_STANDARD = ITEMS.register("utility/kits/blue_standard", BlueTeamStandard::new);
    public static final RegistryObject<Item> GREEN_STANDARD = ITEMS.register("utility/kits/green_standard", GreenTeamStandard::new);

    public static final RegistryObject<Item> RED_MEDIC = ITEMS.register("utility/kits/red_medic", RedTeamMedic::new);
    public static final RegistryObject<Item> BLUE_MEDIC = ITEMS.register("utility/kits/blue_medic", BlueTeamMedic::new);
    public static final RegistryObject<Item> GREEN_MEDIC = ITEMS.register("utility/kits/green_medic", GreenTeamMedic::new);

    public static final RegistryObject<Item> RED_HEAVY = ITEMS.register("utility/kits/red_heavy", RedTeamHeavy::new);
    public static final RegistryObject<Item> BLUE_HEAVY = ITEMS.register("utility/kits/blue_heavy", BlueTeamHeavy::new);
    public static final RegistryObject<Item> GREEN_HEAVY = ITEMS.register("utility/kits/green_heavy", GreenTeamHeavy::new);

    // Grenades //
    public static final RegistryObject<Item> RED_GRENADE = ITEMS.register("utility/grenades/red_grenade", RedGrenadeItem::new);
    public static final RegistryObject<Item> GREEN_GRENADE = ITEMS.register("utility/grenades/green_grenade", GreenGrenadeItem::new);
    public static final RegistryObject<Item> BLUE_GRENADE = ITEMS.register("utility/grenades/blue_grenade", BlueGrenadeItem::new);

    // Extra //
    public static final RegistryObject<Item> TABLET = ITEMS.register("utility/extra/tablet", TabletItem::new);



}

package org.multicoder.mcpaintball.util.config;

import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MCPaintballConfig
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.BooleanValue FRIENDLY_FIRE;
    public static ForgeConfigSpec.DoubleValue PISTOL_INACCURACY;
    public static ForgeConfigSpec.DoubleValue SHOTGUN_INACCURACY;
    public static ForgeConfigSpec.DoubleValue RIFLE_INACCURACY;
    public static ForgeConfigSpec.DoubleValue BAZOOKA_INACCURACY;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BREAKABLES;

    static{
        Predicate<Object> TESTER = x -> true;
        BUILDER.push("MCPaintball Team");
        FRIENDLY_FIRE = BUILDER.comment("Enables/Disables Friendly Fire").define("Friendly_fire",false);
        BUILDER.pop();
        BUILDER.push("MCPaintball World");
        BREAKABLES = BUILDER.comment("Add Blocks That Can Be Broken").defineListAllowEmpty(List.of("breakables"),() -> List.of("minecraft:glass"),TESTER);
        BUILDER.pop();
        BUILDER.push("MCPaintball Weapons");
        PISTOL_INACCURACY = BUILDER.comment("The Inaccuracy Of The Pistol, Lower The Better").defineInRange("pistol_accuracy",0.5,0.0,1.0);
        SHOTGUN_INACCURACY = BUILDER.comment("The Inaccuracy Of The Shotgun, Lower The Better").defineInRange("shotgun_accuracy",0.5,0.0,1.0);
        RIFLE_INACCURACY = BUILDER.comment("The Inaccuracy Of The Rifle, Lower The Better").defineInRange("rifle_accuracy",1.5,0.0,3.0);
        BAZOOKA_INACCURACY = BUILDER.comment("The Inaccuracy Of The Bazooka, Lower The Better").defineInRange("rifle_accuracy",2.3,0.0,4.0);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

package com.mod460.extendenchantment.init

import com.mod460.extendenchantment.ExtendEnchantment
import com.mod460.extendenchantment.enchantments.*
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

object ModEnchantments {
    val ENCHANTMENTS: DeferredRegister<Enchantment> = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ExtendEnchantment.MOD_ID)

    // Lootingエンチャント
    val ADVANCED_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_looting") {
        AdvancedLootingEnchantment()
    }

    val SUPER_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_looting") {
        SuperLootingEnchantment()
    }

    val ULTRA_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_looting") {
        UltraLootingEnchantment()
    }

    val GOD_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("god_looting") {
        GodLootingEnchantment()
    }

    val ADVANCED_GOD_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_god_looting") {
        AdvancedGodLootingEnchantment()
    }

    val SUPER_GOD_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_god_looting") {
        SuperGodLootingEnchantment()
    }

    val ULTRA_GOD_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_god_looting") {
        UltraGodLootingEnchantment()
    }

    val ASU_GOD_LOOTING: RegistryObject<Enchantment> = ENCHANTMENTS.register("asu_god_looting") {
        ASUGodLootingEnchantment()
    }

    // Sharpnessエンチャント
    val ADVANCED_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_sharpness") {
        AdvancedSharpnessEnchantment()
    }

    val SUPER_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_sharpness") {
        SuperSharpnessEnchantment()
    }

    val ULTRA_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_sharpness") {
        UltraSharpnessEnchantment()
    }

    val GOD_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("god_sharpness") {
        GodSharpnessEnchantment()
    }

    val ADVANCED_GOD_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_god_sharpness") {
        AdvancedGodSharpnessEnchantment()
    }

    val SUPER_GOD_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_god_sharpness") {
        SuperGodSharpnessEnchantment()
    }

    val ULTRA_GOD_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_god_sharpness") {
        UltraGodSharpnessEnchantment()
    }

    val ASU_GOD_SHARPNESS: RegistryObject<Enchantment> = ENCHANTMENTS.register("asu_god_sharpness") {
        ASUGodSharpnessEnchantment()
    }

    // Beheadingエンチャント
    val BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("beheading") {
        BeheadingEnchantment()
    }

    val ADVANCED_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_beheading") {
        AdvancedBeheadingEnchantment()
    }

    val SUPER_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_beheading") {
        SuperBeheadingEnchantment()
    }

    val ULTRA_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_beheading") {
        UltraBeheadingEnchantment()
    }

    val GOD_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("god_beheading") {
        GodBeheadingEnchantment()
    }

    val ADVANCED_GOD_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_god_beheading") {
        AdvancedGodBeheadingEnchantment()
    }

    val SUPER_GOD_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_god_beheading") {
        SuperGodBeheadingEnchantment()
    }

    val ULTRA_GOD_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_god_beheading") {
        UltraGodBeheadingEnchantment()
    }

    val ASU_GOD_BEHEADING: RegistryObject<Enchantment> = ENCHANTMENTS.register("asu_god_beheading") {
        ASUGodBeheadingEnchantment()
    }

    // ExpOrbエンチャント
    val EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("exp_orb") {
        ExpOrbEnchantment()
    }

    val ADVANCED_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_exp_orb") {
        AdvancedExpOrbEnchantment()
    }

    val SUPER_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_exp_orb") {
        SuperExpOrbEnchantment()
    }

    val ULTRA_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_exp_orb") {
        UltraExpOrbEnchantment()
    }

    val GOD_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("god_exp_orb") {
        GodExpOrbEnchantment()
    }

    val ADVANCED_GOD_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("advanced_god_exp_orb") {
        AdvancedGodExpOrbEnchantment()
    }

    val SUPER_GOD_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("super_god_exp_orb") {
        SuperGodExpOrbEnchantment()
    }

    val ULTRA_GOD_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("ultra_god_exp_orb") {
        UltraGodExpOrbEnchantment()
    }

    val ASU_GOD_EXP_ORB: RegistryObject<Enchantment> = ENCHANTMENTS.register("asu_god_exp_orb") {
        ASUGodExpOrbEnchantment()
    }

    fun registerEnchantments() {
        ENCHANTMENTS.register(FMLJavaModLoadingContext.get().modEventBus)
        ExtendEnchantment.LOGGER.info("All enchantments registered successfully.")
    }
} 
package com.mod460.extendenchantment

import com.mod460.extendenchantment.events.BeheadingEventHandler
import com.mod460.extendenchantment.events.ExpOrbEventHandler
import com.mod460.extendenchantment.events.LootingEventHandler
import com.mod460.extendenchantment.init.ModEnchantments
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(ExtendEnchantment.MOD_ID)
class ExtendEnchantment {
    companion object {
        const val MOD_ID = "extendenchantment"
        val LOGGER: Logger = LogManager.getLogger()
    }

    init {
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus

        LOGGER.info("ExtendEnchantmentの初期化を開始")

        // エンチャントの登録
        ModEnchantments.ENCHANTMENTS.register(modEventBus)
        LOGGER.info("エンチャントの登録が完了しました")

        // FMLのイベントバスへsetupイベントを登録
        modEventBus.addListener(this::setup)
        LOGGER.info("FMLのイベントバスに setup イベントが登録されました")

        // Forge のイベントバスに各イベントを登録
        MinecraftForge.EVENT_BUS.register(this)  // メインModクラス
        MinecraftForge.EVENT_BUS.register(BeheadingEventHandler)
        MinecraftForge.EVENT_BUS.register(LootingEventHandler)
        MinecraftForge.EVENT_BUS.register(ExpOrbEventHandler)
        LOGGER.info("Forgeのイベントバスに ExtendEnchantment が登録されました")
    }

    private fun setup(event: FMLCommonSetupEvent) {
        // setupイベントの開始ログ
        LOGGER.info("ExtendEnchantmentのゲーム共通セットアップを実行中")
    }
} 
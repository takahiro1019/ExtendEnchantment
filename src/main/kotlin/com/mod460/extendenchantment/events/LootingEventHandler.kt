package com.mod460.extendenchantment.events

import com.mod460.extendenchantment.ExtendEnchantment
import com.mod460.extendenchantment.enchantments.*
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraftforge.event.entity.living.LootingLevelEvent
import net.minecraftforge.event.entity.living.LivingDropsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod.EventBusSubscriber(modid = ExtendEnchantment.MOD_ID)
object LootingEventHandler {
    init {
        ExtendEnchantment.LOGGER.info("LootingEventHandlerが初期化されました (Forgeのイベントバスに自動登録)")
    }

    @SubscribeEvent
    fun onLivingDrops(event: LivingDropsEvent) {
        ExtendEnchantment.LOGGER.debug("LivingDropsEventが発火: エンティティ = ${event.entity.displayName.string}, ダメージソース = ${event.source.msgId}")

        val source = event.source.entity // ダメージを与えたエンティティ (プレイヤーかどうか確認する)
        if (source is Player) { // プレイヤーが攻撃した場合のみ処理する
            val weapon = source.mainHandItem // プレイヤーが使用した武器

            // **バニラのLootingレベルを取得**
            val lootingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, weapon)

            // **カスタムエンチャントの効果を計算**
            val customLootingBonus = EnchantmentHelper.getEnchantments(weapon).entries
                .filter { it.key is BaseLootingEnchantment } // カスタムLootingだけをフィルタ
                .sumOf { (enchantment, level) ->
                    (enchantment as BaseLootingEnchantment).getLootingBonus(level) // カスタムの効果を取得
                }

            // **バニラとカスタムの合算値を計算**
            val totalLootingBonus = lootingLevel + customLootingBonus

            // デバッグ用：現在のボーナス状況をログ出力
            ExtendEnchantment.LOGGER.debug("バニラLootingレベル: $lootingLevel, カスタムLootingボーナス: $customLootingBonus, 合計ボーナス: $totalLootingBonus")

            // **ドロップアイテムの個数を増加**
            if (totalLootingBonus > 0) {
                event.drops.forEach { itemEntity ->
                    val stack = itemEntity.item
                    stack.count += totalLootingBonus // バニラ + カスタムの合計値をボーナスとして加算
                }
            }
        }
    }
} 
package com.mod460.extendenchantment.events

import com.mod460.extendenchantment.ExtendEnchantment
import com.mod460.extendenchantment.enchantments.*
import com.mod460.extendenchantment.init.ModEnchantments
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.event.entity.living.LivingDropsEvent
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import java.util.Random

@Mod.EventBusSubscriber(modid = ExtendEnchantment.MOD_ID)
object ExpOrbEventHandler {

    @SubscribeEvent
    fun onLivingExperienceDrop(event: LivingExperienceDropEvent) {
        val attackingPlayer = event.attackingPlayer // MOBを倒したプレイヤー
        if (attackingPlayer != null) {
            val mainHandItem = attackingPlayer.mainHandItem

            // エンチャントの合計倍率を計算
            var totalMultiplier = 1.0
            EnchantmentHelper.getEnchantments(mainHandItem).forEach { (enchantment, _) ->
                if (enchantment is BaseExpOrbEnchantment) {
                    totalMultiplier += enchantment.baseMultiplier - 1.0
                }
            }

            // 経験値の増加処理
            val originalExperience = event.droppedExperience
            val modifiedExperience = (originalExperience * totalMultiplier).toInt()
            event.droppedExperience = modifiedExperience
        }
    }
} 
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
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import java.util.Random

@Mod.EventBusSubscriber(modid = ExtendEnchantment.MOD_ID)
object BeheadingEventHandler {
    private val BEHEADING_ENCHANTMENTS = listOf(
        ModEnchantments.BEHEADING,
        ModEnchantments.ADVANCED_BEHEADING,
        ModEnchantments.SUPER_BEHEADING,
        ModEnchantments.ULTRA_BEHEADING,
        ModEnchantments.GOD_BEHEADING,
        ModEnchantments.ADVANCED_GOD_BEHEADING,
        ModEnchantments.SUPER_GOD_BEHEADING,
        ModEnchantments.ULTRA_GOD_BEHEADING,
        ModEnchantments.ASU_GOD_BEHEADING
    )

    @SubscribeEvent
    fun onLivingDeath(event: LivingDeathEvent) {
        val entity = event.entity
        val source = event.source
        val attacker = source.entity

        if (attacker is Player) {
            val weapon = attacker.mainHandItem
            if (weapon.isEmpty) return

            for (enchantment in BEHEADING_ENCHANTMENTS) {
                val level = EnchantmentHelper.getItemEnchantmentLevel(enchantment.get(), weapon)
                if (level > 0) {
                    val enchantmentName = enchantment.id.toString() // `registryName` 取得の代わりに `id` を使用
                    val dropChance = (enchantment.get() as BaseBeheadingEnchantment).getDropChance(level)
                    ExtendEnchantment.LOGGER.info("Drop chance: $dropChance Level: $level Enchantment: ${enchantment.get().javaClass.simpleName}")

                    if (Random().nextFloat() < dropChance / 100f) {
                        // ログを追加してランダム値も確認
                        ExtendEnchantment.LOGGER.info("Random check passed! Entity type: ${entity.type}")
                        val headItem = when (entity.type) {
                            EntityType.ZOMBIE -> Items.ZOMBIE_HEAD
                            EntityType.SKELETON -> Items.SKELETON_SKULL
                            EntityType.CREEPER -> Items.CREEPER_HEAD
                            EntityType.ENDER_DRAGON -> Items.DRAGON_HEAD
                            EntityType.WITHER_SKELETON -> Items.WITHER_SKELETON_SKULL
                            EntityType.PLAYER -> Items.PLAYER_HEAD
                            else -> null
                        }

                        if (headItem != null) {
                            // 頭のアイテムをドロップ
                            val headStack = ItemStack(headItem)
                            if (entity is Player) {
                                headStack.getOrCreateTag().putString("SkullOwner", entity.name.string)
                            }
                            entity.spawnAtLocation(headStack)
                        }
                    }

                }
            }
        }
    }
} 
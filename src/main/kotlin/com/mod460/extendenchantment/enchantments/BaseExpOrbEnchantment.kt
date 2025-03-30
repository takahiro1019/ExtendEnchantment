package com.mod460.extendenchantment.enchantments

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.contents.TranslatableContents

abstract class BaseExpOrbEnchantment(
    rarity: Rarity,
    private val displayName: String,         // 表示名
    val baseMultiplier: Double      // 経験値倍率の基準値
) : Enchantment(rarity, EnchantmentCategory.WEAPON, arrayOf(EquipmentSlot.MAINHAND)) {

    override fun getMinLevel(): Int = 1
    override fun getMaxLevel(): Int = 10

    override fun getMinCost(level: Int): Int = 15 + (level - 1) * 9
    override fun getMaxCost(level: Int): Int = getMinCost(level) + 20

    override fun getFullname(level: Int): MutableComponent {
        return Component.literal(displayName)
            .append(" ")
            .append(Component.translatable("enchantment.level.$level"))
    }

    override fun checkCompatibility(other: Enchantment): Boolean = true

    // ドロップする経験値の倍率を計算
    fun calculateMultiplier(level: Int): Double {
        return baseMultiplier * level
    }
} 
package com.mod460.extendenchantment.enchantments

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.contents.TranslatableContents

abstract class BaseBeheadingEnchantment(
    rarity: Enchantment.Rarity,
    private val displayName: String,
    private val baseChance: Float,
    private val chancePerLevel: Float
) : Enchantment(rarity, EnchantmentCategory.WEAPON, arrayOf(EquipmentSlot.MAINHAND)) {
    override fun getMinLevel(): Int = 1
    override fun getMaxLevel(): Int = 10
    override fun getMinCost(level: Int): Int = 15 + (level - 1) * 9
    override fun getMaxCost(level: Int): Int = getMinCost(level) + 50
    override fun getFullname(level: Int): MutableComponent {
        return Component.literal(displayName)
            .append(" ")
            .append(Component.translatable("enchantment.level.$level"))
    }
    override fun checkCompatibility(other: Enchantment): Boolean = true

    /**
     * 頭のドロップ確率を計算する
     * @param level エンチャントレベル
     * @return ドロップ確率（%）
     */
    fun getDropChance(level: Int): Float {
        return baseChance + (level - 1) * chancePerLevel
    }
} 
package com.mod460.extendenchantment.enchantments

import net.minecraft.world.item.enchantment.Enchantment

class AdvancedLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.UNCOMMON, "Advanced Looting", 2f)
class SuperLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.RARE, "Super Looting", 3f)
class UltraLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.VERY_RARE, "Ultra Looting", 4f)
class GodLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.VERY_RARE, "God Looting", 5f)
class AdvancedGodLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.VERY_RARE, "Advanced God Looting", 10f)
class SuperGodLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.VERY_RARE, "Super God Looting", 15f)
class UltraGodLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.VERY_RARE, "Ultra God Looting", 20f)
class ASUGodLootingEnchantment : BaseLootingEnchantment(Enchantment.Rarity.VERY_RARE, "Advanced Super Ultra God Looting", 120f) 
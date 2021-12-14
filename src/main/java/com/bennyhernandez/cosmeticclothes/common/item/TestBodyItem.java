package com.bennyhernandez.cosmeticclothes.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class TestBodyItem extends Item implements ICurio {
    public TestBodyItem() {
        super(new Item.Properties());
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext) {
        return true;
    }
}

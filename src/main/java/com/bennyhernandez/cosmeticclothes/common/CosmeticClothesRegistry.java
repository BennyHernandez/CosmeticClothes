package com.bennyhernandez.cosmeticclothes.common;

import com.bennyhernandez.cosmeticclothes.CosmeticClothes;
import com.bennyhernandez.cosmeticclothes.common.item.HatItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = "cosmeticclothes", bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmeticClothesRegistry {
    @ObjectHolder("cosmeticclothes:testbody")
    public static final Item TESTBODY;

    static {
        TESTBODY = null;
    }

    @SubscribeEvent
    public static void  registerItems(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> registry = evt.getRegistry();
        register(new HatItem(), "hat", registry);
    }

    private static  void register(Item item, String name, IForgeRegistry<Item> registry) {
        item.setRegistryName(CosmeticClothes.MODID, name);
        registry.register(item);
    }
}

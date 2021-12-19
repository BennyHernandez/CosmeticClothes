package com.bennyhernandez.cosmeticclothes.common.item;

import com.bennyhernandez.cosmeticclothes.CosmeticClothes;
import com.bennyhernandez.cosmeticclothes.client.render.model.HatModel;
import com.bennyhernandez.cosmeticclothes.common.capability.CurioItemCapability;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.security.Provider;

public class HatItem extends Item implements ICurio {

    private static final ResourceLocation HAT_TEXTURE = new ResourceLocation(CosmeticClothes.MODID,
            "textures/entity/hat.png");

    public HatItem() {
        super(new Item.Properties());
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext) {
        return true;
    }


    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return CurioItemCapability.createProvider(new ICurio() {
            private Object model;

            @Override
            public boolean canRender(String identifier, int index, LivingEntity livingEntity) {
                return true;
            }

            @Override
            public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                if (!(this.model instanceof HatModel)) {
                    model = new HatModel<>();
                }

                HatModel<?> hat = (HatModel<?>) this.model;
                ICurio.RenderHelper.followHeadRotations(livingEntity, hat.hat);
                IVertexBuilder vertexBuilder = ItemRenderer
                        .getBuffer(renderTypeBuffer, hat.getRenderType(HAT_TEXTURE), false, stack.hasEffect());
                hat.render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
                        1.0F);
            }
        });
    }
}

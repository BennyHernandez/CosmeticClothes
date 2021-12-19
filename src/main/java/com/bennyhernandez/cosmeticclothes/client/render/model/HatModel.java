package com.bennyhernandez.cosmeticclothes.client.render.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import javax.annotation.Nonnull;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class HatModel<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer hat;

    public HatModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.hat = new ModelRenderer(this, 0, 0);
        this.hat.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hat.addBox(-1.0F, -9.5F, -1.0F, 2.0F, 1.5F, 1.9F, 3.8F, 0.0F, 3.8F);
        this.hat.setTextureOffset(8, 0).addBox(-1.0F, -14.5F, -1.0F, 2.0F, 3.0F, 2.0F, 2.4F, 2.0F, 2.4F);
        this.hat.setTextureOffset(16, 0).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 0.6F, 2.0F, 2.6F, 0.1F, 2.6F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.hat).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}




//import com.google.common.collect.ImmutableList;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.vertex.IVertexBuilder;
//import net.minecraft.client.renderer.entity.model.BipedModel;
//import net.minecraft.client.renderer.entity.model.EntityModel;
//import net.minecraft.client.renderer.model.ModelRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import javax.annotation.Nonnull;
//
///**
// * MyFirstModel - BennyF_
// * Created using Tabula 8.0.0
// */
//public class HatModel<T extends LivingEntity> extends BipedModel<T> {
//    public ModelRenderer hat;
//
//    public HatModel() {
//        this.textureWidth = 64;
//        this.textureHeight = 32;
//        this.hat = new ModelRenderer(this, 0, 0);
//        this.hat.setRotationPoint(0.0F, 0.0F, 0.0F);
//        this.hat.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, 5.0F);
//        this.hat.addBox(0.0F, -1.4F, 0.0F, 1.0F, 1.4F, 1.0F, 1.0F, 0.0F, 1.0F);
//    }
//
//    @Override
//    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
//        ImmutableList.of(this.hat).forEach((modelRenderer) -> {
//            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
//        });
//    }
//
//    @Override
//    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
//
//    @Override
//    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
//
//    }
//}

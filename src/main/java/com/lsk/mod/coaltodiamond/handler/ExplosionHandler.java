package com.lsk.mod.coaltodiamond.handler;

import com.lsk.mod.coaltodiamond.CoalToDiamond;
import com.lsk.mod.coaltodiamond.helper.ExplosionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import java.util.Date;


@Mod.EventBusSubscriber
public class ExplosionHandler {
	private static Date lastDoneTime;
	public static void init(){
		lastDoneTime = new Date();
	}
	@SubscribeEvent
	public static void onExplosionStart(ExplosionEvent event){
		Logger logger = CoalToDiamond.logger;
		if ((new Date().getTime() - lastDoneTime.getTime()) < 1000) {
			return;
		}
		try {
			Explosion explosion = event.getExplosion();
			World world = event.getWorld();
			Entity exploder = ExplosionHelper.getExploder(explosion);
			if(exploder instanceof EntityTNTPrimed){
				Vec3d explosionCentre = explosion.getPosition();
				logger.info("Explosion Centre:"+explosionCentre.toString());
				double x = explosionCentre.x;
				double y = explosionCentre.y;
				double z = explosionCentre.z;
				BlockPos block1Pos = new BlockPos(x-1,y,z);
				BlockPos block2Pos = new BlockPos(x+1,y,z);
				BlockPos block3Pos = new BlockPos(x,y-1,z);
				BlockPos block4Pos = new BlockPos(x,y+1,z);
				BlockPos block5Pos = new BlockPos(x,y,z-1);
				BlockPos block6Pos = new BlockPos(x,y,z+1);
				Block block1 = world.getBlockState(block1Pos).getBlock();
				logger.info("Block1: "+block1.getLocalizedName());
				Block block2 = world.getBlockState(block2Pos).getBlock();
				logger.info("Block2: "+block2.getLocalizedName());
				Block block3 = world.getBlockState(block3Pos).getBlock();
				logger.info("Block3: "+block3.getLocalizedName());
				Block block4 = world.getBlockState(block4Pos).getBlock();
				logger.info("Block4: "+block4.getLocalizedName());
				Block block5 = world.getBlockState(block5Pos).getBlock();
				logger.info("Block5: "+block5.getLocalizedName());
				Block block6 = world.getBlockState(block6Pos).getBlock();
				logger.info("Block6: "+block6.getLocalizedName());
				String coalBlockName = Blocks.COAL_BLOCK.getLocalizedName();
				if(block1.getLocalizedName().equals(coalBlockName) && block2.getLocalizedName().equals(coalBlockName) && block3.getLocalizedName().equals(coalBlockName) && block4.getLocalizedName().equals(coalBlockName) && block5.getLocalizedName().equals(coalBlockName) && block6.getLocalizedName().equals(coalBlockName)){
					logger.info("Summon the diamond.");
					EntityItem entityItem = new EntityItem(world);
					entityItem.setItem(new ItemStack(Items.DIAMOND));
					entityItem.setPosition(x,y+2,z);
					world.spawnEntity(entityItem);
				}
			}
		}catch (Exception e){
			logger.error("Failed to handle explosion event!",e);
		}
		lastDoneTime = new Date();
	}
}

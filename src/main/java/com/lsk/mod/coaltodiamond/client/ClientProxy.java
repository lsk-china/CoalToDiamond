package com.lsk.mod.coaltodiamond.client;

import com.lsk.mod.coaltodiamond.common.CommonProxy;
import com.lsk.mod.coaltodiamond.handler.ExplosionHandler;
import com.lsk.mod.coaltodiamond.helper.ExplosionHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
	}
	@Override
	public void init(FMLInitializationEvent event){
		super.init(event);
		ExplosionHandler.init();
	}
	@Override
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
	}
}

package com.lsk.mod.coaltodiamond;

import com.lsk.mod.coaltodiamond.common.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CoalToDiamond.MODID, name = CoalToDiamond.NAME, version = CoalToDiamond.VERSION)
public class CoalToDiamond
{
    public static final String MODID = "lsk_coaltodiamond";
    public static final String NAME = "CoalToDiamond";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @Mod.Instance
	public static CoalToDiamond instance;

    @SidedProxy(serverSide = "com.lsk.mod.coaltodiamond.common.CommonProxy",clientSide = "com.lsk.mod.coaltodiamond.client.ClientProxy")
	public static CommonProxy commonProxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	logger = event.getModLog();
		commonProxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        commonProxy.init(event);
    }
    public void postInit(FMLPostInitializationEvent event){
    	commonProxy.postInit(event);
	}
}

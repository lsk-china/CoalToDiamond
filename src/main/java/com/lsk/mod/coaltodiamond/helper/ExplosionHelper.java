package com.lsk.mod.coaltodiamond.helper;

import com.lsk.mod.coaltodiamond.CoalToDiamond;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public class ExplosionHelper {
	private static final Logger logger = CoalToDiamond.logger;
 	public static Entity getExploder(Explosion explosion) throws NoSuchFieldException, IllegalAccessException {
		Class<?> explosionClass = explosion.getClass();
		Field exploderField = explosionClass.getDeclaredField("field_77283_e");
		exploderField.setAccessible(true);
		logger.info("Exploder: "+exploderField.get(explosion).toString());
		return (Entity) exploderField.get(explosion);
//		for(Field field : explosionClass.getDeclaredFields()){
//			Class<?> type = field.getType();
//			System.out.println(type.getName()+":"+field.getName());
//		}
//		return null;
	}
}

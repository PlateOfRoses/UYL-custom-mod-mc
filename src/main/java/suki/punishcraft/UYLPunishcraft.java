package suki.punishcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import suki.punishcraft.effect.ModEffects;

public class UYLPunishcraft implements ModInitializer {
	public static final String MOD_ID = "uyl-punishcraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		//
		ModEffects.registerEffects();
		//


		LOGGER.info("Hello Fabric world!");


		UseItemCallback.EVENT.register(this::StopCombatItems);
		UseBlockCallback.EVENT.register(this::StopCombatItems);


		ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamageTaken, damageTaken, blocked) -> {
			System.out.println(source.getType());
			Entity attacker = source.getAttacker();
			if (attacker == null) return;
			if (entity.isPlayer()) {
				entity.addStatusEffect(new StatusEffectInstance(ModEffects.COMBAT, 15*20, 0, false, false, false));
			}

		});
	}


	public ActionResult StopCombatItems(PlayerEntity player, World world, Hand hand) {
		if (player.hasStatusEffect(ModEffects.COMBAT)) {
			System.out.println(player.getStackInHand(hand));
			if (player.getStackInHand(hand).getItem() == Items.FIREWORK_ROCKET || player.getStackInHand(hand).getItem() == Items.ENDER_PEARL ) {
				return ActionResult.FAIL;
			}
		}
		return ActionResult.PASS;
	}

	public ActionResult StopCombatItems(PlayerEntity player, World world, Hand hand, HitResult hitResult) {
		return StopCombatItems(player, world, hand);
	}
}
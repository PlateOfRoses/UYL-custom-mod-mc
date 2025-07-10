package suki.punishcraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class AdventureEffect extends StatusEffect {

    protected AdventureEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x000000);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
//        if (entity instanceof PlayerEntity player) {
//            player.addStatusEffect(new StatusEffectInstance(ModEffects.ADVENTURE, 30*20, 0, false, false, false));
//        }
        return true;

//      return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}

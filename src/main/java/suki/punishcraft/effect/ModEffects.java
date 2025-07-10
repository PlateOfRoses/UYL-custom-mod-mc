package suki.punishcraft.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import suki.punishcraft.UYLPunishcraft;

public class ModEffects{

    public static final RegistryEntry<StatusEffect> ADVENTURE = registerStatusEffect("adventure_mode", new AdventureEffect());
    public static final RegistryEntry<StatusEffect> COMBAT = registerStatusEffect("combat_mode", new AdventureEffect());



    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(UYLPunishcraft.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        UYLPunishcraft.LOGGER.info("Registering Mod Effects");
    }
}

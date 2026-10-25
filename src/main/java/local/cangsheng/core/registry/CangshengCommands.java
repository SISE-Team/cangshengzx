package local.cangsheng.core.registry;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

/** Registers read-only M0 debug commands with no gameplay side effects. */
public final class CangshengCommands {
    private CangshengCommands() {}

    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("cangsheng")
                .then(Commands.literal("debug")
                        .then(Commands.literal("profile").executes(context -> {
                            context.getSource().sendSuccess(
                                    () -> Component.literal("profile: level=0, experience=0, realm=, sect=, branch="),
                                    false);
                            return 1;
                        }))
                        .then(Commands.literal("resources").executes(context -> {
                            context.getSource().sendSuccess(
                                    () -> Component.literal("resources: empty pool"), false);
                            return 1;
                        }))
                        .then(Commands.literal("skills").executes(context -> {
                            context.getSource().sendSuccess(
                                    () -> Component.literal("skills: empty loadout"), false);
                            return 1;
                        }))));
    }
}

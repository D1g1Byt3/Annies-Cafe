package net.d1g1byt3.anniescafe.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        // /home set
        dispatcher.register(Commands.literal("home").then(Commands.literal("return")
                .executes(this::execute)));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        boolean hasHomePos = player.getPersistentData().getIntArray("anniescafe.homepos").length != 0;

        if (hasHomePos) {
            int[] playerPos = player.getPersistentData().getIntArray("anniescafe.homepos");
            player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);

            context.getSource().sendSuccess(()-> Component.literal("You have returned Home!"), false);
            return 1;
        } else {
            context.getSource().sendFailure(Component.literal("No Home position has been set!"));
            return -1;
        }
    }
}

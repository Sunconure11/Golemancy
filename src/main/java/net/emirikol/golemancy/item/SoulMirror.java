package net.emirikol.golemancy.item;

import net.emirikol.golemancy.genetics.*;
import net.emirikol.golemancy.screen.*;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.screen.*;
import net.minecraft.util.*;
import net.minecraft.text.*;
import net.minecraft.network.*;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.function.Consumer;

public class SoulMirror extends Item implements ExtendedScreenHandlerFactory {
	private String soulData;
	
	public SoulMirror(Settings settings) {
		super(settings);
	}
	
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new SoulMirrorScreenHandler(syncId, playerInventory);
	}
	
    @Override
    public Text getDisplayName() {
        return Text.translatable(this.getTranslationKey());
    }
	
	@Override
	public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
		packetByteBuf.writeString(soulData);
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		//Get the soul mirror's ItemStack, and whatever's in the other hand.
		ItemStack stack = player.getStackInHand(hand);
		ItemStack otherStack;
		if (hand == Hand.MAIN_HAND) {
			otherStack = player.getStackInHand(Hand.OFF_HAND);
		} else {
			otherStack = player.getStackInHand(Hand.MAIN_HAND);
		}
		//Check if it's a filled soulstone.
		if (otherStack.getItem() instanceof SoulstoneFilled) {
			//Load data from soulstone.
			Genome genome = new Genome(otherStack);
			//Damage the soul mirror.
			stack.damage(1, (LivingEntity) player, (Consumer)((p) -> { LivingEntity q = (LivingEntity) p; q.sendToolBreakStatus(hand); }));
			//Display genome on screen.
			displayGenome(world, player, genome);
			return TypedActionResult.success(stack);
		} 
		//Default fall-through to PASS.
		return TypedActionResult.pass(stack);
	}
	
	//Helper method to handle soul mirror display logic.
	public void displayGenome(World world, PlayerEntity player, Genome genome) {
		soulData = new SerializedGenome(genome).toString();
		player.openHandledScreen(this);
	}
}
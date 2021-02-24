package net.emirikol.amm.screen;

import net.minecraft.entity.player.*;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.*;
import net.minecraft.network.*;

import net.emirikol.amm.*;

public class SoulMirrorScreenHandler extends ScreenHandler {
	String soulData;

	public SoulMirrorScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(AriseMyMinionsMod.SOUL_MIRROR_SCREEN_HANDLER, syncId);
		soulData = "";
	}
	
	public SoulMirrorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
		super(AriseMyMinionsMod.SOUL_MIRROR_SCREEN_HANDLER, syncId);
		soulData = buf.readString();
	}
	
	@Override
	public boolean canUse(PlayerEntity player) {
		return true;
	}
	
	public String getSoulData() {
		return soulData;
	}
}
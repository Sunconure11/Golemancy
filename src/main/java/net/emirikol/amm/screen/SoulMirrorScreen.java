package net.emirikol.amm.screen;

import net.emirikol.amm.genetics.*;
import net.emirikol.amm.screen.*;

import net.minecraft.entity.player.*;
import net.minecraft.screen.*;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.client.util.math.*;
import net.minecraft.client.gui.screen.ingame.*;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.*;

public class SoulMirrorScreen extends HandledScreen<ScreenHandler> {
	//A path to the GUI texture to use.
	private static final Identifier TEXTURE = new Identifier("amm", "textures/gui/container/soul_mirror.png");
	public static final int TITLE_Y = 10;
	public static final int COLUMN_HEADER_Y = 35;
	public static final int COLUMN_DOM_X = 80;
	public static final int COLUMN_REC_X = 125;
	public static final int ROW_START_X = 15;
	public static final int TYPE_ROW_Y = 50;
	public static final int STRENGTH_ROW_Y = 60;
	public static final int AGILITY_ROW_Y = 70;
	public static final int VIGOR_ROW_Y = 80;
	public static final int SMARTS_ROW_Y = 90;
	
	public SoulMirrorScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}
	
	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		client.getTextureManager().bindTexture(TEXTURE);
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;
		drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
	}
	
	@Override
	protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
		//Get genome data from server and deserialize.
		String soulData = ((SoulMirrorScreenHandler) this.handler).getSoulData();
		SerializedGenome serializedGenome = new SerializedGenome(soulData);
		//Draw title.
		Text titleText = new TranslatableText("item.amm.soul_mirror");
		int x = (backgroundWidth - textRenderer.getWidth(titleText)) / 2;
		this.textRenderer.draw(matrices, titleText, (float) x, (float) TITLE_Y, 4210752);
		//Draw column headers.
		Text activeText = new TranslatableText("text.amm.active_column");
		Text dormantText = new TranslatableText("text.amm.dormant_column");
		this.textRenderer.draw(matrices, activeText, (float) COLUMN_DOM_X, (float) COLUMN_HEADER_Y, 0xff0000);
		this.textRenderer.draw(matrices, dormantText, (float) COLUMN_REC_X, (float) COLUMN_HEADER_Y, 0x00acff);
	}
	
	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
		drawMouseoverTooltip(matrices, mouseX, mouseY);
	}
	
	@Override
	protected void init() {
		super.init();
	}
}
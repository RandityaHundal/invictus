package invictus.ui;

import invictus.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		FontRenderer fr = mc.fontRendererObj;
		
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(2, 2, 1);
		GlStateManager.translate(-4, -4, 0);
		fr.drawString(Client.name + " v" + Client.version , 4, 4, -5);
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(0.5, 0.5, 1);
		GlStateManager.translate(-4, -4, 0);
		
		int count = 0;
		
		for(invictus.modules.Module m : Client.modules) {
			if(!m.toggled)
				continue;
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, count*(fr.FONT_HEIGHT + 6), sr.getScaledWidth(), 9 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT), 0x90000000);
			fr.drawString(m.name ,sr.getScaledWidth() - fr.getStringWidth(m.name) - 4, 4 + count*(fr.FONT_HEIGHT + 6), -1);
			
			count++;
			
		}
		
	}
	

}

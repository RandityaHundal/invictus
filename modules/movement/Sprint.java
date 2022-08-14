package invictus.modules.movement;

import org.lwjgl.input.Keyboard;

import invictus.events.Event;
import invictus.events.listeners.EventUpdate;
import invictus.modules.Module;

public class Sprint extends Module {
	
	public Sprint(){
		super("Sprint", Keyboard.KEY_N, Category.MOVEMENT);
	}
	
	public void onEnable(){
		
	}
	public void onDisable(){
		mc.thePlayer.setSprinting(false);
	}
	
	public void onEvent(Event e){
		if(e instanceof EventUpdate){
			if(e.isPre()) {
				mc.thePlayer.setSprinting(true);
				
			}
		}
	}

}

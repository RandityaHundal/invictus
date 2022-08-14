package invictus;

import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import invictus.events.Event;
import invictus.modules.Module;
import invictus.modules.movement.Fly;
import invictus.modules.movement.Sprint;
import invictus.ui.HUD;

public class Client {
	
	public static String name = "Invictus", version = "1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	
	public static void startup(){
		System.out.println("Starting" +" " + name + " " + version);
		Display.setTitle(name + " " + version);
		
		modules.add(new Fly());
		modules.add(new Sprint());
	}
	
	public static void onEvent(Event e){
		for(Module m : modules){
			if(!m.toggled)
				continue;
			
			m.onEvent(e);
		}
	}
	
	public static void keyPress(int key){
		for(Module m : modules){
			if(m.getkey() == key){
				m.toggle();
			}
		}	
	}
	
}

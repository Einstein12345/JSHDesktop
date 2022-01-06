package jshdesktop;

import javax.swing.SwingUtilities;

import jshdesktop.desktop.frame.DialogFrame;
import jshdesktop.desktop.frame.DialogFrame.DialogType;
import terra.shell.modules.ModuleEvent;
import terra.shell.modules.ModuleEvent.DummyEvent;
import terra.shell.utils.keys.Event;

public class module extends terra.shell.modules.Module {
	private static JDesktopFrame main;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "jshdesktop";
	}

	@Override
	public void run() {
		log.debug("Run");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				main = new JDesktopFrame();
			}
		});
	}

	@Override
	public String getVersion() {
		return null;
	}

	@Override
	public String getAuthor() {
		return null;
	}

	@Override
	public String getOrg() {
		return null;
	}

	@Override
	public void onEnable() {
	}

	@Override
	public void trigger(Event event) {
		log.debug("Got Event");
		if (event instanceof DummyEvent) {
			log.debug("Got ModuleEvent");
			ModuleEvent me = ((DummyEvent) event).getME();
			Object[] args = me.getArgs();
			if (args.length != 1 || !(args[0] instanceof String)) {
				log.err("Invalid arguments from ModuleEvent");
				return;
			}
			String arg = (String) args[0];
			if (arg.equals("END_SESSION")) {
				DialogFrame.createDialog(DialogType.OK, "Ending Session");
				main.setVisible(false);
				main = null;
			}
		}
	}

	public static JDesktopFrame getDesktopFrame() {
		return main;
	}

}
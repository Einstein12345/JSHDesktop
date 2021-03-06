/**
 * This software is released as part of the Pumpernickel project.
 * 
 * All com.pump resources in the Pumpernickel project are distributed under the
 * MIT License:
 * https://raw.githubusercontent.com/mickleness/pumpernickel/master/License.txt
 * 
 * More information about the Pumpernickel project is available here:
 * https://mickleness.github.io/pumpernickel/
 */
package jshdesktop.com.pump.showcase;

import java.awt.Font;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.UIManager;

import jshdesktop.com.pump.swing.FontComboBox;

/**
 * This FontFactory shows the fonts in the current UIManager.
 */
public class UIManagerFontFactory extends FontComboBox.FontFactory {

	@Override
	protected SortedMap<String, Font> createFonts() {
		SortedMap<String, Font> returnValue = new TreeMap<>();
		for (Entry entry : UIManager.getDefaults().entrySet()) {
			if (entry.getValue() instanceof Font) {
				Font font = (Font) entry.getValue();
				returnValue.put(String.valueOf(entry.getKey()), font);
			}
		}
		return returnValue;
	}

}
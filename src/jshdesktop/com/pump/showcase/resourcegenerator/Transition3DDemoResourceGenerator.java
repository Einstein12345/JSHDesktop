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
package jshdesktop.com.pump.showcase.resourcegenerator;

import jshdesktop.com.pump.image.transition.Transition;
import jshdesktop.com.pump.showcase.demo.Transition3DDemo;

public class Transition3DDemoResourceGenerator
		extends Transition2DDemoResourceGenerator {

	@Override
	protected Transition[][] getTransitions() {
		return Transition3DDemo.getTransitions();
	}

}
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
package jshdesktop.com.pump.text.html.css;

/**
 * This is a parsed value from CSS data. This is not analogous to the non-public
 * CSS.CssValue class.
 */
public interface CssValue {
	String toCSSString();

	/**
	 * Return a CssValueCreationToken, which is basically a timestamp.
	 */
	CssValueCreationToken getCreationToken();
}
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
package jshdesktop.com.pump.image.gif;

/**
 * A factory to create a {@link jshdesktop.com.pump.image.gif.GifEncoder}.
 */
public class GifEncoderFactory {
	private static GifEncoderFactory factory = new GifEncoderFactory();

	/** Return the static factory. */
	public static GifEncoderFactory get() {
		return factory;
	}

	/** Set the static factory. */
	public static void set(GifEncoderFactory newFactory) {
		if (newFactory == null)
			throw new NullPointerException();
		factory = newFactory;
	}

	/** Create a GifEncoder. */
	public GifEncoder createEncoder() {
		return new BasicGifEncoder();
	}
}
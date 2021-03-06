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
package jshdesktop.com.pump.graphics.vector;

import java.awt.Shape;
import java.io.IOException;
import java.util.Objects;

import jshdesktop.com.pump.geom.ImmutableShape;
import jshdesktop.com.pump.geom.ShapeUtils;
import jshdesktop.com.pump.graphics.Graphics2DContext;

/**
 * This is the abstract parent class for the {@link DrawOperation} and
 * {@link FillOperation}.
 * <p>
 * Shapes are cloned.
 */
public abstract class ShapeOperation extends Operation {
	private static final long serialVersionUID = 1L;

	protected static final String PROPERTY_SHAPE = "shape";

	protected ShapeOperation(Graphics2DContext context, Shape shape) {
		super(context);
		setShape(shape);
	}

	/**
	 * Set the shape to draw or fill. The argument will be cloned as it is
	 * stored in this Operation.
	 */
	public void setShape(Shape shape) {
		Objects.requireNonNull(shape);
		coreProperties.put(PROPERTY_SHAPE, ShapeUtils.clone(shape));
	}

	/**
	 * Return the shape to draw or fill.
	 */
	public ImmutableShape getShape() {
		Shape s = (Shape) coreProperties.get(PROPERTY_SHAPE);
		return new ImmutableShape(s);
	}

	private void writeObject(java.io.ObjectOutputStream out)
			throws IOException {
		out.writeInt(0);
	}

	private void readObject(java.io.ObjectInputStream in)
			throws IOException, ClassNotFoundException {
		int version = in.readInt();
		if (version == 0) {
			// do nothing
		} else {
			throw new IOException("unsupported internal version " + version);
		}
	}
}
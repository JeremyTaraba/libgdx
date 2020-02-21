
package com.badlogic.gdx.math.collision;

import static org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;

public class CollisionTest {

	//original tests
	@Test
	public void testBoundingBox () {
		BoundingBox b1 = new BoundingBox(Vector3.Zero, new Vector3(1, 1, 1));
		BoundingBox b2 = new BoundingBox(new Vector3(1, 1, 1), new Vector3(2, 2, 2));
		assertTrue(b1.contains(Vector3.Zero));
		assertTrue(b1.contains(b1));
		assertFalse(b1.contains(b2));
		// Note, in stage the bottom and left sides are inclusive while the right and top sides are exclusive.
	}

	//Jeremy Taraba's added tests
	@Test
	public void testBoundingBox2 (){
		//testing if large values to small values will create a box
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		BoundingBox b2 = new BoundingBox(new Vector3(-2, -2, -2), new Vector3(2, 2, 2));
		assertTrue(b1.intersects(b2));

		//set boundingbox using the function instead of vectors
		BoundingBox b3 = new BoundingBox(b1);
		
		//check b3 == b1 and b2 != b1 or b3
		assertTrue(b1.contains(b3));
		assertTrue(b1.getCenterX() == b3.getCenterX());
		assertFalse(b1.getCenterX() == b2.getCenterX());
		assertTrue(b1.getCenterY() == b3.getCenterY());
		assertFalse(b1.getCenterY() == b2.getCenterY());
		assertTrue(b1.getCenterZ() == b3.getCenterZ());
		assertFalse(b1.getCenterZ() == b2.getCenterZ());
		assertTrue(b1.getWidth() == b3.getWidth());
		assertTrue(b1.getDepth() == b2.getDepth());
		assertTrue(b1.getHeight() == b3.getHeight());
		
		//change dimensions to see if width, height, depth changed
		b2.ext(b1);
		assertFalse(b1.getWidth() == b2.getWidth());
		assertFalse(b3.getHeight() == b2.getHeight());
		assertFalse(b1.getDepth() == b2.getDepth());

		//change b1 and b3 values to be different
		b3.inf();
		b1.clr();
		//b3 should now be inf
		assertTrue(b1.min != b3.min && b1.max != b3.max);
		b1.ext(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		
	}

	//Jeremy Taraba's added tests
	@Test
	public void testBoundingBox3 (){
		//testing if large values to small values will create a box
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		BoundingBox b2 = new BoundingBox(b1);
		
		
	}
	

}

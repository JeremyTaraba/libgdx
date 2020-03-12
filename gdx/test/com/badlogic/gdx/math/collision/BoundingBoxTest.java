
package com.badlogic.gdx.math.collision;

import static org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;

import org.junit.Test;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;

public class BoundingBoxTest {

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
	public void testIntersect (){
		//testing if large values to small values will create a box
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		BoundingBox b2 = new BoundingBox(new Vector3(-2, -2, -2), new Vector3(2, 2, 2));
		assertTrue(b1.intersects(b2));

	}

	@Test
	public void testInfinite(){
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		BoundingBox b2 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		b2.inf();

		//b2 should now be inf
		assertTrue(b1.min != b2.min && b1.max != b2.max);
		assertTrue(b2.min.x == Float.POSITIVE_INFINITY && b2.min.y == Float.POSITIVE_INFINITY && b2.min.z == Float.POSITIVE_INFINITY);
	}

	
	@Test
	public void testClear(){
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);

		//clear sets min and max valeus to 0
		b1.clr();
		assertTrue(b1.min.x ==  0 && b1.min.y == 0 && b1.min.z == 0);
		assertTrue(b1.max.x ==  0 && b1.max.y == 0 && b1.max.z == 0);
	}

	@Test
	public void testExtensions(){
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		BoundingBox b2 = new BoundingBox(new Vector3(-2, -2, -2), new Vector3(2, 2, 2));

		//extends it by the given box but not if the bounds are less than how big the box already is
		b1.ext(b2);
		assertTrue(b1.max.x == 4 && b1.max.y == 4 && b1.max.z == 4);
		assertTrue(b1.min.x == -2 && b1.min.y == -2 && b1.min.z == -2);

		//extends box by given center and radius(float)
		b1.ext(Vector3.Zero, 5);
		assertTrue(b1.max.x == 5 && b1.max.y == 5 && b1.max.z == 5);
		assertTrue(b1.min.x == -5 && b1.min.y == -5 && b1.min.z == -5);


		/*
		b1.ext(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		assertTrue(b1.max.x == Float.POSITIVE_INFINITY);*/


	}

	@Test
	public void testGetCorners(){
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		Vector3 v1 = new Vector3(3, 3, 3);
		Vector3 v2 = new Vector3(0, 0, 0);

		//why do you need a vector to get the corner of a box??
		assertTrue(b1.getCorner000(v1) == v2 );

	}

	@Test
	public void testGetters(){
		//testing if large values to small values will create a box
		BoundingBox b1 = new BoundingBox(new Vector3(4, 4, 4), Vector3.Zero);
		BoundingBox b2 = new BoundingBox(new Vector3(-2, -2, -2), new Vector3(2, 2, 2));

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
		
		Vector3 v1 = new Vector3(3, 3, 3);
		b1.getCorner000(v1);

		//fix this -------------------------------------------------------------------------------------------------------------
		assertTrue(b1.getCenter(v1) == b1.getCenter(v1) );
	}
	

}

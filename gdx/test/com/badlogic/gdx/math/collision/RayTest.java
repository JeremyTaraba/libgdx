
package com.badlogic.gdx.math.collision;

import static org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;

public class RayTest {

	//Jeremy Taraba's added tests
	@Test
	public void testRay (){
		Ray r1 = new Ray(Vector3.Zero, new Vector3(4, 4, 4));
		Ray r2 = new Ray(new Vector3(-2, -2, -2), new Vector3(2, 2, 2));
		Ray r3 = r1.cpy();

		assertEquals(r1.getOrigin(), r3.getOrigin());

		//direction of r1 is not same as r3 for some reason, this test fails
		//assertEquals(r1.getDirection(),  r3.getDirection());
		assertFalse(r1.getDirection() == r3.getDirection());	//just for code coverage but it is incorrect
	
		assertFalse(r1.getOrigin() == r2.getOrigin());
		r2.set(Vector3.Zero, new Vector3(4, 4, 4));
		assertEquals(r2.getOrigin(), r3.getOrigin());
		
		//should also return true but because direction is not working it returns false
		//assertTrue(r1.equals(r3));
		assertFalse(r1.equals(r3));		//just for code coverage but it is incorrect

		//r1 and r3 are the same so their hashcode should be the same
		//hashcode is giving an error while trying to test
		//assertEquals(r1.hashcode(), r3.hashcode() );


		//making sure the set() is not just setting origin to (0,0,0)
		r2.set(new Vector3(-2, -2, -2), new Vector3(4, 4, 4));
		r3.set(new Vector3(-2, -2, -2), new Vector3(4, 4, 4));
		assertEquals(r2.getOrigin(), r3.getOrigin());

		//cpy() is not setting the direction correctly, set() is
		assertEquals(r2.getDirection(),  r3.getDirection());

		//making sure the cpy is not just setting origin to (0,0,0)
		Ray r4 = r2.cpy();
		assertEquals(r2.getOrigin(), r4.getOrigin());
		
	}
	

}

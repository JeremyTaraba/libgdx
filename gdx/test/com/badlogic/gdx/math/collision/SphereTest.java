
package com.badlogic.gdx.math.collision;

import static org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;

public class SphereTest {

	//Jeremy Taraba's added tests
	@Test
	public void testConstructors (){

        //creates sphere at origin 0,0,0 and radius 4
        Sphere sp1 = new Sphere(new Vector3(0,0,0), 4);
        Sphere sp2 = new Sphere(new Vector3(1,1,1), 7);

        
        assertTrue(sp1.equals(sp1));
        assertTrue(sp1.overlaps(sp2));
        assertFalse(sp1.equals(sp2));

       //I don't know how many decimals it rounds to so I'm gonna round to int
        assertEquals( Math.round(sp1.volume()), 268);
        assertEquals(Math.round(sp1.surfaceArea()), 201);


    }
    

	

}


package com.badlogic.gdx.math.collision;

import static org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;

public class SegmentTest {

	//Jeremy Taraba's added tests
	@Test
	public void testConstructors (){
        Vector3 v1 = new Vector3(0,0,0);
        Vector3 v2 = new Vector3(4,4,4);

        Segment s1 = new Segment(v1, v2);
        Segment s2 = new Segment(0, 0, 0, 4, 4, 4);
        Segment s3 = new Segment(1, 1, 1, 4, 4, 4);

        assertTrue(s1.equals(s2));
        assertTrue(s1.equals(s1));
        assertFalse(s1.equals(s3));
        assertTrue(s1.len() == s2.len());
        assertTrue(s1.len2() == s2.len2());

        //can't really test hashcode

    }
    

	

}

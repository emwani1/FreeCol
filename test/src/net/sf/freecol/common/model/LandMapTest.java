package net.sf.freecol.common.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LandMapTest {

	
	LandMap lm;
	int width = 50;
	int height = 50;
	int weight = 60;
	@Before
	public void setUp() throws Exception {
		lm = new LandMap(width,height);
	}

	@After
	public void tearDown() throws Exception {
		lm = null;
	}

	@Test
	public void testGetWidth() {
		try{
			setUp();
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(50,lm.getWidth());
	}

	@Test
	public void testGetHeight() {
		try{
			setUp();
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(50,lm.getHeight(),0.001);
	}

	@Test
	public void testIsValid() {
		try{
			setUp();
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(true,lm.isValid(20, 30));
		assertEquals(false,lm.isValid(70, 30));
	}

	@Test
	public void testIsLand() {
		try{
			setUp();
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(false,lm.isLand(20, 30));
		assertEquals(false,lm.isLand(90, 30));
	}



}

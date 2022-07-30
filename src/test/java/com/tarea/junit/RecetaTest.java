package com.tarea.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RecetaTest {
	
	private Receta receta;
	
	@Before
	public void setUp() throws Exception {
		receta = new Receta("Café Normal", 1000, new int[] {1, 2, 3, 4});
	}

	@Test
	public void testReceta() {
		int[] nums = {1, 2, 3, 4};
		for (int i = 0; i < 4; i++) {
			assertEquals(nums[i], receta.getIngredientes()[i]);
		}
	}

}

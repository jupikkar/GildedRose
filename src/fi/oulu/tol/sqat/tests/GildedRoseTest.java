package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fi.oulu.tol.sqat.GildedRose;

import fi.oulu.tol.sqat.*;

@RunWith (Parameterized.class)
public class GildedRoseTest {
	
	Item item;
	int expectedSellIn;
	int expectedQuality;
	
	public GildedRoseTest (Item item, int expectedSellIn, int expectedQuality){
		this.item = item;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
	}
	
	@Parameters (name = "{index} SellIn: {1} Quality: {2}")
	public static List<Object[]> myData(){
		return Arrays.asList(new Object [][] {
		{new Item("Aged Brie", 2, 0), 1, 1},
		{new Item("+5 Dexterity Vest", 10, 20), 9, 19},
		{new Item("Elixir of the Mongoose", 5, 7), 4, 6},
		{new Item("Sulfuras, Hand of Ragnaros", 0, 80), 0, 80},
		{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), 14, 21},
		{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 25), 8, 27},
		{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20), 1, 23},
		{new Item("Aged Brie", 2, 50), 1, 50},
		});
	}
	
	
	@Test
	public void testUpdateItem(){
		GildedRose.updateItem(item);
		
		assertEquals("SellIn not correct", expectedSellIn, item.getSellIn());
		assertEquals("Quality not correct", expectedQuality, item.getQuality());
	}
}

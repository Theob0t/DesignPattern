package edu.insightr.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class InventoryTest {

    Item[] itemsTab = new Item[1];


    @Test
    void updateQuality() {
        //int expectedValue = 5;
        //int realValue = 5;
        //assertEquals(expectedValue, realValue);

        //SETUP
        Item vest = new Item("+5 Derterity Vest", 9, 19);
        Item agedBrie = new Item("Aged Brie", 2, 0);
        Item elixir = new Item("Elixir of the Mongoose", 5, 7);
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item concert = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);

        itemsTab[0] = vest;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULT (eviter la logique style boucle)
        assertEquals(18, inventTest.getItems()[0].getQuality());
    }

    @Test
    void datePassedQualityDecreaseTwice() {

        //SETUP
        Item elixir = new Item("Elixir of the Mongoose", 0, 7);
        itemsTab[0] = elixir;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();


        //TEST RESULT
        assertEquals(5, inventTest.getItems()[0].getQuality());
    }

    @Test
    void noNegativeQuality(){
        //SETUP
        Item elixir = new Item("Elixir of the Mongoose", 5, 0);
        itemsTab[0] = elixir;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST RESULT
        assertEquals(0, inventTest.getItems()[0].getQuality());
   }

   @Test
    void brieQtyIncreaseWhenGetsOld(){
       //SETUP
        Item agedBrie = new Item("Aged Brie", 2, 1);
       itemsTab[0] = agedBrie;
       Inventory inventTest = new Inventory(itemsTab);

       //ACTION
       inventTest.updateQuality();


       //TEST RESULT
       assertEquals(2,inventTest.getItems()[0].getQuality());
   }

   @Test
    void qtyNeverMoreThan50(){
        //SETUP
       Item agedBrie = new Item("Aged Brie", 2, 50);
       itemsTab[0] = agedBrie;
       Inventory inventTest = new Inventory(itemsTab);

       //ACTION
       inventTest.updateQuality();

       //TEST RESULT
       assertEquals(50,inventTest.getItems()[0].getQuality());
   }

   @Test
    void sulfuraNeverGetSoldQtyNeverDecreases(){
       //SETUP
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
       itemsTab[0] = sulfuras;
       Inventory inventTest = new Inventory(itemsTab);

       //ACTION
       inventTest.updateQuality();

       //TEST RESULT
       assertEquals(80,inventTest.getItems()[0].getQuality());

   }
}
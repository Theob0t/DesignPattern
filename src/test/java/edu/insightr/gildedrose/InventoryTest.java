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
        Item vest = new Item("+5 Dexterity Vest", 9, 19);
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


   @Test //Quality increases by 2 when there are 10 days or less
    void backstageQualIncreasesby2(){
        //SETUP
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        itemsTab[0] = backstage;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST RESULT
        assertEquals(22,inventTest.getItems()[0].getQuality());
    }


    @Test //Quality increases by 2 when there are 5 days or less
    void backstageQualIncreasesby3(){
        //SETUP
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        itemsTab[0] = backstage;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST RESULT
        assertEquals(23,inventTest.getItems()[0].getQuality());
    }
    @Test //Quality drops to 0 after the concert
    void backstageQualDropsTo0 (){
            //SETUP
            Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
            itemsTab[0] = backstage;
            Inventory inventTest = new Inventory(itemsTab);

            //ACTION
            inventTest.updateQuality();

            //TEST RESULT
            assertEquals(0,inventTest.getItems()[0].getQuality());
    }

    @Test
    void conjuredQual(){
        //SETUP
        Item conjured = new Item("Conjured Mana Cake", 3, 6);
        itemsTab[0] = conjured;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST RESULT
        assertEquals(4,inventTest.getItems()[0].getQuality());
    }
    @Test
    void conjuredQualSellIn0(){
        //SETUP
        Item conjured = new Item("Conjured Mana Cake", 0, 6);
        itemsTab[0] = conjured;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST RESULT
        assertEquals(2,inventTest.getItems()[0].getQuality());

    }

}
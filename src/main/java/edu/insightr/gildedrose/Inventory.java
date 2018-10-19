package edu.insightr.gildedrose;

public class Inventory {

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };

    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() != "Aged Brie"
                    && items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") { //Vest, Elixir, Suluras, Conjured
                if (items[i].getQuality() > 0) { //(can't be negative)
                    if (items[i].getName() != "Sulfuras, Hand of Ragnaros") { //Sulfuras
                        items[i].setQuality(items[i].getQuality() - 1);//Quality shouldn't change (sulfuras.quality = 80)
                    }
                    if(items[i].getName() == "Conjured Mana Cake"){
                        items[i].setQuality(items[i].getQuality() - 1);}
                }
            } else { //Aged Brie & Backstage (ELSE of if not Aged Brie and Backstage
                if (items[i].getQuality() < 50) { //has to be <50 anyway
                    items[i].setQuality(items[i].getQuality() + 1); //Quality increase when it gets old (brie & back)

                    if (items[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getSellIn() < 11) {//backstage Quality increases by 2 when there are 10 days or less
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        if (items[i].getSellIn() < 6) {//backstage Quality increases by 3 when there are 5 days or less
                                items[i].setQuality(items[i].getQuality() + 1);
                        }
                    }
                }
            }

            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {//vest, brie, elixir, backstage, conjured
                items[i].setSellIn(items[i].getSellIn() - 1); //end of each day system lowers Sellin vallue
            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName() != "Aged Brie") {//vest, elixir, sulfuras, backstage, conjured
                    if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {//vest, elixir, sulfuras, conjured
                        if (items[i].getQuality() > 0) {//qualtity can't be negative
                            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {//vest, elixir, conjured
                                items[i].setQuality(items[i].getQuality() - 1);
                                if(items[i].getName() == "Conjured Mana Cake"){
                                    items[i].setQuality(items[i].getQuality() - 1);//Conjured decrease twice as fast as normal items
                                }
                            }
                        }
                    } else {//Backstage
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());//Quality drops to 0
                    }
                } else {//Brie
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);//Quality increases
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }

    public Item[] getItems() {
        return items;
    }
}

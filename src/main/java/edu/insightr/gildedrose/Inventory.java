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
            if (items[i].getQuality() < 50) {

                switch (items[i].getName()) {
                    case "+5 Dexterity Vest":
                        items[i].setSellIn(items[i].getSellIn() - 1);
                        if (items[i].getSellIn() > 0) {items[i].setQuality(items[i].getQuality() - 1);}
                        if(items[i].getSellIn() < 0) {items[i].setQuality(items[i].getQuality() - 2);}
                        if (items[i].getSellIn() < 0){items[i].setQuality(items[i].getQuality() - items[i].getQuality());}
                        break;

                    case "Aged Brie":
                        items[i].setSellIn(items[i].getSellIn() - 1);
                        if (items[i].getSellIn() > 0) {
                            items[i].setQuality(items[i].getQuality() + 1);
                        }
                        break;

                    case "Elixir of the Mongoose":
                        items[i].setSellIn(items[i].getSellIn() - 1);
                        if (items[i].getSellIn() > 0) {
                            items[i].setQuality(items[i].getQuality() - 1); }
                        if(items[i].getSellIn() < 0){items[i].setQuality(items[i].getQuality() - 2);}
                        if (items[i].getQuality() < 0){items[i].setQuality(items[i].getQuality() - items[i].getQuality());}
                        break;

                    case "Sulfuras, Hand of Ragnaros":
                        break;

                    case "Backstage passes to a TAFKAL80ETC concert":
                        items[i].setSellIn(items[i].getSellIn() - 1);
                        if (items[i].getSellIn() > 10) {
                            items[i].setQuality(items[i].getQuality() + 1);
                        }
                        if (items[i].getSellIn() < 11) {
                            items[i].setQuality(items[i].getQuality() + 2);
                        }//backstage Quality increases by 2 when there are 10 days or less
                        if (items[i].getSellIn() < 6) {
                            items[i].setQuality(items[i].getQuality() + 1);
                        }//backstage Quality increases by 3 when there are 5 days or less
                        if (items[i].getSellIn() < 1){items[i].setQuality(items[i].getQuality() - items[i].getQuality());}
                        break;

                    case "Conjured Mana Cake":
                        items[i].setSellIn(items[i].getSellIn() - 1);
                        if (items[i].getSellIn() > 0) {
                            items[i].setQuality(items[i].getQuality() - 2); }
                        if(items[i].getSellIn() < 0){  items[i].setQuality(items[i].getQuality() - 4);}
                        if (items[i].getQuality() < 0){items[i].setQuality(items[i].getQuality() - items[i].getQuality());}
                        break;

                     default: break;

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

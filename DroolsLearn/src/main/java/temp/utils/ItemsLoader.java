package temp.utils;

import temp.ResourceUtil;
import temp.items.Item;
import temp.items.ItemImpl;
import temp.items.parameters.Activity;
import temp.items.parameters.Season;
import temp.items.parameters.StringParameter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Anton Krupnov
 * Date: 26.09.13
 * Time: 14:08
 */
public class ItemsLoader {

    ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> loadItems() {
        if (items.isEmpty()) {
            initLoadTo(items);
        }
        return items;
    }

    private void initLoadTo(List<Item> items) {
//        items.add(new ItemImpl("Обувные фонарики", Season.WINTER));
//        items.add(new ItemImpl("Перчатки 'Верхонки'", Season.WINTER));
//        items.add(new ItemImpl("Перчатки внутрение", Season.WINTER));
//        items.add(new ItemImpl("Палки", Season.WINTER));
//        items.add(new ItemImpl("Шапка", Season.WINTER));
//        items.add(new ItemImpl("Мембранный костюм", Season.WINTER));
//        items.add(new ItemImpl("Тёплые носки", Season.WINTER));
//        items.add(new ItemImpl("Очки", Season.WINTER));
//        items.add(new ItemImpl("Термос", Season.WINTER));

//        items.add(new ItemImpl("Комплект. Жумар.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Кроль.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Спелео-Беседка.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Потдержка для Кроля.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Усы, 3 шт.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Педаль.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Дельта.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Карабины, 4 шт.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. Спусковое.", Activity.SPELEO));
//        items.add(new ItemImpl("Комплект. .", Activity.SPELEO));

//        items.add(new ItemImpl("Палатка", Activity.NIGHT));

//        items.add(new ItemImpl("Ice", Season.SUMMER));

        String directory = "/items";
        String extension = ".itms";
        List<String> itemResources = ResourceUtil.getResources(directory, extension);
        for (String itemResource : itemResources) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(System.class.getResourceAsStream(itemResource)));

                String line;
                while ((line = reader.readLine()) != null) {
                    items.add(new ItemImpl(line.trim(),
                            new StringParameter(
                                    itemResource.substring(
                                            directory.length(),
                                            itemResource.length() - extension.length()))));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

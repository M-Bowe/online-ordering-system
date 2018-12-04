package org.rit.swen440.presentation;

import org.rit.swen440.control.Controller;
import org.rit.swen440.dataLayer.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class menumgr
{
    int currentLevel = 0;
    int lastLevel = 0;
    String currentCategoryName;
    String currentItemName;
    category currentCategory;
    item currentItem;
    private Controller controller;

    public menumgr()
    {
        controller = new Controller(System.getProperty("fileSystemRoot"));

    }

    public boolean loadLevel(int level)
    {
//        System.out.println("Loading level:" + currentLevel);
        switch (currentLevel)
        {
            case -1:
                return true;
            case 0:
                Level0();
                break;
            case 1:
                Level1();
                break;
            case 2:
                Level2();
                break;
            default:
                System.out.println("Returning to main org.rit.swen440.presentation.menu");
                currentLevel = 0;
                Level0();
                break;
        }

        return false;
    }

    public void Level0()
    {
        System.out.println("In Level 0");
        menu m = new menu();
        List<String> categories = controller.getCategories();
        m.loadMenu(categories);
        m.addMenuItem("'s' to view shopping cart");
        m.addMenuItem("'q' to Quit");
        System.out.println("The following org.rit.swen440.presentation.categories are available");
        m.printMenu();
        String result = "0";
        try
        {
            result = m.getSelection();
        }
        catch (Exception e)
        {
            result = "q";
        }
        if (Objects.equals(result,"q"))
        {
            currentLevel--;
        }
        else if (Objects.equals(result,"s"))
        {
            lastLevel = currentLevel;
            currentLevel = 2;
        }
        else
        {
            currentLevel++;
            int iSel = Integer.parseInt(result);

            currentCategoryName = categories.get(iSel);
            System.out.println("\nYour Selection was:" + currentCategoryName);
        }
    }

    public void Level1()
    {
        System.out.println("In Level 1");

        menu m = new menu();

        //items it = new items("orderSys/" + currentCategory.getName());

        // List<item> itemList = controller.getProducts(currentCategoryName);
        List<String> itemList = controller.getProducts(currentCategoryName);
        List<String> l = new ArrayList<>();
        System.out.println("");
        for (String itm: itemList)
            l.add(controller.getProductInformation(currentCategoryName, itm, Controller.PRODUCT_FIELD.NAME)
             + "($" + controller.getProductInformation(currentCategoryName, itm, Controller.PRODUCT_FIELD.COST) + ")");

        m.loadMenu(l);
        m.addMenuItem("'s' to view shopping cart");
        m.addMenuItem("'q' to quit");
        System.out.println("The following items are available");
        m.printMenu();
        String result = m.getSelection();
        try
        {
            int iSel = Integer.parseInt(result);//Item  selected
            currentItemName = itemList.get(iSel);
            //currentItem = itemList.get(iSel);
            //Now read the file and print the org.rit.swen440.presentation.items in the catalog
            System.out.println("You want item from the catalog: " + currentItemName);
        }
        catch (Exception e)
        {
            System.out.println(result);
            //result = "q";
        }
        if (Objects.equals(result,"q"))
            currentLevel--;
        else if (Objects.equals(result,"s"))
        {
            lastLevel = currentLevel;
            currentLevel = 2;
        }
        else
        {
            //currentLevel++;//Or keep at same level?
            OrderQty(currentCategoryName, currentItemName);
        }
    }


    public void Level2()
    {
      // SHOPPING CART HERE
      System.out.println("Shopping cart info");
      menu m = new menu();
      List<String> l = new ArrayList<>();

      //items it = new items("orderSys/" + currentCategory.getName());

      // List<item> itemList = controller.getProducts(currentCategoryName);
      // Load items that've been selected
      // List<String> itemList = controller.getProducts(currentCategoryName);
      // List<String> l = new ArrayList<>();
      System.out.println("");
      // for (String itm: itemList)
      //     l.add(controller.getProductInformation(currentCategoryName, itm, Controller.PRODUCT_FIELD.NAME)
      //      + "($" + controller.getProductInformation(currentCategoryName, itm, Controller.PRODUCT_FIELD.COST) + ")");
      //
      // m.loadMenu(l);
      // m.addMenuItem("'s' to view shopping cart");
      m.loadMenu(l);

      m.addMenuItem("'q' to quit");

      System.out.println("The following items are in your shopping cart:");
      m.printMenu();
      String result = "q";
      try{
        result = m.getSelection();
      }

      catch (Exception e)
      {
          result = "q";
      }

      if (Objects.equals(result, "q"))
          currentLevel = lastLevel;

    }

    public void OrderQty(String category, String item)
    {
        System.out.println("Please select a quantity");
        System.out.println(controller.getProductInformation(category, item, Controller.PRODUCT_FIELD.NAME) +
                " availability:" + controller.getProductInformation(category, item, Controller.PRODUCT_FIELD.INVENTORY));
        System.out.print(":");
        menu m = new menu();
        String result = m.getSelection();
        System.out.println(result + " items added to your shopping cart.");
        // ADD TO SHOPPING CART
    }
}

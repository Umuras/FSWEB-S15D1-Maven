package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery()
    {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Grocery uygulamasına hoş geldiniz, 0 uygulamayı kapatır, 1 listeye ürün ekler, 2 listden ürün" +
                "çıkarır, istediğiniz işlem için 0,1 veya 2' basınız: ");
        int input = Integer.parseInt(myInput.nextLine());

        switch (input)
        {
            case 0:
                System.out.println("Uygulamadan çıkılıyor...");
                return;
            case 1:
                Scanner addingItems = new Scanner(System.in);
                System.out.println("Listeye eklemek istediğiniz elemanları giriniz: ");
                addItems(addingItems.nextLine());
                break;
            case 2:
                Scanner deletingItems = new Scanner(System.in);
                System.out.println("Listeden silmek istediğiniz elemanları giriniz: ");
                removeItems(deletingItems.nextLine());
                break;
            default:
                System.out.println("Yanlış sayı veya klavyeden sayı yerine başka bir şey bastınız");
        }
    }

    public static void addItems(String input)
    {
       input = input.trim();
       if(input.contains(","))
       {
           String[] items = input.split(",");
           for(String item: items)
           {
                if(!checkItemIsInList(item))
                {
                    groceryList.add(item);
                }
           }
       }else{
           if(!checkItemIsInList(input))
           {
               groceryList.add(input);
           }
       }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input)
    {
        input = input.trim();
        if(input.contains(","))
        {
            String[] items = input.split(",");
            for(String item: items)
            {
                if(checkItemIsInList(item))
                {
                    groceryList.remove(item);
                }
            }
        }else{
            if(checkItemIsInList(input))
            {
                groceryList.remove(input);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product)
    {
        return groceryList.contains(product);
    }

    public static void printSorted()
    {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}

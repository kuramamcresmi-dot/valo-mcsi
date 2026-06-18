package com.kuramamc.valorant.util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiUtils {
    
    // Basit bir envanter oluşturucu
    public static Inventory createMenu(String title, int rows) {
        return Bukkit.createInventory(null, rows * 9, TextUtils.colorString(title));
    }

    // Menüye boşlukları doldurmak için cam/panel koyma metodu
    public static void fillEmptySlots(Inventory inventory, ItemStack fillerItem) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, fillerItem);
            }
        }
    }
}

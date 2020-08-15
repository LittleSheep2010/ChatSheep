package pluginCore;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeProcessing {

    public static void recipeManager() {
        ItemStack unbreakableDiamondPickaxe_Stack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemStack unbreakableDiamondAxe_Stack = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemStack unbreakableDiamondSword_Stack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack unbreakableDiamondShovel_Stack = new ItemStack(Material.DIAMOND_SHOVEL, 1);

        ItemMeta unbreakableDiamondPickaxe_ItemMeta = unbreakableDiamondPickaxe_Stack.getItemMeta();
        ItemMeta unbreakableDiamondAxe_ItemMeta = unbreakableDiamondAxe_Stack.getItemMeta();
        ItemMeta unbreakableDiamondSword_ItemMeta = unbreakableDiamondSword_Stack.getItemMeta();
        ItemMeta unbreakableDiamondShovel_ItemMeta = unbreakableDiamondShovel_Stack.getItemMeta();
        unbreakableDiamondPickaxe_ItemMeta.setUnbreakable(true);
        unbreakableDiamondAxe_ItemMeta.setUnbreakable(true);
        unbreakableDiamondSword_ItemMeta.setUnbreakable(true);
        unbreakableDiamondShovel_ItemMeta.setUnbreakable(true);
        unbreakableDiamondPickaxe_ItemMeta.setDisplayName("§c§lGod pickaxe §b- §8Stage one");
        unbreakableDiamondAxe_ItemMeta.setDisplayName("§c§lGod axe §b- §8Stage one");
        unbreakableDiamondSword_ItemMeta.setDisplayName("§c§lGod sword §b- §8Stage one");
        unbreakableDiamondShovel_ItemMeta.setDisplayName("§c§lGod shovel §b- §8Stage one");
        unbreakableDiamondPickaxe_Stack.setItemMeta(unbreakableDiamondPickaxe_ItemMeta);
        unbreakableDiamondAxe_Stack.setItemMeta(unbreakableDiamondAxe_ItemMeta);
        unbreakableDiamondSword_Stack.setItemMeta(unbreakableDiamondSword_ItemMeta);
        unbreakableDiamondShovel_Stack.setItemMeta(unbreakableDiamondShovel_ItemMeta);

        ShapedRecipe unbreakableDiamondPickaxe_Recipe = new ShapedRecipe(unbreakableDiamondPickaxe_Stack);
        ShapedRecipe unbreakableDiamondAxe_Recipe = new ShapedRecipe(unbreakableDiamondAxe_Stack);
        ShapedRecipe unbreakableDiamondSword_Recipe = new ShapedRecipe(unbreakableDiamondSword_Stack);
        ShapedRecipe unbreakableDiamondShovel_Recipe = new ShapedRecipe(unbreakableDiamondShovel_Stack);

        unbreakableDiamondPickaxe_Recipe.shape("*%*", " / ", " / ");
        unbreakableDiamondAxe_Recipe.shape("*%*", " / ", " / ");
        unbreakableDiamondSword_Recipe.shape("*%*", " / ", " / ");
        unbreakableDiamondShovel_Recipe.shape("*%*", " / ", " / ");


        unbreakableDiamondPickaxe_Recipe.setIngredient('%', Material.DIAMOND_PICKAXE);
        unbreakableDiamondPickaxe_Recipe.setIngredient('*', Material.NETHER_STAR);
        unbreakableDiamondPickaxe_Recipe.setIngredient('/', Material.GOLD_BLOCK);

        unbreakableDiamondAxe_Recipe.setIngredient('%', Material.DIAMOND_AXE);
        unbreakableDiamondAxe_Recipe.setIngredient('*', Material.NETHER_STAR);
        unbreakableDiamondAxe_Recipe.setIngredient('/', Material.GOLD_BLOCK);

        unbreakableDiamondSword_Recipe.setIngredient('%', Material.DIAMOND_SWORD);
        unbreakableDiamondSword_Recipe.setIngredient('*', Material.NETHER_STAR);
        unbreakableDiamondSword_Recipe.setIngredient('/', Material.GOLD_BLOCK);

        unbreakableDiamondShovel_Recipe.setIngredient('%', Material.DIAMOND_SHOVEL);
        unbreakableDiamondShovel_Recipe.setIngredient('*', Material.NETHER_STAR);
        unbreakableDiamondShovel_Recipe.setIngredient('/', Material.GOLD_BLOCK);

        Bukkit.getServer().addRecipe(unbreakableDiamondPickaxe_Recipe);
        Bukkit.getServer().addRecipe(unbreakableDiamondAxe_Recipe);
        Bukkit.getServer().addRecipe(unbreakableDiamondSword_Recipe);
        Bukkit.getServer().addRecipe(unbreakableDiamondShovel_Recipe);
    }
}

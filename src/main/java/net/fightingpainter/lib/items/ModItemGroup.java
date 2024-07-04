package net.fightingpainter.lib.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.fightingpainter.lib.Lib;

//a helper class for creating item groups, 

public class ModItemGroup{

    private Identifier id;
    private Item icon;

    //list of Item objects
    private Item[] items = new Item[0];

    public ModItemGroup(Identifier id, Item icon){
        this.id = id;
        this.icon = icon;
    }

    public ModItemGroup(String group_id, Item icon){
        this.id = new Identifier(Lib.MOD_ID, group_id);
        this.icon = icon;
    }

    public ModItemGroup(String group_id, String mod_id, Item icon){
        this.id = new Identifier(mod_id, group_id);
        this.icon = icon;
    }


    public ModItemGroup add(Item... items){
        this.items = items;
        return this;
    }

    public ItemGroup register(){
        return Registry.register(Registries.ITEM_GROUP, id,
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup."+id.getNamespace()+"."+id.getPath()))
                .icon(() -> new ItemStack(icon)).entries(
                    (displayContext, entries) -> {
                        for(Item item : items){
                            entries.add(() -> item);
                        }
                    }
                ).build()
        );

    }
}

package net.fightingpainter.lib.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fightingpainter.lib.Lib;

public class ModItem extends Item {

    private Identifier id;

    //identifier
    public ModItem(Identifier id) {
        super(new FabricItemSettings());
        this.id = id;
    }
    public ModItem(Identifier id, FabricItemSettings settings) {
        super(settings);
        this.id = id;
    }

    //item id
    public ModItem(String item_id) {
        super(new FabricItemSettings());
        this.id = new Identifier(Lib.MOD_ID, item_id);
    }
    public ModItem(String item_id, FabricItemSettings settings) {
        super(settings);
        this.id = new Identifier(Lib.MOD_ID, item_id);
    }

    //item id and mod id
    public ModItem(String item_id, String mod_id) {
        super(new FabricItemSettings());
        this.id = new Identifier(mod_id, item_id);
    }
    public ModItem(String item_id, String mod_id, FabricItemSettings settings) {
        super(settings);
        this.id = new Identifier(mod_id, item_id);
    }

    public Item register() {
        return Registry.register(Registries.ITEM, id, this);
    }
}

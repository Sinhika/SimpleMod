package mod.author.simplemod.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simpleores.api.config.ISimpleConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;

public class SimpleModConfig implements ISimpleConfig
{
    // recipe flags
    private static Map<String, Boolean> flags = new HashMap<>();
    public static SimpleModConfig INSTANCE = new SimpleModConfig();
    
    // general
    
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static boolean enable_foo = true;
    public static CountRangeConfig foo_cfg;
    public static int foo_veinsize = 17;

    public static boolean enable_bar = true;
    public static CountRangeConfig bar_cfg;
    public static int bar_veinsize = 17;
    
    
    // client-side
    public static boolean makeBlockFlame = true;
    
    @Override
    public void clear()
    {
        flags.clear();
    }

    @Override
    public boolean getFlag(String n)
    {
        Boolean obj = flags.get(n);
        return obj != null && obj;
    }

    @Override
    public void putFlag(String n, boolean val)
    {
        flags.put(n, val);
    }

} // end-class

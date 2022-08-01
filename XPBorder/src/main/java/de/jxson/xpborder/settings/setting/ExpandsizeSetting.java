package de.jxson.xpborder.settings.setting;

import de.jxson.xpborder.settings.Setting;

/**
 * Author: Jason M.
 * de.jxson.xpborder.settings.setting
 * 21.12.2021 at 18:32
 */
public class ExpandsizeSetting implements Setting {

    boolean b;
    int size;

    public ExpandsizeSetting() {
        if(configManager.getConfiguration().get("setting." + name() + ".enabled") != null) {
            b = configManager.getBool("setting." + name() + ".enabled");
            size = configManager.getInt("setting." + name() + ".size");
        } else {
            configManager.set("setting." + name() + ".enabled", true);
            configManager.set("setting." + name() + ".size", 1);
            b = true;
            size = 1;
        }

    }

    public String name() {
        return "expandsize";
    }

    public String value() {
        if(b) {
            return String.valueOf(size);
        } else {
            return "1";
        }
    }

    public void setSize(int size) {
        this.size = size;
        configManager.set("setting." + name() + ".size", size);

    }

    public boolean isToggled() {
        return b;
    }

    public void toggle(boolean b) {
        configManager.set("setting." + name() + ".enabled", b);
        this.b = b;
    }

}

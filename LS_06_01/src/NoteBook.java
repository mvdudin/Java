import java.util.HashMap;

public class NoteBook {
    private String vendor;
    private String model;
    private Integer ram_volume;
    private Integer hdd_volume;
    private String os_name;
    private String color;
    private static HashMap<String, String> fltr = new HashMap<>();

    public NoteBook(String vdr, String mdl, Integer ram, Integer hdd, String osn, String clr){
        this.vendor = vdr.toUpperCase();
        this.model = mdl.toUpperCase();
        this.ram_volume = ram;
        this.hdd_volume = hdd;
        this.os_name = osn.toUpperCase();
        this.color = clr.toLowerCase();
    }
    @Override
    public String toString() {
        return String.format("%s %s (OC:%s; ОЗУ:%dГб; ПЗУ%dГб; Корпус:%s)", vendor, model, os_name, ram_volume, hdd_volume, color);
    }
    public static String filterToString(){
        StringBuilder result = new StringBuilder();
        for (var node : fltr.entrySet()) {
            switch (node.getKey()) {
                case "os_name": {
                    result.append("OC:").append(node.getValue()).append(" ");
                    break;
                }
                case "ram_volume": {
                    result.append("ОЗУ минимум:").append(node.getValue()).append("Гб. ");
                    break;
                }
                case "hdd_volume": {
                    result.append("ПЗУ минимум:").append(node.getValue()).append("Гб. ") ;
                    break;
                }
                case "color": {
                    result.append("цвет корпуса:").append(node.getValue()).append(" ") ;
                    break;
                }
            }
        }
        if (result.isEmpty()) result.append("Критерий отбора не задан. Берем все ноутбуки.");
        return result.toString();
    }
    public static void setOSFilter(String osn){
        fltr.put("os_name", osn.toUpperCase());
    }
    public static void setRAMFilter(Integer ram){
        fltr.put("ram_volume", ram.toString());
    }
    public static void setHDDFilter(Integer hdd){
        fltr.put("hdd_volume", hdd.toString());
    }
    public static void setColorFilter(String clr){
        fltr.put("color", clr.toLowerCase());
    }

    public static void clearFilter(){
        fltr.clear();
    }
    public boolean select(){
        boolean result = true;
        for (var node : fltr.entrySet()) {
            if (! result) break;
            switch (node.getKey()) {
                case "os_name": {
                    result = this.os_name.indexOf(node.getValue()) > -1;
                    break;
                }
                case "ram_volume": {
                    result = this.ram_volume >= Integer.parseInt(node.getValue());
                    break;
                }
                case "hdd_volume": {
                    result = this.hdd_volume >= Integer.parseInt(node.getValue());
                    break;
                }
                case "color": {
                    result = this.color.indexOf(node.getValue()) > -1;
                    break;
                }
            }
        }
        return result;
    }
}

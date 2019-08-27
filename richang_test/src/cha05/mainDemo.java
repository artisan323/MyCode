package cha05;

public class mainDemo {
    public static void main(String[] args) {
        product p = new product("商家A", "厂家A", 100);
        p.disPlay();
        System.out.println("==================================================");

        p = new Printer("喷墨打印机","惠普",600,"6色真才","A 4");
        p.disPlay();
        System.out.println("==================================================");

        p = new Mobile("IPhone 6", "苹果", 5299, "4.7英寸", "双核");
        p.disPlay();

    }
}

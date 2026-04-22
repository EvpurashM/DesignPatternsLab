package structural;

interface MicroUsbPhone { void useMicroUsb(); }
interface LightningPhone { void useLightning(); }

class Android implements MicroUsbPhone {
    public void useMicroUsb() { System.out.println("MicroUsb підключено."); }
}

class Adapter implements LightningPhone {
    private MicroUsbPhone android;
    public Adapter(MicroUsbPhone android) { this.android = android; }
    public void useLightning() {
        System.out.println("Адаптер (Adapter): конвертуємо Lightning в MicroUsb...");
        android.useMicroUsb();
    }
}

public class AdapterPattern {
    public static void run() {
        LightningPhone phone = new Adapter(new Android());
        phone.useLightning();
    }
}
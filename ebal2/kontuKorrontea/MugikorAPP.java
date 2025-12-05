package kontuKorrontea;

public class MugikorAPP {

    public static void main(String[] args) {

        System.out.println("--- 1. Mugikor Aurreordainketa Normala ---");
        // mZ, dEK, dMK, mBK, s (Zenbakia, EzarriKostea, MinutuKostea, MBKostea, Saldoa)
        MugikorAurreordainketa normala = new MugikorAurreordainketa(666111222L, 0.20f, 0.05f, 0.01f, 10.00f);
        System.out.println("Hasierako egoera: " + normala);//to string dehitzen du horrela

        normala.deitu(120); // Dei bat 2 minutukoa (120 segundu)
        normala.nabigatu(50); // 50 MB nabigatu
        System.out.println(normala.toString());//beste modu batean

        System.out.println("\n--- 2. Mugikor Tarifa Laua ---");
        MugikorTarifaLaua tarifaLaua = new MugikorTarifaLaua(666333444L, 0.20f, 0.05f, 0.01f, 20.00f);
        System.out.println( tarifaLaua);
        
        tarifaLaua.deitu(120); // Dei bat 2 minutukoa
        tarifaLaua.nabigatu(50); // 50 MB nabigatu (ez luke kosturik izan behar)
        System.out.println("tarifa laula aldatutako parametroekin");
        System.out.println(tarifaLaua);
        
        tarifaLaua.birkargatu(10); // 10€ birkargatu (baliozkoa)
        System.out.println(tarifaLaua.toString());
        System.out.println("\n--- 3. Mugikor Plus---");
        MugikorPlus plus = new MugikorPlus(666666666L, 0.20f, 0.05f, 0.01f, 20.00f);
        System.out.println(plus);
        plus.bideodeia(20);
        System.out.println("aldaketekin: " + plus);
        
    }
}

package view;

import controller.KontrolatzaileaNagusia;

/**W
 * Programaren hasiera
 */
public class Main {

    public static void main(String[] args) {

        LeihoNagusia leihoa = new LeihoNagusia();
        new KontrolatzaileaNagusia(leihoa);

        leihoa.setVisible(true);
    }
}
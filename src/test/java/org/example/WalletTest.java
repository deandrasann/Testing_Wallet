package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    private Wallet wallet;

    @BeforeAll
    public static void connectSystemTest(){
        Wallet.connectSystem();
    }

    @AfterAll
    public static void disconnectSystem(){
        Wallet.disconectSystem();
    }

//    @BeforeEach
//    public void setUpObj(){
//
//    }

    @BeforeEach
    public void cekMoneyBefore(){
        if (wallet == null) {
            wallet = new Wallet();
            wallet.purchaseWallet("Dea");
            wallet.addMoney(500000); // Menambahkan uang 500rb dan menset nama owner
        }
        System.out.println("Saldo sebelum transaksi: " + wallet.getTotalMoney());
    }

    @AfterEach
    public void cekMoneyAfter(){
        System.out.println("Saldo setelah transaksi: " + wallet.getTotalMoney());
    }

//    @Test
//    public void getCardTest(){
//        wallet.addCard("Debit");
//        wallet.addCard("Visa");
//
//        List<String> cards = wallet.getCards();
//
//        assertEquals(2, cards.size());
//        assertTrue(cards.contains("Debit"));
//        assertTrue(cards.contains("Visa"));
//        assertFalse(cards.contains("Credit"));
//    }

//    @Test
//    void purchaseWalletTest() {
//        assertEquals("Dea", wallet.getOwner());
//    }

//    @Test
//    void addCardTest() {
//        wallet.addCard("Debit Card");
//        wallet.addCard("Credit Card");
//
//        assertTrue(wallet.getCards().contains("Debit Card"));
//        assertTrue(wallet.getCards().contains("Credit Card"));
//    }

//    @Test
//    void addMoneyNormalTest() {
//        wallet.addMoney(200000);
//        assertEquals(700000, wallet.getTotalMoney(),
//                "Saldo harusnya 700000");
//
//    }
//    @Test
//    void addMoneyNegativeTest(){
//        wallet.addMoney(-1);
//        assertEquals(500000, wallet.getTotalMoney(),
//                "Saldo tidak boleh berubah jika input negatif");
//    }
//    @Test
//    void addMoneySisaTest(){
//        wallet.addMoney(199);
//        assertEquals(500100, wallet.getTotalMoney(),
//                "Saldo harusnya bertambah 100");
//    }

//    @Test
//    public void getTotalMoneyTest() {
//        wallet.withdrawMoney(200000);
//        assertEquals(300000, wallet.getTotalMoney(), "Saldo harus tersisa 300000 setelah penarikan");
//
//        wallet.addMoney(5250);
//        assertEquals(305250, wallet.getTotalMoney(), "Saldo harus bertambah sesuai jumlah uang yang ditambahkan");
//    }

    @Test
    void withdrawNormalMoneyTest() {
        wallet.withdrawMoney(200000);
        assertEquals(300000, wallet.getTotalMoney(),
                "Saldo harus tersisa 300000 setelah penarikan 200000");
    }

    @Test
    void withdrawNegativeMoneyTest(){
        wallet.withdrawMoney(-1);
        assertEquals(500000, wallet.getTotalMoney(),
                "Negatif tidak bisa ditarik");
    }

    @Test
    void withdrawMoreMoneyTest(){
        wallet.withdrawMoney(600000); // Seharusnya gagal karena saldo tidak mencukupi
        assertEquals(500000, wallet.getTotalMoney(),
                "Saldo tidak boleh berubah karena uang tidak mencukupi");
    }
}

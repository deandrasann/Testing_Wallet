package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    private Wallet wallet;

    @BeforeEach
    public void setUpObj(){
        wallet = new Wallet();
        wallet.purchaseWallet("Dea");
//        wallet.addMoney(201);
    }

    @Test
    public void getCardTest(){
        List<String> cards = wallet.getCards();
        wallet.addCard("Debit");
        wallet.addCard("Visa");
//        assertEquals(2, cards.size()); //Berhasil
//        assertEquals("Debit", cards.get(0)); //Berhasil
//        assertTrue(cards.contains("Debit")); //Berhasil
//        assertTrue(cards.contains("Credit"));
//        assertFalse(cards.contains("Credit")); //Berhasil
        assertFalse(cards.contains("Debit"));
    }


    @Test
    void purchaseWalletTest() {
//        assertEquals("Dea", wallet.purchaseWallet("Dea"),
//                "Not the wallet owner");

        assertEquals("Dea", wallet.purchaseWallet("Rio"), "Not the wallet owner");
    }

    @Test
    void addCardTest() {
//        Wallet wallet1 = new Wallet();
//        wallet1.addCard("KTM");
//        assertTrue(wallet1.getCards().contains("KTM"));

        wallet.addCard("Debit Card");
        wallet.addCard("Credit Card");

//        assertTrue(wallet.getCards().contains("Debit Card"));
        assertTrue(wallet.getCards().contains("Credit Card"));
    }


    @Test
    void addMoney() {
//        wallet.addMoney(2499);
//        assertEquals(2400, wallet.getTotalMoney(), "harusnya 2400");
//        assertEquals(2499, wallet.getTotalMoney(), "harusnya 2400");
//        assertEquals(2500, wallet.getTotalMoney(), "harusnya 2400");

//        wallet.addMoney(2500);
//        assertEquals(2400, wallet.getTotalMoney(), "harusnya 2500");
//        assertEquals(2500, wallet.getTotalMoney(), "harusnya 2500");

        wallet.addMoney(-1);
        assertEquals(-1, wallet.getTotalMoney());

//        wallet.addMoney(2501);
//        assertEquals(2500, wallet.getTotalMoney(), "harusnya 2500");
//        assertEquals(2501, wallet.getTotalMoney(), "harusnya 2500");
//        assertEquals(2600, wallet.getTotalMoney(), "harusnya 2500");

        //TEST CASE COINS
//        wallet.addMoney(99);
//        assertEquals(0, wallet.getTotalMoney());
//        assertEquals(99, wallet.getTotalMoney());
//        assertEquals(100, wallet.getTotalMoney());
//        wallet.addMoney(100);
//        assertEquals(100, wallet.getTotalMoney());
//        assertEquals(0, wallet.getTotalMoney());
//        wallet.addMoney(101);
//        assertEquals(100, wallet.getTotalMoney());
//        assertEquals(200, wallet.getTotalMoney());
    }

    @Test
    void getTotalMoney() {
        wallet.addMoney(20000);
//        assertEquals(20000, wallet.getTotalMoney());
        wallet.addMoney(5250);
//        assertEquals(25250, wallet.getTotalMoney()); //Error
        assertEquals(25200, wallet.getTotalMoney());

//        Wallet wallet1 = new Wallet();
//        wallet1.addMoney(200);
//        wallet.addMoney(50000);
//        assertEquals(70000, tm);
    }

    @Test
    void withdrawMoneyTest() {

//        wallet.addMoney(1000);
//        wallet.withdrawMoney(-999);
//        assertEquals(1, wallet.getTotalMoney());
//
//        wallet.addMoney(999);
//        wallet.withdrawMoney(1000); // Melebihi total uang dalam wallet
//        assertEquals(1, wallet.getTotalMoney(), "Saldo Kurang");

//        wallet.addMoney(1000);
//        wallet.withdrawMoney(1000);
//        assertEquals(0, wallet.getTotalMoney());

        wallet.addMoney(1200);
        wallet.withdrawMoney(200);
        assertEquals(1000, wallet.getTotalMoney());


    }
}
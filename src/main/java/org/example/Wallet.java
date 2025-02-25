package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String owner;
    private final List<Integer> coins = new ArrayList<>();
    private final List<Integer> bills = new ArrayList<>();
    private final List<String> cards = new ArrayList<>();

    private final List<Integer> coinValues = List.of(500, 200, 100);
    private final List<Integer> billsValues = List.of(100000, 50000, 20000, 10000, 5000, 2000, 1000);

    public String purchaseWallet(String buyerName) {
        if (this.owner == null) {
            this.owner = buyerName;
            return buyerName;
        }
        return null;
    }

    public List<String> getCards() {
        if (owner == null) {
            System.out.println("Wallet belum dibeli. Tidak dapat membuat kartu.");
            return new ArrayList<>();
        }
        return cards;
    }

    public void addCard(String card) {
        if (owner == null) {
            System.out.println("Wallet belum dibeli. Tidak dapat menambahkan kartu.");
            return;
        }
        if (card == null || card.isEmpty()) {
            System.out.println("Nama kartu tidak boleh kosong.");
            return;
        }
        cards.add(card);
        System.out.println("Kartu " + card + " berhasil ditambahkan.");
    }

    public int addMoney(int amount) {
        if (owner == null) {
            System.out.println("Wallet belum dibeli. Tidak dapat menambahkan uang.");
            return amount;
        }
        if (amount <= 0) {
            System.out.println("Jumlah uang harus lebih dari 0.");
            return amount;
        }

        int originalAmount = amount;

        for (int bill : billsValues) {
            while (amount >= bill) {
                bills.add(bill);
                amount -= bill;
            }
        }

        for (int coin : coinValues) {
            while (amount >= coin) {
                coins.add(coin);
                amount -= coin;
            }
        }

        if (amount > 0) {
            System.out.println("Sisa uang tidak dapat diterima: " + amount + " rupiah dikembalikan.");
            return amount;
        }

        System.out.println("Berhasil menambahkan: " + originalAmount + " rupiah.");
        return amount;
    }

    public int getTotalMoney() {
        if (owner == null) {
            System.out.println("Wallet belum dibeli. Tidak dapat menghitung total uang.");
            return 0;
        }
        int totalMoney = bills.stream().mapToInt(Integer::intValue).sum()
                + coins.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total uang dalam wallet: " + totalMoney + " rupiah.");
        return totalMoney;
    }

    public void withdrawMoney(int amount) {
        if (owner == null) {
            System.out.println("Wallet belum dibeli. Tidak dapat melakukan penarikan uang.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Jumlah penarikan harus lebih dari 0.");
            return;
        }

        int totalMoney = getTotalMoney();
        if (amount > totalMoney) {
            System.out.println("Uang tidak mencukupi.");
            return;
        }
        int remaining = amount;

        for (Integer bill : new ArrayList<>(bills)) {
            if (remaining >= bill) {
                bills.remove(bill);
                remaining -= bill;
            }
        }

        for (Integer coin : new ArrayList<>(coins)) {
            if (remaining >= coin) {
                coins.remove(coin);
                remaining -= coin;
            }
        }

        if (remaining > 0) {
            System.out.println("Sisa uang tidak dapat diterima: " + remaining + " rupiah dikembalikan.");
        } else {
            System.out.println("Penarikan berhasil: " + amount + " rupiah.");
        }
    }
}



package org.progprojet;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class WalletTest {

    @Test
    public void testAddMoney() {
        Wallet wallet = new Wallet("red", 5, 0.6, "Gucci");
        assertEquals(200, wallet.addMoney(200));
        assertEquals(220, wallet.addMoney(20));
        assertEquals(220, wallet.checkMoney());
    }

    @Test
    public void testGetMoney() {
        Wallet wallet = new Wallet("red", 5, 0.6, "Gucci");
        wallet.addMoney(100);
        assertEquals(40, wallet.getMoney(60));
        assertEquals(0, wallet.getMoney(50));
    }

    @Test
    public void testAddCard() {
        Wallet wallet = new Wallet("red", 3, 0.6, "Gucci");
        assertTrue(wallet.addCard(2));
        assertFalse(wallet.addCard(2));
    }

    @Test
    public void testLostWallet() {
        Wallet wallet = new Wallet("red", 5, 0.6, "Gucci");
        wallet.addMoney(100);
        wallet.addCard(3);
        wallet.lost();
        assertEquals(0, wallet.checkMoney());
        assertFalse(wallet.addCard(1));
    }
}


package org.progprojet;

public class Wallet {
    private String color;
    private int cardHolder;
    private int existingCard;
    private double weight;
    private String brand;
    private double existingMoney;
    private boolean isLost;

    public Wallet(String color, int cardHolder, double weight, String brand){
        this.color = color;
        this.cardHolder = cardHolder;
        this.weight = weight;
        this.brand = brand;
        this.existingCard = 0;
        this.existingMoney = 0;
        this.isLost = false;
    }

    public double getMoney(double amount){
        if(isLost){
            return 0;
        }
        if (existingMoney >= amount){
            existingMoney -= amount;
            return existingMoney;
        }
        return 0;
    }

    public double addMoney(double amount){
        if(isLost || amount <= 0){
            return 0;
        }
        existingMoney += amount;
        return existingMoney;
    }

    public double checkMoney(){
        if(isLost){
            return 0;
        }
        return existingMoney;
    }
    public boolean addCard(int card){
        if(isLost){
            return false;
        }
        if(existingCard + card <= cardHolder){
            existingCard += card;
            return true;
        }
        return false;
    }

    public void lost(){
        isLost = true;
        existingMoney = 0;
        existingCard = 0;
    }

    @Override
    public String toString(){
        if(isLost){
            return "The wallet is lost!";
        }
        return "Wallet{"
                +
                "color='" + color + '\''
                +
                ", Card holder=" + cardHolder
                +
                ", Existing card=" + existingCard
                +
                ", Weight=" + weight
                +
                ", Brand='" + brand + '\''
                +
                ", Existing money=" + existingMoney
                +
                '}';
    }

    public static void main(String[] args){
        Wallet wallet = new Wallet("red", 5, 0.6, "Gucci");

        wallet.addMoney(200);
        wallet.addMoney(20);
        wallet.checkMoney();
        wallet.addCard(2);
        wallet.getMoney(199);
        wallet.lost();

    }
}

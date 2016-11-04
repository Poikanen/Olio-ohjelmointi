/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

/**
 *
 * @author tommi
 */
public abstract class Account
{
    protected String accountNumber;
    protected int balance;
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public Account()
    {
        accountNumber = "Empty";
        balance = 0;
    }
    public Account(String n, int m)
    {
        accountNumber = n;
        balance = m;
    }
    public void addMoney(int m)
    {
        balance += m;
//        System.out.println("Talletetaan tilille: "+accountNumber+" rahaa "+m);
    }
    public void withdrawMoney(int m)
    {
        if (balance > m){
        balance -=m;}
//        System.out.println("Nostetaan tililtä: "+accountNumber+" rahaa "+m);
    }
    public void print()
    {
        System.out.println("Tilinumero: "+accountNumber+" Tilillä rahaa: "+balance);
    }
}


class SavingsAccount extends Account
{
    public SavingsAccount(String n, int m)
    {
        super(n,m);
        System.out.println("Tili luotu.");
    }
}

/*class CreditAccount extends Account
{
    private int credit;
    public CreditAccount()
    {
        super();
        credit = 0;
    }
    public CreditAccount(String n, int m, int c)
    {
        super(n,m);
        credit = c;
        System.out.println("Pankkiin lisätään: "+accountNumber+","+balance+","+credit);
    }
    public void withdrawMoney(int m)
    {
        if (balance > m){
        balance -=m;}
        System.out.println("Nostetaan tililtä: "+accountNumber+" rahaa "+m);
    }
    @Override
    public void print()
    {
        System.out.println("Tilinumero: "+accountNumber);
        System.out.println("Rahamäärä: "+balance);
        System.out.println("Luotto: "+credit);
    }
}*/

package com.Yeah;
import java.util.*;

class Beverage {
    String name;
    int price;
    Beverage(String name, int price){
        this.name = name;
        this.price = price;
    }
}
public class Main {
    public static void main(String[] args) {
        List<Beverage> bevs = new ArrayList<Beverage>();
        Beverage cafeLatte = new Beverage("Iced Cafe Latte", 1500);
        Beverage vanillaLatte = new Beverage("Iced Vanilla Latte", 2000);
        Beverage icedTea = new Beverage("Iced Tea", 1000);
        Beverage coke = new Beverage("Coke", 500);
        Beverage mogu = new Beverage("Mogu Mogu", 800);
        Beverage milkiss = new Beverage("Milkiss", 500);
        Beverage chris = new Beverage("Chris Evans", 3000);
        bevs.add(cafeLatte);
        bevs.add(vanillaLatte);
        bevs.add(icedTea);
        bevs.add(coke);
        bevs.add(mogu);
        bevs.add(milkiss);
        bevs.add(chris);
        bevs.forEach(item -> System.out.println(bevs.indexOf(item)+1 +". "+ item.name +", ￦"+item.price));

        Scanner scanner = new Scanner(System.in);
        System.out.print("지폐나 동전을 투입구에 넣어주세요.\n투입구: ");
        int moneyPaid = scanner.nextInt();
        final int minPrice = 500;
        while(moneyPaid < minPrice) {
            System.out.print("구매할 수 있는 상품이 없습니다. 더 큰 금액을 넣어주세요.\n투입구: ");
            moneyPaid = scanner.nextInt();
        }
        System.out.println("￦"+moneyPaid+"을 투입하셨습니다.");
        int finalMoneyPaid = moneyPaid;

        System.out.println("------선택 가능한 상품------");
        bevs.forEach(item -> {
            if(item.price <= finalMoneyPaid)
                System.out.println(bevs.indexOf(item)+1 +". "+ item.name +", ￦"+item.price);
        });
        System.out.print("상품의 번호를 입력하세요: ");
        int choice = scanner.nextInt()-1;
        System.out.println(bevs.get(choice).name + "를 고르셨습니다.");

        int balance = moneyPaid - bevs.get(choice).price;
        System.out.println("￦"+balance + "의 거스름돈을 가져가세요.");

        scanner.close();
    }
}

package Game;

import Item.HealingItem;
import Item.PokeBall;

public class Shop {
    private Bag bag;
    private static final int POTION_PRICE = 200;
    private static final int SUPERBALL_PRICE = 500;
    private static final int ADVANCED_POTION_PRICE = 500;
    private static final int HYPERBALL_PRICE = 1000;
    private static final int MASTERBALL_PRICE = 2000;

    public Shop(Bag bag) {
        this.bag = bag;
    }

    public void buyPotion() {
        if (bag.getCoin() >= POTION_PRICE) {
            HealingItem potion = new HealingItem("Potion", "Heals a Pokémon by 20 HP.", POTION_PRICE, 20);
            if (bag.addItem(potion) == 0) {
                bag.deductCoin(POTION_PRICE);
                System.out.println("일반 회복약을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 일반 회복약을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 일반 회복약을 구매할 수 없습니다.");
        }
    }

    public void buySuperBall() {
        if (bag.getCoin() >= SUPERBALL_PRICE) {
            PokeBall superBall = new PokeBall("Super Ball", "A good, high-performance Ball that provides a higher catch rate than a standard Poké Ball.", SUPERBALL_PRICE, 0.2);
            if (bag.addItem(superBall) == 0) {
                bag.deductCoin(SUPERBALL_PRICE);
                System.out.println("슈퍼볼을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 슈퍼볼을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 슈퍼볼을 구매할 수 없습니다.");
        }
    }

    public void buyAdvancedPotion() {
        if (bag.getCoin() >= ADVANCED_POTION_PRICE) {
            HealingItem advancedPotion = new HealingItem("Advanced Potion", "Heals a Pokémon by 50 HP.", ADVANCED_POTION_PRICE, 50);
            if (bag.addItem(advancedPotion) == 0) {
                bag.deductCoin(ADVANCED_POTION_PRICE);
                System.out.println("고급 회복약을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 고급 회복약을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 고급 회복약을 구매할 수 없습니다.");
        }
    }

    public void buyHyperBall() {
        if (bag.getCoin() >= HYPERBALL_PRICE) {
            PokeBall hyperBall = new PokeBall("Hyper Ball", "A high-performance Ball that provides a higher catch rate than a Super Ball.", HYPERBALL_PRICE, 0.3);
            if (bag.addItem(hyperBall) == 0) {
                bag.deductCoin(HYPERBALL_PRICE);
                System.out.println("하이퍼볼을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 하이퍼볼을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 하이퍼볼을 구매할 수 없습니다.");
        }
    }

    public void buyMasterBall() {
        if (bag.getCoin() >= MASTERBALL_PRICE) {
            PokeBall masterBall = new PokeBall("Master Ball", "The best Poké Ball with the ultimate level of performance.", MASTERBALL_PRICE, 1.0);
            if (bag.addItem(masterBall) == 0) {
                bag.deductCoin(MASTERBALL_PRICE);
                System.out.println("마스터볼을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 마스터볼을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 마스터볼을 구매할 수 없습니다.");
        }
    }
}

package Game;

import Item.HealingItem;
import Item.PokeBall;

public class Shop {
    private Bag bag;
    private static final int POTION_PRICE = 200;
    private static final int ADVANCED_POTION_PRICE = 500;
    private static final int MONSTERBALL_PRICE = 300;
    private static final int SUPERBALL_PRICE = 500;
    private static final int HYPERBALL_PRICE = 1000;
    private static final int MASTERBALL_PRICE = 2000;

    public Shop(Bag bag) {
        this.bag = bag;
    }

    public void addPotion() {
        HealingItem potion = new HealingItem("일반 회복약", "포켓몬의 체력을 20 회복시킵니다.", POTION_PRICE, 20);
        bag.addItem(potion);
        System.out.println("상점에 일반 회복약을 추가하였습니다.");
    }

    public void addAdvancedPotion() {
        HealingItem advancedPotion = new HealingItem("고급 회복약", "포켓몬의 체력을 50 회복시킵니다.", ADVANCED_POTION_PRICE, 50);
        bag.addItem(advancedPotion);
        System.out.println("상점에 고급 회복약을 추가하였습니다.");
    }

    public void addMonsterBall() {
        PokeBall monsterBall = new PokeBall("몬스터볼", "특별한 캐치율을 제공하는 특수한 볼입니다.", MONSTERBALL_PRICE, 0.5);
        bag.addItem(monsterBall);
        System.out.println("상점에 몬스터볼을 추가하였습니다.");
    }

    public void addSuperBall() {
        PokeBall superBall = new PokeBall("슈퍼볼", "표준 포켓볼보다 높은 캐치율을 제공하는 좋은 고성능 볼입니다.", SUPERBALL_PRICE, 0.2);
        bag.addItem(superBall);
        System.out.println("상점에 슈퍼볼을 추가하였습니다.");
    }

    public void addHyperBall() {
        PokeBall hyperBall = new PokeBall("하이퍼볼", "슈퍼볼보다 높은 캐치율을 제공하는 고성능 볼입니다.", HYPERBALL_PRICE, 0.3);
        bag.addItem(hyperBall);
        System.out.println("상점에 하이퍼볼을 추가하였습니다.");
    }

    public void addMasterBall() {
        PokeBall masterBall = new PokeBall("마스터볼", "최고 수준의 성능을 가진 최상의 포켓볼입니다.", MASTERBALL_PRICE, 1.0);
        bag.addItem(masterBall);
        System.out.println("상점에 마스터볼을 추가하였습니다.");
    }


    // 나머지 아이템 추가 메소드도 한국어로 작성
    // ...

    public void buyPotion() {
        if (bag.getCoin() >= POTION_PRICE) {
            HealingItem potion = new HealingItem("포션", "포켓몬의 체력을 20 회복시킵니다.", POTION_PRICE, 20);
            if (bag.addItem(potion) == 0) {
                bag.deductCoin(POTION_PRICE);
                System.out.println("포션을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 포션을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 포션을 구매할 수 없습니다.");
        }
    }

    public void buySuperBall() {
        if (bag.getCoin() >= SUPERBALL_PRICE) {
            PokeBall superBall = new PokeBall("슈퍼볼", "표준 포켓볼보다 높은 캐치율을 제공하는 좋은 고성능 볼입니다.", SUPERBALL_PRICE, 0.2);
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
            HealingItem advancedPotion = new HealingItem("고급 회복약", "포켓몬의 체력을 50 회복시킵니다.", ADVANCED_POTION_PRICE, 50);
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
            PokeBall hyperBall = new PokeBall("하이퍼볼", "슈퍼볼보다 높은 캐치율을 제공하는 고성능 볼입니다.", HYPERBALL_PRICE, 0.3);
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
            PokeBall masterBall = new PokeBall("마스터볼", "최고 수준의 성능을 가진 최상의 포켓볼입니다.", MASTERBALL_PRICE, 1.0);
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

    public void buyMonsterBall() {
        if (bag.getCoin() >= MONSTERBALL_PRICE) {
            PokeBall monsterBall = new PokeBall("몬스터볼", "특별한 캐치율을 제공하는 특수한 볼입니다.", MONSTERBALL_PRICE, 0.5);
            if (bag.addItem(monsterBall) == 0) {
                bag.deductCoin(MONSTERBALL_PRICE);
                System.out.println("몬스터볼을 구매하였습니다.");
            } else {
                System.out.println("가방이 가득 차서 몬스터볼을 구매할 수 없습니다.");
            }
        } else {
            System.out.println("코인이 부족하여 몬스터볼을 구매할 수 없습니다.");
        }
    }
}

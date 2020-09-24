package com.company.homework.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 * <p>
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 * 1-1. BARE_HANDS - 공격력 5
 * 1-2. DAGGER - 공격력 40
 * 1-3. LONG_SWORD - 공격력 100
 * 1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 * 2-1. BLACK_POTION - 공격력 10% 증가
 * 2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 * 2-3. MUSHROOM - 무기 공격력 + 20
 */

enum Weapon {
    // 무기 구현
    BARE_HANDS(5.0), DAGGER(40.0), LONG_SWORD(100.0), DRAGON_SLAYER(250.0);

    Weapon(Double offensePower) {
        this.offensePower = offensePower;
    }

    private Double offensePower;

    public Double getOffensePower() {
        return offensePower;
    }

    public void setOffensePower(Double offensePower) {
        this.offensePower = offensePower;
    }
}

enum Item {
    // 소비 아이템 구현
    MUSHROOM(0), BLACK_POTION(0), WHITE_POSITION(0);

    private Integer count;

    Item(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

class Player {
    private Weapon currentWeapon;
    private List<Item> items;
    private Double offendPower;

    // TODO: Player에 필요한 메소드 구현
    // 무기 교체, 아이템 사용, 아이템 효과 종료 메소드 구현
    public Function<Weapon, Double> weaponChange = (weaponNew) -> {
        this.offendPower = weaponNew.getOffensePower();
        this.currentWeapon = weaponNew;
        return this.offendPower;
    };

    public Function<List<Item>, Double> useItem = (items) -> {
        for (Item item : items) {
            switch (item) {
                case MUSHROOM:
                    Item.MUSHROOM.setCount(Item.MUSHROOM.getCount() + 1);
                    break;
                case BLACK_POTION:
                    Item.BLACK_POTION.setCount(Item.BLACK_POTION.getCount() + 1);
                    break;
                case WHITE_POSITION:
                    Item.WHITE_POSITION.setCount(Item.WHITE_POSITION.getCount() + 1);
                    break;
            }
        }
        return (this.offendPower + 20 * (Item.MUSHROOM.getCount())) +
                (this.offendPower + 20 * (Item.MUSHROOM.getCount())) * 0.1 * (Item.BLACK_POTION.getCount()) +
                200 * Item.WHITE_POSITION.getCount();
    };

    public Function<List<Item>, Double> removeItem = (items) -> {
        for (Item item : items) {
            switch (item) {
                case MUSHROOM:
                    Item.MUSHROOM.setCount(Item.MUSHROOM.getCount() - 1);
                    break;
                case BLACK_POTION:
                    Item.BLACK_POTION.setCount(Item.BLACK_POTION.getCount() - 1);
                    break;
                case WHITE_POSITION:
                    Item.WHITE_POSITION.setCount(Item.WHITE_POSITION.getCount() - 1);
                    break;
            }
        }
        return (this.offendPower + 20 * (Item.MUSHROOM.getCount())) +
                (this.offendPower + 20 * (Item.MUSHROOM.getCount())) * 0.1 * (Item.BLACK_POTION.getCount()) +
                200 * Item.WHITE_POSITION.getCount();
    };

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getOffendPower() {
        return offendPower;
    }

    public void setOffendPower(Double offendPower) {
        this.offendPower = offendPower;
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        // 무기 및 아이템 장착/사용 시나리오 및 플레이어 공격력 출력
        // Dagger 장착 -> M M B W W 순서로 사용 -> Long_SWORD 로 무기 교체 -> 사용효과 제거
        Player player = new Player();
        System.out.println(player.weaponChange.apply(Weapon.DAGGER));

        System.out.println("-------------------");
        List<Item> items = new ArrayList<>();
        items.add(Item.MUSHROOM);
        items.add(Item.MUSHROOM);
        items.add(Item.BLACK_POTION);
        items.add(Item.WHITE_POSITION);
        items.add(Item.WHITE_POSITION);

        System.out.println(player.useItem.apply(items));
        System.out.println("-------------------");

        System.out.println(player.removeItem.apply(items));

        System.out.println("-------------------");
        System.out.println(player.weaponChange.apply(Weapon.DRAGON_SLAYER));
        System.out.println("-------------------");

        System.out.println(player.useItem.apply(items));
        System.out.println("-------------------");

        System.out.println(player.removeItem.apply(items));


    }
}

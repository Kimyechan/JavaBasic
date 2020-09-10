package com.company.project1.solution.basic;

public interface Playable<T> {
    boolean play(T move, Player player);
}

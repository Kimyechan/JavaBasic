package com.company.project1.solution.advanced;

public interface Playable<T> {
    boolean play(T move, Player player);
}

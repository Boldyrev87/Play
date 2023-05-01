package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTests {
    Game game = new Game();
    Player player1 = new Player(1, "Anatoly", 8);
    Player player2 = new Player(2, "John", 9);
    Player player3 = new Player(3, "Keanu", 10);
    Player player4 = new Player(4, "Neo", 8);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void test() {
        int expected = 2;
        int actual = game.round("Anatoly", "John");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_2() {
        int expected = 1;
        int actual = game.round("Keanu", "Neo");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anatoly", "Max");
        });
    }

    @Test
    public void test4() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Svetlana", "Max");
        });
    }

    @Test
    public void test5() {
        int expected = 0;
        int actual = game.round("Anatoly", "Neo");
        Assertions.assertEquals(expected, actual);
    }
}

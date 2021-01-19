package com.palvair;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    public void should_generate_getters_when_using_record() {
        final User user = new User("Ruddy", "Palvair");

        assertThat(user).extracting(User::firstname, User::lastname)
                .containsExactly("Ruddy", "Palvair");
    }

    @Test
    public void should_implements_equals_when_using_record() {
        final User user = new User("Ruddy", "Palvair");
        final User user2 = new User("Ruddy", "Palvair");

        assertThat(user.equals(user2)).isTrue();
    }

    @Test
    public void should_throw_exception_when_firstname_is_null_in_second_constructor() {
        assertThatThrownBy(() -> new User(null, "Palvair")).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void should_call_method_on_record() {
        final User user = new User("Ruddy", "Palvair");

        assertThat(user).extracting(User::getName)
                .isEqualTo("Ruddy-Palvair");
    }

    @Test
    public void should_call_static_method_on_record() {
        final User user = User.unknown();

        assertThat(user).extracting(User::getName)
                .isEqualTo("John-Doe");
    }
}
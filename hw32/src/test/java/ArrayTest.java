import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.ArrayMethods;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayTest {

    @Test
    public void testArrayAfterLastUnit() {
        Assertions.assertArrayEquals(new int[]{2, 2}, ArrayMethods.arrayAfterOneOrExcep(new int[]{1, 2, 1, 2, 2}));
    }

    @Test
    public void testRuntimeExceptionArrayAfterLastUnit() {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayMethods.arrayAfterOneOrExcep(new int[]{2, 2, 2, 2}));
    }

    @ParameterizedTest
    @MethodSource("checkArrayContainsOnlyOneAndTwoTrue")
    public void testIsArrayOfOnesAndTwosTrue(int[] array) {
        Assertions.assertTrue(ArrayMethods.checkArrayContainsOnlyOneAndTwo(array));
    }

    public static Stream<Arguments> checkArrayContainsOnlyOneAndTwoTrue() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 2, 2, 1}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("checkArrayContainsOnlyOneAndTwoFalse")
    public void checkArrayContainsOnlyOneAndTwoFalse(int[] arr) {
        Assertions.assertFalse(ArrayMethods.checkArrayContainsOnlyOneAndTwo(arr));
    }

    public static Stream<Arguments> checkArrayContainsOnlyOneAndTwoFalse() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1}));
        out.add(Arguments.arguments(new int[]{1, 3}));
        out.add(Arguments.arguments(new int[]{0, 2}));
        return out.stream();
    }
}


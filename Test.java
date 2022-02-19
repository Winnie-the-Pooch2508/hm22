import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class Test {
    void shouldThrowRuntimeException_whenNo4DigitFound_inPassedArray() {
        Assertions.assertThrows(RuntimeException.class, () -> Library.extractValuesAfterFour(new int[]{1, 2, 3, 5}));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowRuntimeException_whenNullOrEmptyArrayPassed(int[] invalidArray) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            int[] ints = Library.extractValuesAfterFour(invalidArray);
        });
    }

    @ParameterizedTest
    @MethodSource("arrayWith4DigitInsideProvider")
    void shouldRetrieve_newArrayWithValuesAfter4Digit(int[] inboundArray, int[] expected) {
        Assertions.assertArrayEquals(expected, Library.extractValuesAfterFour(inboundArray));
    }
    private static Stream<Arguments> arrayWith4DigitInsideProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[0]),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 4, 8, 9}, new int[]{8, 9})
        );
    }
    @ParameterizedTest
    @MethodSource("arrayWithNo1Or4DigitProvider")
    void shouldRetrieveFalse_whenNoFourNorOneDigitFound_inPassedArray(int[] inboundArray) {
        Assertions.assertFalse(Library.checkOneOrFourDigitPresenceTry(inboundArray));
    }
    private static Stream<int[]> arrayWithNo1Or4DigitProvider() {
        return Stream.of(
                new int[]{},
                new int[]{55},
                new int[]{2, 3},
                new int[]{2, 3, 5, 6}
        );
    }

    @ParameterizedTest
    @MethodSource("arrayWithOneOrFourDigitProvider")
    void shouldRetrieveTrue_whenOneOrFourDigitFound_inPassedArray(int[] inboundArray) {
        Assertions.assertTrue(Library.checkOneOrFourDigitPresenceFoul(inboundArray));
    }
    private static Stream<int[]> arrayWithOneOrFourDigitProvider() {
        return Stream.of(
                new int[]{1},
                new int[]{4},
                new int[]{1, 2, 3},
                new int[]{4, 3, 5, 6},
                new int[]{1, 2, 3, 5}
        );
    }
}

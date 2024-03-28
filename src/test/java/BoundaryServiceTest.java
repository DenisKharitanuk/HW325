import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.OptionalInt;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoundaryServiceTest {
    private final BoundaryService boundaryService = new BoundaryService();

    private static Stream<int[]> arrays() {
        return Stream.of((new int[]{2, 4, 0}), (new int[]{3, 3, 3}), (new int[]{4, 4, 6}), (new int[]{3, 3, 3}));
    }

    @ParameterizedTest(name = "Array test  {0}")
    @DisplayName("Finding the minimum element in an array")
    @Description("Minimum array element found")
    @MethodSource("arrays")
    public void findMinElementInArray(int[] arr) {
        OptionalInt min = OptionalInt.of(boundaryService.findMin(arr));
        OptionalInt exp = stream(arr).min();
        assertEquals(exp, min);

    }

}

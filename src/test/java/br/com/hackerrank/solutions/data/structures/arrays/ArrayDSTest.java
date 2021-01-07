package br.com.hackerrank.solutions.data.structures.arrays;

import br.com.hackerrank.solutions.HackerRankTest;
import br.com.hackerrank.solutions.In;
import br.com.hackerrank.solutions.Out;
import org.junit.jupiter.api.Test;

class ArrayDSTest extends HackerRankTest {
    @Test
    @In({
            "8",
            "6676 3216 4063 8373 423 586 8850 6762",
    })
    @Out("6762 8850 586 423 8373 4063 3216 6676")
    public void test_case_0() throws Exception {
        ArrayDS.main(null);
    }

    @Test
    @In({
            "4",
            "1 4 3 2"
    })
    @Out("2 3 4 1")
    public void test_case_8() throws Exception {
        ArrayDS.main(null);
    }
}
package br.com.hackerrank.solutions.data.structures.arrays;

import br.com.hackerrank.solutions.HackerRankTest;
import br.com.hackerrank.solutions.In;
import br.com.hackerrank.solutions.Out;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftRotationTest extends HackerRankTest {
    @Test
    @In({
            "5 4",
            "1 2 3 4 5",
    })
    @Out("5 1 2 3 4")
    public void test_case_0() throws Exception {
        LeftRotation.main(null);
    }

    @Test
    @In(filename = "arrays-left-rotation/input09.txt")
    @Out(filename = "arrays-left-rotation/output09.txt")
    public void test_case_9() throws Exception {
        LeftRotation.main(null);
    }
}
package br.com.hackerrank.solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HackerRankTest {
    @BeforeEach
    public void setUp(TestInfo testInfo) {
            mockSystemIn(testInfo);
    }

    private void mockSystemIn(TestInfo testInfo) {
        if (testInfo.getTestMethod().isPresent()) {
            In inputData = testInfo.getTestMethod().get().getAnnotation(In.class);

            if (inputData.filename().isEmpty()) {
                String inputDataString = String.join("\n", inputData.value());
                System.setIn(new ByteArrayInputStream(inputDataString.getBytes()));
            } else {
                System.setIn(getClass().getClassLoader().getResourceAsStream(inputData.filename()));
            }
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) throws IOException, URISyntaxException {
        validateResult(testInfo);
    }

    private void validateResult(TestInfo testInfo) throws IOException, URISyntaxException {
        if (testInfo.getTestMethod().isPresent()) {
            Out expectedOutputData = testInfo.getTestMethod().get().getAnnotation(Out.class);
            List<String> resultLines = Files.readAllLines(Paths.get(System.getenv("OUTPUT_PATH")));

            if (expectedOutputData.filename().isEmpty()) {
                assertArrayEquals(expectedOutputData.value(), resultLines.toArray());
            } else {
                assertArrayEquals(
                        Files.readAllLines(
                                Paths.get(
                                        getClass().getClassLoader().getResource(
                                                expectedOutputData.filename()).toURI()))
                                .toArray(),
                        resultLines.toArray());
            }
        }
    }
}

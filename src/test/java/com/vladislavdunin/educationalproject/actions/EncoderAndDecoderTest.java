package com.vladislavdunin.educationalproject.actions;

import com.vladislavdunin.educationalproject.dataDispatchers.FileDispatcher;
import com.vladislavdunin.educationalproject.entity.Result;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class EncoderAndDecoderTest {
    private Encoder encoder = new Encoder();
    private Decoder decoder = new Decoder();
    private FileDispatcher dispatcher = new FileDispatcher();
    private String inputFileEncode = "src/test/java/com/vladislavdunin/educationalproject/testresources/forEncodeTest.txt";
    private String outputFile = "src/test/java/com/vladislavdunin/educationalproject/testresources/encodedTest.txt";

    private String decodedFile = "src/test/java/com/vladislavdunin/educationalproject/testresources/decodedTest.txt";

    @Test
    void encodeAndDecodePositiveValue() {
        String key = "2";

        String[] encodeParameters = {inputFileEncode, outputFile, key};
        String[] decodeParameters = {outputFile, decodedFile, key};

        encoder.execute(encodeParameters);
        decoder.execute(decodeParameters);

        String expected = "hello world";
        String actualEncodeResult = dispatcher.getInputData(Path.of(decodedFile));
        
        assertEquals(expected, actualEncodeResult);

    }
}
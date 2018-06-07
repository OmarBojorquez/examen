package mx.unam.dgpe.sample.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

import io.vertx.core.AbstractVerticle;
import static mx.unam.dgpe.sample.controller.RestUtil.*;

public class TestMyController extends AbstractVerticle {
    private static final Logger logger = Logger.getLogger(TestMyController.class);
   
//    @Test
    public void ok() throws Exception {
        //String result = sendGet("https://www.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
        String result = sendGet("http://0.0.0.0:8080/api/tercero?mode=gusgus");
        assertTrue("Este es un mensaje", result.length() >1);
	logger.info(result);

        result = sendGet("http://0.0.0.0:8080/api/tercero?mode=gusgus2");
        assertTrue("Este es un mensaje", result.length() >1);
        logger.info(result);

        result = sendGet("http://0.0.0.0:8080/api/tercero?mode=abcabc");
        assertTrue("Este es un mensaje", result.length() >1);
        logger.info(result);

	result = sendGet("http://0.0.0.0:8081/api/suma?num1=5&num2=9");
        assertTrue("Fallo suma", result.length() > 1);
        logger.info(result);

        result = sendGet("http://0.0.0.0:8081/api/resta?num1=9&num2=3");
        assertTrue("Fallo resta", result.length() > 1);
        logger.info(result);

	result = sendGet("http://0.0.0.0:8081/api/multiplicacion?num1=2&num2=7");
        assertTrue("Fallo multiplicacion", result.length() > 1);
        logger.info(result);

        result = sendGet("http://0.0.0.0:8081/api/division?num1=9&num2=3");
        assertTrue("Fallo division", result.length() > 1);
        logger.info(result);

    }

}

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



    }

}

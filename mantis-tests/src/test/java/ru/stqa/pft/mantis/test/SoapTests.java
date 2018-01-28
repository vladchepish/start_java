package ru.stqa.pft.mantis.test;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import org.testng.annotations.Test;

import java.net.URL;

public class SoapTests {

    @Test
    public void testGetProject(){
        new MantisConnectLocator().getMantisConnectPort(new URL("http://localhost"))
    }
}

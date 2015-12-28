package mx.com.factmex.app.client;

import junit.framework.Assert;

import com.google.gwt.junit.client.GWTTestCase;

public class GwtTestSample
    extends GWTTestCase
{

   public String getModuleName()
   {
      return "mx.com.factmex.app.Application";
   }

   public void testSomething()
   {
      // Not much to actually test in this sample app
      // Ideally you would test your Controller here (NOT YOUR UI)
      // (Make calls to RPC services, test client side model objects, test client side logic, etc)
      Assert.assertTrue( true );
   }
}
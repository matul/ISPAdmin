package cz.ispadmin.services.network;

import java.util.Vector;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 *
 * @author Matul
 */
public class SNMP {

  private static String ipAddress = "192.168.1.20";
  private static String port = "161";
  private static String oidValue = ".1.3.6.1.2.1.1.1.0";  // ends with 0 for scalar object
  private static int snmpVersion = SnmpConstants.version2c;
  private static String community = "ubnt";

  public Vector getInfo() throws Exception {
    System.out.println("SNMP GET Demo");
    // Create TransportMapping and Listen
    TransportMapping transport = new DefaultUdpTransportMapping();
    transport.listen();

    // Create Target Address object
    CommunityTarget comtarget = new CommunityTarget();
    comtarget.setCommunity(new OctetString(community));
    comtarget.setVersion(snmpVersion);
    comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
    comtarget.setRetries(2);
    comtarget.setTimeout(1000);

    // Create the PDU object
    PDU pdu = new PDU();
    pdu.add(new VariableBinding(new OID(oidValue)));
    pdu.setType(PDU.GET);
    pdu.setRequestID(new Integer32(1));

    // Create Snmp object for sending data to Agent
    Snmp snmp = new Snmp(transport);

    System.out.println("Sending Request to Agent...");
    ResponseEvent response = snmp.get(pdu, comtarget);

    // Process Agent Response
    if (response != null) {
      System.out.println("Got Response from Agent");
      PDU responsePDU = response.getResponse();

      if (responsePDU != null) {
        int errorStatus = responsePDU.getErrorStatus();
        int errorIndex = responsePDU.getErrorIndex();
        String errorStatusText = responsePDU.getErrorStatusText();

        if (errorStatus == PDU.noError) {
          return responsePDU.getVariableBindings();
        } else {
          System.out.println("Error: Request Failed");
          System.out.println("Error Status = " + errorStatus);
          System.out.println("Error Index = " + errorIndex);
          System.out.println("Error Status Text = " + errorStatusText);
          return null;
        }
      }

    } else {
      return null;
    }

    snmp.close();
    return null;

  }
}

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInfo {
    public static void main(String[] args) {
        try {
            // Especificar la ruta de la carpeta "output"
            String outputPath = "output/";
            File outputFolder = new File(outputPath);
            if (!outputFolder.exists()) {
                outputFolder.mkdirs(); // Crear la carpeta si no existe
            }

            // Crear el archivo de salida en la carpeta especificada
            File outputFile = new File(outputFolder, "network_info.txt");
            FileOutputStream fos = new FileOutputStream(outputFile);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                System.out.println("Interface: " + iface.getDisplayName());
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    System.out.println("  IP Address: " + addr.getHostAddress());
                    if (!addr.isLoopbackAddress() && iface.isUp()) {
                        InterfaceAddress interfaceAddress = iface.getInterfaceAddresses().get(0);
                        InetAddress subnet = interfaceAddress.getAddress();
                        short subnetPrefix = interfaceAddress.getNetworkPrefixLength();

                        byte[] subnetBytes = subnet.getAddress();
                        int subnetInt = ((subnetBytes[0] & 0xFF) << 24) |
                                ((subnetBytes[1] & 0xFF) << 16) |
                                ((subnetBytes[2] & 0xFF) << 8) |
                                (subnetBytes[3] & 0xFF);

                        int subnetMask = -1 << (32 - subnetPrefix);
                        int network = subnetInt & subnetMask;
                        int broadcast = network | ~subnetMask;

                        System.out.println("  Subnet Mask: " + subnetPrefix);
                        System.out.println("  Network Address: " + InetAddress.getByAddress(new byte[]{
                                (byte) (network >>> 24),
                                (byte) (network >> 16 & 0xff),
                                (byte) (network >> 8 & 0xff),
                                (byte) (network & 0xff)
                        }));
                        System.out.println("  Broadcast Address: " + InetAddress.getByAddress(new byte[]{
                                (byte) (broadcast >>> 24),
                                (byte) (broadcast >> 16 & 0xff),
                                (byte) (broadcast >> 8 & 0xff),
                                (byte) (broadcast & 0xff)
                        }));

                        System.out.println("  Possible IP Addresses in Subnet:");
                        for (int i = network + 1; i < broadcast; i++) {
                            InetAddress testAddr = InetAddress.getByAddress(new byte[]{
                                    (byte) (i >>> 24),
                                    (byte) (i >> 16 & 0xff),
                                    (byte) (i >> 8 & 0xff),
                                    (byte) (i & 0xff)
                            });
                            System.out.println("    Testing: " + testAddr.getHostAddress() + " - Reachable: " + testAddr.isReachable(1000));
                        }
                    }
                }
                System.out.println();
            }

            fos.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

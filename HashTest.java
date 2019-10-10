package sber;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashTest {
    public static void main(String[] args) throws IOException {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         String st = in.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(st)); //new FileReader("C:\\Users\\mi\\Desktop\\file.txt"
        char[] buf = new char[200];
        int c;
        while ((c = reader.read(buf)) > 0) {

            if (c < 256) {
                buf = Arrays.copyOf(buf, c);
            }
            System.out.print(buf);

        }

        Pattern pattern = Pattern.compile("type=([A-Za-z_]+)\\r\\nprice=([\\d]+)");
        String test = new String(buf);
        Matcher m1 = pattern.matcher(new String(buf));
        String type = null;
        int price = 0;
        if (m1.find()) {
            type = m1.group(1);
            price = Integer.parseInt(m1.group(2));
        }

        SimpleTradeType obj = null;

        switch (type) {
            case "FX_SPOT":
                obj = new FXSPOT(price);
                break;
            case "BOND":
                obj = new Bond(price);
                break;
            case "IR_SWAP":
                obj = new Irswap(price);
            case "COMMODITY_SPOT":
                obj = new CommoditySpot(price);
                break;

        }
        TradeType trade1 = TradeType.valueOf(type).createTrade(12);
        trade1.setPrice(12);
        TradeType trade2 = TradeType.valueOf("BOND");
        trade2.setPrice(0);
    }
}

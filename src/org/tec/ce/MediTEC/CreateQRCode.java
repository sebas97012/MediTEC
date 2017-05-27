package org.tec.ce.MediTEC;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;

public class CreateQRCode {
    private static final int qrTamAncho = 400;
    private static final int qrTamAlto = 400;
    private static final String formato = "png";
    private static final String ruta = System.getProperty("user.dir") + "/qrcode.png";

    public static void CreateQRCode(String texto) {
        BitMatrix matriz;
        Writer writer = new QRCodeWriter();
        try {
            matriz = writer.encode(texto, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }
        BufferedImage imagen = new BufferedImage(qrTamAncho,
                qrTamAlto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < qrTamAlto; y++) {
            for (int x = 0; x < qrTamAncho; x++) {
                int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
            }
        }
        try {
            FileOutputStream qrCode = new FileOutputStream(ruta);
            ImageIO.write(imagen, formato, qrCode);
            qrCode.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

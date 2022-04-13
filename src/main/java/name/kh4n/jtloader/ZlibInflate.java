package name.kh4n.jtloader;

import io.kaitai.struct.CustomDecoder;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class ZlibInflate implements CustomDecoder {
    public final int compressionFlag;

    public ZlibInflate(int compressionFlag) {
        this.compressionFlag = compressionFlag;
    }

    @Override
    public byte[] decode(byte[] src) {
        if (compressionFlag != 2) {
            return src;
        }
        Inflater inflater = new Inflater();
        inflater.setInput(src);
        byte[] buf = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buf);
                outputStream.write(buf, 0, count);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        }
        return outputStream.toByteArray();
    }
}

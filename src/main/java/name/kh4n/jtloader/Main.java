package name.kh4n.jtloader;

import io.kaitai.struct.ByteBufferKaitaiStream;

class Main {
    public static void main(String[] args) throws Exception {
        Jt j = new Jt(new ByteBufferKaitaiStream(
            Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("example.jt")
                .readAllBytes()
        ));
        j.body().tocSegment().entries().get(0).data();
        System.out.println("hello");
    }
}
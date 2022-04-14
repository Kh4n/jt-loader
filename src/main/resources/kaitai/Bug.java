// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Bug extends KaitaiStruct {
    public static Bug fromFile(String fileName) throws IOException {
        return new Bug(new ByteBufferKaitaiStream(fileName));
    }

    public Bug(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Bug(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Bug(KaitaiStream _io, KaitaiStruct _parent, Bug _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.version = new String(this._io.readBytes(80), Charset.forName("ASCII"));
        this.byteOrder = this._io.readU1();
        this.body = new JtBody(this._io, this, _root);
    }
    public static class JtBody extends KaitaiStruct {
        public static JtBody fromFile(String fileName) throws IOException {
            return new JtBody(new ByteBufferKaitaiStream(fileName));
        }

        public enum Variability {
            UNKNOWN(0),
            CONSTANT(1),
            UNIFORM(2),
            VARYING(3);

            private final long id;
            Variability(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, Variability> byId = new HashMap<Long, Variability>(4);
            static {
                for (Variability e : Variability.values())
                    byId.put(e.id(), e);
            }
            public static Variability byId(long id) { return byId.get(id); }
        }

        public enum ValueClass {
            UNKNOWN(0),
            IMMEDIATE(1),
            SEMANTIC(2);

            private final long id;
            ValueClass(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, ValueClass> byId = new HashMap<Long, ValueClass>(3);
            static {
                for (ValueClass e : ValueClass.values())
                    byId.put(e.id(), e);
            }
            public static ValueClass byId(long id) { return byId.get(id); }
        }

        public enum Direction {
            UNKNOWN(0),
            INPUT(1),
            OUTPUT(2),
            BOTH(3);

            private final long id;
            Direction(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, Direction> byId = new HashMap<Long, Direction>(4);
            static {
                for (Direction e : Direction.values())
                    byId.put(e.id(), e);
            }
            public static Direction byId(long id) { return byId.get(id); }
        }

        public enum SemanticBinding {
            UNKNOWN(0),
            NONE(1),
            POSITION(2),
            NORMAL(3),
            BINORMAL(4),
            BLEND_INDICES(5),
            BLEND_WEIGHT(6),
            TANGENT(7),
            POINT_SIZE(8),
            TEX_COORD_0(10),
            TEX_COORD_1(11),
            TEX_COORD_2(12),
            TEX_COORD_3(13),
            TEX_COORD_4(14),
            TEX_COORD_5(15),
            TEX_COORD_6(16),
            TEX_COORD_7(17),
            FOG_COORDINATE(20),
            PRIMARY_COLOR_OUTPUT_INPUT(21),
            SECONDARY_COLOR(22),
            PRIMARY_COLOR_NA_OUTPUT(23),
            DEPTH_VALUE(24);

            private final long id;
            SemanticBinding(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, SemanticBinding> byId = new HashMap<Long, SemanticBinding>(22);
            static {
                for (SemanticBinding e : SemanticBinding.values())
                    byId.put(e.id(), e);
            }
            public static SemanticBinding byId(long id) { return byId.get(id); }
        }

        public enum SegmentType {
            LOGICAL_SCENE_GRAPH(1),
            JT_B_REP(2),
            PMI_DATA(3),
            META_DATA(4),
            SHAPE(6),
            SHAPE_LOD0(7),
            SHAPE_LOD1(8),
            SHAPE_LOD2(9),
            SHAPE_LOD3(10),
            SHAPE_LOD4(11),
            SHAPE_LOD5(12),
            SHAPE_LOD6(13),
            SHAPE_LOD7(14),
            SHAPE_LOD8(15),
            SHAPE_LOD9(16),
            XT_B_REP(17),
            WIREFRAME_REPRESENTATION(18),
            ULP(20),
            LWPA(24);

            private final long id;
            SegmentType(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, SegmentType> byId = new HashMap<Long, SegmentType>(19);
            static {
                for (SegmentType e : SegmentType.values())
                    byId.put(e.id(), e);
            }
            public static SegmentType byId(long id) { return byId.get(id); }
        }

        public enum StateFlags {
            ACCUMULATION_FINAL(1),
            ACCUMULATION_FORCE(2),
            ACCUMULATION_IGNORE(4),
            ATTRIBUTE_PERSISTABLE(8);

            private final long id;
            StateFlags(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, StateFlags> byId = new HashMap<Long, StateFlags>(4);
            static {
                for (StateFlags e : StateFlags.values())
                    byId.put(e.id(), e);
            }
            public static StateFlags byId(long id) { return byId.get(id); }
        }

        public enum CompressionLevel {
            UNKNOWN(-1),
            LOSSLESS(0),
            MINIMALLY_LOSSY(10),
            MODERATE_LOSSY(50),
            AGGRESSIVE_LOSSY(100);

            private final long id;
            CompressionLevel(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, CompressionLevel> byId = new HashMap<Long, CompressionLevel>(5);
            static {
                for (CompressionLevel e : CompressionLevel.values())
                    byId.put(e.id(), e);
            }
            public static CompressionLevel byId(long id) { return byId.get(id); }
        }

        public enum ParamType {
            UNKNOWN(0),
            BOOLEAN(1),
            INTEGER(2),
            FLOAT(3),
            VEC2I(4),
            VEC3I(5),
            VEC4I(6),
            VEC2F(7),
            VEC3F(8),
            VEC4F(9),
            MAT2X2F(10),
            MAT3X3F(11),
            MAT4X4F(12),
            SAMPLER1D(13),
            SAMPLER2D(14),
            SAMPLER3D(15),
            SAMPLER_RECTMAP(16),
            SAMPLER_CUBE_MAP(17),
            SAMPLER1D_SHADOW_MAP(18),
            SAMPLER2D_SHADOW_MAP(19);

            private final long id;
            ParamType(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, ParamType> byId = new HashMap<Long, ParamType>(20);
            static {
                for (ParamType e : ParamType.values())
                    byId.put(e.id(), e);
            }
            public static ParamType byId(long id) { return byId.get(id); }
        }

        public enum ShaderLanguage {
            NONE(0),
            GLSL(2);

            private final long id;
            ShaderLanguage(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, ShaderLanguage> byId = new HashMap<Long, ShaderLanguage>(2);
            static {
                for (ShaderLanguage e : ShaderLanguage.values())
                    byId.put(e.id(), e);
            }
            public static ShaderLanguage byId(long id) { return byId.get(id); }
        }

        public enum CompressionAlgo {
            NO_COMPRESSION(1),
            ZLIB_COMPRESSION(2);

            private final long id;
            CompressionAlgo(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, CompressionAlgo> byId = new HashMap<Long, CompressionAlgo>(2);
            static {
                for (CompressionAlgo e : CompressionAlgo.values())
                    byId.put(e.id(), e);
            }
            public static CompressionAlgo byId(long id) { return byId.get(id); }
        }

        public enum ElementType {
            UNKNOWN(0),
            END_OF_ELEMENTS(1),
            BASE_NODE_ELEMENT(2),
            PARTITION_NODE_ELEMENT(3),
            GROUP_NODE_ELEMENT(4),
            INSTANCE_NODE_ELEMENT(5),
            PART_NODE_ELEMENT(6),
            META_DATA_NODE_ELEMENT(7),
            LOD_NODE_ELEMENT(8),
            RANGE_LOD_NODE_ELEMENT(9),
            SWITCH_NODE_ELEMENT(10),
            BASE_SHAPE_NODE_ELEMENT(11),
            VERTEX_SHAPE_NODE_ELEMENT(12),
            TRI_STRIP_SET_SHAPE_NODE_ELEMENT(13),
            POLYLINE_SET_SHAPE_NODE_ELEMENT(14),
            POINT_SET_SHAPE_NODE_ELEMENT(15),
            POLYGON_SET_SHAPE_NODE_ELEMENT(16),
            NULL_SHAPE_NODE_ELEMENT(17),
            PRIMITIVE_SET_SHAPE_NODE_ELEMENT(18);

            private final long id;
            ElementType(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, ElementType> byId = new HashMap<Long, ElementType>(19);
            static {
                for (ElementType e : ElementType.values())
                    byId.put(e.id(), e);
            }
            public static ElementType byId(long id) { return byId.get(id); }
        }
        private Boolean _is_le;

        public JtBody(KaitaiStream _io) {
            this(_io, null, null);
        }

        public JtBody(KaitaiStream _io, Bug _parent) {
            this(_io, _parent, null);
        }

        public JtBody(KaitaiStream _io, Bug _parent, Bug _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            switch (_root.byteOrder()) {
            case 0: {
                boolean _tmp = (boolean) (true);
                this._is_le = _tmp;
                break;
            }
            case 1: {
                boolean _tmp = (boolean) (false);
                this._is_le = _tmp;
                break;
            }
            }

            if (_is_le == null) {
                throw new KaitaiStream.UndecidedEndiannessError();
            } else if (_is_le) {
                _readLE();
            } else {
                _readBE();
            }
        }
        private void _readLE() {
            this.header = new JtHeader(this._io, this, _root, _is_le);
        }
        private void _readBE() {
            this.header = new JtHeader(this._io, this, _root, _is_le);
        }
        public static class CoordF32 extends KaitaiStruct {
            private Boolean _is_le;

            public CoordF32(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                data = new ArrayList<Float>(((Number) (3)).intValue());
                for (int i = 0; i < 3; i++) {
                    this.data.add(this._io.readF4le());
                }
            }
            private void _readBE() {
                data = new ArrayList<Float>(((Number) (3)).intValue());
                for (int i = 0; i < 3; i++) {
                    this.data.add(this._io.readF4be());
                }
            }
            private ArrayList<Float> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public ArrayList<Float> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class VecI32 extends KaitaiStruct {
            private Boolean _is_le;

            public VecI32(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.count = this._io.readS4le();
                data = new ArrayList<Integer>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readS4le());
                }
            }
            private void _readBE() {
                this.count = this._io.readS4be();
                data = new ArrayList<Integer>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readS4be());
                }
            }
            private int count;
            private ArrayList<Integer> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public int count() { return count; }
            public ArrayList<Integer> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class VecF32 extends KaitaiStruct {
            private Boolean _is_le;

            public VecF32(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.count = this._io.readS4le();
                data = new ArrayList<Float>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readF4le());
                }
            }
            private void _readBE() {
                this.count = this._io.readS4be();
                data = new ArrayList<Float>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readF4be());
                }
            }
            private int count;
            private ArrayList<Float> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public int count() { return count; }
            public ArrayList<Float> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class DataSegment extends KaitaiStruct {
            private Boolean _is_le;

            public DataSegment(KaitaiStream _io, Bug.JtBody.TocEntry _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.header = new SegmentHeader(this._io, this, _root, _is_le);
                {
                    SegmentType on = header().segmentType();
                    if (on != null) {
                        switch (header().segmentType()) {
                        case LOGICAL_SCENE_GRAPH: {
                            this.body = new LsgSegment(this._io, this, _root, _is_le);
                            break;
                        }
                        }
                    }
                }
            }
            private void _readBE() {
                this.header = new SegmentHeader(this._io, this, _root, _is_le);
                {
                    SegmentType on = header().segmentType();
                    if (on != null) {
                        switch (header().segmentType()) {
                        case LOGICAL_SCENE_GRAPH: {
                            this.body = new LsgSegment(this._io, this, _root, _is_le);
                            break;
                        }
                        }
                    }
                }
            }
            public static class SegmentHeader extends KaitaiStruct {
                private Boolean _is_le;

                public SegmentHeader(KaitaiStream _io, Bug.JtBody.DataSegment _parent, Bug _root, boolean _is_le) {
                    super(_io);
                    this._parent = _parent;
                    this._root = _root;
                    this._is_le = _is_le;
                    _read();
                }
                private void _read() {

                    if (_is_le == null) {
                        throw new KaitaiStream.UndecidedEndiannessError();
                    } else if (_is_le) {
                        _readLE();
                    } else {
                        _readBE();
                    }
                }
                private void _readLE() {
                    this.segmentId = new Guid(this._io, this, _root, _is_le);
                    this.segmentType = Bug.JtBody.SegmentType.byId(this._io.readS4le());
                    this.segmentLength = this._io.readS4le();
                }
                private void _readBE() {
                    this.segmentId = new Guid(this._io, this, _root, _is_le);
                    this.segmentType = Bug.JtBody.SegmentType.byId(this._io.readS4be());
                    this.segmentLength = this._io.readS4be();
                }
                private Guid segmentId;
                private SegmentType segmentType;
                private int segmentLength;
                private Bug _root;
                private Bug.JtBody.DataSegment _parent;
                public Guid segmentId() { return segmentId; }
                public SegmentType segmentType() { return segmentType; }
                public int segmentLength() { return segmentLength; }
                public Bug _root() { return _root; }
                public Bug.JtBody.DataSegment _parent() { return _parent; }
            }
            public static class ZlibHeader extends KaitaiStruct {
                private Boolean _is_le;

                public ZlibHeader(KaitaiStream _io, Bug.JtBody.DataSegment.LsgSegment _parent, Bug _root, boolean _is_le) {
                    super(_io);
                    this._parent = _parent;
                    this._root = _root;
                    this._is_le = _is_le;
                    _read();
                }
                private void _read() {

                    if (_is_le == null) {
                        throw new KaitaiStream.UndecidedEndiannessError();
                    } else if (_is_le) {
                        _readLE();
                    } else {
                        _readBE();
                    }
                }
                private void _readLE() {
                    this.compressionFlag = this._io.readS4le();
                    this.compressedDataLen = this._io.readS4le();
                    this.compressionAlgo = Bug.JtBody.CompressionAlgo.byId(this._io.readU1());
                }
                private void _readBE() {
                    this.compressionFlag = this._io.readS4be();
                    this.compressedDataLen = this._io.readS4be();
                    this.compressionAlgo = Bug.JtBody.CompressionAlgo.byId(this._io.readU1());
                }
                private int compressionFlag;
                private int compressedDataLen;
                private CompressionAlgo compressionAlgo;
                private Bug _root;
                private Bug.JtBody.DataSegment.LsgSegment _parent;
                public int compressionFlag() { return compressionFlag; }
                public int compressedDataLen() { return compressedDataLen; }
                public CompressionAlgo compressionAlgo() { return compressionAlgo; }
                public Bug _root() { return _root; }
                public Bug.JtBody.DataSegment.LsgSegment _parent() { return _parent; }
            }
            public static class LogicalElementHeader extends KaitaiStruct {
                private Boolean _is_le;

                public LogicalElementHeader(KaitaiStream _io, Bug.JtBody.DataSegment.LsgSegment.LsgGraphElement _parent, Bug _root, boolean _is_le) {
                    super(_io);
                    this._parent = _parent;
                    this._root = _root;
                    this._is_le = _is_le;
                    _read();
                }
                private void _read() {

                    if (_is_le == null) {
                        throw new KaitaiStream.UndecidedEndiannessError();
                    } else if (_is_le) {
                        _readLE();
                    } else {
                        _readBE();
                    }
                }
                private void _readLE() {
                    this.elementLength = this._io.readS4le();
                    this.typeId = new Guid(this._io, this, _root, _is_le);
                    this.objectBaseType = this._io.readU1();
                    this.objectId = this._io.readS4le();
                }
                private void _readBE() {
                    this.elementLength = this._io.readS4be();
                    this.typeId = new Guid(this._io, this, _root, _is_le);
                    this.objectBaseType = this._io.readU1();
                    this.objectId = this._io.readS4be();
                }
                private ElementType elementType;
                public ElementType elementType() {
                    if (this.elementType != null)
                        return this.elementType;
                    this.elementType = ( ((typeId().a() == 4294967295L) && (typeId().b() == 65535) && (typeId().c() == 65535) && (typeId().d() == 255) && (typeId().e() == 255) && (typeId().f() == 255) && (typeId().g() == 255) && (typeId().h() == 255) && (typeId().i() == 255) && (typeId().j() == 255) && (typeId().k() == 255))  ? Bug.JtBody.ElementType.END_OF_ELEMENTS : ( ((typeId().a() == 282923061) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.BASE_NODE_ELEMENT : ( ((typeId().a() == 282923070) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.PARTITION_NODE_ELEMENT : ( ((typeId().a() == 282923035) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.GROUP_NODE_ELEMENT : ( ((typeId().a() == 282923050) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.INSTANCE_NODE_ELEMENT : ( ((typeId().a() == 3459609156L) && (typeId().b() == 14587) && (typeId().c() == 4561) && (typeId().d() == 165) && (typeId().e() == 6) && (typeId().f() == 0) && (typeId().g() == 96) && (typeId().h() == 151) && (typeId().i() == 189) && (typeId().j() == 198) && (typeId().k() == 225))  ? Bug.JtBody.ElementType.PART_NODE_ELEMENT : ( ((typeId().a() == 3459609157L) && (typeId().b() == 14587) && (typeId().c() == 4561) && (typeId().d() == 165) && (typeId().e() == 6) && (typeId().f() == 0) && (typeId().g() == 96) && (typeId().h() == 151) && (typeId().i() == 189) && (typeId().j() == 198) && (typeId().k() == 225))  ? Bug.JtBody.ElementType.META_DATA_NODE_ELEMENT : ( ((typeId().a() == 282923052) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.LOD_NODE_ELEMENT : ( ((typeId().a() == 282923084) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.RANGE_LOD_NODE_ELEMENT : ( ((typeId().a() == 282923251) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.SWITCH_NODE_ELEMENT : ( ((typeId().a() == 282923097) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.BASE_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 282923135) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.VERTEX_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 282923127) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.TRI_STRIP_SET_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 282923078) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.POLYLINE_SET_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 2551400214L) && (typeId().b() == 16) && (typeId().c() == 2072) && (typeId().d() == 25) && (typeId().e() == 152) && (typeId().f() == 8) && (typeId().g() == 0) && (typeId().h() == 9) && (typeId().i() == 131) && (typeId().j() == 93) && (typeId().k() == 90))  ? Bug.JtBody.ElementType.POINT_SET_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 282923080) && (typeId().b() == 10952) && (typeId().c() == 4561) && (typeId().d() == 155) && (typeId().e() == 107) && (typeId().f() == 0) && (typeId().g() == 128) && (typeId().h() == 199) && (typeId().i() == 187) && (typeId().j() == 89) && (typeId().k() == 151))  ? Bug.JtBody.ElementType.POLYGON_SET_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 3527010230L) && (typeId().b() == 56695) && (typeId().c() == 17033) && (typeId().d() == 160) && (typeId().e() == 125) && (typeId().f() == 176) && (typeId().g() == 238) && (typeId().h() == 121) && (typeId().i() == 247) && (typeId().j() == 148) && (typeId().k() == 148))  ? Bug.JtBody.ElementType.NULL_SHAPE_NODE_ELEMENT : ( ((typeId().a() == 3825431489L) && (typeId().b() == 6873) && (typeId().c() == 4563) && (typeId().d() == 157) && (typeId().e() == 175) && (typeId().f() == 0) && (typeId().g() == 160) && (typeId().h() == 201) && (typeId().i() == 199) && (typeId().j() == 221) && (typeId().k() == 194))  ? Bug.JtBody.ElementType.PRIMITIVE_SET_SHAPE_NODE_ELEMENT : Bug.JtBody.ElementType.UNKNOWN))))))))))))))))));
                    return this.elementType;
                }
                private int elementLength;
                private Guid typeId;
                private int objectBaseType;
                private int objectId;
                private Bug _root;
                private Bug.JtBody.DataSegment.LsgSegment.LsgGraphElement _parent;
                public int elementLength() { return elementLength; }
                public Guid typeId() { return typeId; }
                public int objectBaseType() { return objectBaseType; }
                public int objectId() { return objectId; }
                public Bug _root() { return _root; }
                public Bug.JtBody.DataSegment.LsgSegment.LsgGraphElement _parent() { return _parent; }
            }
            public static class LsgSegment extends KaitaiStruct {
                private Boolean _is_le;

                public LsgSegment(KaitaiStream _io, Bug.JtBody.DataSegment _parent, Bug _root, boolean _is_le) {
                    super(_io);
                    this._parent = _parent;
                    this._root = _root;
                    this._is_le = _is_le;
                    _read();
                }
                private void _read() {

                    if (_is_le == null) {
                        throw new KaitaiStream.UndecidedEndiannessError();
                    } else if (_is_le) {
                        _readLE();
                    } else {
                        _readBE();
                    }
                }
                private void _readLE() {
                    this.zlibHeader = new ZlibHeader(this._io, this, _root, _is_le);
                    this._raw__raw_body = this._io.readBytes((zlibHeader().compressedDataLen() - 1));
                    name.kh4n.jtloader.ZlibInflate _process__raw__raw_body = new name.kh4n.jtloader.ZlibInflate(zlibHeader().compressionFlag());
                    this._raw_body = _process__raw__raw_body.decode(_raw__raw_body);
                    KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
                    this.body = new LsgSegmentBody(_io__raw_body, this, _root, _is_le);
                }
                private void _readBE() {
                    this.zlibHeader = new ZlibHeader(this._io, this, _root, _is_le);
                    this._raw__raw_body = this._io.readBytes((zlibHeader().compressedDataLen() - 1));
                    name.kh4n.jtloader.ZlibInflate _process__raw__raw_body = new name.kh4n.jtloader.ZlibInflate(zlibHeader().compressionFlag());
                    this._raw_body = _process__raw__raw_body.decode(_raw__raw_body);
                    KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
                    this.body = new LsgSegmentBody(_io__raw_body, this, _root, _is_le);
                }
                public static class BaseShaderData extends KaitaiStruct {
                    private Boolean _is_le;

                    public BaseShaderData(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.sourceCodeLoc = new MbString(this._io, this, _root, _is_le);
                    }
                    private void _readBE() {
                        this.sourceCodeLoc = new MbString(this._io, this, _root, _is_le);
                    }
                    private MbString sourceCodeLoc;
                    private Bug _root;
                    private KaitaiStruct _parent;
                    public MbString sourceCodeLoc() { return sourceCodeLoc; }
                    public Bug _root() { return _root; }
                    public KaitaiStruct _parent() { return _parent; }
                }
                public static class NodeCountRange extends KaitaiStruct {
                    private Boolean _is_le;

                    public NodeCountRange(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.minCount = this._io.readS4le();
                    }
                    private void _readBE() {
                        this.minCount = this._io.readS4be();
                    }
                    private int minCount;
                    private Bug _root;
                    private KaitaiStruct _parent;
                    public int minCount() { return minCount; }
                    public Bug _root() { return _root; }
                    public KaitaiStruct _parent() { return _parent; }
                }
                public static class PolygonCountRange extends KaitaiStruct {
                    private Boolean _is_le;

                    public PolygonCountRange(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.minCount = this._io.readS4le();
                    }
                    private void _readBE() {
                        this.minCount = this._io.readS4be();
                    }
                    private int minCount;
                    private Bug _root;
                    private KaitaiStruct _parent;
                    public int minCount() { return minCount; }
                    public Bug _root() { return _root; }
                    public KaitaiStruct _parent() { return _parent; }
                }
                public static class LsgGraphElement extends KaitaiStruct {
                    private Boolean _is_le;

                    public LsgGraphElement(KaitaiStream _io, Bug.JtBody.DataSegment.LsgSegment.LsgSegmentBody _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.header = new LogicalElementHeader(this._io, this, _root, _is_le);
                        {
                            ElementType on = header().elementType();
                            if (on != null) {
                                switch (header().elementType()) {
                                case PARTITION_NODE_ELEMENT: {
                                    this._raw_data = this._io.readBytes((header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS ? 0 : (header().elementLength() - ((16 + 1) + 4))));
                                    KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
                                    this.data = new PartitionNodeData(_io__raw_data, this, _root, _is_le);
                                    break;
                                }
                                default: {
                                    this.data = this._io.readBytes((header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS ? 0 : (header().elementLength() - ((16 + 1) + 4))));
                                    break;
                                }
                                }
                            } else {
                                this.data = this._io.readBytes((header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS ? 0 : (header().elementLength() - ((16 + 1) + 4))));
                            }
                        }
                    }
                    private void _readBE() {
                        this.header = new LogicalElementHeader(this._io, this, _root, _is_le);
                        {
                            ElementType on = header().elementType();
                            if (on != null) {
                                switch (header().elementType()) {
                                case PARTITION_NODE_ELEMENT: {
                                    this._raw_data = this._io.readBytes((header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS ? 0 : (header().elementLength() - ((16 + 1) + 4))));
                                    KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
                                    this.data = new PartitionNodeData(_io__raw_data, this, _root, _is_le);
                                    break;
                                }
                                default: {
                                    this.data = this._io.readBytes((header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS ? 0 : (header().elementLength() - ((16 + 1) + 4))));
                                    break;
                                }
                                }
                            } else {
                                this.data = this._io.readBytes((header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS ? 0 : (header().elementLength() - ((16 + 1) + 4))));
                            }
                        }
                    }
                    private LogicalElementHeader header;
                    private Object data;
                    private Bug _root;
                    private Bug.JtBody.DataSegment.LsgSegment.LsgSegmentBody _parent;
                    private byte[] _raw_data;
                    public LogicalElementHeader header() { return header; }
                    public Object data() { return data; }
                    public Bug _root() { return _root; }
                    public Bug.JtBody.DataSegment.LsgSegment.LsgSegmentBody _parent() { return _parent; }
                    public byte[] _raw_data() { return _raw_data; }
                }
                public static class ShaderParam extends KaitaiStruct {
                    private Boolean _is_le;

                    public ShaderParam(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.paramName = new MbString(this._io, this, _root, _is_le);
                    }
                    private void _readBE() {
                        this.paramName = new MbString(this._io, this, _root, _is_le);
                    }
                    private MbString paramName;
                    private Bug _root;
                    private KaitaiStruct _parent;
                    public MbString paramName() { return paramName; }
                    public Bug _root() { return _root; }
                    public KaitaiStruct _parent() { return _parent; }
                }
                public static class LsgSegmentBody extends KaitaiStruct {
                    private Boolean _is_le;

                    public LsgSegmentBody(KaitaiStream _io, Bug.JtBody.DataSegment.LsgSegment _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.graphElements = new ArrayList<LsgGraphElement>();
                        {
                            LsgGraphElement _it;
                            int i = 0;
                            do {
                                _it = new LsgGraphElement(this._io, this, _root, _is_le);
                                this.graphElements.add(_it);
                                i++;
                            } while (!(_it.header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS));
                        }
                    }
                    private void _readBE() {
                        this.graphElements = new ArrayList<LsgGraphElement>();
                        {
                            LsgGraphElement _it;
                            int i = 0;
                            do {
                                _it = new LsgGraphElement(this._io, this, _root, _is_le);
                                this.graphElements.add(_it);
                                i++;
                            } while (!(_it.header().elementType() == Bug.JtBody.ElementType.END_OF_ELEMENTS));
                        }
                    }
                    private ArrayList<LsgGraphElement> graphElements;
                    private Bug _root;
                    private Bug.JtBody.DataSegment.LsgSegment _parent;
                    public ArrayList<LsgGraphElement> graphElements() { return graphElements; }
                    public Bug _root() { return _root; }
                    public Bug.JtBody.DataSegment.LsgSegment _parent() { return _parent; }
                }
                public static class PartitionNodeData extends KaitaiStruct {
                    private Boolean _is_le;

                    public PartitionNodeData(KaitaiStream _io, Bug.JtBody.DataSegment.LsgSegment.LsgGraphElement _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.fileName = new MbString(this._io, this, _root, _is_le);
                    }
                    private void _readBE() {
                        this.fileName = new MbString(this._io, this, _root, _is_le);
                    }
                    private MbString fileName;
                    private Bug _root;
                    private Bug.JtBody.DataSegment.LsgSegment.LsgGraphElement _parent;
                    public MbString fileName() { return fileName; }
                    public Bug _root() { return _root; }
                    public Bug.JtBody.DataSegment.LsgSegment.LsgGraphElement _parent() { return _parent; }
                }
                public static class VertexCountRange extends KaitaiStruct {
                    private Boolean _is_le;

                    public VertexCountRange(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                        super(_io);
                        this._parent = _parent;
                        this._root = _root;
                        this._is_le = _is_le;
                        _read();
                    }
                    private void _read() {

                        if (_is_le == null) {
                            throw new KaitaiStream.UndecidedEndiannessError();
                        } else if (_is_le) {
                            _readLE();
                        } else {
                            _readBE();
                        }
                    }
                    private void _readLE() {
                        this.minCount = this._io.readS4le();
                    }
                    private void _readBE() {
                        this.minCount = this._io.readS4be();
                    }
                    private int minCount;
                    private Bug _root;
                    private KaitaiStruct _parent;
                    public int minCount() { return minCount; }
                    public Bug _root() { return _root; }
                    public KaitaiStruct _parent() { return _parent; }
                }
                private ZlibHeader zlibHeader;
                private LsgSegmentBody body;
                private Bug _root;
                private Bug.JtBody.DataSegment _parent;
                private byte[] _raw_body;
                private byte[] _raw__raw_body;
                public ZlibHeader zlibHeader() { return zlibHeader; }
                public LsgSegmentBody body() { return body; }
                public Bug _root() { return _root; }
                public Bug.JtBody.DataSegment _parent() { return _parent; }
                public byte[] _raw_body() { return _raw_body; }
                public byte[] _raw__raw_body() { return _raw__raw_body; }
            }
            private SegmentHeader header;
            private LsgSegment body;
            private Bug _root;
            private Bug.JtBody.TocEntry _parent;
            public SegmentHeader header() { return header; }
            public LsgSegment body() { return body; }
            public Bug _root() { return _root; }
            public Bug.JtBody.TocEntry _parent() { return _parent; }
        }
        public static class TocSegment extends KaitaiStruct {
            private Boolean _is_le;

            public TocSegment(KaitaiStream _io, Bug.JtBody _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.entryCount = this._io.readS4le();
                entries = new ArrayList<TocEntry>(((Number) (entryCount())).intValue());
                for (int i = 0; i < entryCount(); i++) {
                    this.entries.add(new TocEntry(this._io, this, _root, _is_le));
                }
            }
            private void _readBE() {
                this.entryCount = this._io.readS4be();
                entries = new ArrayList<TocEntry>(((Number) (entryCount())).intValue());
                for (int i = 0; i < entryCount(); i++) {
                    this.entries.add(new TocEntry(this._io, this, _root, _is_le));
                }
            }
            private int entryCount;
            private ArrayList<TocEntry> entries;
            private Bug _root;
            private Bug.JtBody _parent;
            public int entryCount() { return entryCount; }
            public ArrayList<TocEntry> entries() { return entries; }
            public Bug _root() { return _root; }
            public Bug.JtBody _parent() { return _parent; }
        }
        public static class Guid extends KaitaiStruct {
            private Boolean _is_le;

            public Guid(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.a = this._io.readU4le();
                this.b = this._io.readU2le();
                this.c = this._io.readU2le();
                this.d = this._io.readU1();
                this.e = this._io.readU1();
                this.f = this._io.readU1();
                this.g = this._io.readU1();
                this.h = this._io.readU1();
                this.i = this._io.readU1();
                this.j = this._io.readU1();
                this.k = this._io.readU1();
            }
            private void _readBE() {
                this.a = this._io.readU4be();
                this.b = this._io.readU2be();
                this.c = this._io.readU2be();
                this.d = this._io.readU1();
                this.e = this._io.readU1();
                this.f = this._io.readU1();
                this.g = this._io.readU1();
                this.h = this._io.readU1();
                this.i = this._io.readU1();
                this.j = this._io.readU1();
                this.k = this._io.readU1();
            }
            private long a;
            private int b;
            private int c;
            private int d;
            private int e;
            private int f;
            private int g;
            private int h;
            private int i;
            private int j;
            private int k;
            private Bug _root;
            private KaitaiStruct _parent;
            public long a() { return a; }
            public int b() { return b; }
            public int c() { return c; }
            public int d() { return d; }
            public int e() { return e; }
            public int f() { return f; }
            public int g() { return g; }
            public int h() { return h; }
            public int i() { return i; }
            public int j() { return j; }
            public int k() { return k; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class VecF64 extends KaitaiStruct {
            private Boolean _is_le;

            public VecF64(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.count = this._io.readS4le();
                data = new ArrayList<Double>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readF8le());
                }
            }
            private void _readBE() {
                this.count = this._io.readS4be();
                data = new ArrayList<Double>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readF8be());
                }
            }
            private int count;
            private ArrayList<Double> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public int count() { return count; }
            public ArrayList<Double> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class VecU32 extends KaitaiStruct {
            private Boolean _is_le;

            public VecU32(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.count = this._io.readS4le();
                data = new ArrayList<Long>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readU4le());
                }
            }
            private void _readBE() {
                this.count = this._io.readS4be();
                data = new ArrayList<Long>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.data.add(this._io.readU4be());
                }
            }
            private int count;
            private ArrayList<Long> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public int count() { return count; }
            public ArrayList<Long> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class JtHeader extends KaitaiStruct {
            private Boolean _is_le;

            public JtHeader(KaitaiStream _io, Bug.JtBody _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.reservedField = this._io.readS4le();
                this.tocOffset = this._io.readS4le();
                this.lsgSegmentId = new Guid(this._io, this, _root, _is_le);
            }
            private void _readBE() {
                this.reservedField = this._io.readS4be();
                this.tocOffset = this._io.readS4be();
                this.lsgSegmentId = new Guid(this._io, this, _root, _is_le);
            }
            private int reservedField;
            private int tocOffset;
            private Guid lsgSegmentId;
            private Bug _root;
            private Bug.JtBody _parent;
            public int reservedField() { return reservedField; }
            public int tocOffset() { return tocOffset; }
            public Guid lsgSegmentId() { return lsgSegmentId; }
            public Bug _root() { return _root; }
            public Bug.JtBody _parent() { return _parent; }
        }
        public static class CoordF64 extends KaitaiStruct {
            private Boolean _is_le;

            public CoordF64(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                data = new ArrayList<Double>(((Number) (3)).intValue());
                for (int i = 0; i < 3; i++) {
                    this.data.add(this._io.readF8le());
                }
            }
            private void _readBE() {
                data = new ArrayList<Double>(((Number) (3)).intValue());
                for (int i = 0; i < 3; i++) {
                    this.data.add(this._io.readF8be());
                }
            }
            private ArrayList<Double> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public ArrayList<Double> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class MbString extends KaitaiStruct {
            private Boolean _is_le;

            public MbString(KaitaiStream _io, Bug.JtBody.DataSegment.LsgSegment.PartitionNodeData _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.count = this._io.readS4le();
                str = new ArrayList<Integer>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.str.add(this._io.readU2le());
                }
            }
            private void _readBE() {
                this.count = this._io.readS4be();
                str = new ArrayList<Integer>(((Number) (count())).intValue());
                for (int i = 0; i < count(); i++) {
                    this.str.add(this._io.readU2be());
                }
            }
            private int count;
            private ArrayList<Integer> str;
            private Bug _root;
            private Bug.JtBody.DataSegment.LsgSegment.PartitionNodeData _parent;
            public int count() { return count; }
            public ArrayList<Integer> str() { return str; }
            public Bug _root() { return _root; }
            public Bug.JtBody.DataSegment.LsgSegment.PartitionNodeData _parent() { return _parent; }
        }
        public static class BboxF32 extends KaitaiStruct {
            private Boolean _is_le;

            public BboxF32(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.minCorner = new CoordF32(this._io, this, _root, _is_le);
                this.maxCorner = new CoordF32(this._io, this, _root, _is_le);
            }
            private void _readBE() {
                this.minCorner = new CoordF32(this._io, this, _root, _is_le);
                this.maxCorner = new CoordF32(this._io, this, _root, _is_le);
            }
            private CoordF32 minCorner;
            private CoordF32 maxCorner;
            private Bug _root;
            private KaitaiStruct _parent;
            public CoordF32 minCorner() { return minCorner; }
            public CoordF32 maxCorner() { return maxCorner; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class DirF32 extends KaitaiStruct {
            private Boolean _is_le;

            public DirF32(KaitaiStream _io, KaitaiStruct _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                data = new ArrayList<Float>(((Number) (3)).intValue());
                for (int i = 0; i < 3; i++) {
                    this.data.add(this._io.readF4le());
                }
            }
            private void _readBE() {
                data = new ArrayList<Float>(((Number) (3)).intValue());
                for (int i = 0; i < 3; i++) {
                    this.data.add(this._io.readF4be());
                }
            }
            private ArrayList<Float> data;
            private Bug _root;
            private KaitaiStruct _parent;
            public ArrayList<Float> data() { return data; }
            public Bug _root() { return _root; }
            public KaitaiStruct _parent() { return _parent; }
        }
        public static class TocEntry extends KaitaiStruct {
            private Boolean _is_le;

            public TocEntry(KaitaiStream _io, Bug.JtBody.TocSegment _parent, Bug _root, boolean _is_le) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                this._is_le = _is_le;
                _read();
            }
            private void _read() {

                if (_is_le == null) {
                    throw new KaitaiStream.UndecidedEndiannessError();
                } else if (_is_le) {
                    _readLE();
                } else {
                    _readBE();
                }
            }
            private void _readLE() {
                this.segmentId = new Guid(this._io, this, _root, _is_le);
                this.segmentOffset = this._io.readS4le();
                this.segmentLength = this._io.readS4le();
                this.segmentAttrs = new SegmentAttr(this._io, this, _root, _is_le);
            }
            private void _readBE() {
                this.segmentId = new Guid(this._io, this, _root, _is_le);
                this.segmentOffset = this._io.readS4be();
                this.segmentLength = this._io.readS4be();
                this.segmentAttrs = new SegmentAttr(this._io, this, _root, _is_le);
            }
            public static class SegmentAttr extends KaitaiStruct {
                private Boolean _is_le;

                public SegmentAttr(KaitaiStream _io, Bug.JtBody.TocEntry _parent, Bug _root, boolean _is_le) {
                    super(_io);
                    this._parent = _parent;
                    this._root = _root;
                    this._is_le = _is_le;
                    _read();
                }
                private void _read() {

                    if (_is_le == null) {
                        throw new KaitaiStream.UndecidedEndiannessError();
                    } else if (_is_le) {
                        _readLE();
                    } else {
                        _readBE();
                    }
                }
                private void _readLE() {
                    this.reserved = this._io.readBitsIntBe(24);
                    this.attribute = Bug.JtBody.SegmentType.byId(this._io.readBitsIntBe(8));
                }
                private void _readBE() {
                    this.reserved = this._io.readBitsIntBe(24);
                    this.attribute = Bug.JtBody.SegmentType.byId(this._io.readBitsIntBe(8));
                }
                private long reserved;
                private SegmentType attribute;
                private Bug _root;
                private Bug.JtBody.TocEntry _parent;
                public long reserved() { return reserved; }
                public SegmentType attribute() { return attribute; }
                public Bug _root() { return _root; }
                public Bug.JtBody.TocEntry _parent() { return _parent; }
            }
            private DataSegment data;
            public DataSegment data() {
                if (this.data != null)
                    return this.data;
                long _pos = this._io.pos();
                this._io.seek(segmentOffset());
                if (_is_le) {
                    this._raw_data = this._io.readBytes(segmentLength());
                    KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
                    this.data = new DataSegment(_io__raw_data, this, _root, _is_le);
                } else {
                    this._raw_data = this._io.readBytes(segmentLength());
                    KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
                    this.data = new DataSegment(_io__raw_data, this, _root, _is_le);
                }
                this._io.seek(_pos);
                return this.data;
            }
            private Guid segmentId;
            private int segmentOffset;
            private int segmentLength;
            private SegmentAttr segmentAttrs;
            private Bug _root;
            private Bug.JtBody.TocSegment _parent;
            private byte[] _raw_data;
            public Guid segmentId() { return segmentId; }
            public int segmentOffset() { return segmentOffset; }
            public int segmentLength() { return segmentLength; }
            public SegmentAttr segmentAttrs() { return segmentAttrs; }
            public Bug _root() { return _root; }
            public Bug.JtBody.TocSegment _parent() { return _parent; }
            public byte[] _raw_data() { return _raw_data; }
        }
        private TocSegment tocSegment;
        public TocSegment tocSegment() {
            if (this.tocSegment != null)
                return this.tocSegment;
            long _pos = this._io.pos();
            this._io.seek(header().tocOffset());
            if (_is_le) {
                this.tocSegment = new TocSegment(this._io, this, _root, _is_le);
            } else {
                this.tocSegment = new TocSegment(this._io, this, _root, _is_le);
            }
            this._io.seek(_pos);
            return this.tocSegment;
        }
        private JtHeader header;
        private Bug _root;
        private Bug _parent;
        public JtHeader header() { return header; }
        public Bug _root() { return _root; }
        public Bug _parent() { return _parent; }
    }
    private String version;
    private int byteOrder;
    private JtBody body;
    private Bug _root;
    private KaitaiStruct _parent;
    public String version() { return version; }
    public int byteOrder() { return byteOrder; }
    public JtBody body() { return body; }
    public Bug _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}

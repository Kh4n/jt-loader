meta:
  id: jt
  file-extension: jt
seq:
  - id: version
    type: str
    size: 80
    encoding: ASCII
  - id: byte_order
    type: u1
  - id: body
    type: jt_body
types:
  jt_body:
    meta:
      endian:
        switch-on: _root.byte_order
        cases:
          0: le
          1: be
    seq:
      - id: header
        type: jt_header
    instances:
      toc_segment:
        pos: header.toc_offset
        type: toc_segment
    enums:
      compression_level:
        0: lossless
        10: minimally_lossy
        50: moderate_lossy
        100: aggressive_lossy
        -1: unknown
      segment_type:
        1: logical_scene_graph
        2: jt_b_rep
        3: pmi_data
        4: meta_data
        6: shape
        7: shape_lod0
        8: shape_lod1
        9: shape_lod2
        10: shape_lod3
        11: shape_lod4
        12: shape_lod5
        13: shape_lod6
        14: shape_lod7
        15: shape_lod8
        16: shape_lod9
        17: xt_b_rep
        18: wireframe_representation
        20: ulp
        24: lwpa
      element_type:
        0: unknown
        1: end_of_elements
        2: base_node_element
        3: partition_node_element
        4: group_node_element
        5: instance_node_element
        6: part_node_element
        7: meta_data_node_element
        8: lod_node_element
        9: range_lod_node_element
        10: switch_node_element
        11: base_shape_node_element
      compression_algo:
        1: no_compression
        2: zlib_compression
    types:
      guid:
        seq:
          - id: a
            type: u4
          - id: b
            type: u2
          - id: c
            type: u2
          - id: d
            type: u1
          - id: e
            type: u1
          - id: f
            type: u1
          - id: g
            type: u1
          - id: h
            type: u1
          - id: i
            type: u1
          - id: j
            type: u1
          - id: k
            type: u1
      mb_string:
        seq:
          - id: count
            type: s4
          - id: str
            type: u2
            repeat: expr
            repeat-expr: count
      vec_f32:
        seq:
          - id: count
            type: s4
          - id: data
            type: f4
            repeat: expr
            repeat-expr: count
      vec_f64:
        seq:
          - id: count
            type: s4
          - id: data
            type: f8
            repeat: expr
            repeat-expr: count
      vec_i32:
        seq:
          - id: count
            type: s4
          - id: data
            type: s4
            repeat: expr
            repeat-expr: count
      vec_u32:
        seq:
          - id: count
            type: s4
          - id: data
            type: u4
            repeat: expr
            repeat-expr: count
      dir_f32:
        seq:
          - id: data
            type: f4
            repeat: expr
            repeat-expr: 3
      coord_f32:
        seq:
          - id: data
            type: f4
            repeat: expr
            repeat-expr: 3
      coord_f64:
        seq:
          - id: data
            type: f8
            repeat: expr
            repeat-expr: 3
      bbox_f32:
        seq:
          - id: min_corner
            type: coord_f32
          - id: max_corner
            type: coord_f32
      jt_header:
        seq:
          - id: reserved_field
            type: s4
          - id: toc_offset
            type: s4
          - id: lsg_segment_id
            type: guid
      toc_segment:
        seq:
          - id: entry_count
            type: s4
          - id: entries
            type: toc_entry
            repeat: expr
            repeat-expr: entry_count
      toc_entry:
        types:
          segment_attr:
            seq:
              - id: reserved
                type: b24
              - id: attribute
                type: b8
                enum: segment_type
        seq:
          - id: segment_id
            type: guid
          - id: segment_offset
            type: s4
          - id: segment_length
            type: s4
          - id: segment_attrs
            type: segment_attr
        instances:
          data:
            pos: segment_offset
            size: segment_length
            type: data_segment
      data_segment:
        seq:
          - id: header
            type: segment_header
          - id: body
            type:
              switch-on: header.segment_type
              cases:
                segment_type::logical_scene_graph: lsg_segment
        types:
          segment_header:
            seq:
              - id: segment_id
                type: guid
              - id: segment_type
                type: s4
                enum: segment_type
              - id: segment_length
                type: s4
          zlib_header:
            seq:
              - id: compression_flag
                type: s4
              - id: compressed_data_len
                type: s4
              - id: compression_algo
                type: u1
                enum: compression_algo
          logical_element_header:
            seq:
              - id: element_length
                type: s4
              - id: type_id
                type: guid
              - id: object_base_type
                type: u1
              - id: object_id
                type: s4
            instances:
              element_type:
                # python to gen: expr = lambda a,b : pyperclip.copy(" and ".join(f"type_id.{i}=={hex(j)}" for i,j in zip("abcdefghijk",a)) + f" ? element_type::{b}")
                value: >
                  type_id.a==0xffffffff and type_id.b==0xffff and type_id.c==0xffff and type_id.d==0xff and type_id.e==0xff and type_id.f==0xff and type_id.g==0xff and type_id.h==0xff and type_id.i==0xff and type_id.j==0xff and type_id.k==0xff ? element_type::end_of_elements
                  : type_id.a==0x10dd1035 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x00 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::base_node_element
                  : type_id.a==0x10dd103e and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::partition_node_element
                  : type_id.a==0x10dd101b and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::group_node_element
                  : type_id.a==0x10dd102a and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::instance_node_element
                  : type_id.a==0xce357244 and type_id.b==0x38fb and type_id.c==0x11d1 and type_id.d==0xa5 and type_id.e==0x6 and type_id.f==0x0 and type_id.g==0x60 and type_id.h==0x97 and type_id.i==0xbd and type_id.j==0xc6 and type_id.k==0xe1 ? element_type::part_node_element
                  : type_id.a==0xce357245 and type_id.b==0x38fb and type_id.c==0x11d1 and type_id.d==0xa5 and type_id.e==0x6 and type_id.f==0x0 and type_id.g==0x60 and type_id.h==0x97 and type_id.i==0xbd and type_id.j==0xc6 and type_id.k==0xe1 ? element_type::meta_data_node_element
                  : type_id.a==0x10dd102c and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::lod_node_element
                  : type_id.a==0x10dd104c and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::range_lod_node_element
                  : type_id.a==0x10dd10f3 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::switch_node_element
                  : type_id.a==0x10dd1059 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::base_shape_node_element
                  : element_type::unknown
          lsg_segment:
            seq:
              - id: zlib_header
                type: zlib_header
              - id: body
                type: lsg_segment_body
                size: zlib_header.compressed_data_len - 1
                process: name.kh4n.jtloader.zlib_inflate(zlib_header.compression_flag)
            types:
              lsg_segment_body:
                seq:
                  - id: graph_elements
                    type: lsg_graph_element
                    repeat: until
                    repeat-until: _.header.element_type == element_type::end_of_elements
              lsg_graph_element:
                seq:
                  - id: header
                    type: logical_element_header
                  - id: data
                    size: 'header.element_type==element_type::end_of_elements ? 0 : header.element_length - (16 + 1 + 4)'
                    type:
                      switch-on: header.element_type
                      cases:
                        element_type::end_of_elements: end_of_elements_data
                        element_type::base_node_element: base_node_data
                        element_type::group_node_element: group_node_data
                        element_type::partition_node_element: partition_node_data
                        element_type::instance_node_element: instance_node_data
                        element_type::part_node_element: part_node_data
                        element_type::meta_data_node_element: meta_data_node_data
                        element_type::lod_node_element: lod_node_data
                        element_type::range_lod_node_element: range_lod_node_data
                        element_type::switch_node_element: switch_node_data
                        element_type::base_shape_node_element: base_shape_data
              vertex_count_range:
                seq:
                  - id: min_count
                    type: s4
                  - id: max_count
                    type: s4
              node_count_range:
                seq:
                  - id: min_count
                    type: s4
                  - id: max_count
                    type: s4
              polygon_count_range:
                seq:
                  - id: min_count
                    type: s4
                  - id: max_count
                    type: s4
              meta_data_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: version_number
                    type: s2
              end_of_elements_data: {}
              base_node_data:
                seq:
                  - id: version_number
                    type: s2
                  - id: node_flags
                    type: u4
                  - id: attribute_count
                    type: s4
                  - id: attribute_object_id
                    type: s4
                    repeat: expr
                    repeat-expr: attribute_count
              group_node_data:
                seq:
                  - id: base
                    type: base_node_data
                  - id: version_number
                    type: s2
                  - id: child_count
                    type: s4
                  - id: child_node_object_id
                    type: s4
                    repeat: expr
                    repeat-expr: child_count
              partition_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: partition_flags
                    type: s4
                  - id: file_name
                    type: mb_string
                  - id: reserved_field
                    type: bbox_f32
                    if: partition_flags & 0x00000001 != 0
                  - id: transformed_bbox
                    type: bbox_f32
                    if: partition_flags & 0x00000001 == 0
                  - id: area
                    type: f4
                  - id: vertex_count_range
                    type: vertex_count_range
                  - id: node_count_range
                    type: node_count_range
                  - id: polygon_count_range
                    type: polygon_count_range
                  - id: untransformed_bbox
                    type: bbox_f32
                    if: partition_flags & 0x00000001 != 0
              instance_node_data:
                seq:
                  - id: base
                    type: base_node_data
                  - id: version_number
                    type: s2
                  - id: child_node_object_id
                    type: s4
              part_node_data:
                seq:
                  - id: meta_data
                    type: meta_data_node_data
                  - id: version_number
                    type: s2
                  - id: reserved_field
                    type: s4
              lod_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: version_number
                    type: s2
                  - id: reserved_field
                    type: vec_f32
                  - id: reserved_field2
                    type: s4
              range_lod_node_data:
                seq:
                  - id: lod
                    type: lod_node_data
                  - id: version_number
                    type: s2
                  - id: range_limits
                    type: vec_f32
                  - id: center
                    type: coord_f32
              switch_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: version_number
                    type: s2
                  - id: selected_child
                    type: s4
              base_shape_data:
                instances:
                  compression_level:
                    value: |
                      compression_level_raw == 0.0 ? compression_level::lossless
                      : compression_level_raw == 0.1 ? compression_level::minimally_lossy
                      : compression_level_raw == 0.5 ? compression_level::moderate_lossy
                      : compression_level_raw == 1.0 ? compression_level::aggressive_lossy
                      : compression_level::unknown
                seq:
                  - id: base
                    type: base_node_data
                  - id: version_number
                    type: s2
                  - id: reserved_field
                    type: bbox_f32
                  - id: untransformed_bbox
                    type: bbox_f32
                  - id: area
                    type: f4
                  - id: vertex_count_range
                    type: vertex_count_range
                  - id: node_count_range
                    type: node_count_range
                  - id: polygon_count_range
                    type: polygon_count_range
                  - id: size
                    type: s4
                  - id: compression_level_raw
                    type: f4
#                    continue with adding more lsg elements